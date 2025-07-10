package bw4_team5;

import bw4_team5.dao.*;
import bw4_team5.entities.*;
import bw4_team5.enums.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Scanner;

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
//        tsd.save(reseller1);
//        tsd.save(machine1);
//        tsd.save(machine2);
//        tsd.save(machine3);

        // Recupera machine1 dal database tramite il suo UUID
      //  VendingMachine machine1FromDb = (VendingMachine) tsd.findTicketSystemByUuid(machine1.getUuid().toString());

        // ------- TEST ------- Create User, Card and Subscription
        User mario = new User("Mario", "Balotelli", UserType.CUSTOMER);
//        ud.save(mario);
        User pino = new User("Pino", "Lalavatrice", UserType.CUSTOMER);
        User aldo = new User("Aldo", "Baglio", UserType.CUSTOMER);
//        ud.save(pino);
//        ud.save(aldo);

        User marioFromDb = ud.findUserById(352); // Inserire l'id corretto dell'utente dal DB
//        System.out.println("User retrieved: " + marioFromDb + " with ID: " + marioFromDb.getId());
        User pinoFromDb = ud.findUserById(353); // Inserire l'id corretto dell'utente dal DB
//        System.out.println("User retrieved: " + pinoFromDb + " with ID: " + pinoFromDb.getId());
        User aldoFromDb = ud.findUserById(354); // Inserire l'id corretto dell'utente dal DB
//        System.out.println("User retrieved: " + pinoFromDb + " with ID: " + aldoFromDb.getId());

        // Creazione della Card per l'utente Mario
       Card mariosCard = new Card(marioFromDb);
//        cd.save(mariosCard);
        Card pinosCard = new Card(pinoFromDb);
//        cd.save(pinosCard);

        // Associa la Card all'utente Mario e salva l'utente aggiornato

            Card mariosCardFromDb = cd.findCardById(52);
            Card pinosCardFromDb = cd.findCardById(53);

        //System.out.println("Card retrieved: " + mariosCardFromDb + " with ID: " + mariosCardFromDb.getId());

        // Creazione della Subscription per l'utente Mario

        TicketSystem machine1FromDb = tsd.findTicketSystemByUuid("1006fb8d-a689-4b5e-9c31-42695b152ab2");
        TicketSystem machine3FromDb = tsd.findTicketSystemByUuid("c84ee2e0-1262-40fc-867c-5354615fa711");
        Subscription mariosSub = new Subscription(LocalDate.of(2025, 6, 12), TypeSubscription.MONTHLY, machine1FromDb, mariosCardFromDb);
        Subscription pinosSub = new Subscription(LocalDate.of(2025, 5, 12 ), TypeSubscription.MONTHLY, machine3FromDb, pinosCardFromDb);

//        sd.save(mariosSub);
//        sd.save(pinosSub);
//        sd.save(mariosSub);
        //System.out.println("Subscription saved for " + mario.getFirstName());
        // Recupera la Subscription dal database
        //Subscription mariosSubFromDb = sd.findSubscriptionByUuid(mariosSub.getId());
      //  System.out.println("Subscription retrieved: " + mariosSubFromDb + " with ID: " + mariosSubFromDb.getId());

        // ------- END TEST -------

        //CREATION RECORD VEHICLES
        Vehicle bus1 = new Bus("BH000ZS", 2025, ServiceVehicleStatus.MAINTENANCE, 40);
        Vehicle bus2 = new Bus("VG020GS", 1994, ServiceVehicleStatus.IN_SERVICE, 50);
        Vehicle bus3 = new Bus("YT030HH", 2009, ServiceVehicleStatus.IN_SERVICE, 35);

        Vehicle tram1 = new Tram("XX987II", 2020, ServiceVehicleStatus.MAINTENANCE, 130);
        Vehicle tram2 = new Tram("SS222RR", 2010, ServiceVehicleStatus.IN_SERVICE, 120);
        Vehicle tram3 = new Tram("GH333TT", 2015, ServiceVehicleStatus.IN_SERVICE, 140);

        // -----------Salva i veicoli nel database
//        vd.save(bus1);
//       vd.save(bus2);
//        vd.save(bus3);
//        vd.save(tram1);
//        vd.save(tram2);
//        vd.save(tram3);

