package com.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.controller.Controller;
import com.model.Gas_Station;

public class View extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btn_Save,btn_Clear;
	String items[] = {"","90(E10)","87(E10)","USLD"};
	JComboBox cmbx = new JComboBox (items);
	JTextField txt_Name,txt_Amount;
	Controller cntrl  = new Controller();
	Gas_Station gas = new Gas_Station();
	
	
	public View() {
		
		intiView();
		configListeners();
	}

	public void intiView() {
		
		
		this.setTitle("Pete's Gas Station");
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(300, 300);
		
		JPanel grid = new JPanel(new GridLayout(4,1));
		grid.add(new JLabel("Driver name: "));
		grid.add(txt_Name=new JTextField(""));
		grid.add(new JLabel("Gas Amount(Li): "));
		grid.add(txt_Amount=new JTextField(""));
		grid.add(new JLabel("Gas Type: "));
		grid.add(cmbx);
		grid.add(btn_Clear=new JButton("Clear"));
		grid.add(btn_Save=new JButton("Save"));
		this.add(grid);
		
	}
	
	public void configListeners() {
		
		btn_Clear.addActionListener(this);
		btn_Save.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		
		if (evt.getSource()==btn_Clear) {
			txt_Name.setText("");
			txt_Amount.setText("");
			cmbx.setSelectedIndex(0);
			
		}
		
		if (evt.getSource()==btn_Save) {
			try {
				
			String name = txt_Name.getText();
			gas.setName(name);
			String type = (String) cmbx.getSelectedItem();
			gas.setType(type);
			double amount = Double.parseDouble(txt_Amount.getText());
			gas.setAmount(amount);
			double price = 0.0;
			gas.setPrice(price);
			
			}catch(NullPointerException | NumberFormatException e){
				
				JOptionPane.showMessageDialog(null, "Empty Object", "Message", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			cntrl.setObj(gas);
			cntrl.save(gas);
			
			
		}
		
		
	}

	
	
	
	
	
	
	
	
	
}
