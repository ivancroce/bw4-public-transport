package bw4_team5;

import bw4_team5.dao.*;
import bw4_team5.entities.*;
import bw4_team5.enums.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.*;

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
        VehicleStateLogDAO vsld = new VehicleStateLogDAO(em);
        TravelRouteDAO trd = new TravelRouteDAO(em);
        RouteDAO rd = new RouteDAO(em);



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
        List<TicketSystem> machines = new ArrayList<>();
        List<TicketSystem> resellers = new ArrayList<>();
        machines.add(machine1);
        machines.add(machine2);
        machines.add(machine3);
        resellers.add(reseller1);

        // Recupera machine1 dal database tramite il suo UUID

        TicketSystem machine1FromDb = tsd.findTicketSystemByUuid("b647e367-8f59-4d1d-8897-1e93670104ae");
        TicketSystem machine2FromDb = tsd.findTicketSystemByUuid("9101d73c-8594-457d-9c06-b303c9fb1b21");
        TicketSystem machine3FromDb = tsd.findTicketSystemByUuid("52347748-e3ea-4b7c-a1f5-e6adf2a4853f");
        TicketSystem reseller1FromDb = tsd.findTicketSystemByUuid("86d6108f-fbf8-4c2d-abaa-8df880fa5734");

        // ------- TEST ------- Create User, Card and Subscription
        User mario = new User("Mario", "Balotelli", UserType.CUSTOMER);
//        ud.save(mario);
        User pino = new User("Pino", "Lalavatrice", UserType.CUSTOMER);
        User aldo = new User("Aldo", "Baglio", UserType.CUSTOMER);
//        ud.save(pino);
//        ud.save(aldo);

       /* User marioFromDb = ud.findUserById(352); // Inserire l'id corretto dell'utente dal DB
//        System.out.println("User retrieved: " + marioFromDb + " with ID: " + marioFromDb.getId());
        User pinoFromDb = ud.findUserById(353); // Inserire l'id corretto dell'utente dal DB
//        System.out.println("User retrieved: " + pinoFromDb + " with ID: " + pinoFromDb.getId());
        User aldoFromDb = ud.findUserById(354); // Inserire l'id corretto dell'utente dal DB
//        System.out.println("User retrieved: " + pinoFromDb + " with ID: " + aldoFromDb.getId());
*/
      /*  // Creazione della Card per l'utente Mario
       Card mariosCard = new Card(marioFromDb);
//        cd.save(mariosCard);
        Card pinosCard = new Card(pinoFromDb);
//        cd.save(pinosCard);*/

        // Associa la Card all'utente Mario e salva l'utente aggiornato

            /*Card mariosCardFromDb = cd.findCardById(52);
            Card pinosCardFromDb = cd.findCardById(53);*/

        //System.out.println("Card retrieved: " + mariosCardFromDb + " with ID: " + mariosCardFromDb.getId());

        // Creazione della Subscription per l'utente Mario

        /*TicketSystem machine1FromDb = tsd.findTicketSystemByUuid("1006fb8d-a689-4b5e-9c31-42695b152ab2");
        TicketSystem machine3FromDb = tsd.findTicketSystemByUuid("c84ee2e0-1262-40fc-867c-5354615fa711");

        Subscription mariosSub = new Subscription(LocalDate.of(2025, 6, 12), TypeSubscription.MONTHLY, machine1FromDb, mariosCardFromDb);
        Subscription pinosSub = new Subscription(LocalDate.of(2025, 5, 12 ), TypeSubscription.MONTHLY, machine3FromDb, pinosCardFromDb);*/

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
//        vd.save(tram3)
        //

        // Recupera i veicoli dal database tramite id

        Vehicle bus1FromDb = vd.findBusById(252);
        Vehicle bus2FromDb = vd.findBusById(253);
        Vehicle bus3FromDb = vd.findBusById(254);
        Vehicle tram1FromDb = vd.findTramById(255);
        Vehicle tram2FromDb = vd.findTramById(256);
        Vehicle tram3FromDb = vd.findTramById(257);

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(bus1FromDb);
        vehicleList.add(bus2FromDb);
        vehicleList.add(bus3FromDb);
        vehicleList.add(tram1FromDb);
        vehicleList.add(tram2FromDb);
        vehicleList.add(tram3FromDb);


        VehicleStateLog log1 = new VehicleStateLog(LocalDate.of(2025, 4, 19), "Tagliando e manutenzione ordinaria", LocalDate.of(2025, 4, 29), bus1FromDb);
        VehicleStateLog log2 = new VehicleStateLog(LocalDate.of(2025, 5, 10), "Cambio motore e frizione", LocalDate.of(2025, 6, 15), bus2FromDb);
        VehicleStateLog log3 = new VehicleStateLog(LocalDate.of(2025, 6, 11), "Lavori di carrozzeria", LocalDate.of(2025, 7, 22), bus3FromDb);
        VehicleStateLog log4 = new VehicleStateLog(LocalDate.of(2025, 2, 1), "Riparazione quadro elettrico", LocalDate.of(2025, 2, 24), tram1FromDb);
        VehicleStateLog log5 = new VehicleStateLog(LocalDate.of(2024, 12, 10), "Ristrutturazione sedili", LocalDate.of(2025, 1, 15), tram2FromDb);
        VehicleStateLog log6 = new VehicleStateLog(LocalDate.of(2025, 2, 17), "Controlli ordinari", LocalDate.of(2025, 3, 6), tram3FromDb);

      /*  vsld.save(log1);
        vsld.save(log2);
        vsld.save(log3);
        vsld.save(log4);
        vsld.save(log5);
        vsld.save(log6);*/

