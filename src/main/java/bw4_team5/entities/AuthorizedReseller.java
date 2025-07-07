package bw4_team5.entities;

import jakarta.persistence.Entity;

@Entity
public class AuthorizedReseller extends TicketSystem{

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
