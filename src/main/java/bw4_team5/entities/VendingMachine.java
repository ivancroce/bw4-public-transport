package bw4_team5.entities;

import bw4_team5.enums.ServiceStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class VendingMachine extends TicketSystem{
    @Enumerated(EnumType.STRING)
    private ServiceStatus status;

    public VendingMachine(){}

    public VendingMachine(String name,String location,ServiceStatus status){
        super(name, location);
        this.status = status;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
                "status=" + status +
                '}';
    }
}