//        // Creazione e salvataggio di un biglietto con stato NOT_ENDORSED e vendor
        Ticket ticket1 = new Ticket(LocalDate.now(), TicketStatus.NOT_ENDORSED, machine1FromDb);
        Ticket ticket2 = new Ticket(LocalDate.now(), TicketStatus.NOT_ENDORSED, machine3FromDb);
        Ticket ticket3 = new Ticket(LocalDate.now(), TicketStatus.NOT_ENDORSED, reseller1FromDb);

         /*ticketDAO.save(ticket1);
        ticketDAO.save(ticket2);
        ticketDAO.save(ticket3);*/
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
        // ----CREAZIONE DELLE ROTTE --
        Route romeRoute = new Route("Via Roma", "Stazione Termini", 120);
        Route milanRoute = new Route("Via Milano", "Piazza Duomo", 90);
        Route naplesRoute = new Route("Via Napoli", "Piazza del Plebiscito", 150);

        // Salva le rotte nel database
        /*rd.save(romeRoute);
        rd.save(milanRoute);
        rd.save(naplesRoute);*/

        // Recupera le rotte dal database tramite id
        Route romeRouteFromDb = rd.findRouteById(52);
        Route milanRouteFromDb = rd.findRouteById(53);
        Route naplesRouteFromDb = rd.findRouteById(54);
        // ----CREAZIONE DELLE TRATTE --
        TravelRoute romeTravelRoute1 = new TravelRoute(bus3FromDb, romeRouteFromDb);
        TravelRoute romeTravelRoute2 = new TravelRoute(bus3FromDb, romeRouteFromDb);
        TravelRoute milanTravelRoute1 = new TravelRoute(bus2FromDb, milanRouteFromDb);
        TravelRoute naplesTravelRoute1 = new TravelRoute(tram3FromDb, naplesRouteFromDb);
        TravelRoute naplesTravelRoute2 = new TravelRoute(tram3FromDb, naplesRouteFromDb);

        // Salva le tratte nel database
        /*trd.save(romeTravelRoute1);
        trd.save(romeTravelRoute2);
        trd.save(milanTravelRoute1);
        trd.save(naplesTravelRoute1);
        trd.save(naplesTravelRoute2);
*/

        // ----CREAZIONE DELLE TRATTE CON TEMPO DI PERCORRENZA --

        /*updateTravelRoute(trd, 2, 90); // Aggiorna il tempo di percorrenza della tratta con ID 2 a 120 minuti
        updateTravelRoute(trd, 3, 56);
        updateTravelRoute(trd, 4, 85);
        updateTravelRoute(trd, 5, 135);
        updateTravelRoute(trd, 6, 90);*/




