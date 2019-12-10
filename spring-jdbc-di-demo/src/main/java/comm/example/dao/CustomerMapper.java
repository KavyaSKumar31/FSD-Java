package comm.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import comm.example.model.Customer;

public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer c = new Customer();
		c.setFirstName(rs.getString("firstname"));
		c.setLastName(rs.getString("lastname"));
		c.setEmail(rs.getString("email"));
		return c;
	
	}

}
