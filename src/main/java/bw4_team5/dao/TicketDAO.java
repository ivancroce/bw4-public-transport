package bw4_team5.dao;

import bw4_team5.entities.Ticket;
import bw4_team5.entities.Vehicle;
import bw4_team5.enums.TicketStatus;
import bw4_team5.exceptions.UuidNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class TicketDAO {
    private final EntityManager entityManager;

    public TicketDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Ticket newTicket) {
        try {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newTicket);
        transaction.commit();
        System.out.println("Ticket con id '" + newTicket.getId() + "it was created successfully!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public Ticket findTicketByUuid(UUID uuid) {
        Ticket found = entityManager.find(Ticket.class, uuid);
        if (found == null) throw new UuidNotFoundException(uuid.toString() + " not found.");
        return found;
    }

    public void endorseTicket(UUID ticketUuid, Vehicle vehicle) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Ticket ticket = entityManager.find(Ticket.class, ticketUuid);

        if (ticket == null) throw new UuidNotFoundException(ticketUuid.toString());
        if (ticket.getStatus() == TicketStatus.ENDORSED) {
            throw new IllegalStateException("The ticket is not valid for validation.");
        }
        ticket.setStatus(bw4_team5.enums.TicketStatus.ENDORSED);
        ticket.setVehicle(vehicle);
        entityManager.merge(ticket);
        transaction.commit();
        System.out.println("Ticket " + ticketUuid + " stamped on the vehicle " + vehicle.getId());
    }
}