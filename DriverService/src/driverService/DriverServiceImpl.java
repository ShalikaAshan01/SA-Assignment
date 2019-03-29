package driverService;

import java.util.ArrayList;
import java.util.Scanner;

import fileoperator.CSVFile;

public class DriverServiceImpl implements DriverService {

	private CSVFile csvFile;
	
	public DriverServiceImpl(CSVFile csv) {
		csvFile = csv;
		csvFile.createFirestCSV(Driver.getAvailabledriverscsv(), "FirstName,LastName,NIC,PhoneNumber,Age");
		csvFile.createFirestCSV(Driver.getDriverlistcsv(), "FirstName,LastName,NIC,PhoneNumber,Age");
		csvFile.createFirestCSV(Driver.getReserveddrivercsv(), "FirstName,LastName,NIC,PhoneNumber,Age");
	}
	
	
	@Override
	public boolean reserveDriver(String regNo) {
		if(csvFile.findline(regNo, Driver.getAvailabledriverscsv()) != null) {
			String details = csvFile.modifyCSV(regNo, Driver.getAvailabledriverscsv());
			csvFile.writeCSV(details, Driver.getReserveddrivercsv());
			System.out.println("Reserved a driver");
			return true;
		}else {
			System.out.println("Not Available");
			return false;
		}
	}

	@Override
	public boolean addAvailableDriver(String regNo) {
		if(csvFile.findline(regNo, Driver.getReserveddrivercsv())!= null) {
			String details = csvFile.modifyCSV(regNo, Driver.getReserveddrivercsv());
			csvFile.writeCSV(details, Driver.getAvailabledriverscsv());
			System.out.println("Add available driver");
			return true;
		}else {
			System.out.println("Not Available");
			return false;
		}
	}

	@Override
	public boolean addNewDriver() {
		System.out.println("Adding a new driver....");
		
		String firstName,lastName,nic,phoneNumber;
		int age;
		
		System.out.println("----------Please Enter Driver Details--------------");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Driver First Name: ");
		firstName = sc.next();

		System.out.print("Driver Last Name: ");
		lastName = sc.next();

		System.out.print("NIC Number: ");
		nic = sc.next();
		
		System.out.print("Phone Number: ");
		phoneNumber = sc.next();

		System.out.print("Driver Age: ");
		age = sc.nextInt();

		Driver driver = new Driver(firstName, lastName, nic, phoneNumber, age);
		
		csvFile.writeCSV(driver.toString(), driver.getDriverlistcsv());
		csvFile.writeCSV(driver.toString(), driver.getAvailabledriverscsv());
		System.out.println("New Driver Added");
		return true;
	}


	@Override
	public boolean removeDriver(String regNo) {
		csvFile.modifyCSV(regNo, Driver.getAvailabledriverscsv());
		csvFile.modifyCSV(regNo, Driver.getDriverlistcsv());
		csvFile.modifyCSV(regNo, Driver.getReserveddrivercsv());
		System.out.println("Remove Driver");
		return true;
	}


	@Override
	public void displayAvailableDrivers() {
		ArrayList<String[]> driverlist = getAvailableDrivers();
		

		System.out.println("---Displaying Available Drivers---");
		
		for(int i=0; i<driverlist.size(); i++) {
			System.out.println("First Name: " + driverlist.get(i)[0] + ", Last Name: " + driverlist.get(i)[1]
					+ ", NIC Number: " + driverlist.get(i)[2] + ", Phone Number: " + driverlist.get(i)[3] + ", Age: " + driverlist.get(i)[4]);
		}
		
		
	}

	@Override
	public void displayReservedDrivers() {
		// TODO Auto-generated method stub
		System.out.println("---Displaying Reserved Drivers");
		
	}
	
	@Override
	public void displayAllDrivers() {
		ArrayList<String[]> driverlist = getAllDrivers();
		

		System.out.println("---Displaying Available Drivers---");
		
		for(int i=0; i<driverlist.size(); i++) {
			System.out.println("First Name: " + driverlist.get(i)[0] + ", Last Name: " + driverlist.get(i)[1]
					+ ", NIC Number: " + driverlist.get(i)[2] + ", Phone Number: " + driverlist.get(i)[3] + ", Age: " + driverlist.get(i)[4]);
		}

	}
	
	@Override
	public ArrayList<String[]> getAllDrivers() {
		return csvFile.readCSV(Driver.getDriverlistcsv());
	}


	@Override
	public ArrayList<String[]> getReservedDrivers() {
		// TODO Auto-generated method stub
		return csvFile.readCSV(Driver.getReserveddrivercsv());		
	}

	@Override
	public ArrayList<String[]> getAvailableDrivers() {
		return csvFile.readCSV(Driver.getAvailabledriverscsv());
	}

}
