package helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by marioquer on 2017/3/14.
 */
public class HibernateUtil {
    public HibernateUtil() {
    }
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static final ThreadLocal threadLocal = new ThreadLocal();

    public static Session currentSession() {
        Session currentSession = (Session) threadLocal.get();
        if (currentSession == null) {
            currentSession = sessionFactory.openSession();
            threadLocal.set(currentSession);
        }
        return currentSession;
    }

    public static void closeSession() {
        Session currentSession = (Session) threadLocal.get();
        if (currentSession == null) {
            currentSession.close();
        }
        threadLocal.set(null);
    }
}
