package edu.cuit.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
     	   Configuration configuration = new Configuration().configure();

     	  //apply configuration property settings to StandardServiceRegistryBuilder
     	    	            
     	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
     	    	            StandardServiceRegistryImpl registry = (StandardServiceRegistryImpl) builder
     	    	                  .build();
     	    	              
     	    	   
     	    	           return configuration.buildSessionFactory(registry);
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void closeSessionFactory(){
    	sessionFactory.close();
    }

}