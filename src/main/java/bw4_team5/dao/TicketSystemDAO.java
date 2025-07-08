package bw4_team5.dao;

import bw4_team5.entities.TicketSystem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
}
