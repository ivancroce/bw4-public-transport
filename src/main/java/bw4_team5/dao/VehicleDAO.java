package bw4_team5.dao;

import bw4_team5.entities.Bus;
import bw4_team5.entities.Tram;
import bw4_team5.entities.Vehicle;
import bw4_team5.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class VehicleDAO {
    private final EntityManager entityManager;

    public VehicleDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Vehicle newVehicle) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(newVehicle);
            transaction.commit();
            System.out.println("The vehicle " + newVehicle.getNumberPlate() + " it was created successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Bus findBusById(long id) {
        Bus found = entityManager.find(Bus.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public Tram findTramById(long id) {
        Tram found = entityManager.find(Tram.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }
}
