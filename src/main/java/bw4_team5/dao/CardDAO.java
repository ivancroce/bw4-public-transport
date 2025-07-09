package bw4_team5.dao;

import bw4_team5.entities.Card;
import bw4_team5.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CardDAO {
    private final EntityManager entityManager;

    public CardDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Card newCard) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newCard);
            transaction.commit();
            System.out.println("Card with ID '" + newCard.getId() + "' has been successfully created!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Card findCardById(long id) {
        Card found = entityManager.find(Card.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }
}
