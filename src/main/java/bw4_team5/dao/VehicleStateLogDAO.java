package bw4_team5.dao;


import bw4_team5.entities.VehicleStateLog;
import bw4_team5.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;


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
        System.out.println("The vehicleStateLog" + vehicleStateLog.getCause() + " it was created successfully!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public VehicleStateLog findVehicleStateLogById(long id) {
        VehicleStateLog found = entityManager.find(VehicleStateLog.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }
    public List<VehicleStateLog> getAllLogs() {
        try {
            TypedQuery<VehicleStateLog> query = entityManager.createQuery(
                    "SELECT vsl FROM VehicleStateLog vsl ORDER BY vsl.vehicle.id, vsl.startDate", VehicleStateLog.class);
            return query.getResultList();
        } catch (Exception exception){
            System.out.println("Errore nel caricamento dei dati quindi la lista è vuota!" + exception.getMessage());
            return List.of();
        }
    }

    public List<VehicleStateLog> getLogsByVehicleId(long vehicleId) {
        try {
            TypedQuery<VehicleStateLog> query = entityManager.createQuery(
                            "SELECT vsl FROM VehicleStateLog vsl WHERE vsl.vehicle.id = :vehicleId", VehicleStateLog.class)
                    .setParameter("vehicleId", vehicleId);
            return query.getResultList();
        } catch (Exception exception){
            System.out.println("Errore nel caricamento dei dati quindi la lista è vuota!" + exception.getMessage());
            return List.of();
        }
    }

    public List<VehicleStateLog> getLogsByDateRange(LocalDate from, LocalDate to) {
        try {
            TypedQuery<VehicleStateLog> query = entityManager.createQuery(
                            "SELECT vsl FROM VehicleStateLog vsl WHERE vsl.startDate >= :from AND vsl.endDate <= :to", VehicleStateLog.class)
                    .setParameter("from", from)
                    .setParameter("to", to);
            return query.getResultList();
        } catch (Exception exception){
            System.out.println("Errore nel caricamento dei dati quindi la lista è vuota!" + exception.getMessage());
            return List.of();
        }
    }

    public List<VehicleStateLog> getLogsByVehicleAndDateRange(long vehicleId, LocalDate from, LocalDate to) {
        try {
            TypedQuery<VehicleStateLog> query = entityManager.createQuery(
                            "SELECT vsl FROM VehicleStateLog vsl WHERE vsl.vehicle.id = :vehicleId AND vsl.startDate >= :from AND vsl.endDate <= :to", VehicleStateLog.class)
                    .setParameter("vehicleId", vehicleId)
                    .setParameter("from", from)
                    .setParameter("to", to);
            return query.getResultList();
        } catch (Exception exception){
            System.out.println("Errore nel caricamento dei dati quindi la lista è vuota!" + exception.getMessage());
            return List.of();
        }
    }
}
