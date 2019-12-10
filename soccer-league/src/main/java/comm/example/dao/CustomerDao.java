package comm.example.dao;

import java.util.List;

import comm.example.model.Customer;

public interface CustomerDao {
	public void createCustomer(Customer customer);
	public List<Customer> DisplayCustomer();
	public int deleteCustomer(int id);
}
