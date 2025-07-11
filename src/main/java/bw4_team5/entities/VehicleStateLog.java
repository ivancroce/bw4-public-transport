package bw4_team5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vehicle_state_logs")
public class VehicleStateLog {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    private String cause;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public VehicleStateLog(){}

    public VehicleStateLog(LocalDate startDate, String cause, LocalDate endDate, Vehicle vehicle) {
        this.startDate = startDate;
        this.cause = cause;
        this.endDate = endDate;
        this.vehicle = vehicle;
    }

    public long getId() {
        return id;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "VehicleStateLogs{" +
                "cause='" + cause + '\'' +
                ", id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
