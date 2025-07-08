package bw4_team5.dao;

import bw4_team5.entities.TicketSystem;
import bw4_team5.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserDAO {
    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(User newUser) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newUser);
        transaction.commit();
        System.out.println("L'utente" + newUser.getFirstName() + " è stato creato correttamente!");
    }
}
