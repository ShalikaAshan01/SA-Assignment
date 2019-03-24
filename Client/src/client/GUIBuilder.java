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
	
	JTextField modelText = new JTextField(40);
    JTextField regNoText = new JTextField(40);
    JTextField brandText = new JTextField(40);
    JTextField typeText = new JTextField(40);
    JTextField priceText = new JTextField(40);
    final JButton btnAdd = new JButton("Reserve a Car");
	
	
	public GUIBuilder() {
        frame = new JFrame("Add New Car");
	}
	public void buildInterface(CarService carService) {
        frame.setSize(500, 500);
        frame.getContentPane().setLayout(new FlowLayout());
        
        
        modelText.setText("Model");
        regNoText.setText("Reg");
        brandText.setText("Brand");
        typeText.setText("Type");
        priceText.setText("Price (Enter double)");
        
        //btnReserve.setVerticalTextPosition(AbstractButton.CENTER);
        //btnReserve.setHorizontalTextPosition(AbstractButton.CENTER);
        
        frame.getContentPane().add(modelText);
        frame.getContentPane().add(brandText);
        frame.getContentPane().add(regNoText);
        frame.getContentPane().add(typeText);
        frame.getContentPane().add(priceText);
        frame.getContentPane().add(btnAdd);
        frame.setVisible(true);
        
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	String model = modelText.getText();
            	String brand = brandText.getText();
            	String regNo = regNoText.getText();
            	String price = priceText.getText();
            	String type = typeText.getText();
            	
            	carService.addNewCar(model, regNo, brand, type, price);
            	
            	modelText.setText("Model");
                regNoText.setText("Reg");
                brandText.setText("Brand");
                typeText.setText("Type");
                priceText.setText("Price");
            }
        });
//        carService.displayAvailableCars();
//    	String[][] data = {
//                { "Kundan Kumar Jha", "4031", "CSE" }, 
//                { "Anand Jha", "6014", "IT" } 
//            };
//        String[] columnNames = { "Name", "Roll Number", "Department" }; 
//        j = new JTable(data, columnNames); 
//        j.setBounds(30, 40, 200, 300);
//        JScrollPane sp = new JScrollPane(j);
          
//        frame.getContentPane().add(sp);    	
//        frame.getContentPane().add(btnReserve);
//        frame.setVisible(true);
		
		
		
		
		
		
    }
}