package bw4_team5.dao;


import bw4_team5.entities.VehicleStateLog;
import bw4_team5.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;



public class VehicleStateLogDAO {
    private final EntityManager entityManager;

    public VehicleStateLogDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(VehicleStateLog vehicleStateLog){
        try {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(vehicleStateLog);
        transaction.commit();
        System.out.println("Il tipo di riparazione" + vehicleStateLog.getCause() + " è stato creato correttamente!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public VehicleStateLog findVehicleStateLogById(long id) {
        VehicleStateLog found = entityManager.find(VehicleStateLog.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }
}
