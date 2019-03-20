package servicesubscriber;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import servicepublish.ServicePublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	private JFrame frame;
//	private Message message;

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
//		System.out.println("Enter:  ");
//		String val = sc.nextLine();
//		System.out.println(val);
		buildInterface();
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Good Bye...!");
		
		bundleContext.ungetService(serviceReference);
		destroyInterface();
	}
	
    private void buildInterface() {
        frame = new JFrame("Hello");
        frame.setSize(200, 80);
        frame.getContentPane().setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
 
        final JButton button = new JButton("Send");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
//                message.send(textField.getText());
            }
        });
        frame.getContentPane().add(textField, BorderLayout.NORTH);
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

        private void destroyInterface() {
            frame.setVisible(false);
            frame.dispose();
        }
}
