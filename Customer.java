package folder1.folder2;
import folder1.folder2.*;
import java.util.*;
import java.io.*;

public class Customer extends GM{
	String first_name;
	String last_name;
	int lottery_num;
	CustomerType type;
	int id;
	
	public String toString(){
		String info="";
		info = "The name is "+first_name+" "+last_name+". The type is "+getType()+". The ID is "+id+". The ticket is "+lottery_num;
		return info;
	}
	public void createFile(){
		ImplCustomer temp = new ImplCustomer();
		Vector<Customer> customers = new Vector<Customer>();
		customers.addAll(createCustomers());
		temp.createCustomersSer(customers);
	}
	public ArrayList<Customer> readFile(){
		ImplCustomer temp = new ImplCustomer();
		ArrayList<Customer> customers = temp.readCustomersSer();
		return customers;
	}
	
	public Customer(){
		first_name="";
		last_name="";
		lottery_num=-1;
	}
	public Customer(String f, String l, int n){
		first_name=f;
		last_name=l;
		lottery_num=n;
	}
	public String is(){
		return "Customer";
	}
	public int getID(){
		return id;
	}
	public void setID(int u){
		id=u;
	}
	public Vector<Customer> createCustomers(){
		Vector<Customer> all = new Vector<Customer>();
		for(int i = 1; i<=25; i++){
			String f = "John"+Integer.toString(i);
			String l = "Dow"+Integer.toString(i);
			int num = 0;
			if(i<=10){
				num = i;
			}else if(i<=15){
				num = i+9;
			}else if(i<=25){
				num = i+20;
			}
			Customer temp = new Customer(f,l,num);
			if((i<=5)&&(i>0)){
				temp.setType(CustomerType.A);
			}else if((i<=10)&&(i>5)){
				temp.setType(CustomerType.B);
			}else if((i<=15)&&(i>10)){
				temp.setType(CustomerType.C);
			}else if((i<=20)&&(i>15)){
				temp.setType(CustomerType.D);
			}else if((i<=25)&&(i>20)){
				temp.setType(CustomerType.E);
			}
			temp.setID(i);
			all.add(temp);
		}
		return all;
	}

	public void setType(CustomerType c){
		type = c;
	}
	public String getLastName(){
		return last_name;
	}
	public CustomerType getType(){
		return type;
	}
	public int getTicket(){
		return lottery_num;
	}
}