package ir.javaland.projects.location.config;

import ir.javaland.projects.location.model.Country;
import ir.javaland.projects.location.model.Location;
import ir.javaland.projects.location.model.User;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static Session session;

    static {
        session = new Configuration().configure()
                .addAnnotatedClass(Location.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory().openSession();
    }

    public static Session getSession() {
        return session;
    }
}
