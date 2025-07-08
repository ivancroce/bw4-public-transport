package bw4_team5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vehicle_state_logs")
public class VehicleStateLogs {
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

    public VehicleStateLogs(){}

    public VehicleStateLogs(LocalDate startDate, long id, String cause, LocalDate endDate) {
        this.startDate = startDate;
        this.id = id;
        this.cause = cause;
        this.endDate = endDate;
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
