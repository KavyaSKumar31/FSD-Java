package comm.example;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import comm.example.dao.CustomerDAO;
import comm.example.dao.CustomerDAOImpl;
import comm.example.dao.JdbcConfig;
import comm.example.model.Customer;

public class Tester {

	public static void main(String[] args) {

		try {

			AnnotationConfigApplicationContext context=
					new AnnotationConfigApplicationContext(JdbcConfig.class);
		 	CustomerDAO customerDAO = context.getBean("customerDao", CustomerDAOImpl.class);
			Customer c = new Customer("Iyaaz","Matisham Hassan","iyaaz@gmail.com");
			customerDAO.updateCustomer(c,4);
		//	System.out.println("ok!");
			/*List<Customer> l= customerDAO.displayCustomer();
			 Iterator<Customer> i=l.iterator(); while(i.hasNext()) { Customer c=i.next();
			  System.out.println(c.getFirstName()+" , "+c.getLastName()+" , "+c.getEmail())
			  ; }*/

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
