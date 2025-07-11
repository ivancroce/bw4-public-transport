package bw4_team5;

import bw4_team5.dao.*;
import bw4_team5.entities.*;
import bw4_team5.enums.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        VehicleStateLogDAO vsld = new VehicleStateLogDAO(em);

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

       TicketSystem machine1FromDb =  tsd.findTicketSystemByUuid("52347748-e3ea-4b7c-a1f5-e6adf2a4853f");
       TicketSystem machine2FromDb =  tsd.findTicketSystemByUuid("9101d73c-8594-457d-9c06-b303c9fb1b21");
       TicketSystem machine3FromDb =  tsd.findTicketSystemByUuid("b647e367-8f59-4d1d-8897-1e93670104ae");

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


        VehicleStateLog log1 = new VehicleStateLog(LocalDate.of(2025,4,19),"Tagliando e manutenzione ordinaria",LocalDate.of(2025,4,29),bus1FromDb);
        VehicleStateLog log2 = new VehicleStateLog(LocalDate.of(2025,5,10),"Cambio motore e frizione",LocalDate.of(2025,6,15),bus2FromDb);
        VehicleStateLog log3 = new VehicleStateLog(LocalDate.of(2025,6,11),"Lavori di carrozzeria",LocalDate.of(2025,7,22),bus3FromDb);
        VehicleStateLog log4 = new VehicleStateLog(LocalDate.of(2025,2,1),"Riparazione quadro elettrico",LocalDate.of(2025,2,24),tram1FromDb);
        VehicleStateLog log5 = new VehicleStateLog(LocalDate.of(2024,12,10),"Ristrutturazione sedili",LocalDate.of(2025,1,15),tram2FromDb);
        VehicleStateLog log6 = new VehicleStateLog(LocalDate.of(2025,2,17),"Controlli ordinari",LocalDate.of(2025,3,6),tram3FromDb);

      /*  vsld.save(log1);
        vsld.save(log2);
        vsld.save(log3);
        vsld.save(log4);
        vsld.save(log5);
        vsld.save(log6);*/

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
                            System.out.println("Inserisci il numero corrispondente alla macchinetta che si desidera utilizzare : ");
                            for (int i = 0; i < machines.toArray().length; i++) {
                                System.out.println((i + 1) + " --- " + machines.get(i));
                            }
                            int j = Integer.parseInt(scanner.nextLine());
                            switch (j) {
                                case 1:
                                    break;
                                case 2:
                                    System.out.println("sojwfjsdjoj");
                                    break;
                                case 3:
                                    System.out.println("prova");
                                    break;

                            }
                            break;
                        case 2:
                            System.out.println("Inserisci il numero corrispondente al rivenditore che si desidera utilizzare : ");
                            for (int i = 0; i < resellers.toArray().length; i++) {
                                System.out.println((i + 1) + " --- " + resellers.get(i));
                            }
                            j = Integer.parseInt(scanner.nextLine());
                            switch (j) {
                                case 1:
                                    break;
                                case 2:
                                    System.out.println("psadsadsadsad");
                                    break;
                                case 3:
                                    System.out.println("prova");
                                    break;

                            }
                    }

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
                    System.out.println("Desideri acquistare l'abbonamento da una macchinetta automatica o da un rivenditore autorizzato?");
                    System.out.println("Inserisci 1 per acqusitare da una macchinetta automatica");
                    System.out.println("Inserisci 2 per acquistare da un rivenditore autorizzato");

                    n = Integer.parseInt(scanner.nextLine());
                    //lista rivenditori switch 1/2
                    switch (n) {
                        case 1:
                            System.out.println("Inserisci il numero corrispondente alla macchinetta che si desidera utilizzare : ");
                            for (int i = 0; i < machines.toArray().length; i++) {
                                System.out.println((i + 1) + " --- "  + machines.get(i));

                            }
                            int j = Integer.parseInt(scanner.nextLine());
                            switch (j) {
                                case 1:
                                    vendorSave = machine1FromDb.getUuid();
                                    break;
                                case 2:
                                    vendorSave = machine3FromDb.getUuid();
                                    break;
                                case 3:

                                    break;

                            }
                            break;
                        case 2:
                            System.out.println("Inserisci il numero corrispondente al rivenditore che si desidera utilizzare : ");
                            for (int i = 0; i < resellers.toArray().length; i++) {
                                System.out.println((i + 1) + " --- " + resellers.get(i));
                            }
                            j = Integer.parseInt(scanner.nextLine());
                            switch (j) {
                                case 1:

                                    break;
                                case 2:
                                    System.out.println("psadsadsadsad");
                                    break;
                                case 3:
                                    System.out.println("prova");
                                    break;

                            }


                    }

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
                System.out.println("Nome utente -> " + ud.findUserByCardId(inputCard).getFirstName());
                System.out.println("Congome utente -> "+ ud.findUserByCardId(inputCard).getLastName());
                System.out.println("Id Utente -> "  + ud.findUserByCardId(inputCard).getId());
                //checkExpirationById(inputCard);
                // se la carta è scaduta va rinnovata
                Subscription personaProvaFromDb = sd.findSubscriptionByUuid(sd.findUuidByIdCard(inputCard));
                sd.setSubscriptionVendorIdFromVendorUuid(personaProvaFromDb.getId(), vendorSave);
                System.out.println("Vuoi sottoscrivere un abbonamento mensile o settimanale?");
                System.out.println("Inserisci 'WEEKLY' o 'MONTHLY'");

                String subTry = scanner.nextLine().toUpperCase();
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
            // -----------------------------------------------------------------        ADMIN               ------------------------------------------------
            System.out.println("Benvenuto nel pannello di amministrazione");
            System.out.println("Inserisci 1 per visualizzare i veicoli in servizio");
            System.out.println("Inserisci 2 per visualizzare i veicoli in manutenzione");
            System.out.println("Inserisci 3 per visualizzare i veicoli non in servizio");
            System.out.println("Inserisci 4 per visualizzare le tratte percorribili");
            System.out.println("Inserisci 5 per visualizzare i biglietti vidimati");
            System.out.println("Inserisci 6 per visualizzare le tratte percorribili da un mezzo specifico");
            System.out.println("Inserisci 7 per visualizzare le tratte percorribili da un mezzo specifico con il tempo medio di percorrenza");
            System.out.println("Inserisci 8 per visualizzare i rivenditori autorizzati");
            System.out.println("Inserisci 9 per visualizzare le macchinette");
            System.out.println("Inserisci 10 per visualizzare i tram");
            System.out.println("Inserisci 11 per visualizzare i bus");
            System.out.println("Inserisci 12 per gestire veicoli e rotte");
            System.out.println("Inserisci 0 per uscire");
            n = Integer.parseInt(scanner.nextLine());
            if (n < 0 || n > 12) {
                System.out.println("Inserisci nuovamente il numero");
            }
        } while (n < 0 || n > 12);
        if (n == 1) {
            //visualizza veicoli in servizio
            System.out.println("Veicoli in servizio:");
            for (Vehicle vehicle : vd.findAllInServiceVehicles()) {
                System.out.println(vehicle);
            }
        } else if (n == 2) {
            //visualizza veicoli in manutenzione
            System.out.println("Veicoli in manutenzione:");
            for (Vehicle vehicle : vd.findAllMaintenanceVehicles()) {
                System.out.println(vehicle);
            }
        } else if (n == 3) {
            //visualizza veicoli non in servizio
            System.out.println("Veicoli non in servizio:");
            for (Vehicle vehicle : vd.findAllNotInServiceVehicles()) {
                System.out.println(vehicle);
            }
        } else if (n == 4) {
            //visualizza tratte percorribili
            System.out.println("Tratte percorribili:");
            TravelRouteDAO trd = new TravelRouteDAO(em);
            for (TravelRoute route : trd.findAllRoutes()) {
                System.out.println(route);
            }
        } else if (n == 5) {
            //visualizza biglietti vidimati
            System.out.println("Biglietti vidimati:");
            for (Ticket ticket : ticketDAO.findAllEndorsedTickets()) {
                System.out.println(ticket);
            }
        } else if (n == 6) {
            //visualizza tratte percorribili da un mezzo specifico
            System.out.println("Inserisci l'ID del veicolo per visualizzare le tratte percorribili:");
            long vehicleId = Long.parseLong(scanner.nextLine());
            Vehicle vehicle = vd.findVehicleById(vehicleId);
            TravelRouteDAO trd = new TravelRouteDAO(em);
            System.out.println("Tratte percorribili dal veicolo " + vehicle.getNumberPlate() + ":");
            for (TravelRoute route : trd.findRoutesByVehicle(vehicle)) {
                System.out.println(route);
            }
        } else if (n == 7) {
            //visualizza tratte percorribili da un mezzo specifico con il tempo medio di percorrenza
            System.out.println("Inserisci l'ID del veicolo per visualizzare le tratte percorribili con il tempo medio di percorrenza:");
            long vehicleId = Long.parseLong(scanner.nextLine());
            Vehicle vehicle = vd.findVehicleById(vehicleId);
            TravelRouteDAO trd = new TravelRouteDAO(em);
            System.out.println("Tratte percorribili dal veicolo " + vehicle.getNumberPlate() + " con il tempo medio di percorrenza:");

            for (TravelRoute route : trd.findRoutesByVehicle(vehicle)) {
                System.out.println(route + " - Tempo medio di percorrenza: " + route.getActualTravelTime() + " minuti");
            }
        } else if (n == 8) {
            //visualizza rivenditori autorizzati
            System.out.println("Rivenditori autorizzati:");
            for (TicketSystem ts : tsd.findAllAuthorizedResellers()) {
                System.out.println(ts);
            }
        } else if (n == 9) {
            //visualizza macchinette
            System.out.println("Macchinette:");
            for (TicketSystem ts : tsd.findAllVendingMachines()) {
                System.out.println(ts);
            }
        } else if (n == 10) {
            //visualizza tram
            System.out.println("Tram:");
            for (Vehicle vehicle : vd.findAllTrams()) {
                System.out.println(vehicle);
            }
        } else if (n == 11) {
            //visualizza bus
            System.out.println("Bus:");

            for (Vehicle vehicle : vd.findAllBuses()) {
                System.out.println(vehicle);
            }
        } else if (n == 12) {
            //gestione veicoli e rotte
            System.out.println("Gestione veicoli e rotte:");
            //  implementare la logica per gestire veicoli e rotte
            //  creare, aggiornare o eliminare veicoli e rotte

            System.out.println("Questa funzionalità è in fase di sviluppo.");
            // Puoi implementare le seguenti funzionalità:
            // - Creazione di nuovi veicoli e rotte
            // - Aggiornamento dello stato dei veicoli
            // - Associazione di veicoli a rotte specifiche
            // - Visualizzazione delle rotte disponibili per un veicolo specifico
            // - Calcolo del tempo medio di percorrenza per una tratta specifica
            // - Gestione delle tratte e dei veicoli in manutenzione
            // - Visualizzazione delle tratte percorribili da un mezzo specifico
            //calcolo tempo medio effettivo di percorrenza tratta da parte di un mezzo
        } else {
            System.out.println("Uscita dal programma.");


        }
        em.close();
        emf.close();
    }
}
