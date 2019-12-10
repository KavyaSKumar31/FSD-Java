import org.springframework.context.support.ClassPathXmlApplicationContext;

import customers.model.Customers;
import customers.service.CustomerServiceImpl;

public class App {
	ClassPathXmlApplicationContext context=
			new ClassPathXmlApplicationContext("applicationContext.xml");
	CustomerServiceImpl theCustomer=context.getBean("customerService",CustomerServiceImpl.class);
	Customers c = new Customers("Arjun","Suvarna");
	
	Customers k = theCustomer.createCustomer(c);
}
