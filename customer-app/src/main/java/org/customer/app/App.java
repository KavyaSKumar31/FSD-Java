package org.customer.app;

import java.util.Scanner;

import org.customer.app.factory.CustomerFactory;
import org.customer.app.factory.CustomerFactoryImpl;
import org.customer.app.model.Customer;

public class App {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			CustomerFactory impl = new CustomerFactoryImpl();
			System.out.println("1. Create Customer");
			System.out.println("2. Find Customer By Id");
			System.out.println("3. Find Customer By Name");
			System.out.println("4. Update customer");
			System.out.println("5. Delete Customer");
			System.out.println("6. Exit");

			int choice;

			do {
				choice = scanner.nextInt();
				switch (choice) {
				case 1:

					System.out.print("ID: ");
					int id = scanner.nextInt();
					System.out.print("NAME: ");
					String name = scanner.next();
					System.out.print("EMAIL: ");
					String email = scanner.next();

					Customer customer = impl.createCustomer(id, name, email);
					System.out.println(customer.toString());
					break;
				/*
				 * List<Customer> list=impl.getAllCustomer(); for(Customer c:list) {
				 * System.out.println(c); }
				 */
				case 2:
					System.out.print("enter id to search: ");
					int id1 = scanner.nextInt();
					impl.findById(id1);

					break;
				case 3:
					System.out.print("enter Name to search: ");
					String name1 = scanner.next();
					impl.findByName(name1);
					break;
				case 4:
					System.out.println("Enter id to update");
					int id2 = scanner.nextInt();
					impl.updateCustomer(id2);
					break;
				case 5:
					System.out.println("Enter id to delete");
					int id3 = scanner.nextInt();
					impl.deleteCustomer(id3);
					break;
				case 6:
					System.exit(0);
				default:
					System.out.println("invalid choice");

				}
			} while (choice != 0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
