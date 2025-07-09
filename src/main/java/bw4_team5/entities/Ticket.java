package bw4_team5.entities;

import bw4_team5.enums.TicketStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private TicketSystem vendorId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public Ticket(){}

    public Ticket(LocalDate issueDate,TicketStatus status){
        this.issueDate = issueDate;
        this.status = status;
    }

    public UUID getUuid() {
        return id;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "uuid=" + id +
                ", issueDate=" + issueDate +
                ", vendorId=" + vendorId +
                ", status=" + status +
                '}';
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
