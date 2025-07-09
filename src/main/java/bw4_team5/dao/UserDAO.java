package bw4_team5.dao;

import bw4_team5.entities.User;
import bw4_team5.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserDAO {
    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(User newUser) {
        try {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newUser);
        transaction.commit();
        System.out.println("L'utente" + newUser.getFirstName() + " è stato creato correttamente!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public User findUserById(long id) {
        User found = entityManager.find(User.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

}
