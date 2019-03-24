package carservice;

public class Car {
	/*
	 * car model,car brand, registration number of the car,price per km and also type(petrol,diesel)
	 */
	private final String model;
	private final String brand;
	private final String regNo;
	private final String type;
	private double price;
	private final static String CARLISTCSV= "D:/list.csv"; 
	private final static String AVAILABLECARSCSV= "D:/available.csv"; 
	private final static String RESERVEDCARCSV = "D:/reserved.csv"; 

	
	public Car(String model, String brand, String regNo, String type, double price) {
		this.model = model;
		this.brand = brand;
		this.regNo = regNo;
		this.type = type;
		this.price = price;
	}

	/*
	 * setters
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/*
	 * getters
	 */
	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}

	public String getRegNo() {
		return regNo;
	}

	public String getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	public static String getCarlistcsv() {
		return CARLISTCSV;
	}

	public static String getAvailablecarscsv() {
		return AVAILABLECARSCSV;
	}

	public static String getReservedcarcsv() {
		return RESERVEDCARCSV;
	}

	@Override
	public String toString() {
		return regNo + "," + brand + "," + model + "," + type + "," + price;
	}
}
