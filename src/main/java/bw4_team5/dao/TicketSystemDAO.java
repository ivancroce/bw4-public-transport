package bw4_team5.dao;

import bw4_team5.entities.Ticket;
import bw4_team5.entities.TicketSystem;
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
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newTicketSystem);
        transaction.commit();
        System.out.println("Il rivenditore" + newTicketSystem.getName() + " è stato creato correttamente!");
    }

    // Salva un nuovo Ticket
    public void saveTicket(Ticket ticket) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(ticket);
        transaction.commit();
        System.out.println("Biglietto creato! Stato del biglietto: " + ticket.getStatus());
    }

    public TicketSystem findTicketSystemByUuid(String uuid) {
        TicketSystem found = entityManager.find(TicketSystem.class, UUID.fromString(uuid));
        if (found == null) throw new UuidNotFoundException(uuid);
        return found;
    }
}
