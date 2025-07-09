package bw4_team5.dao;

import bw4_team5.entities.Subscription;
import bw4_team5.enums.TypeSubscription;
import bw4_team5.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class SubscriptionDAO {
    private final EntityManager entityManager;

    public SubscriptionDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Subscription newSubscription) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newSubscription);
        transaction.commit();
        System.out.println("Subscription with ID '" + newSubscription.getId() + "' has been successfully created!");
    }

    public Subscription findSubscriptionById(long id) {
        Subscription found = entityManager.find(Subscription.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void setSubscriptionType(TypeSubscription typeSubscription, long id){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("UPDATE Subscription s SET s.type = :type WHERE s.card.id = :card_id");
        query.setParameter("type", typeSubscription);
        query.setParameter("card_id", id);
        query.executeUpdate();
        transaction.commit();
        System.out.println("Elemento modificato con successo");
    }
}