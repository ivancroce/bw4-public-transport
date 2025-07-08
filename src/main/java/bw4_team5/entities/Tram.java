package bw4_team5.entities;

import bw4_team5.enums.ServiceVehicleStatus;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("trams")
public class Tram extends Vehicle{

    public Tram(){}

    public Tram(long id, String numberPlate, int registrationYear, ServiceVehicleStatus status, int capacity){
        super(id, numberPlate, registrationYear, status, capacity);
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
