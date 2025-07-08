package bw4_team5;

import bw4_team5.dao.TicketSystemDAO;
import bw4_team5.entities.*;
import bw4_team5.enums.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw4_public_transport_pu");





    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        //CREATION RECORD TICKETSYSTEM
        AuthorizedReseller reseller1 = new AuthorizedReseller("FrancoSrl", "Roma");
        VendingMachine machine1 = new VendingMachine("AlbertoMachine","Milano", ServiceVendingStatus.ACTIVE);

        //CREATION RECORD SUBSCRIPTIONS
        Subscription subscription1 = new Subscription(LocalDate.of(2024, 8, 8), TypeSubscription.MONTHLY);
        Subscription subscription2 = new Subscription(LocalDate.of(2025, 6, 30), TypeSubscription.MONTHLY);


        //CREATION RECORD TICKETS
        Ticket ticket1 = new Ticket(LocalDate.of(2025, 7, 8), TicketStatus.NOT_ENDORSED);
        Ticket ticket3 = new Ticket(LocalDate.of(2025, 5, 7), TicketStatus.ENDORSED);
        Ticket ticket4 = new Ticket(LocalDate.of(2023, 4, 6), TicketStatus.NOT_ENDORSED);
        Ticket ticket5 = new Ticket(LocalDate.of(2025, 2, 5), TicketStatus.ENDORSED);
        Ticket ticket2 = new Ticket(LocalDate.of(2022, 3, 4), TicketStatus.NOT_ENDORSED);

        //CREATION RECORD USERS
        /*Card card1 = new Card(1, LocalDate.of(2025, 9,29),subscription1);
        User user1 = new User(1,"Mario","Balotelli",card1, UserType.CUSTOMER);
        User admin1= new User(2, "Mirco", "l'amministratore", UserType.ADMIN);
        User user2 = new User(3, "Gino", "L'utente", UserType.CUSTOMER);
        User user3 = new User(1,"Daniele","IlTesserato",new Card(2, LocalDate.of(2025, 4,1), subscription2), UserType.CUSTOMER);*/

        //CREATION RECORD VEHICLES
        Vehicle bus1 = new Bus(1,"BH000ZS", 2025, ServiceVehicleStatus.MAINTENANCE,40);
        Vehicle bus2 = new Bus(2,"VG020GS", 1994, ServiceVehicleStatus.IN_SERVICE,50);
        Vehicle bus3 = new Bus(3,"YT030HH", 2009, ServiceVehicleStatus.IN_SERVICE,35);

        Vehicle tram1 = new Tram(1, "XX987II", 2020, ServiceVehicleStatus.MAINTENANCE, 130);
        Vehicle tram2 = new Tram(2, "SS222RR", 2010, ServiceVehicleStatus.IN_SERVICE, 120);
        Vehicle tram3 = new Tram(3, "GH333TT", 2015, ServiceVehicleStatus.IN_SERVICE, 140);

        // --- SALVATAGGIO DATI NEL DATABASE ---
        bw4_team5.dao.UserDAO userDAO = new bw4_team5.dao.UserDAO(em);

        bw4_team5.dao.VehicleDao vehicleDao = new bw4_team5.dao.VehicleDao(em);

        bw4_team5.dao.SubscriptionDAO subscriptionDAO = new bw4_team5.dao.SubscriptionDAO(em);

        bw4_team5.dao.TicketSystemDAO ticketSystemDAO = new bw4_team5.dao.TicketSystemDAO(em);

      /*  // Salva TicketSystem
        ticketSystemDAO.save(reseller1);
        ticketSystemDAO.save(machine1);*/

        // Salva Subscriptions
        subscriptionDAO.save(subscription1);
        subscriptionDAO.save(subscription2);

        // Crea e salva Card collegate alle Subscription
        Card card1 = new Card(LocalDate.of(2025, 9,29), subscription1);
        Card card2 = new Card(LocalDate.of(2025, 4,1), subscription2);

        em.getTransaction().begin();

      /*  em.persist(card1);
        em.persist(card2);*/

        em.getTransaction().commit();

        // Crea Users collegando le Card già salvate
        User user1 = new User("Mario","Balotelli",card1, UserType.CUSTOMER);
        User admin1= new User("Mirco", "l'amministratore", UserType.ADMIN);
        User user2 = new User("Gino", "L'utente", UserType.CUSTOMER);
        User user3 = new User("Daniele","IlTesserato",card2, UserType.CUSTOMER);

      /*  // Salva Users
        userDAO.save(user1);
        userDAO.save(admin1);
        userDAO.save(user2);
        userDAO.save(user3);*/


        System.out.println("Hello World!");
    }
}
