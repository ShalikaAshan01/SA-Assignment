package carservice;

public interface CarService {
	public boolean reserveCar(String regNo);
	public boolean addAvailableCar(String regNo);
	/*
	 * add new car into csv
	 */
	//public boolean addNewCar();
	boolean addNewCar(String model, String regNo, String brand, String type, String price);
	public boolean removeCar();
	public void displayAvailableCars();
	public void displayReservedCars();
	
}