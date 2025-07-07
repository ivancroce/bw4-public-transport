package bw4_team5.entities;

import bw4_team5.enums.ServiceVendingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class VendingMachine extends TicketSystem{
    @Enumerated(EnumType.STRING)
    private ServiceVendingStatus status;

    public VendingMachine(){}

    public VendingMachine(String name, String location, ServiceVendingStatus status){
        super(name, location);
        this.status = status;
    }

    public ServiceVendingStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceVendingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
                "status=" + status +
                '}';
    }
}
