package bw4_team5;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw4_public_transport_pu");

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
