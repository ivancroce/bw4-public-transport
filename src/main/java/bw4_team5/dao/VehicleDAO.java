package bw4_team5.dao;

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
            System.out.println("Il veicolo " + newVehicle.getNumberPlate() + " è stato creato correttamente!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Vehicle findVehicleById(long id) {
        Vehicle found = entityManager.find(Vehicle.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

}
