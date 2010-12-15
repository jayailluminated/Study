package jjseo.test.jpa;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Settings;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.hibernate.event.EventListeners;
import org.hibernate.event.PostInsertEventListener;
import org.hibernate.impl.SessionFactoryImpl;
import org.hibernate.impl.SessionImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractJpaTestCase {

    protected Logger log = LoggerFactory.getLogger(this.getClass());



    private static EntityManagerFactory entityManagerFactory;
    protected static Connection connection;
    protected EntityManager em;

    @BeforeClass
    public static void setupDatabase() throws Exception {
        // this information defined in the persistence.xml and hibernate.properties file **************
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-persistence-unit-name");
        connection = getConnection(entityManagerFactory);
    }

    @AfterClass
    public static void closeDatabase() throws Exception {
        if (connection != null) {
            // TODO: hsqldb was supposed to shutdown on close, but it isn't
            connection.prepareStatement("SHUTDOWN").execute();
            connection.close();
            connection = null;
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }


    @SuppressWarnings("unused")
    @Before
    public void setEntityManager() {
        em = entityManagerFactory.createEntityManager();

        // change if statement below to true to figure out the Hibernate
        // listeners
        if (false) {
        //if (true) {
            Object delegate = em.getDelegate();
            SessionImpl session = (SessionImpl) delegate;
            EventListeners listeners = session.getListeners();
            PostInsertEventListener[] originalPostInsertEventListener = listeners.getPostInsertEventListeners();
            for (PostInsertEventListener listener : originalPostInsertEventListener) {
                System.err.println(">>> PostInsertEventListener: " + listener.getClass().getName());
            }
        }
    }

    @After
    public void closeEntityManager() {
        assert em != null;
        em.close();
    }

    /**
     * it's better to extract the JDBC connection from JPA's entity manager
     */
    public static Connection getConnection(Object object) throws Exception {
        Connection connection = null;

        if (object instanceof EntityManagerFactoryImpl) {
            EntityManagerFactoryImpl impl = (EntityManagerFactoryImpl) object;
            SessionFactory sessionFactory = impl.getSessionFactory();

            if (sessionFactory instanceof SessionFactoryImpl) {
                SessionFactoryImpl sfi = (SessionFactoryImpl) sessionFactory;
                Settings settings = sfi.getSettings();
                ConnectionProvider provider = settings.getConnectionProvider();
                connection = provider.getConnection();
            }
        }
        return connection;
    }

    protected void beginTransaction() {
        assert em != null;
        em.getTransaction().begin();
    }

    protected void commitTransaction() {
        assert em != null;
        em.getTransaction().commit();
    }

    protected void commitTransaction(boolean clearContext) {
        commitTransaction();
        if (clearContext) {
            em.clear();
        }
    }
}