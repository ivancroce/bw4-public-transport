package bw4_team5;

import bw4_team5.dao.*;
import bw4_team5.entities.*;
import bw4_team5.enums.ServiceVehicleStatus;
import bw4_team5.enums.ServiceVendingStatus;
import bw4_team5.enums.TypeSubscription;
import bw4_team5.enums.UserType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw4_public_transport_pu");


    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        // Instances of DAO
        TicketSystemDAO tsd = new TicketSystemDAO(em);
        UserDAO ud = new UserDAO(em);
        VehicleDAO vd = new VehicleDAO(em);
        SubscriptionDAO sd = new SubscriptionDAO(em);
        CardDAO cd = new CardDAO(em);
        RouteDAO rd = new RouteDAO(em);

        //CREATION RECORD TICKETSYSTEM
        AuthorizedReseller reseller1 = new AuthorizedReseller("FrancoSrl", "Roma");
        VendingMachine machine1 = new VendingMachine("AlbertoMachine", "Milano", ServiceVendingStatus.ACTIVE);
        // tsd.save(reseller1);
        // tsd.save(machine1);

        // ------- TEST ------- Create User, Card and Subscription
        User mario = new User("Mario", "Balotelli", UserType.CUSTOMER);
        // ud.save(mario);

        User marioFromDb = ud.findUserById(352);
        Card mariosCard = new Card(marioFromDb);
        // cd.save(mariosCard);

        Card mariosCardFromDb = cd.findCardById(52);
        TicketSystem machine1FromDb = tsd.findTicketSystemByUuid("edee78f8-3ba4-4704-a001-95f84d3c9162");
        Subscription mariosSub = new Subscription(LocalDate.of(2025, 6, 12), TypeSubscription.MONTHLY, machine1FromDb, mariosCardFromDb);
        // sd.save(mariosSub);
        // System.out.println("Subscription saved for " + mario.getFirstName());

        // ------- END TEST -------

        //CREATION RECORD TICKETS

        /* Ticket ticket1 = new Ticket(LocalDate.of(2025, 7, 8), TicketStatus.NOT_ENDORSED);
        Ticket ticket3 = new Ticket(LocalDate.of(2025, 5, 7), TicketStatus.ENDORSED);
        Ticket ticket4 = new Ticket(LocalDate.of(2023, 4, 6), TicketStatus.NOT_ENDORSED);
        Ticket ticket5 = new Ticket(LocalDate.of(2025, 2, 5), TicketStatus.ENDORSED);
        Ticket ticket2 = new Ticket(LocalDate.of(2022, 3, 4), TicketStatus.NOT_ENDORSED); */

        //CREATION RECORD USERS
        User admin1 = new User("Mirco", "l'amministratore", UserType.ADMIN);
        User user2 = new User("Gino", "L'utente", UserType.CUSTOMER);

        // ud.save(user1);
        // ud.save(user2);


        //CREATION RECORD VEHICLES
        Vehicle bus1 = new Bus("BH000ZS", 2025, ServiceVehicleStatus.MAINTENANCE, 40);
        Vehicle bus2 = new Bus("VG020GS", 1994, ServiceVehicleStatus.IN_SERVICE, 50);
        Vehicle bus3 = new Bus("YT030HH", 2009, ServiceVehicleStatus.IN_SERVICE, 35);

        Vehicle tram1 = new Tram("XX987II", 2020, ServiceVehicleStatus.MAINTENANCE, 130);
        Vehicle tram2 = new Tram("SS222RR", 2010, ServiceVehicleStatus.IN_SERVICE, 120);
        Vehicle tram3 = new Tram("GH333TT", 2015, ServiceVehicleStatus.IN_SERVICE, 140);

        /*vd.save(bus1);
        vd.save(bus2);
        vd.save(bus3);
        vd.save(tram1);
        vd.save(tram2);
        vd.save(tram3);*/

        // Save routes
        Route romeRoute = new Route("Rome Street", "Rome station", 120);
        Route milanRoute = new Route("Milan Street", "Milan station", 45);
        Route naplesRoute = new Route("Naples Street", "Naples station", 20);
        /* rd.save(romeRoute);
        rd.save(milanRoute);
        rd.save(naplesRoute); */

        // Save Travel Routes
        // to continue

        em.close();
        emf.close();
    }
}
