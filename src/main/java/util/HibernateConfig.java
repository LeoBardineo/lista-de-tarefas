package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	private static HibernateConfig instance = new HibernateConfig();
    private SessionFactory sessionFactory;
    
    public static HibernateConfig getInstance(){
    	return instance;
    }
    
    private HibernateConfig(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }
    
    public static Session getSession(){
        Session session =  getInstance().sessionFactory.openSession();
        return session;
    }
}
