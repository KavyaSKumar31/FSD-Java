import org.springframework.context.support.ClassPathXmlApplicationContext;

import customers.model.Customers;
import customers.service.CustomerServiceImpl;

public class Tester {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerServiceImpl theCustomer=context.getBean("customerService",CustomerServiceImpl.class);
		Customers c = new Customers("Arjun","Suvarna");
		
		c = theCustomer.createCustomer(c);
		System.out.println(c.getId()+" "+c.getFirstName()+" "+ c.getLastName());

	}

}
