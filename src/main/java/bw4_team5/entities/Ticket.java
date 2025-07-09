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
    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private TicketSystem vendor;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public Ticket() {
    }

    public Ticket(LocalDate issueDate, TicketStatus status) {
        this.issueDate = issueDate;
        this.status = status;
    }

    public Ticket(LocalDate issueDate, TicketStatus status, TicketSystem vendor) {
        this.issueDate = issueDate;
        this.status = status;
        this.vendor = vendor;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public TicketSystem getVendor() {
        return vendor;
    }

    public void setVendor(TicketSystem vendor) {
        this.vendor = vendor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", issueDate=" + issueDate +
                ", status=" + status +
                ", vendor=" + vendor +
                ", vehicle=" + vehicle +
                '}';
    }
}
