package servicesubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import servicepublish.ServicePublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Service Subscriber Start");
		serviceReference = bundleContext.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish) bundleContext.getService(serviceReference);
		System.out.println(servicePublish.publishService());
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter:  ");
		String val = sc.nextLine();
		System.out.println(val);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Good Bye...!");
		bundleContext.ungetService(serviceReference);
	}

}
