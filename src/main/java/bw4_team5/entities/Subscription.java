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
    @Column(name = "start_date", nullable = true)
    private LocalDate startDate;
    @Column(name = "end_date", nullable= true)
    private LocalDate endDate;
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private TypeSubscription type;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private TicketSystem vendor;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    public Subscription() {
    }

    public Subscription(LocalDate startDate, TypeSubscription type, TicketSystem vendor, Card card) {
        this.startDate = startDate;
        if (type == TypeSubscription.MONTHLY) {
            this.endDate = this.startDate.plusMonths(1);
        } else {
            this.endDate = this.startDate.plusWeeks(1);
        }
        this.type = type;
        this.vendor = vendor;
        this.card = card;
    }
    public Subscription(TicketSystem vendor, Card card){
        this.vendor=vendor;
        this.card=card;
    }

    public UUID getId() {
        return id;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public TypeSubscription getType() {
        return type;
    }

    public void setType(TypeSubscription type) {
        this.type = type;
    }

    public TicketSystem getVendor() {
        return vendor;
    }

    public void setVendor(TicketSystem vendor) {
        this.vendor = vendor;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    
}
