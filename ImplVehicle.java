package folder1.folder2;
import folder1.folder2.*;
import java.util.*;
import java.io.*;
public class ImplVehicle extends Vehicleser implements IntVehicle
{
	public void createFile(ArrayList<VehicleA> vehicles){
		Vehicleser temp = new Vehicleser();
		temp.createVehiclesSer(vehicles);
	}
	public ArrayList<VehicleA> readFile(){
		Vehicleser temp = new Vehicleser();
		ArrayList<VehicleA> vehicles = new ArrayList<VehicleA>();
		vehicles.addAll(temp.readVehiclesSer());
		return vehicles;
	}
		public static ArrayList<VehicleA> createVehicles(){
		ArrayList<VehicleA> all = new ArrayList<VehicleA>();
		for(int i = 0; i<10;i++){
			VehicleA car = new VehicleA();
			if(i==0){
				car = new VehicleA(VehicleType.FOUR_DOOR_SEDAN, 1, 1, 0, 0);
			}
			if(i==1){
				car = new VehicleA(VehicleType.FOUR_DOOR_SEDAN, 2, 1, 0, 0);
			}
			if(i==2){
				car = new VehicleA(VehicleType.TWO_DOOR_COUPE, 3, 1, 0, 0);
			}
			if(i==3){
				car = new VehicleA(VehicleType.TWO_DOOR_COUPE, 4, 1, 0, 0);
			}
			if(i==4){
				car = new VehicleA(VehicleType.TRUCK, 5, 1, 0, 0);
			}
			if(i==5){
				car = new VehicleA(VehicleType.TRUCK, 6, 1, 0, 0);
			}
			if(i==6){
				car = new VehicleA(VehicleType.SUV, 7, 1, 0, 0);
			}
			if(i==7){
				car = new VehicleA(VehicleType.SPORT, 8, 1, 0, 0);
			}
			if(i==8){
				car = new VehicleA(VehicleType.SPORT, 8, 1, 0, 0);
			}
			if(i==9){
				car = new VehicleA(VehicleType.MINI_VAN, 10, 1, 0, 0);
			}
			all.add(car);
		}
		return all;
	}
}
