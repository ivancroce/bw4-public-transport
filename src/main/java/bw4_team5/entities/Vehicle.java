package bw4_team5.entities;

import bw4_team5.enums.ServiceVehicleStatus;

public abstract class Vehicle {
    protected long id;
    protected String numberPlate;
    protected int registrationYear;
    protected ServiceVehicleStatus status;
    protected int capacity;
    protected Route route;

    public Vehicle(){}

    public Vehicle(long id, String numberPlate, int registrationYear, Route route, ServiceVehicleStatus status,int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.numberPlate = numberPlate;
        this.registrationYear = registrationYear;
        this.route = route;
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(int registrationYear) {
        this.registrationYear = registrationYear;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public ServiceVehicleStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceVehicleStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", numberPlate='" + numberPlate + '\'' +
                ", registrationYear=" + registrationYear +
                ", status=" + status +
                ", route=" + route +
                ", capacity=" + capacity +
                '}';
    }
}
