package comm.example.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import comm.example.model.Customer;

public class HibernateUtilFactory {
	private static SessionFactory factory = null;
	public static SessionFactory getSessionFactory()
	{
		factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory();
		return factory;
	}
}
