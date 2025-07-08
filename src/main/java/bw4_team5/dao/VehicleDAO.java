package bw4_team5.dao;

import bw4_team5.entities.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class VehicleDAO {
    private final EntityManager entityManager;

    public VehicleDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Vehicle newVehicle) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newVehicle);
        transaction.commit();
        System.out.println("Il veicolo " + newVehicle.getNumberPlate() + " è stato creato correttamente!");
    }
}
