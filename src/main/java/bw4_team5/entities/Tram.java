package bw4_team5.entities;

import bw4_team5.enums.ServiceVehicleStatus;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("tram")
public class Tram extends Vehicle {

    public Tram() {
    }

    public Tram(String numberPlate, int registrationYear, ServiceVehicleStatus status, int capacity) {
        super(numberPlate, registrationYear, status, capacity);
    }

    @Override
    public String toString() {
        return "Tram{" +
                "id=" + id +
                ", numberPlate='" + numberPlate + '\'' +
                ", registrationYear=" + registrationYear +
                ", status=" + status +
                ", capacity=" + capacity +
                '}';
    }
}
