package comm.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import comm.example.model.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDAOImpl implements CustomerDAO {

	
	private JdbcTemplate jdbcTemplate;
	
	
	
	
	
	@Override
	public void createCustomer(Customer customer) {
		jdbcTemplate.update("insert into customer(firstname,lastname,email) values (?,?,?)",
				customer.getFirstName(),customer.getLastName(),customer.getEmail());
	}
	
	public List<Customer> displayCustomer() {
		 final String SELECT = "select firstname,lastname,email from customer";
		return jdbcTemplate.query(SELECT,new CustomerMapper());
		
		}
		
	public void deleteCustomer(int id) {
		jdbcTemplate.update("delete from customer where id=?",
				id);
		
	}
	public void updateCustomer(Customer customer,int id) {
		jdbcTemplate.update("update customer set firstname = ?,lastname=?,email=? where id = ?",
				customer.getFirstName(),customer.getLastName(),customer.getEmail(),id);
	}
	
	
	



	

}
