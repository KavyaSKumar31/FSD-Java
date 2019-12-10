package comm.example.dao;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;



import comm.example.factory.HibernateUtilFactory;
import comm.example.model.Customer;


public class CustomerDaoImpl implements CustomerDao {

	
		private org.hibernate.Session session = null;
		private SessionFactory factory = null;

		{
			factory = HibernateUtilFactory.getSessionFactory();
		}
		public void createCustomer(Customer customer) {
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.persist(customer);
			session.getTransaction().commit();

		} finally {
			session.close();
		}
	}
		public List<Customer> DisplayCustomer() {
			SessionFactory factory = HibernateUtilFactory.getSessionFactory();
			
			session = factory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery("from Customer");
			session.getTransaction().commit();
			@SuppressWarnings("unchecked")
			List<Customer> list1 = query.getResultList();
			List<Customer> sList = new ArrayList<Customer>();
			
			for(Customer c:list1) {
				sList.add(c);
			}
			
			session.close();
			

			return sList;
			
			
		
		}
		public int deleteCustomer(int id)  {
			// TODO Auto-generated method stub
			SessionFactory factory = HibernateUtilFactory.getSessionFactory();
			try {
			session=factory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery("delete from Customer c where c.id=:cId");
			query.setParameter("cId", id);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			return id;
			
			}
		catch (Error t) {
			 
			  
			}
			return id;
			
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
		}

	}
		
	


