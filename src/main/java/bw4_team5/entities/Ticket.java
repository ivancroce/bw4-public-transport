package bw4_team5.entities;

import bw4_team5.enums.TicketStatus;

import java.time.LocalDate;
import java.util.UUID;

public class Ticket {
    private UUID uuid;
    private LocalDate issueDate;
    private TicketStatus status;
    private int vendorId;

    public Ticket(){}

    public Ticket(LocalDate issueDate,TicketStatus status, int vendorId){
        this.issueDate = issueDate;
        this.status = status;
        this.vendorId = vendorId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getVendorId() {
        return vendorId;
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
                "uuid=" + uuid +
                ", issueDate=" + issueDate +
                ", vendorId=" + vendorId +
                ", status=" + status +
                '}';
    }
}
