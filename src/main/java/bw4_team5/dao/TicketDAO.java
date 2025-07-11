package bw4_team5.dao;

import bw4_team5.entities.Ticket;
import bw4_team5.entities.TicketSystem;
import bw4_team5.entities.Vehicle;
import bw4_team5.enums.TicketStatus;
import bw4_team5.exceptions.UuidNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.time.LocalDate;

import java.util.UUID;

public class TicketDAO {
    private final EntityManager entityManager;

    public TicketDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Ticket newTicket) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newTicket);
            transaction.commit();
            System.out.println("Ticket con id '" + newTicket.getId() + "' it was created successfully!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public Ticket findTicketByUuid(UUID uuid) {
        Ticket found = entityManager.find(Ticket.class, uuid);
        if (found == null) throw new UuidNotFoundException(uuid.toString() + " not found.");
        return found;
    }

    public void endorseTicket(UUID ticketUuid, Vehicle vehicle) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Ticket ticket = entityManager.find(Ticket.class, ticketUuid);

        if (ticket == null) throw new UuidNotFoundException("Ticket con UUID " + ticketUuid + " non trovato.");
        if (ticket.getStatus() == TicketStatus.ENDORSED) {
            throw new IllegalStateException("Il biglietto è già stato vidimato.");
        }
        ticket.setStatus(TicketStatus.ENDORSED);
        ticket.setVehicle(vehicle);
        entityManager.merge(ticket);
        transaction.commit();
        System.out.println("Ticket " + ticketUuid + " vidimato sul veicolo " + vehicle.getId() + "Targa veicolo: " + vehicle.getNumberPlate());
    }

    public Ticket[] findAllEndorsedTickets() {
        Ticket[] tickets = entityManager.createQuery("SELECT t FROM Ticket t WHERE t.status = 'ENDORSED'", Ticket.class)
                .getResultList()
                .toArray(new Ticket[0]);
        if (tickets.length == 0) {
            System.out.println("Nessun biglietto vidimato trovato.");
        }
        return tickets;
    }
    // Conta biglietti vidimati su un veicolo specifico
    public long countEndorsedTicketsByVehicle(long vehicleId) {
        return entityManager.createQuery(
                        "SELECT COUNT(t) FROM Ticket t WHERE t.status = :status AND t.vehicle.id = :vehicleId", Long.class)
                .setParameter("status", TicketStatus.ENDORSED)
                .setParameter("vehicleId", vehicleId)
                .getSingleResult();
    }

    // Conta biglietti vidimati in un intervallo di tempo
    public long countEndorsedTicketsByPeriod(LocalDate start, LocalDate end) {
        return entityManager.createQuery(
                        "SELECT COUNT(t) FROM Ticket t WHERE t.status = :status AND t.issueDate BETWEEN :start AND :end", Long.class)
                .setParameter("status", TicketStatus.ENDORSED)
                .setParameter("start", start)
                .setParameter("end", end)
                .getSingleResult();


    }
    public void setTicketDate(LocalDate date, UUID uuid) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("UPDATE Ticket t SET t.issueDate = :issue_date WHERE t.id = :uuid");
        query.setParameter("issue_date", date);
        query.setParameter("uuid", uuid);
        query.executeUpdate();
        transaction.commit();
        System.out.println("data salvata con successo");
    }

    public void setTicketVendor(UUID vendorUuid, UUID ticketUuid) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TicketSystem vendor = entityManager.find(TicketSystem.class, vendorUuid);
        Query query = entityManager.createQuery("UPDATE Ticket t SET t.vendor = :vendor WHERE t.id = :ticketId");
        query.setParameter("vendor", vendor);
        query.setParameter("ticketId", ticketUuid);
        query.executeUpdate();
        transaction.commit();
        System.out.println("vendor salvato con successo");
    }

    public void setTicketVehicle(long vehicleId, UUID ticketUuid){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Vehicle vehicle= entityManager.find(Vehicle.class, vehicleId);
        Query query =entityManager.createQuery("UPDATE Ticket t SET t.vehicle = :vehicle WHERE t.id = :ticketId");
        query.setParameter("vehicle", vehicle);
        query.setParameter("ticketId", ticketUuid);
        query.executeUpdate();
        transaction.commit();
    }
}