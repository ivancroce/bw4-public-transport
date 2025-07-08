package bw4_team5.entities;

import bw4_team5.enums.ServiceVehicleStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type")
@Table
public abstract class Vehicle {
    @Id
    @GeneratedValue
    protected long id;
    @Column(name = "number_plate")
    protected String numberPlate;
    @Column(name = "registration_year")
    protected int registrationYear;
    @Enumerated(EnumType.STRING)
    protected ServiceVehicleStatus status;
    protected int capacity;

    @OneToMany(mappedBy = "vehicle")
    private List<Ticket> ticketList= new ArrayList<>();

    @OneToMany(mappedBy = "vehicle")
    private List<VehicleStateLogs> vehicleStateLogsList= new ArrayList<>();


    public Vehicle(){}

    public Vehicle(long id, String numberPlate, int registrationYear, ServiceVehicleStatus status,int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.numberPlate = numberPlate;
        this.registrationYear = registrationYear;
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
                ", capacity=" + capacity +
                '}';
    }
}
