package bw4_team5.entities;

import bw4_team5.enums.TypeSubscription;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate issueDate;
    @Enumerated(EnumType.STRING)
    private TypeSubscription type;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private TicketSystem vendorId;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public Subscription(){}

    public Subscription(long id, LocalDate issueDate, TypeSubscription type) {
        this.id = id;
        this.issueDate = issueDate;
        this.type = type;
    }

    public long getId() {
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
