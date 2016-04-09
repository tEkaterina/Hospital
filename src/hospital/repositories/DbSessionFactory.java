package hospital.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbSessionFactory {

    private static SessionFactory sessionFactory;

    static {
        try{
            sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
        }catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session get() {
        return sessionFactory.openSession();
    }
}
