package bw4_team5.dao;

import bw4_team5.entities.Route;
import bw4_team5.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class RouteDAO {
    private final EntityManager entityManager;

    public RouteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Route newRoute) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newRoute);
            transaction.commit();
            System.out.println("Route with ID '" + newRoute.getId() + "' has been successfully created!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Route findRouteById(long id) {
        Route found = entityManager.find(Route.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public List <Route> findAllRoutes() {
        List<Route> routes = entityManager.createQuery("SELECT r FROM Route r", Route.class).getResultList();
        if (routes.isEmpty()) {
            System.out.println("No routes found.");
        }
        return routes;
    }
}
