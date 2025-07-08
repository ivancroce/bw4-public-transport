package bw4_team5.entities;

import bw4_team5.enums.TypeSubscription;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate issueDate;
    @Enumerated(EnumType.STRING)
    private TypeSubscription type;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private TicketSystem vendorId;

    @OneToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public Subscription(){}

    public Subscription( LocalDate issueDate, TypeSubscription type) {
        this.issueDate = issueDate;
        this.type = type;
    }

    public UUID getId() {
        return id;
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
