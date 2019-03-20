package client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import carservice.CarService;

public class GUIBuilder {

	private JFrame frame;
	JTable j;
	public GUIBuilder() {
        frame = new JFrame("Client");
	}
	public void buildInterface(CarService carService) {
        frame.setSize(1024, 720);
        frame.getContentPane().setLayout(new FlowLayout());
 
        final JButton btnReserve = new JButton("Reserve a Car");
        btnReserve.setVerticalTextPosition(AbstractButton.CENTER);
        btnReserve.setHorizontalTextPosition(AbstractButton.CENTER);
        
        btnReserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

            }
        });
        carService.displayAvailableCars();
    	String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE" }, 
                { "Anand Jha", "6014", "IT" } 
            };
        String[] columnNames = { "Name", "Roll Number", "Department" }; 
        j = new JTable(data, columnNames); 
        j.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(j);
        frame.getContentPane().add(sp);    	
        frame.getContentPane().add(btnReserve);
        frame.setVisible(true);
    }
}