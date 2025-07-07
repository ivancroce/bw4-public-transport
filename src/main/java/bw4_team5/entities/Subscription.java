package bw4_team5.entities;

import bw4_team5.enums.TypeSubscription;

import java.time.LocalDate;
import java.util.UUID;

public class Subscription {
    private long id;
    private LocalDate issueDate;
    private TypeSubscription type;
    private UUID vendorId;

    public Subscription(){}

    public Subscription(long id, LocalDate issueDate, TypeSubscription type, UUID vendorId) {
        this.id = id;
        this.issueDate = issueDate;
        this.type = type;
        this.vendorId = vendorId;
    }

    public long getId() {
        return id;
    }

    public UUID getVendorId() {
        return vendorId;
    }

    public void setVendorId(UUID vendorId) {
        this.vendorId = vendorId;
    }

    public TypeSubscription getType() {
        return type;
    }

    public void setType(TypeSubscription type) {
        this.type = type;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", issueDate=" + issueDate +
                ", type=" + type +
                ", vendorId=" + vendorId +
                '}';
    }
}