//        // Creazione e salvataggio di un biglietto con stato NOT_ENDORSED e vendor
//        Ticket ticket = new Ticket(LocalDate.now(), TicketStatus.NOT_ENDORSED, machine1Vendor);
//        ticketDAO.save(ticket);
//
//        // Recupera bus2 dal database tramite id
//        Vehicle bus2FromDb = vd.findBusById(bus2.getId());
//
//        // --- Vidimazione del biglietto (associa un veicolo) ---
//        ticketDAO.endorseTicket(ticket.getId(), bus2FromDb);
//
//        // Stampa il biglietto vidimato
//        Ticket endorsedTicket = ticketDAO.findTicketByUuid(ticket.getId());
//        System.out.println("Biglietto vidimato: " + endorsedTicket);

        Scanner scanner = new Scanner(System.in);

        int n = 0;
        do {
            System.out.println("Inserisci 1 per il pannello utente");
            System.out.println("Inserisci il 2 per il pannello admin");
            n = Integer.parseInt(scanner.nextLine());
            if (n <= 0 || n > 2) {
                System.out.println("Inserisci nuovamente il numero");
            }
        } while (n <= 0 || n > 2);
        if (n == 1) {


            do {
                System.out.println("Desideri acquistare un biglietto oppure un abbonamento? ");
                System.out.println("Inserisci 1 per acquistare un biglietto");
                System.out.println("Inserisci 2 per acquistare un abbonamento");
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0 || n > 2) {
                    System.out.println("Inserisci nuovamente il numero");
                }
            } while (n <= 0 || n > 2);
            if (n == 1) {
                do {
                    System.out.println("Desideri acquistare il biglietto da una macchinetta automatica o da un rivenditore autorizzato?");
                    System.out.println("Inserisci 1 per acqusitare da una macchinetta automatica");
                    System.out.println("Inserisci 2 per acquistare da un rivenditore autorizzato");

                    //lista rivenditori switch 1/2

                    //SetIdFromVendor/Machine
                    //switch

                    n = Integer.parseInt(scanner.nextLine());
                    if (n <= 0 || n > 2) {
                        System.out.println("Inserisci nuovamente il numero");
                    }
                } while (n <= 0 || n > 2);
                //CREAZIONE BIGLIETTO

                //VIDIMAZIONE BIGLIETTO

                //FINDTICKETBYID

                //SELEZIONE MEZZO SU CUI SI STA VIDIMANDO IL BIGLIETTO
                //ID53 -> BUS -> TRATTA BARI/ROMA ES.

                //FINDVEHICLEBYID
                //VIDIMAZIONE. UPDATE NOT TO ENDORSED

            } else {
                do {
                    System.out.println("Desideri acquistare il biglietto da una macchinetta automatica o da un rivenditore autorizzato?");
                    System.out.println("Inserisci 1 per acqusitare da una macchinetta automatica");
                    System.out.println("Inserisci 2 per acquistare da un rivenditore autorizzato");

                    //lista rivenditori switch 1/2

                    //SetIdFromVendor/Machine
                    //switch

                    n = Integer.parseInt(scanner.nextLine());
                    if (n <= 0 || n > 2) {
                        System.out.println("Inserisci nuovamente il numero");
                    }
                } while (n <= 0 || n > 2);

                //controllo numero carta, checkCardByID
                System.out.println("Inserisci l'Id della tua Tessera");
                long inputCard = scanner.nextLong();
                cd.findCardById(inputCard);
                scanner.nextLine();
                System.out.println("Nome utente -> " );/*+ ud.findUserByCardId(inputCard).getFirstName())*/;
                System.out.println("Congome utente -> ");/* + ud.findUserByCardId(inputCard).getLastName())*/;
                System.out.println("Id tessera -> " );/*+ ud.findUserByCardId(inputCard).getId())*/;
                //checkExpirationById(inputCard);
                // se la carta è scaduta va rinnovata
                Subscription personaProvaFromDb = sd.findSubscriptionByUuid(sd.findUuidByIdCard(inputCard));
                System.out.println("Vuoi sottoscrivere un abbonamento mensile o settimanale?");
                System.out.println("Inserisci 'WEEKLY' o 'MONTHLY'");

                String subTry = scanner.nextLine();
                if(subTry.equals("WEEKLY")){

                    LocalDate startDate = LocalDate.now();
                    LocalDate endDate= startDate.plusWeeks(1);

                    personaProvaFromDb.setStartDate(startDate);
                    personaProvaFromDb.setType(TypeSubscription.WEEKLY);
                    sd.setSubscriptionType(TypeSubscription.WEEKLY, inputCard);
                    personaProvaFromDb.setEndDate(startDate.plusWeeks(1));
                    sd.setSubscriptionDate(startDate,endDate, inputCard);


                }else {

                    LocalDate startDate = LocalDate.now();
                    LocalDate endDate= startDate.plusMonths(1);
                    personaProvaFromDb.setStartDate(startDate);
                    personaProvaFromDb.setType(TypeSubscription.MONTHLY);
                    sd.setSubscriptionType(TypeSubscription.MONTHLY, inputCard);
                    personaProvaFromDb.setEndDate(startDate.plusMonths(1));
                    sd.setSubscriptionDate(startDate, endDate, inputCard);

                }


                System.out.println(personaProvaFromDb.getType());

                System.out.println("Il tuo abbonamento " + subTry + " è stato sottoscritto con successo");

            }


        }else{
            //ADMIN
            //calcolo tempo medio effettivo di percorrenza tratta da parte di un mezzo
            //lista venditori autorizzati
            //lista macchinette
            //lista tram
            //lista bus
            //gestione veicolo e rotte
            //

        }
        em.close();
        emf.close();
    }
}
