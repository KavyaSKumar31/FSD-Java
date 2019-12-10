package customers.service;

import org.springframework.stereotype.Service;

import customers.dao.CustomerDao;
import customers.model.Customers;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{
private CustomerDao dao;
	public Customers createCustomer(Customers theCustomer) {
		// TODO Auto-generated method stub
		Customers c = dao.createcustomer(theCustomer);
		return c;
	}

}
