package sample;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by Tomáš on 29.4.2015.
 */
public class OpenSession {
    private static final SessionFactory mySessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration cnfg = new Configuration();
            cnfg.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(cnfg.getProperties()).buildServiceRegistry();
            mySessionFactory = cnfg.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return mySessionFactory.openSession();
    }
}
