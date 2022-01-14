package folder1.folder2;

import folder1.folder2.*;
import java.util.*;
import java.io.*;

public class Dealership extends GM {
	DealershipType type;
	String name;
	ArrayList<VehicleA> cars;
	static ArrayList<Integer> tickets;

	public String probability() {
		String info = "";
		if (name.equals("Chicago Buick")) {
			info = "Uniform probability";
		} else if (name.equals("Glen Ellyn Chevrolet")) {
			info = "Exponential probability";
		} else if (name.equals("Saturn of North Chicago")) {
			info = "Gaussian probability";
		} else if (name.equals("South Suburbs Pontiac")) {
			info = "Uniform probability";
		} else if (name.equals("Schaumburg Cadillac")) {
			info = "Gaussian probability";
		}
		return info;
	}

	public int[] declareWinner() {
		int[] data = { 0, 0, 0, 0, 0 };
		// Zeroeth is a 1 or 0 determining whether the method was called successfully or
		// not
		// First is the number of the winning car in the array
		// Second is number of times match not found was thrown
		// Third is number of times repeat number was thrown
		// Fourth is which ticket won
		if (cars.size() == 0) {
			System.out.println(name + " has no more cars.");
			return data;
		}
		boolean flag = true;
		int ticket = 0;
		System.out.println("Number of cars for this dealer " + cars.size());
		while (flag) {
			try {
				while ((ticket < 1) || (ticket > 45)) {
					if (name.equals("Chicago Buick")) {
						ticket = (int) ((Math.random() + 1) * 40);
					} else if (name.equals("Glen Ellyn Chevrolet")) {
						ticket = (int) (-5 * Math.log(Math.random()));
					} else if (name.equals("Saturn of North Chicago")) {
						Random r = new Random();
						while ((ticket < 1) || (ticket > 45)) {
							ticket = (int) (r.nextGaussian() * 5 + 20);
						}
					} else if (name.equals("South Suburbs Pontiac")) {
						ticket = (int) ((Math.random() + 1) * 20);
					} else if (name.equals("Schaumburg Cadillac")) {
						Random r = new Random();
						while ((ticket < 1) || (ticket > 45)) {
							ticket = (int) (r.nextGaussian() * 2.5 + 2.5);
						}
					}
				}
				data[4] = ticket;
				if (((ticket > 10) && (ticket < 20)) || ((ticket > 24) && (ticket < 36))) {
					data[2] = data[2] + 1;
					throw new MatchNotFoundException();
				}

				for (int i = 0; i < tickets.size(); i++) {
					if (ticket == tickets.get(i)) {
						data[3] = data[3] + 1;
						throw new RepeatNumberException();
					} else {
						boolean limit = true;
						int count = 0;
						while (limit) {
							int d = (int) ((Math.random()) * cars.size());
							if ((d > 0) && (d < cars.size())) {
								data[1] = d;
								limit = false;
							}
							count++;
							if (count == 5)
								limit = false;
						}

						flag = false;
					}
				}
				tickets.add(ticket);
				data[0] = 1;

			} catch (MatchNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println("M ERROR");
				flag = false;
			} catch (RepeatNumberException r) {
				System.out.println(r.getMessage());
				System.out.println("R ERROR");
				flag = false;
			}
		}
		return data;
	}

	public Dealership() {
		name = "";
	}

	public Dealership(String n, DealershipType t) {
		name = n;
		type = t;
		cars = new ArrayList<VehicleA>();
	}

	public void fixName() {
		switch (type) {
			case CHEVROLET:
				name = "Glen Ellyn Chevrolet";
				break;
			case PONTIAC:
				name = "South Suburbs Pontiac";
				break;
			case BUICK:
				name = "Chicago Buick";
				break;
			case CADILLAC:
				name = "Schaumburg Cadillac";
				break;
			case SATURN:
				name = "Saturn of North Chicago";
				break;
		}
	}

	public Dealership[] createDealerships() {
		Dealership[] all = new Dealership[5];
		for (int i = 0; i < 5; i++) {
			Dealership temp = new Dealership("", DealershipType.values()[i]);
			temp.fixName();
			all[i] = temp;
		}
		tickets = new ArrayList<Integer>();
		tickets.add(0);
		tickets.add(50);
		return all;
	}

	public void createFile() {
		ImplDealership temp = new ImplDealership();
		Dealership[] dealers = createDealerships();
		temp.createFile(dealers);
	}

	public ArrayList<Dealership> readFile() {
		ImplDealership temp = new ImplDealership();
		ArrayList<Dealership> dealers = temp.readFile();
		return dealers;
	}

	public void addVehicle(VehicleA car) {
		cars.add(car);
	}

	public VehicleA getVehicle(int car) {
		return cars.get(car);
	}

	public void removeVehicle(int car) {
		cars.remove(car);
	}

	public String is() {
		return "Dealership";
	}

	public int countCars() {
		return cars.size();
	}

	public String getEnum() {
		return type.name();
	}

	public String getName() {
		return name;
	}
}
