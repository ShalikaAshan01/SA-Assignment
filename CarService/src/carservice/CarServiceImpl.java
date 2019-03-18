package carservice;

import java.util.Scanner;

import fileoperator.CSVFile;

public class CarServiceImpl implements CarService {

	private CSVFile csvFile;
	
	public CarServiceImpl() {
		csvFile = new CSVFile();
	}
	
	@Override
	public boolean reserveCar(String regNo) {
		System.out.println("Reserved a car");
		csvFile.readCSV();
		return true;
	}

	@Override
	public boolean addAvailableCar(String regNo) {
		System.out.println("Add available car");
		return true;
	}

	@Override
	public boolean addNewCar() {
		System.out.println("Adding a new car");
		
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
		System.out.println("new car added");
		return true;
	}


	@Override
	public boolean removeCar() {
		System.out.println("Remove new Car");
		return true;
	}

}
