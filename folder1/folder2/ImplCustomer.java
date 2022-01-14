package folder1.folder2;

import folder1.folder2.*;
import java.util.*;
import java.io.*;

public class ImplCustomer extends Customerser implements IntCustomer {
	public void createFile(Vector<Customer> customers) {
		Customerser temp = new Customerser();
		temp.createCustomersSer(customers);
	}

	public ArrayList<Customer> readFile() {
		Customerser temp = new Customerser();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.addAll(temp.readCustomersSer());
		return customers;
	}
}
