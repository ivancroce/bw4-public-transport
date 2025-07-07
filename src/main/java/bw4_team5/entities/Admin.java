package bw4_team5.entities;

public class Admin extends User{

    public Admin(){}

    public Admin(long id,String firstName,String lastName){
        super(id,firstName,lastName);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
