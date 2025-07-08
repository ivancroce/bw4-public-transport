package bw4_team5.entities;

import bw4_team5.enums.ServiceVehicleStatus;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("bus")
public class Bus extends Vehicle {

    public Bus() {
    }

    public Bus(String numberPlate, int registrationYear, ServiceVehicleStatus status, int capacity) {
        super(numberPlate, registrationYear, status, capacity);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", numberPlate='" + numberPlate + '\'' +
                ", registrationYear=" + registrationYear +
                ", status=" + status +
                ", capacity=" + capacity +
                '}';
    }
}