/*-----------------------------------------------------------------------------------------------------------------------------------SCANNER---------------------------------------*/
        Scanner scanner = new Scanner(System.in);
        boolean back;

        int n = 0;
        do {
            System.out.println("Inserisci 1 per il pannello utente");
            System.out.println("Inserisci 2 per il pannello admin");
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
            UUID vendorSave = null;
            if (n == 1) {
                do {
                    System.out.println("Desideri acquistare il biglietto da una macchinetta automatica o da un rivenditore autorizzato?");
                    System.out.println("Inserisci 1 per acqusitare da una macchinetta automatica");
                    System.out.println("Inserisci 2 per acquistare da un rivenditore autorizzato");
                    System.out.println("----------------------------------------------------------");

                    n = Integer.parseInt(scanner.nextLine());
                    //lista rivenditori switch 1/2
                    switch (n) {
                        case 1:
                            do {
                                System.out.println("Inserisci il numero corrispondente alla macchinetta che si desidera utilizzare : ");
                                for (int i = 0; i < machines.toArray().length; i++) {
                                    System.out.println((i + 1) + " --- " + machines.get(i));
                                }System.out.println("");
                                int k = Integer.parseInt(scanner.nextLine());
                                back = false;

                                switch (k) {
                                    case 1:
                                        vendorSave = machine1FromDb.getUuid();
                                        break;
                                    case 2:
                                        vendorSave = machine3FromDb.getUuid();
                                        break;

                                    case 3:
                                        System.out.println("Macchinetta non attiva!");
                                        System.out.println("Scegli una macchinetta attiva!");
                                        back=true;
                                        break;


                                }
                            }while(back);
                            break;
                        case 2:
                            System.out.println("Inserisci il numero corrispondente al rivenditore che si desidera utilizzare : ");
                            for (int i = 0; i < resellers.toArray().length; i++) {
                                System.out.println((i + 1) + " --- " + resellers.get(i));
                            }
                            int j = Integer.parseInt(scanner.nextLine());
                            switch (j) {
                                case 1:
                                    /*vendorSave = reseller1FromDb.getUuid();*/
                                    break;
                                case 2:
                                    /*vendorSave = reseller1FromDb.getUuid();*/
                                    break;
                                case 3:
                                   /* vendorSave = reseller1FromDb.getUuid();*/
                                    break;

                            }
                    }
                    if (n <= 0 || n > 2) {
                        System.out.println("Inserisci nuovamente il numero");
                    }
                } while (n <= 0 || n > 2);
                //CREAZIONE BIGLIETTO

                Ticket newTicket = new Ticket();
                ticketDAO.save(newTicket);



                Ticket newTicketFromDb= ticketDAO.findTicketByUuid(newTicket.getId());
                newTicketFromDb.setIssueDate(LocalDate.now());
                ticketDAO.setTicketDate(LocalDate.now(), newTicketFromDb.getId());

                newTicketFromDb.setVendor(tsd.findTicketSystemByUuid(vendorSave.toString()));


                ticketDAO.setTicketVendor(vendorSave, newTicketFromDb.getId());

                System.out.println("Seleziona il mezzo : ");
                System.out.println("Veicoli in servizio:");
                int countVehicle=0;
                for (Vehicle vehicle : vd.findAllInServiceVehicles()) {

                    System.out.println(vehicle);

                }
                System.out.println("inserisci l'id del veicolo");
                long idInserito= scanner.nextLong();
                scanner.nextLine();
                System.out.println("id inserito : " + idInserito);
                Vehicle veicoloSelezionato = null;

                int num = vehicleList.size();

                for (int i=0; i<num; i++){

                    if (vehicleList.get(i).getId() == idInserito){
                        veicoloSelezionato = vehicleList.get(i);
                    }

                }
                if(veicoloSelezionato !=null){
                    ticketDAO.endorseTicket(newTicketFromDb.getId(), veicoloSelezionato);

                    System.out.println("Veicolo associato con successo");

                }else{
                    System.out.println("veicolo non trovato");
                }


            } else {
                do {
                    System.out.println("Desideri acquistare l'abbonamento da una macchinetta automatica o da un rivenditore autorizzato?");
                    System.out.println("Inserisci 1 per acqusitare da una macchinetta automatica");
                    System.out.println("Inserisci 2 per acquistare da un rivenditore autorizzato");

                    n = Integer.parseInt(scanner.nextLine());
                    //lista rivenditori switch 1/2
                    switch (n) {
                        case 1:
                            do {
                                System.out.println("Inserisci il numero corrispondente alla macchinetta che si desidera utilizzare : ");
                                for (int i = 0; i < machines.toArray().length; i++) {
                                    System.out.println((i + 1) + " --- " + machines.get(i));
                                }System.out.println("");
                                int k = Integer.parseInt(scanner.nextLine());
                                back = false;

                                switch (k) {
                                    case 1:
                                        vendorSave = machine1FromDb.getUuid();
                                        break;
                                    case 2:
                                        vendorSave = machine3FromDb.getUuid();
                                        break;

                                    case 3:
                                        System.out.println("Macchinetta non attiva!");
                                        System.out.println("Scegli una macchinetta attiva!");
                                        back=true;
                                        break;


                                }
                            }while(back);
                            break;
                        case 2:
                            System.out.println("Inserisci il numero corrispondente al rivenditore che si desidera utilizzare : ");
                            for (int i = 0; i < resellers.toArray().length; i++) {
                                System.out.println((i + 1) + " --- " + resellers.get(i));
                            }

                            int j= Integer.parseInt(scanner.nextLine());
                            switch (j) {
                                case 1:
                                    vendorSave = reseller1FromDb.getUuid();
                                    break;
                                case 2:
                                    //   vendorSave = reseller2FromDb.getUuid();
                                    break;
                                case 3:
                                    //  vendorSave = reseller3FromDb.getUuid();
                                    break;

                            }


                    }

                    //SetIdFromVendor/Machine
                    //switch

                    if (n <= 0 || n > 2) {
                        System.out.println("Inserisci nuovamente il numero");
                    }
                } while (n <= 0 || n > 2);

                //controllo numero carta, checkCardByID
                System.out.println("Inserisci l'Id della tua Tessera");
                long inputCard = scanner.nextLong();
                cd.findCardById(inputCard);
                scanner.nextLine();
                System.out.println("Nome utente -> " + ud.findUserByCardId(inputCard).getFirstName());
                System.out.println("Congome utente -> " + ud.findUserByCardId(inputCard).getLastName());
                System.out.println("Id Utente -> " + ud.findUserByCardId(inputCard).getId());
                //checkExpirationById(inputCard);
                // se la carta è scaduta va rinnovata
                Subscription personaProvaFromDb = sd.findSubscriptionByUuid(sd.findUuidByIdCard(inputCard));
                sd.setSubscriptionVendorIdFromVendorUuid(personaProvaFromDb.getId(), vendorSave);
                System.out.println("Vuoi sottoscrivere un abbonamento mensile o settimanale?");
                System.out.println("Inserisci 'WEEKLY' o 'MONTHLY'");

                String subTry = scanner.nextLine().toUpperCase();
                if (subTry.equals("WEEKLY")) {

                    LocalDate startDate = LocalDate.now();
                    LocalDate endDate = startDate.plusWeeks(1);

                    personaProvaFromDb.setStartDate(startDate);
                    personaProvaFromDb.setType(TypeSubscription.WEEKLY);
                    sd.setSubscriptionType(TypeSubscription.WEEKLY, inputCard);
                    personaProvaFromDb.setEndDate(startDate.plusWeeks(1));
                    sd.setSubscriptionDate(startDate, endDate, inputCard);


                } else {

                    LocalDate startDate = LocalDate.now();
                    LocalDate endDate = startDate.plusMonths(1);
                    personaProvaFromDb.setStartDate(startDate);
                    personaProvaFromDb.setType(TypeSubscription.MONTHLY);
                    sd.setSubscriptionType(TypeSubscription.MONTHLY, inputCard);
                    personaProvaFromDb.setEndDate(startDate.plusMonths(1));
                    sd.setSubscriptionDate(startDate, endDate, inputCard);

                }


                System.out.println(personaProvaFromDb.getType());

                System.out.println("Il tuo abbonamento " + subTry + " è stato sottoscritto con successo");

            }


        } else {
            // -----------------------------------------------------------------        ADMIN               ------------------------------------------------
            int sceltaAdmin;
            do {
                System.out.println("Benvenuto nel pannello di amministrazione");
                System.out.println("Inserisci 1 per visualizzare i veicoli in servizio");
                System.out.println("Inserisci 2 per visualizzare i veicoli in manutenzione");
                System.out.println("Inserisci 3 per assegnare una tratta ad un veicolo");
                System.out.println("Inserisci 4 per visualizzare i biglietti vidimati");
                System.out.println("Inserisci 5 per visualizzare le tratte percorribili da un mezzo specifico");
                System.out.println("Inserisci 6 per visualizzare le tratte percorribili da un mezzo specifico con il tempo medio di percorrenza");
                System.out.println("Inserisci 7 per visualizzare lo storico manutenzione veicoli");
                System.out.println("Inserisci 8 per visualizzare lo storico manutenzione per un determinato periodo");
                System.out.println("Inserisci 9 per aggiungere un mezzo al parco mezzi");
                System.out.println("Inserisci 10 per visualizzare tutti i veicoli ");
                System.out.println("Inserisci 11 per visualizzare le tratte disponibili");

                System.out.println("Inserisci 0 per uscire");
                sceltaAdmin = Integer.parseInt(scanner.nextLine());

                switch (sceltaAdmin) {
                    case 1:
                        System.out.println("Veicoli in servizio:");
                        for (Vehicle vehicle : vd.findAllInServiceVehicles()) {
                            System.out.println(vehicle);
                        }
                        break;
                    case 2:
                        System.out.println("Veicoli in manutenzione:");
                        for (Vehicle vehicle : vd.findAllMaintenanceVehicles()) {
                            System.out.println(vehicle);
                        }
                        break;
                    case 3:
                        System.out.println("Asegna una tratta a un veicolo:");
                        System.out.println("Veicoli disponibili IN_SERVIS:");
                        for (Vehicle v : vd.findAllInServiceVehicles()) {
                            System.out.println("ID: " + v.getId() + " - Targa: " + v.getNumberPlate());
                        }
                        System.out.println("Inserisci l'ID del veicolo:");
                        long vehicleId3 = Long.parseLong(scanner.nextLine());
                        Vehicle vehicle3 = vd.findVehicleById(vehicleId3);
                        if (vehicle3 == null) {
                            System.out.println("Veicolo non trovato.");
                            break;
                        }
                        System.out.println("Asegna una tratta al un veicolo:");
                        System.out.println("Tratte disponibili:");
                        for (Route route : rd.findAllRoutes()) {
                            System.out.println("ID: " + route.getId() + " - Da " + route.getStartRoute() + " a " + route.getTerminal());
                        }
                        System.out.println("Inserisci l'ID della tratta:");
                        long routeId3 = Long.parseLong(scanner.nextLine());
                        Route route3 = rd.findRouteById(routeId3);
                        if (route3 == null) {
                            System.out.println("Tratta non trovata.");
                            break;
                        }
                        TravelRoute travelRoute = new TravelRoute(vehicle3, route3);
                        trd.save(travelRoute);
                        System.out.println("Tratta assegnata con successo al veicolo " + vehicle3.getNumberPlate());
                        break;
                    case 4:
                        System.out.println("Biglietti vidimati:");
                        for (Ticket ticket : ticketDAO.findAllEndorsedTickets()) {
                            System.out.println(ticket);
                        }

                        System.out.println("Vuoi vedere il conteggio dei biglietti vidimati?");
                        System.out.println("1 - Per veicolo");
                        System.out.println("2 - Per periodo");
                        int scelta = Integer.parseInt(scanner.nextLine());

                        if (scelta == 1) {
                            System.out.println("Veicoli disponibili:");
                            for (Vehicle v : vd.findAllVehicles()) {
                                System.out.println("ID: " + v.getId() + " - Targa: " + v.getNumberPlate());
                            }
                            System.out.println("Inserisci l'ID del veicolo:");
                            long vehicleId = Long.parseLong(scanner.nextLine());
                            long count = ticketDAO.countEndorsedTicketsByVehicle(vehicleId);
                            System.out.println("Biglietti vidimati su questo veicolo: " + count);
                        } else if (scelta == 2) {
                            System.out.println("Inserisci la data di inizio (YYYY-MM-DD):");
                            LocalDate start = LocalDate.parse(scanner.nextLine());
                            System.out.println("Inserisci la data di fine (YYYY-MM-DD):");
                            LocalDate end = LocalDate.parse(scanner.nextLine());
                            long count = ticketDAO.countEndorsedTicketsByPeriod(start, end);
                            System.out.println("Biglietti vidimati nel periodo: " + count);
                        }
                        break;
                    case 5:
                        System.out.println("Inserisci l'ID del veicolo per visualizzare le tratte percorribili:");
                        long vehicleId = Long.parseLong(scanner.nextLine());
                        Vehicle vehicle = vd.findVehicleById(vehicleId);
                        trd = new TravelRouteDAO(em);
                        System.out.println("Tratte percorribili dal veicolo " + vehicle.getNumberPlate() + ":");
                        for (TravelRoute route : trd.findRoutesByVehicle(vehicle)) {
                            System.out.println(route);
                        }
                        break;
                    case 6:// Visualizza le tratte percorribili da un veicolo specifico con il tempo medio di percorrenza
                        System.out.println("Veicoli disponibili:");
                        for (Vehicle v : vd.findAllVehicles()) {
                            System.out.println("ID: " + v.getId() + " - " + v.getNumberPlate());
                        }
                        System.out.println("Inserisci l'ID del veicolo:");
                        long vehicleId6 = Long.parseLong(scanner.nextLine());
                        Vehicle vehicle6 = vd.findVehicleById(vehicleId6);

                        if (vehicle6 == null) {
                            System.out.println("Veicolo non trovato.");
                            break;
                        }
                        System.out.println("Tratte percorribili dal veicolo:");
                        for (TravelRoute tr : trd.findRoutesByVehicle(vehicle6)) {
                            System.out.println("ID tratta: " + tr.getRoute().getId() + " - Da " + tr.getRoute().getStartRoute() + " a " + tr.getRoute().getTerminal());
                        }
                        System.out.println("Inserisci l'ID della tratta:");
                        long routeId = Long.parseLong(scanner.nextLine());

                        Double media = trd.avgTimeByVehicleAndRoute(vehicleId6, routeId);
                        long count = trd.countTravelsByVehicleAndRoute(vehicleId6,routeId);
                        if (media == null) {
                            System.out.println("Nessuna percorrenza registrata per questa tratta e questo veicolo.");
                        } else {
                            System.out.println("Tempo medio effettivo di percorrenza: " + media + " minuti.");
                            System.out.println("Numero percorrenze completate : " + count);

                        }
                        break;
                    case 7:
                        System.out.println("Storico manutenzione veicoli:");
                        for (VehicleStateLog log : vsld.getAllLogs()) {
                            System.out.println("ID: " + log.getId() + ", Veicolo: " + log.getVehicle().getNumberPlate() +
                                    ", Inizio: " + log.getStartDate() + ", Fine: " + log.getEndDate() +
                                    ", Causa: " + log.getCause());
                        }
                        break;
                    case 8:
                        System.out.println("Storico manutenzione per un determinato periodo:");
                        System.out.println("Inserisci la data di inizio (YYYY-MM-DD):");
                        LocalDate from = LocalDate.parse(scanner.nextLine());
                        System.out.println("Inserisci la data di fine (YYYY-MM-DD):");
                        LocalDate to = LocalDate.parse(scanner.nextLine());
                        List<VehicleStateLog> logs = vsld.getLogsByDateRange(from, to);
                        if (logs.isEmpty()) {
                            System.out.println("Nessun log trovato per il periodo specificato.");
                        } else {
                            for (VehicleStateLog log : logs) {
                                System.out.println("ID: " + log.getId() + ", Veicolo: " + log.getVehicle().getNumberPlate() +
                                        ", Inizio: " + log.getStartDate() + ", Fine: " + log.getEndDate() +
                                        ", Causa: " + log.getCause());
                            }
                        }
                        break;
                    case 9:
                        System.out.println("Aggiungi un mezzo al parco mezzi :");
                        System.out.println("Inserisci il tipo di veicolo (1 per Tram, 2 per Bus):");
                        int tipoVeicolo = Integer.parseInt(scanner.nextLine());
                        if (tipoVeicolo == 1) {
                            System.out.println("Inserisci la targa del Tram:");
                            String targaTram = scanner.nextLine();
                            System.out.println("Inserisci l'anno di immatricolazione del Tram:");
                            int annoTram = Integer.parseInt(scanner.nextLine());
                            System.out.println("Inserisci lo stato del servizio del Tram (IN_SERVICE, MAINTENANCE):");
                            ServiceVehicleStatus statoTram = ServiceVehicleStatus.valueOf(scanner.nextLine().toUpperCase());
                            System.out.println("Inserisci la capacità del Tram:");
                            int capacitaTram = Integer.parseInt(scanner.nextLine());
                            Vehicle tram = new Tram(targaTram, annoTram, statoTram, capacitaTram);
                            vd.save(tram);
                        } else if (tipoVeicolo == 2) {
                            System.out.println("Inserisci la targa del Bus:");
                            String targaBus = scanner.nextLine();
                            System.out.println("Inserisci l'anno di immatricolazione del Bus:");
                            int annoBus = Integer.parseInt(scanner.nextLine());
                            System.out.println("Inserisci lo stato del servizio del Bus (IN_SERVICE, MAINTENANCE):");
                            ServiceVehicleStatus statoBus = ServiceVehicleStatus.valueOf(scanner.nextLine().toUpperCase());
                            System.out.println("Inserisci la capacità del Bus:");
                            int capacitaBus = Integer.parseInt(scanner.nextLine());
                            Vehicle bus = new Bus(targaBus, annoBus, statoBus, capacitaBus);
                            vd.save(bus);
                        } else {
                            System.out.println("Tipo di veicolo non valido.");
                        }
                        break;
                    case 10:
                        System.out.println("Elenco dei veicoli presententi nel database:");
                        for (Vehicle vehiclePark : vd.findAllVehicles()) {
                            System.out.println(vehiclePark);
                        }
                        break;
                        case 11:
                        System.out.println("Registrazione tempo effettivo di una tratta percorsa:");

                            for (TravelRoute travelRoute1 : trd.findAllTravelRoutes()) {
                                System.out.println(travelRoute1);
                            }
                        System.out.println("Inserisci l'ID della tratta da aggiornare:");
                        long travelRouteId = Long.parseLong(scanner.nextLine());
                        System.out.println("Inserisci il tempo effettivo di percorrenza in minuti:");
                        int actualTime = Integer.parseInt(scanner.nextLine());
                        updateTravelRoute(trd, travelRouteId, actualTime);
                            for (TravelRoute travelRoute1 : trd.findAllTravelRoutes()) {
                                System.out.println(travelRoute1);
                            }
                        break;
                    case 0:
                        System.out.println("Uscita dal pannello amministratore.");

                    default:
                        System.out.println("Scelta non valida, riprova.");
                }
                System.out.println(); // Riga vuota per separare le operazioni
            } while (sceltaAdmin != 0);
        }
            em.close();
            emf.close();
        }
    // updateTravelRoute method
    private static void updateTravelRoute(TravelRouteDAO trd, long id, int time) {
        TravelRoute travel = trd.findTravelRouteById(id);
        try {
            travel.setActualTravelTime(time);
            System.out.println("Travel route completed, actual travel time: " + travel.getActualTravelTime() + " mins.");
            // update in db
            trd.updateActualTravelTime(travel); // update method from TravelRouteDAO
            System.out.println("Travel route with ID '" + id + "' has been updated.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    }
