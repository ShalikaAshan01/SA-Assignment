package carservice;

public interface CarService {
	public boolean reserveCar(String regNo);
	public boolean addAvailableCar(String regNo);
	/*
	 * add new car into csv
	 */
	public boolean addNewCar();
	public boolean removeCar();
}