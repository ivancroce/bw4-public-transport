package bw4_team5.dao;

import bw4_team5.entities.Ticket;
import bw4_team5.entities.Vehicle;
import bw4_team5.enums.TicketStatus;
import bw4_team5.exceptions.UuidNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
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
}