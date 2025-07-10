package bw4_team5.dao;

import bw4_team5.entities.TravelRoute;
import bw4_team5.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class TravelRouteDAO {
    private final EntityManager entityManager;

    public TravelRouteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(TravelRoute newTravelRoute) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newTravelRoute);
            transaction.commit();
            System.out.println("Travel Route with ID '" + newTravelRoute.getId() + "' has been successfully created!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public TravelRoute findTravelRouteById(long id) {
        TravelRoute found = entityManager.find(TravelRoute.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void updateActualTravelTime(TravelRoute travelRoute) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            long id = travelRoute.getId();
            Integer time = travelRoute.getActualTravelTime();

            Query query = entityManager.createQuery(
                    "UPDATE TravelRoute t SET t.actualTravelTime = :time WHERE t.id = :id"
            );

            query.setParameter("time", time);
            query.setParameter("id", id);

            int numUpdated = query.executeUpdate();

            transaction.commit();
            System.out.println(numUpdated + " items have been successfully modified!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
