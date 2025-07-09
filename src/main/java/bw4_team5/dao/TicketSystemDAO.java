package bw4_team5.dao;

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

    public TicketSystem findTicketSystemByUuid(String uuid) {
        TicketSystem found = entityManager.find(TicketSystem.class, UUID.fromString(uuid));
        if (found == null) throw new UuidNotFoundException(uuid);
        return found;
    }
}
