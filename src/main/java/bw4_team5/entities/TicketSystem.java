package bw4_team5.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tickets_systems")
public abstract class TicketSystem {
    @Id
    @GeneratedValue
    protected UUID uuid;
    @Column(nullable = false)
    protected String name;
    @Column(nullable = false)
    protected String location;

    @OneToMany(mappedBy = "vendor")
    private List<Ticket> ticketList = new ArrayList<>();

    @OneToMany(mappedBy = "vendor")
    private List<Subscription> subscriptionList = new ArrayList<>();

    public TicketSystem() {
    }

    public TicketSystem(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "TicketSystem{" +
                "uuid=" + uuid + '\'' +
                ", name='" + name +
                " ,location='" + location + '\'' +
                '}';
    }
}

