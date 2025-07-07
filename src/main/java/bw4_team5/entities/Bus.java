package bw4_team5.entities;

import bw4_team5.enums.ServiceVehicleStatus;

public class Bus extends Vehicle{

    public Bus(){}

    public Bus(long id, String numberPlate, int registrationYear, ServiceVehicleStatus status,int capacity,Route route){
        super(id, numberPlate, registrationYear, route, status, capacity);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", numberPlate='" + numberPlate + '\'' +
                ", registrationYear=" + registrationYear +
                ", route=" + route +
                ", status=" + status +
                ", capacity=" + capacity +
                '}';
    }
}
