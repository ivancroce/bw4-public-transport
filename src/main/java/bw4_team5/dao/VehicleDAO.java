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
            System.out.println("Il veicolo " + newVehicle.getNumberPlate() + " è stato creato correttamente!");
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

    public Vehicle[] findAllBuses() {
        Vehicle[] buses = entityManager.createQuery("SELECT b FROM Bus b", Vehicle.class).getResultList().toArray(new Vehicle[0]);
        if (buses.length == 0) {
            System.out.println("Nessun bus trovato.");
        }
        return buses;
    }

    public Vehicle[] findAllInServiceVehicles() {
    Vehicle[] vehicles = entityManager.createQuery("SELECT v FROM Vehicle v WHERE v.status = 'IN_SERVICE'", Vehicle.class).getResultList().toArray(new Vehicle[0]);
        if (vehicles.length == 0) {
            System.out.println("Nessun veicolo in servizio trovato.");
        }
        return vehicles;
    }

    public Vehicle[] findAllMaintenanceVehicles() {
    Vehicle[] vehicles = entityManager.createQuery("SELECT v FROM Vehicle v WHERE v.status = 'UNDER_MAINTENANCE'", Vehicle.class).getResultList().toArray(new Vehicle[0]);
        if (vehicles.length == 0) {
            System.out.println("Nessun veicolo in manutenzione trovato.");
        }
        return vehicles;
    }

    public Vehicle[] findAllNotInServiceVehicles() {
    Vehicle[] vehicles = entityManager.createQuery("SELECT v FROM Vehicle v WHERE v.status = 'NOT_IN_SERVICE'", Vehicle.class).getResultList().toArray(new Vehicle[0]);
        if (vehicles.length == 0) {
            System.out.println("Nessun veicolo non in servizio trovato.");
        }
        return vehicles;
    }

    public Vehicle findVehicleById(long vehicleId) {
    Vehicle found = entityManager.find(Vehicle.class, vehicleId);
        if (found == null) throw new NotFoundException(vehicleId);
        return found;
    }

    public Vehicle[] findAllTrams() {
        Vehicle[] trams = entityManager.createQuery("SELECT t FROM Tram t", Vehicle.class).getResultList().toArray(new Vehicle[0]);
        if (trams.length == 0) {
            System.out.println("Nessun tram trovato.");
        }
        return trams;
    }
}
