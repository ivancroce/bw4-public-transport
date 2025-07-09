package bw4_team5.dao;

import bw4_team5.entities.Subscription;
import bw4_team5.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class SubscriptionDAO {
    private final EntityManager entityManager;

    public SubscriptionDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Subscription newSubscription) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newSubscription);
            transaction.commit();
            System.out.println("Subscription with ID '" + newSubscription.getId() + "' has been successfully created!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Subscription findSubscriptionById(long id) {
        Subscription found = entityManager.find(Subscription.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }
}