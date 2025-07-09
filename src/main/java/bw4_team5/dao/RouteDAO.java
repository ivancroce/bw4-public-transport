package bw4_team5.dao;

import bw4_team5.entities.Route;
import bw4_team5.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RouteDAO {
    private final EntityManager entityManager;

    public RouteDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Route newRoute){
        try {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newRoute);
        transaction.commit();
        System.out.println("La rotta da :"+ newRoute.getStartRoute() + "per : "+ newRoute.getTerminal()+" è stata creata correttamente!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public Route findRouteById(long id){
        Route found = entityManager.find(Route.class,id);
        if (found == null) throw new NotFoundException(id);
        return found;

    }
}
