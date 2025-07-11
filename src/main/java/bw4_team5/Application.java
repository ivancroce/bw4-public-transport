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
        VehicleStateLogDAO vsld = new VehicleStateLogDAO(em);

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

        VehicleStateLog log1 = new VehicleStateLog(LocalDate.of(2025,4,19),"Tagliando e manutenzione ordinaria",LocalDate.of(2025,4,29),bus1);
        VehicleStateLog log2 = new VehicleStateLog(LocalDate.of(2025,5,10),"Cambio motore e frizione",LocalDate.of(2025,6,15),bus2);
        VehicleStateLog log3 = new VehicleStateLog(LocalDate.of(2025,6,11),"Lavori di carrozzeria",LocalDate.of(2025,7,22),bus3);
        VehicleStateLog log4 = new VehicleStateLog(LocalDate.of(2025,2,1),"Riparazione quadro elettrico",LocalDate.of(2025,2,24),tram1);
        VehicleStateLog log5 = new VehicleStateLog(LocalDate.of(2024,12,10),"Ristrutturazione sedili",LocalDate.of(2025,1,15),tram2);
        VehicleStateLog log6 = new VehicleStateLog(LocalDate.of(2025,2,17),"Controlli ordinari",LocalDate.of(2025,3,6),tram3);

        /*vsld.save(log1);
        vsld.save(log2);
        vsld.save(log3);
        vsld.save(log4);
        vsld.save(log5);
        vsld.save(log6);*/


        vsld.getAllLogs().forEach(System.out::println);
        Vehicle bus1FromDb = vd.findBusById(1);
        Vehicle bus2FromDb = vd.findBusById(2);
        Vehicle bus3FromDb = vd.findBusById(3);
        Vehicle tram1FromDb = vd.findTramById(4);
        Vehicle tram2FromDb = vd.findTramById(5);
        Vehicle tram3FromDb = vd.findTramById(6);
        System.out.println("-------------------------------");
        System.out.println(vsld.getLogsByVehicleId(bus1FromDb.getId()));
        System.out.println(vsld.getLogsByVehicleId(bus2FromDb.getId()));
        System.out.println(vsld.getLogsByVehicleId(bus3FromDb.getId()));
        System.out.println(vsld.getLogsByVehicleId(tram1FromDb.getId()));
        System.out.println(vsld.getLogsByVehicleId(tram2FromDb.getId()));
        System.out.println(vsld.getLogsByVehicleId(tram3FromDb.getId()));
        System.out.println("-------------------------------");
        System.out.println(vsld.getLogsByVehicleAndDateRange(bus1FromDb.getId(),LocalDate.of(2025,1,1),LocalDate.of(2025,6,30)));
        System.out.println(vsld.getLogsByVehicleAndDateRange(bus2FromDb.getId(),LocalDate.of(2025,1,1),LocalDate.of(2025,6,30)));
        System.out.println(vsld.getLogsByVehicleAndDateRange(bus3FromDb.getId(),LocalDate.of(2025,1,1),LocalDate.of(2025,6,30)));
        System.out.println(vsld.getLogsByVehicleAndDateRange(tram1FromDb.getId(),LocalDate.of(2025,1,1),LocalDate.of(2025,6,30)));
        System.out.println(vsld.getLogsByVehicleAndDateRange(tram2FromDb.getId(),LocalDate.of(2024,1,1),LocalDate.of(2025,6,30)));
        System.out.println(vsld.getLogsByVehicleAndDateRange(tram3FromDb.getId(),LocalDate.of(2025,1,1),LocalDate.of(2025,6,30)));
        System.out.println("-------------------------------");
        System.out.println(vsld.getLogsByVehicleAndDateRange(bus1FromDb.getId(),LocalDate.of(2025,6,1),LocalDate.of(2025,12,30)));
        System.out.println(vsld.getLogsByVehicleAndDateRange(bus2FromDb.getId(),LocalDate.of(2025,6,1),LocalDate.of(2025,12,30)));
        System.out.println(vsld.getLogsByVehicleAndDateRange(bus3FromDb.getId(),LocalDate.of(2025,6,1),LocalDate.of(2025,12,30)));
        System.out.println(vsld.getLogsByVehicleAndDateRange(tram1FromDb.getId(),LocalDate.of(2025,6,1),LocalDate.of(2025,12,30)));
        System.out.println(vsld.getLogsByVehicleAndDateRange(tram2FromDb.getId(),LocalDate.of(2025,6,1),LocalDate.of(2025,12,30)));
        System.out.println(vsld.getLogsByVehicleAndDateRange(tram3FromDb.getId(),LocalDate.of(2025,6,1),LocalDate.of(2025,12,30)));

        em.close();
        emf.close();
    }
}
