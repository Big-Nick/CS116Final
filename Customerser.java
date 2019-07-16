package folder1.folder2;
import folder1.folder2.*;
import java.util.*;
import java.io.*;
public class Customerser implements serializable{
	public void createCustomersSer(Vector<Customer> customers){
		try{
			System.out.println("Creating the file customers.ser");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("customers.ser")));
			for(int i = 0; i<customers.size();i++){
				oos.writeObject( customers.get(i) );
			}
			oos.close();
		}catch(IOException ioe)
		{
			System.out.println("Error with file");
		}
	}
	public ArrayList<Customer> readCustomersSer(){
		ObjectInputStream ois=null;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		System.out.println("Reading customers.ser");
		try{
			ois = new ObjectInputStream(new FileInputStream(new File("customers.ser")));
			while(true){
				Customer customer = (Customer)ois.readObject();
				customers.add(customer);
			}
		} catch (EOFException ignored) {
		} catch(IOException ioe){
			System.out.println(ioe);
		} catch(ClassNotFoundException cnfe){
			System.out.println(cnfe);
		} 
		return customers;
	}
}