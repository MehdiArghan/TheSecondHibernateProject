package base.repository.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    public static final StandardServiceRegistry STANDARD_SERVICE_REGISTRY = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml").build();
    public static final Metadata METADATA = new MetadataSources(STANDARD_SERVICE_REGISTRY).getMetadataBuilder().build();
    public static final SessionFactory SESSION_FACTORY = METADATA.getSessionFactoryBuilder().build();

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}