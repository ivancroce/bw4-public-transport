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
        TicketDAO ticketDAO = new TicketDAO(em);
        UserDAO ud = new UserDAO(em);
        VehicleDAO vd = new VehicleDAO(em);
        SubscriptionDAO sd = new SubscriptionDAO(em);
        CardDAO cd = new CardDAO(em);

        //CREATION RECORD TICKETSYSTEM
        AuthorizedReseller reseller1 = new AuthorizedReseller("FrancoSrl", "Roma");
        VendingMachine machine1 = new VendingMachine("AlbertoMachine", "Milano", ServiceVendingStatus.ACTIVE);
        VendingMachine machine2 = new VendingMachine("GiovanniMachine", "Torino", ServiceVendingStatus.ACTIVE);
        VendingMachine machine3 = new VendingMachine("LucaMachine", "Napoli", ServiceVendingStatus.NOT_ACTIVE);


        // Salva i TicketSystem nel database
        tsd.save(reseller1);
        tsd.save(machine1);
        tsd.save(machine2);
        tsd.save(machine3);

        // Recupera machine1 dal database tramite il suo UUID
        VendingMachine machine1FromDb = (VendingMachine) tsd.findTicketSystemByUuid(machine1.getUuid().toString());

        // ------- TEST ------- Create User, Card and Subscription
        User mario = new User("Mario", "Balotelli", UserType.CUSTOMER);
        ud.save(mario);

        User marioFromDb = ud.findUserById(mario.getId()); // Inserire l'id corretto dell'utente dal DB
        System.out.println("User retrieved: " + marioFromDb + " with ID: " + marioFromDb.getId());

        // Creazione della Card per l'utente Mario
        Card mariosCard = new Card(marioFromDb);
        cd.save(mariosCard);

        // Associa la Card all'utente Mario e salva l'utente aggiornato
        marioFromDb.setCard(mariosCard);
        ud.save(marioFromDb);

        Card mariosCardFromDb = cd.findCardById(302);//inserire l'id corretto della card dal DB
        System.out.println("Card retrieved: " + mariosCardFromDb + " with ID: " + mariosCardFromDb.getId());

        // Creazione della Subscription per l'utente Mario
        TicketSystem machine1Vendor = machine1FromDb;
        Subscription mariosSub = new Subscription(LocalDate.of(2025, 6, 12), TypeSubscription.MONTHLY, machine1Vendor, mariosCardFromDb);

        sd.save(mariosSub);
        System.out.println("Subscription saved for " + mario.getFirstName());
        // Recupera la Subscription dal database
        Subscription mariosSubFromDb = sd.findSubscriptionByUuid(mariosSub.getId());
        System.out.println("Subscription retrieved: " + mariosSubFromDb + " with ID: " + mariosSubFromDb.getId());

        // ------- END TEST -------

        //CREATION RECORD VEHICLES
        Vehicle bus1 = new Bus("BH000ZS", 2025, ServiceVehicleStatus.MAINTENANCE, 40);
        Vehicle bus2 = new Bus("VG020GS", 1994, ServiceVehicleStatus.IN_SERVICE, 50);
        Vehicle bus3 = new Bus("YT030HH", 2009, ServiceVehicleStatus.IN_SERVICE, 35);

        Vehicle tram1 = new Tram("XX987II", 2020, ServiceVehicleStatus.MAINTENANCE, 130);
        Vehicle tram2 = new Tram("SS222RR", 2010, ServiceVehicleStatus.IN_SERVICE, 120);
        Vehicle tram3 = new Tram("GH333TT", 2015, ServiceVehicleStatus.IN_SERVICE, 140);

        // -----------Salva i veicoli nel database
        vd.save(bus1);
        vd.save(bus2);
        vd.save(bus3);
        vd.save(tram1);
        vd.save(tram2);
        vd.save(tram3);

        // Creazione e salvataggio di un biglietto con stato NOT_ENDORSED e vendor
        Ticket ticket = new Ticket(LocalDate.now(), TicketStatus.NOT_ENDORSED, machine1Vendor);
        ticketDAO.save(ticket);

        // Recupera bus2 dal database tramite id
        Vehicle bus2FromDb = vd.findById(bus2.getId());

        // --- Vidimazione del biglietto (associa un veicolo) ---
        ticketDAO.endorseTicket(ticket.getId(), bus2FromDb);

        // Stampa il biglietto vidimato
        Ticket endorsedTicket = ticketDAO.findTicketByUuid(ticket.getId());
        System.out.println("Biglietto vidimato: " + endorsedTicket);


        em.close();
        emf.close();
    }
}
