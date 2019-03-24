package carservice;

import java.util.ArrayList;
import java.util.HashMap;

public interface CarService {
	public boolean reserveCar(String regNo);
	public boolean addAvailableCar(String regNo);
	/*
	 * add new car into csv
	 */
	public boolean addNewCar();
	public boolean removeCar(String regNo);
	public void displayAvailableCars();
	public void displayReservedCars();
	public void displayAllCars();
	public ArrayList<String[]> getAllCars();
	public ArrayList<String[]> getReservedCars();
	public ArrayList<String[]> getAvailableCars();
}