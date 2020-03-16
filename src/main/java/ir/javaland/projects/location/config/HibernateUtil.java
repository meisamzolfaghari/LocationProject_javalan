package ir.javaland.projects.location.config;

import ir.javaland.projects.location.model.Location;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static Session session;

    static {
        session = new Configuration().configure()
                .addAnnotatedClass(Location.class)
                .buildSessionFactory().openSession();
    }

    public static Session getSession() {
        return session;
    }
}
