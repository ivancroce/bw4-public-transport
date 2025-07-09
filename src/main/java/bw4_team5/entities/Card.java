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
    @Column(name = "issue_date")
    private LocalDate issueDate;
    private LocalDate expirationDate;

    @OneToMany(mappedBy = "card")
    private List<Subscription> subscriptionList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Card() {
    }

    public Card(User user) {
        this.issueDate = LocalDate.now();
        this.expirationDate = issueDate.plusYears(1);
        this.user = user;
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
