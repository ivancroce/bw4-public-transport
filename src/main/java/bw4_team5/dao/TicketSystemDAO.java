package bw4_team5.dao;

import bw4_team5.entities.Ticket;
import bw4_team5.entities.TicketSystem;
import bw4_team5.entities.Vehicle;
import bw4_team5.exceptions.UuidNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class TicketSystemDAO {
    private final EntityManager entityManager;

    public TicketSystemDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(TicketSystem newTicketSystem) {
        try {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newTicketSystem);
        transaction.commit();
        System.out.println("TicketSystem :" + newTicketSystem.getName() + " It was created successfully!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    // Salva un nuovo Ticket, assicurandosi che il vendor sia presente
    public void saveTicket(Ticket ticket) {
        if (ticket.getVendor() == null) {
            throw new IllegalArgumentException("Il vendor deve essere specificato per il ticket.");
        }
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(ticket);
        transaction.commit();
        System.out.println("Biglietto creato! Stato del biglietto: " + ticket.getStatus() + ", UUID venditore: " + ticket.getVendor().getUuid() + "nome venditore: " + ticket.getVendor().getName());
    }

    // Metodo per vidimare un biglietto e assegnare il veicolo
    public void endorseTicket(UUID ticketId, long vehicleId) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Ticket ticket = entityManager.find(Ticket.class, ticketId);
        if (ticket == null) {
            transaction.rollback();
            throw new IllegalArgumentException("Ticket non trovato.");
        }
        Vehicle vehicle = entityManager.find(bw4_team5.entities.Vehicle.class, vehicleId);
        if (vehicle == null) {
            transaction.rollback();
            throw new IllegalArgumentException("Veicolo non trovato.");
        }
        ticket.setStatus(bw4_team5.enums.TicketStatus.ENDORSED);
        ticket.setVehicle(vehicle);
        entityManager.merge(ticket);
        transaction.commit();
        System.out.println("Biglietto vidimato! Stato: " + ticket.getStatus() + ", veicolo: " + vehicle.getId());
    }

    public TicketSystem findTicketSystemByUuid(String uuid) {
        TicketSystem found = entityManager.find(TicketSystem.class, UUID.fromString(uuid));
        if (found == null) throw new UuidNotFoundException(uuid);
        return found;
    }
//da rifare
    public Iterable<? extends TicketSystem> findAllAuthorizedResellers() {
        Iterable<TicketSystem> resellers = entityManager.createQuery("SELECT ts FROM TicketSystem ts WHERE ts.isAuthorized = true", TicketSystem.class)
                .getResultList();
        if (!resellers.iterator().hasNext()) {
            System.out.println("Nessun rivenditore autorizzato trovato.");
        }
        return resellers;
    }
    public Iterable<? extends TicketSystem> findAllVendingMachines() {
        Iterable<TicketSystem> vendingMachines = entityManager.createQuery("SELECT ts FROM TicketSystem ts WHERE ts.isVendingMachine = true", TicketSystem.class)
                .getResultList();
        if (!vendingMachines.iterator().hasNext()) {
            System.out.println("Nessuna macchina automatica trovata.");
        }
        return vendingMachines;
    }
}
