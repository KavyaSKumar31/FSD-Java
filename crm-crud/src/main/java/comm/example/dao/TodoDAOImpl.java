package comm.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import comm.example.model.Login;

public class TodoDAOImpl implements TodoDAO{
	private SessionFactory factory = null;
	private Session session;
	@Override
	public List<Login> getCred(String uName) {
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Login.class)
				.buildSessionFactory();
		session = factory.openSession();
		session.getTransaction().begin();
		String upass = null;
		Query query = session.createQuery("from Login where uname=:name", Login.class).setParameter("name",uName);
		List<Login> l= query.getResultList();
		
		session.getTransaction().commit();
		return l;
	}

}
