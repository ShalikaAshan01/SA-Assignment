package client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.jws.soap.SOAPBinding;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import driverService.DriverService;
import driverService.DriverServiceImpl;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	ServiceReference serviceReference;

	static int j=0;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Driver Service...");
		serviceReference = bundleContext.getServiceReference(DriverService.class.getName());
		DriverService driverService = (DriverService) bundleContext.getService(serviceReference);

		int num = 0;
		Scanner sc = new Scanner(System.in);

		if(j==0) {
			System.out.println("Please re run the bundle");
		}
		String regNo = null;
		
		while (j!=0) {
			do {
				System.out.println("--------------------------------");
				System.out.println("Main Menu");
				System.out.println("1.Add a Driver");
				System.out.println("2.Reserved a Driver");
				System.out.println("3.Remove Driver from Reserved List");
				System.out.println("4.Remove a Driver from System");
				System.out.println("99.Exit");
				System.out.println("--------------------------------");
				System.out.print("Please select a Number: ");
				num = sc.nextInt();
			} while (num != 1 && num != 2 && num !=3 && num != 4 && num !=99);

			
			if(num == 99)
				break;
			
			
			switch (num) {
			case 1:
				driverService.addNewDriver();
				break;
			case 2:
				System.out.println();
				driverService.displayAvailableDrivers();
				System.out.print("Please Enter Registration Number: ");
				regNo = sc.next();
				driverService.reserveDriver(regNo);
				break;
			case 3:
				System.out.println();
				driverService.displayReservedDrivers();
				System.out.print("Please Enter Registration Number: ");
				regNo = sc.next();
				driverService.addAvailableDriver(regNo);
				break;
			default:
				System.out.println();
				driverService.displayAvailableDrivers();
				System.out.print("Please Enter Registration Number: ");
				regNo = sc.next();
				driverService.removeDriver(regNo);
				break;
			}
			
		}
		
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop client");
		j++;//for fixing console input error
		bundleContext.ungetService(serviceReference);
	}

}
