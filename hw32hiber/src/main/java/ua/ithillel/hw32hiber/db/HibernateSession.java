package ua.ithillel.hw32hiber.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ua.ithillel.hw32hiber.entity.Student;

import java.io.File;
import java.util.Locale;

public class HibernateSession {
    public static SessionFactory buildSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(Student.class);
        configObj.configure(new File("hw32hiber\\src\\main\\resources\\META-INF\\hibernate.cfg.xml"));
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
                .applySettings(configObj.getProperties())
                .build();
        return configObj.buildSessionFactory(serviceRegistryObj);
    }
}
