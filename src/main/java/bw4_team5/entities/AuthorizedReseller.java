package bw4_team5.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "authorized_reseller")
public class AuthorizedReseller extends TicketSystem{
    @Id
    @GeneratedValue
    private UUID uuid;

    public AuthorizedReseller(){}

    public AuthorizedReseller(String name,String location){
        super(name,location);
    }

    @Override
    public String toString() {
        return "AuthorizedReseller{" +
                "name='" + name + '\'' +
                ", uuid=" + uuid +
                ", location='" + location + '\'' +
                '}';
    }
}
