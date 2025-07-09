package bw4_team5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorized_resellers")
public class AuthorizedReseller extends TicketSystem {

    public AuthorizedReseller() {
    }

    public AuthorizedReseller(String name, String location) {
        super(name, location);
    }

    @Override
    public String toString() {
        return "AuthorizedReseller{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                "} " + super.toString();
    }
}
