package folder1.folder2;
import folder1.folder2.*;
import java.util.*;
import java.io.*;
public class Vehicleser implements serializable{
	public void createVehiclesSer(ArrayList<VehicleA> cars){
		try{
			System.out.println("Creating the file vehicles.ser");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("vehicles.ser")));
			for(int i = 0; i<cars.size();i++){
				oos.writeObject( cars.get(i) );
			}
			oos.close();
		}catch(IOException ioe)
		{
			System.out.println("Error with file");
		}
	}
	public ArrayList<VehicleA> readVehiclesSer(){
		ObjectInputStream ois=null;
		ArrayList<VehicleA> cars = new ArrayList<VehicleA>();
		System.out.println("Reading vehicles.ser");
		try{
			ois = new ObjectInputStream(new FileInputStream(new File("vehicles.ser")));
			while(true){
				VehicleA car = (VehicleA)ois.readObject();
				cars.add(car);
			}
		} catch (EOFException ignored) {
		} catch(IOException ioe){
			System.out.println(ioe);
		} catch(ClassNotFoundException cnfe){
			System.out.println(cnfe);
		} 
		return cars;
	}
}