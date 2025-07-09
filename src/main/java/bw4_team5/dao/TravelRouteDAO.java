package bw4_team5.dao;

import bw4_team5.entities.TravelRoute;
import bw4_team5.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TravelRouteDAO {
    private final EntityManager entityManager;

    public TravelRouteDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(TravelRoute newTravelRoute){
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newTravelRoute);
            transaction.commit();
            System.out.println("Il percorso :" + newTravelRoute.getId() +" è stato creato correttamente!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public TravelRoute findTravelRouteById(long id){
        TravelRoute found = entityManager.find(TravelRoute.class,id);
        if (found == null) throw new NotFoundException(id);
        return found;

    }
}
