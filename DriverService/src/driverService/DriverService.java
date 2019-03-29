package driverService;

import java.util.ArrayList;
import java.util.HashMap;

public interface DriverService {
	public boolean reserveDriver(String regNo);
	public boolean addAvailableDriver(String regNo);
	/*
	 * add new car into csv
	 */
	public boolean addNewDriver();
	public boolean removeDriver(String regNo);
	public void displayAvailableDrivers();
	public void displayReservedDrivers();
	public void displayAllDrivers();
	public ArrayList<String[]> getAllDrivers();
	public ArrayList<String[]> getReservedDrivers();
	public ArrayList<String[]> getAvailableDrivers();
}