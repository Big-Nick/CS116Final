package folder1;

import folder1.folder2.*;
import java.util.*;
import java.io.*;

public class LotterySimulator extends GM {

	public static void main(String args[]) {
		int[] data = { 0, 0, 0, 0, 0 };
		// Zeroeth is a 1 or 0 determining whether the method was called successfully or
		// not
		// First is the number of the winning car in the array
		// Second is number of times match not found was thrown
		// Third is number of times repeat number was thrown
		// Fourth is which ticket won
		int allNotFound = 0;
		int allRepeats = 0;
		int wins = 0;
		int called = 0;
		int totalPrices = 0;
		ArrayList<String> outputs = new ArrayList<String>();
		Dealership dealership = new Dealership();
		Customer originalCustomer = new Customer();
		originalCustomer.createFile();
		Dealership[] dealerships = dealership.createDealerships();
		Vector<Customer> customers = originalCustomer.createCustomers();
		ArrayList<VehicleA> cars = createVehicles();
		GM gm = new Dealership();
		ArrayList<Dealership> dealers = gm.assignVehicles(dealerships, cars);
		int timecount = 0;
		int newtimecount = 0;

		FileOutputStream fos;
		OutputStreamWriter osw;
		String filename = "output.txt";
		dealership.createFile();
		ImplVehicle impl = new ImplVehicle();
		impl.createFile(cars);
		while ((timecount < 2000) && (wins < 10)) {

			if (timecount == newtimecount) {
				newtimecount = (int) (timecount + (Math.random() * 100));
				called++;
				String info = "";
				String output = "";
				info = info + "\n" + "\n" + "This is event " + called;

				int dealer = (int) ((Math.random()) * dealers.size());
				Dealership dea = dealers.get(dealer);
				while (dea.countCars() == 0) {
					dea.declareWinner();
					dealers.remove(dealer);
					dealer = (int) ((Math.random()) * dealers.size());
					dea = dealers.get(dealer);
				}
				data = dea.declareWinner();
				allNotFound += data[2];

				allRepeats += data[3];
				String dnm = dealers.get(dealer).getName();
				VehicleA veh = dea.getVehicle(data[1]);

				if (dnm.equals("Glen Ellyn Chevrolet"))
					veh.setPrice(16000);
				else if (dnm.equals("South Suburbs Pontiac"))
					veh.setPrice(19000);
				else if (dnm.equals("Chicago Buick"))
					veh.setPrice(20000);
				else if (dnm.equals("Schaumburg Cadillac"))
					veh.setPrice(35000);
				else if (dnm.equals("Saturn of North Chicago"))
					veh.setPrice(23000);

				info = info + "\n" + veh.getVehicleType() + " is the type. " + veh.getPrice() + " is the price. "
						+ veh.getCurrentID() + " is the ID";
				info = info + "\n" + "The dealer is " + dnm;
				info = info + "\n" + dea.probability() + " is the type of probability.";
				info = info + "\n" + data[4] + " is the ticket drawn.";

				for (int i = 0; i < customers.size(); i++) {
					Customer tempCustomer = customers.get(i);
					if (data[4] == tempCustomer.getTicket()) {
						originalCustomer = tempCustomer;
					}
				}

				String money = "";
				if (data[0] == 0) {
					info = info + "\n" + "The ticket is not a winner.";
				} else if (data[0] == 1) {
					wins++;
					totalPrices += veh.getPrice();
					money = "\n" + totalPrices + " is the total price of all " + wins + " cars so far";
					info = info + "\n" + "The ticket is a winner!!!";
					info = info + "\n" + originalCustomer.toString();
					output = output + veh.getCurrentID() + " is the ID. " + "\t";
					output = output + timecount + " is the time. " + "\t";
					output = output + called + " is the event number. " + "\t";
					output = output + originalCustomer.getID() + " is the ID" + "\t";
					output = output + dnm + " is the dealership." + "\n";
					dea.removeVehicle(data[1]);
					if (dea.countCars() == 0) {
						dealers.remove(dealer);
					}
				}

				outputs.add(output);
				info = info + money;
				System.out.println(info);

			}
			timecount++;

		}
		try {
			fos = new FileOutputStream(filename, true);
			osw = new OutputStreamWriter(fos);
			for (int i = 0; i < outputs.size(); i++) {
				osw.write(outputs.get(i));
			}
			osw.write("The exception: MatchNotFoundException was thrown " + allNotFound + " times." + "\n");
			osw.write("The exception: RepeatNumberException  was thrown " + allRepeats + " times." + "\n");
			osw.flush();
			fos.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public String is() {
		return "The main LotterySimulator";
	}

	public static ArrayList<VehicleA> createVehicles() {
		ArrayList<VehicleA> all = new ArrayList<VehicleA>();
		for (int i = 0; i < 10; i++) {
			VehicleA car = new VehicleA();
			if (i == 0) {
				car = new VehicleA(VehicleType.FOUR_DOOR_SEDAN, 1, 1, 0, 0);
			}
			if (i == 1) {
				car = new VehicleA(VehicleType.FOUR_DOOR_SEDAN, 2, 1, 0, 0);
			}
			if (i == 2) {
				car = new VehicleA(VehicleType.TWO_DOOR_COUPE, 3, 1, 0, 0);
			}
			if (i == 3) {
				car = new VehicleA(VehicleType.TWO_DOOR_COUPE, 4, 1, 0, 0);
			}
			if (i == 4) {
				car = new VehicleA(VehicleType.TRUCK, 5, 1, 0, 0);
			}
			if (i == 5) {
				car = new VehicleA(VehicleType.TRUCK, 6, 1, 0, 0);
			}
			if (i == 6) {
				car = new VehicleA(VehicleType.SUV, 7, 1, 0, 0);
			}
			if (i == 7) {
				car = new VehicleA(VehicleType.SPORT, 8, 1, 0, 0);
			}
			if (i == 8) {
				car = new VehicleA(VehicleType.SPORT, 8, 1, 0, 0);
			}
			if (i == 9) {
				car = new VehicleA(VehicleType.MINI_VAN, 10, 1, 0, 0);
			}
			all.add(car);
		}
		return all;
	}

}