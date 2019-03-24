package client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import carservice.CarService;
import carservice.CarServiceImpl;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	ServiceReference serviceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting client...");
		serviceReference = bundleContext.getServiceReference(CarService.class.getName());
		CarService carService = (CarService) bundleContext.getService(serviceReference);
		//carService.addNewCar();
		GUIBuilder gui = new GUIBuilder();
		gui.buildInterface(carService);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop client");
		bundleContext.ungetService(serviceReference);
	}

}
