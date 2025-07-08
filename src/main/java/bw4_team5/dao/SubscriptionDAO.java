package bw4_team5.dao;

import bw4_team5.entities.Subscription;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class SubscriptionDAO {
    private EntityManager em;

    public SubscriptionDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Subscription subscription) {
        em.getTransaction().begin();
        em.persist(subscription);
        em.getTransaction().commit();
    }

    public Subscription findById(UUID id) {
        return em.find(Subscription.class, id);
    }

    public List<Subscription> findAll() {
        TypedQuery<Subscription> query = em.createQuery("SELECT s FROM Subscription s", Subscription.class);
        return query.getResultList();
    }

    public void update(Subscription subscription) {
        em.getTransaction().begin();
        em.merge(subscription);
        em.getTransaction().commit();
    }

    public void delete(UUID id) {
        em.getTransaction().begin();
        Subscription subscription = em.find(Subscription.class, id);
        if (subscription != null) {
            em.remove(subscription);
        }
        em.getTransaction().commit();
    }
}