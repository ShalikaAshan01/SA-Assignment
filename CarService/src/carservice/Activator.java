package carservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import fileoperator.CSVFile;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	ServiceReference serviceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Car Service...");
		CarService carService = new CarServiceImpl();
		
//		serviceReference = bundleContext.getServiceReference(ServicePublish.class.getName());
//		ServicePublish servicePublish = (ServicePublish) bundleContext.getService(serviceReference);
//		System.out.println(servicePublish.publishService());
		
		carService.addNewCar();
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Car Service...");
	}

}
