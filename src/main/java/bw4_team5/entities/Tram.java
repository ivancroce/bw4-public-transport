package bw4_team5.entities;

import bw4_team5.enums.ServiceVehicleStatus;

public class Tram extends Vehicle{

    public Tram(){}

    public Tram(long id, String numberPlate, int registrationYear, ServiceVehicleStatus status, int capacity, Route route){
        super(id, numberPlate, registrationYear, route, status, capacity);
    }

    @Override
    public String toString() {
        return "Tram{" +
                "id=" + id +
                ", numberPlate='" + numberPlate + '\'' +
                ", registrationYear=" + registrationYear +
                ", route=" + route +
                ", status=" + status +
                ", capacity=" + capacity +
                '}';
    }
}
