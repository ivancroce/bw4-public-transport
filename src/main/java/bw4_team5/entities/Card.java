package bw4_team5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate issueDate;
    private LocalDate expirationDate;

    @OneToMany(mappedBy = "card")
    private List <Subscription> subscriptionList= new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Card(){}

    public Card(LocalDate expirationDate, long id, LocalDate issueDate) {
        this.expirationDate = expirationDate.plusDays(365);
        this.id = id;
        this.issueDate = issueDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public long getId() {
        return id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                " ,expirationDate=" + expirationDate +
                ", issueDate=" + issueDate +
                '}';
    }
}
