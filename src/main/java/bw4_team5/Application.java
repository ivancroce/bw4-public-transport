package bw4_team5;

import bw4_team5.dao.*;
import bw4_team5.entities.*;
import bw4_team5.enums.*;
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

        //CREATION RECORD TICKETSYSTEM
        AuthorizedReseller reseller1 = new AuthorizedReseller("FrancoSrl", "Roma");
        VendingMachine machine1 = new VendingMachine("AlbertoMachine", "Milano", ServiceVendingStatus.ACTIVE);
        // tsd.save(reseller1);
        // tsd.save(machine1);

        // ------- TEST ------- Create User
        User mario = new User("Mario", "Balotelli", UserType.CUSTOMER);

        // ud.save(mario);

        User marioFromDb = ud.findUserById(302);

        Card mariosCard = new Card(marioFromDb);
        // cd.save(mariosCard);

        Card mariosCardFromDb = cd.findCardById(2);

        TicketSystem machine1FromDb = tsd.findTicketSystemByUuid("82b3c849-c2aa-4dc9-9a7e-4b67f71d2f92");
        Subscription mariosSub = new Subscription(LocalDate.of(2025, 6, 12), TypeSubscription.MONTHLY, machine1FromDb, mariosCardFromDb);
        sd.save(mariosSub);
        System.out.println("Subscription saved for " + mario.getFirstName());

        //CREATION RECORD TICKETS
        Ticket ticket1 = new Ticket(LocalDate.of(2025, 7, 8), TicketStatus.NOT_ENDORSED);
        Ticket ticket3 = new Ticket(LocalDate.of(2025, 5, 7), TicketStatus.ENDORSED);
        Ticket ticket4 = new Ticket(LocalDate.of(2023, 4, 6), TicketStatus.NOT_ENDORSED);
        Ticket ticket5 = new Ticket(LocalDate.of(2025, 2, 5), TicketStatus.ENDORSED);
        Ticket ticket2 = new Ticket(LocalDate.of(2022, 3, 4), TicketStatus.NOT_ENDORSED);

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

        //CREATION RECORD ROUTES

//        List<TravelRoute> travelRoutesBus1 = new ArrayList<>();
//
//        TravelRoute firstRouteBus1 = new TravelRoute(1, 200, LocalDate.of(2025,7,8),bus1 );
//
//        travelRoutesBus1.add(firstRouteBus1);
//        travelRoutesBus1.add
//
//        Route route1 = new Route(1, "Bari","Roma", 300, travelRoutesBus1);


        em.close();
        emf.close();
    }
}
