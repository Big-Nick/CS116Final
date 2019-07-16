package folder1.folder2;
import folder1.folder2.*;
import java.util.*;
import java.io.*;
public abstract class GM implements Serializable,Interface{
	

	public abstract String is();
	public String getEnum(){
		return "none";
	}
	
	public ArrayList<Dealership> assignVehicles(Dealership[] dealers,ArrayList<VehicleA> cars){
		int size = cars.size();
		ArrayList<Dealership> all = new ArrayList<Dealership>();
		while(size>0){
			int winningDealer = (int)((Math.random())*5); //Range is 0-4
			int winningCar = (int)((Math.random())*cars.size());
			Dealership dealer = dealers[winningDealer];
			VehicleA car = cars.get(winningCar);
			dealer.addVehicle(car);
			cars.remove(winningCar);
			size = cars.size();
		}
		for(int i = 0; i<5; i++){
			all.add(dealers[i]);
		}
		return all;
	}
}