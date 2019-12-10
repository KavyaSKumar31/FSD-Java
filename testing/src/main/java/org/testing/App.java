package org.testing;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
			SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Account.class)
					.addAnnotatedClass(SavingsAccount.class)
					.addAnnotatedClass(CurrentAccount.class).buildSessionFactory();
			Session session = factory.openSession();
			Account a = new Account("Ash", "124569c");
			SavingsAccount sa = new SavingsAccount("Pikachu", "323235679384", 1000);
			CurrentAccount ca = new CurrentAccount("Charmander", "38898384", 10);
		session.getTransaction().begin();
			session.save(a);
			session.save(sa);
			session.save(ca);
			session.getTransaction().commit();
			System.out.println("ok..");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    }

