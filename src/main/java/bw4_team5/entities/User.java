package bw4_team5.entities;

import bw4_team5.enums.UserType;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public abstract class User {
    @Id
    @GeneratedValue
    protected long id;
    protected String firstName;
    protected String lastName;
    @OneToOne(mappedBy = "user")
    private Card card;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(){}

    public User( long id,String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName +
                ", id=" + id + '\'' +
                '}';
    }
}
