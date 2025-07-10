package bw4_team5.dao;

import bw4_team5.entities.Subscription;
import bw4_team5.exceptions.NotFoundException;
import bw4_team5.exceptions.UuidNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Id;

import java.util.UUID;

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
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public Subscription findSubscriptionByUuid(String uuid) {
        Subscription found = entityManager.find(Subscription.class, UUID.fromString(uuid));
        if (found == null) throw new UuidNotFoundException(uuid);
        return found;
    }
}