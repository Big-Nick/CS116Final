package folder1.folder2;

import folder1.folder2.*;

import java.io.Serializable;

public class VehicleA implements Serializable {

	private double velocity;
	private double acceleration;
	private double distance;
	private int time;
	private static int vehicleID = 0;
	private int currentID = 0;
	private double init_v;
	private double init_d;
	public VehicleType vt = VehicleType.NO_VEHICLE_AWARDED;
	public ShapeTypes vs = ShapeTypes.DEFAULT;
	int price = 0;
	boolean status = false;
	// false means that the vehicle has not been awarded

	int timeawarded = 0;
	Customer p = new Customer();

	public VehicleA() {

		velocity = 0.0;
		acceleration = 0.0;
		time = 0;
		distance = 0.0;

		init_v = 0.0;
		init_d = 0.0;
	}

	public VehicleA(VehicleType ty, double a, int t, double initv, double initd) {
		vehicleID++;
		currentID = vehicleID;
		vt = ty;
		acceleration = a;
		time = t;
		init_v = initv;
		init_d = initd;

	}

	public int getTimeAwarded() {
		return timeawarded;
	}

	public void setTimeAwarded(int ta) {

		timeawarded = ta;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int pr) {
		price = pr;
	}

	public void setPerson(Customer peo) {
		p = peo;
	}

	public Customer getPerson() {

		return p;
	}

	public void setStatus(boolean b) {

		status = b;
	}

	public boolean getStatus() {

		return status;
	}

	public double getVelocity() {
		return velocity;
	}

	public double getAcceleration() {

		return acceleration;
	}

	public double getDistance() {
		return distance;
	}

	public int getTime() {
		return time;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public int getCurrentID() {

		return currentID;
	}

	public double getInitV() {
		return init_v;
	}

	public double getInitD() {

		return init_d;
	}

	public void setInitV(double inv) {
		init_v = inv;
	}

	public void setInitD(double ind) {

		init_d = ind;
	}

	public void setTime(int t) {

		time = t;
	}

	public void setDistance(double dist) {

		distance = dist;
	}

	public void setVelocity(double vel) {

		velocity = vel;

	}

	public void setAcceleration(double acc) {

		acceleration = acc;
	}

	public String toString() {

		String str = "The vehicle ID is:" + " " + currentID + " " + "The maximum velocity is:" + " " + velocity
				+ "m/sec" + " " + "The price is:" + " " + price + "" + "The type is:" + " " + vt + " "
				+ "The vehicle belongs now to person:" + " " + p.getLastName() + "The time of award was:" + " "
				+ timeawarded;
		return str;
	}

	public void calculateV() {

		velocity = acceleration * time + init_v;
	}

	public void calculateD() {

		double timed = (double) time;
		double t = Math.pow(timed, 2.0);
		distance = 0.5 * acceleration * t + init_v * time + init_d;
	}

	public void setVehicleType(VehicleType vehty) {
		this.vt = vehty;
	}

	public ShapeTypes getShapeTypes() {

		return vs;

	}

	public void setShapeTypes(ShapeTypes st) {

		this.vs = st;
	}

	public VehicleType getVehicleType() {
		return vt;
	}

	public boolean equals(Object o) {
		// if o is not an Auto object, return false
		if (!(o instanceof VehicleA))
			return false;
		else {
			// type cast o to an Auto object
			VehicleA objVeh = (VehicleA) o;
			if (this.getCurrentID() == objVeh.getCurrentID())
				return true;
			else
				return false;
		}
	}

	public void setCalcutedTime(double dist, double acc, double iv) {

		int t = 0;
		double d = dist;
		double a = acc;
		double inve = iv;
		t = (int) (((Math.pow(inve, 2) + Math.sqrt(Math.pow(inve, 2) + 2 * a * d - 2 * a * init_d)) / a));
		time = t;

	}

}
