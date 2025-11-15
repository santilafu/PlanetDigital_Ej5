package org.planetdigital;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();

            Empresa e1 = new Empresa("TechCorp", "España");
            PersonaContacto c1 = new PersonaContacto("Laura Pérez", "600123456");
            PersonaContacto c2 = new PersonaContacto("Carlos Ruiz", "699112233");

            e1.addContacto(c1);
            e1.addContacto(c2);

            session.persist(e1);

            session.getTransaction().commit();

            System.out.println("Datos insertados correctamente.");
        } finally {
            session.close();
            factory.close();
        }
    }
}
