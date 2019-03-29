package carservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import fileoperator.CSVFile;

public class CarServiceImpl implements CarService {

	private CSVFile csvFile;
	
	public CarServiceImpl(CSVFile csv) {
		csvFile = csv;
		csvFile.createFirestCSV(Car.getAvailablecarscsv(), "RegNo,Brand,Model,Type,price");
		csvFile.createFirestCSV(Car.getCarlistcsv(), "RegNo,Brand,Model,Type,price");
		csvFile.createFirestCSV(Car.getReservedcarcsv(), "RegNo,Brand,Model,Type,price");
	}
	
	
	@Override
	public boolean reserveCar(String regNo) {
		if(csvFile.findline(regNo, Car.getAvailablecarscsv()) != null) {
			String details = csvFile.modifyCSV(regNo, Car.getAvailablecarscsv());
			csvFile.writeCSV(details, Car.getReservedcarcsv());
			System.out.println("Reserved a car");
			return true;
		}else {
			System.out.println("This car is not available");
			return false;
		}
	}

	@Override
	public boolean addAvailableCar(String regNo) {
		if(csvFile.findline(regNo, Car.getReservedcarcsv())!= null) {
			String details = csvFile.modifyCSV(regNo, Car.getReservedcarcsv());
			csvFile.writeCSV(details, Car.getAvailablecarscsv());
			System.out.println("Add available car");
			return true;
		}else {
			System.out.println("This car is not in reserved list");
			return false;
		}
	}

	@Override
	public boolean addNewCar() {
		System.out.println("Adding a new car....");
		
		String model,regNo,brand,type;
		double price;
		
		System.out.println("----------Please Enter Car Details--------------");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Car Brand: ");
		brand = sc.next();

		System.out.print("Car Model: ");
		model = sc.next();

		System.out.print("Registaration Number: ");
		regNo = sc.next();
		
		System.out.print("Petrol/Diesle: ");
		type = sc.next();

		System.out.print("LKR per km: ");
		price = sc.nextDouble();

		Car car = new Car(model, brand, regNo, type, price);
		
		csvFile.writeCSV(car.toString(), car.getCarlistcsv());
		csvFile.writeCSV(car.toString(), car.getAvailablecarscsv());
		System.out.println("new car added");
		return true;
	}


	@Override
	public boolean removeCar(String regNo) {
		if(csvFile.findline(regNo, Car.getCarlistcsv()) != null) {
			csvFile.modifyCSV(regNo, Car.getAvailablecarscsv());
			csvFile.modifyCSV(regNo, Car.getCarlistcsv());
			csvFile.modifyCSV(regNo, Car.getReservedcarcsv());
			System.out.println("Remove Car");
			return true;
		}else {
			System.out.println("This car is not available");
			return false;
		}
	}


	@Override
	public ArrayList<String[]> getAllCars() {
		return csvFile.readCSV(Car.getCarlistcsv());
	}


	@Override
	public ArrayList<String[]> getReservedCars() {
		// TODO Auto-generated method stub
		return csvFile.readCSV(Car.getReservedcarcsv());		
	}

	@Override
	public ArrayList<String[]> getAvailableCars() {
		return csvFile.readCSV(Car.getAvailablecarscsv());
	}


	@Override
	public void displayAvailableCars() {
		ArrayList<String[]> carlist = getAvailableCars();
		

		System.out.println("---Displaying Available Cars---");
		
		for(int i=0; i<carlist.size(); i++) {
			System.out.println("Registration Number: " + carlist.get(i)[0] + ", Brand: " + carlist.get(i)[1]
					+ ", Model: " + carlist.get(i)[2] + ", Type: " + carlist.get(i)[3] + ", LKR per km: " + carlist.get(i)[4]);
		}
		
		
	}


	@Override
	public void displayReservedCars() {
		ArrayList<String[]> carlist = getReservedCars();
		

		System.out.println("---Displaying Available Cars---");
		
		for(int i=0; i<carlist.size(); i++) {
			System.out.println("Registration Number: " + carlist.get(i)[0] + ", Brand: " + carlist.get(i)[1]
					+ ", Model: " + carlist.get(i)[2] + ", Type: " + carlist.get(i)[3] + ", LKR per km: " + carlist.get(i)[4]);
		}
		
	}


	@Override
	public void displayAllCars() {
		ArrayList<String[]> carlist = getAllCars();
		

		System.out.println("---Displaying Available Cars---");
		
		for(int i=0; i<carlist.size(); i++) {
			System.out.println("Registration Number: " + carlist.get(i)[0] + ", Brand: " + carlist.get(i)[1]
					+ ", Model: " + carlist.get(i)[2] + ", Type: " + carlist.get(i)[3] + ", LKR per km: " + carlist.get(i)[4]);
		}

	}

}
