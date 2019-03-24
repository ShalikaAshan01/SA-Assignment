package carservice;

import java.util.Scanner;

import fileoperator.CSVFile;

public class CarServiceImpl implements CarService {

	private CSVFile csvFile;
	
	public CarServiceImpl(CSVFile csv) {
		csvFile = csv;
	}
	
	
	@Override
	public boolean reserveCar(String regNo) {
		if(csvFile.findline(regNo, Car.getAvailablecarscsv()) != null) {
			String details = csvFile.modifyCSV(regNo, Car.getAvailablecarscsv());
			csvFile.writeCSV(details, Car.getReservedcarcsv());
			System.out.println("Reserved a car");
			return true;
		}else {
			System.out.println("Not Available");
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
			System.out.println("Not Available");
			return false;
		}
	}

	@Override
	public boolean addNewCar(String model, String brand, String regNo, String type, String priced) {
		System.out.println("Adding a new car....");
		
		//String model,regNo,brand,type;
		double price = Double.parseDouble(priced);
//		
//		System.out.println("----------Please Enter Car Details--------------");
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("Car Brand: ");
//		brand = sc.next();
//
//		System.out.print("Car Model: ");
//		model = sc.next();
//
//		System.out.print("Registaration Number: ");
//		regNo = sc.next();
//		
//		System.out.print("Petrol/Diesle: ");
//		type = sc.next();
//
//		System.out.print("LKR per km: ");
//		price = sc.nextDouble();

		Car car = new Car(model, brand, regNo, type, price);
		
		csvFile.writeCSV(car.toString(), car.getCarlistcsv());
		csvFile.writeCSV(car.toString(), car.getAvailablecarscsv());
		System.out.println("new car added");
		return true;
	}


	@Override
	public boolean removeCar() {
		System.out.println("Remove new Car");
		return true;
	}


	@Override
	public void displayAvailableCars() {
		System.out.println("---Displaying Available Cars");
		csvFile.readCSV(Car.getCarlistcsv());
	}


	@Override
	public void displayReservedCars() {
		// TODO Auto-generated method stub
		System.out.println("---Displaying Reserved Cars");
		
	}

}
