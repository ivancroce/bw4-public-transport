package bw4_team5.dao;

import bw4_team5.entities.User;
import bw4_team5.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

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
        System.out.println("User :" + newUser.getFirstName() + " it was created successfully!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public User findUserById(long id) {
        User found = entityManager.find(User.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public User findUserByCardId(long id){
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u JOIN Card c ON c.user.id = u.id WHERE c.id = :cardId", User.class);
        query.setParameter("cardId", id);
        return query.getSingleResult();


    }

}
