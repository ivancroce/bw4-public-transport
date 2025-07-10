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
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToUrl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

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
//         tsd.save(reseller1);
//        tsd.save(machine1);

        // ------- TEST ------- Create User, Card and Subscription
        User mario = new User("Mario", "Balotelli", UserType.CUSTOMER);
        User pinoprovino = new User("Pino", "Provino", UserType.CUSTOMER);
        //ud.save(pinoprovino);

      //   ud.save(mario);

        User marioFromDb = ud.findUserById(1);
        User pinoFromDb = ud.findUserById(2);

        Card mariosCard = new Card(marioFromDb);
        Card pinosCard = new Card(pinoFromDb);
       // cd.save(mariosCard);
       // cd.save(pinosCard);

      Card mariosCardFromDb = cd.findCardById(1);
      Card pinosCardFromDb = cd.findCardById(2);
//
        TicketSystem machine1FromDb = tsd.findTicketSystemByUuid("7d8bec30-7c46-4cc0-9dfc-3fba16572186");
        TicketSystem vendor1FromDb = tsd.findTicketSystemByUuid("13083734-fc55-4eb4-91b9-ff5907f0711e");
        Subscription mariosSub = new Subscription(LocalDate.of(2025, 6, 12), TypeSubscription.MONTHLY, machine1FromDb, mariosCardFromDb);
        Subscription pinosSub = new Subscription(vendor1FromDb, pinosCardFromDb);

        Subscription mariosSubFromDb = sd.findSubscriptionByUuid("6ad0982d-f8ff-414e-8275-014c68263e73");

        // sd.save(mariosSub);
        //sd.save(pinosSub);
//         System.out.println("Subscription saved for " + mario.getFirstName());

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


        Route route1 = new Route(1, "Bari","Roma", 300);

        //     Route route2 = new Route(1, "Napoli","Milano", 300, );
        //   Route route3 = new Route(1, "Venezia","Torino", 300,);

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


//
TravelRoute firstRouteBus1 = new TravelRoute( 200, LocalDate.of(2025,7,8),bus1 );
TravelRoute secondoRouteBus2 = new TravelRoute( 250, LocalDate.of(2025, 7,9 ),bus2);
TravelRoute thirdRouteBus3 = new TravelRoute( 300, LocalDate.of(2025, 7,10 ),bus3);
//

//

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
                System.out.println("Nome utente -> " + ud.findUserById(inputCard).getFirstName());
                System.out.println("Congome utente -> " + ud.findUserById(inputCard).getLastName());
                System.out.println("Id tessera -> " + ud.findUserById(inputCard).getId());
                //checkExpirationById(inputCard);
                // se la carta è scaduta va rinnovata

                System.out.println("Vuoi sottoscrivere un abbonamento mensile o settimanale?");
                System.out.println("Inserisci 'WEEKLY' o 'MONTHLY'");

                String subTry = scanner.nextLine();
                if(subTry.equals("WEEKLY")){

                    LocalDate startDate = LocalDate.now();
                    LocalDate endDate= startDate.plusWeeks(1);

                    pinosSub.setStartDate(startDate);
                    pinosSub.setType(TypeSubscription.WEEKLY);
                    sd.setSubscriptionType(TypeSubscription.WEEKLY, inputCard);
                    pinosSub.setEndDate(startDate.plusWeeks(1));
                    sd.setSubscriptionDate(startDate,endDate, inputCard);


                }else {
                    LocalDate startDate = LocalDate.now();
                    LocalDate endDate= startDate.plusMonths(1);
                    pinosSub.setStartDate(startDate);
                    pinosSub.setType(TypeSubscription.MONTHLY);
                    sd.setSubscriptionType(TypeSubscription.MONTHLY, inputCard);
                    pinosSub.setEndDate(startDate.plusMonths(1));
                    sd.setSubscriptionDate(startDate, endDate, inputCard);

                }
                Subscription personaProvaFromDb = sd.findSubscriptionByUuid(sd.findUuidByIdCard(inputCard));

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