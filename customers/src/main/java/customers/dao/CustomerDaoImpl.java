package customers.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import customers.model.Customers;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Repository
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	private SessionFactory sessionFactory;
	

	
	public Customers createcustomer(Customers theCustomer) {
		Session session;
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.save(theCustomer);
		return theCustomer;
	}



}
