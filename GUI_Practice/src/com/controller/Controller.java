package com.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import com.model.Gas_Station;

public class Controller {
	
	
	private ObjectOutputStream oos;
	
	public Controller() {
		
		
		oos=null;
		
		
		
	}
	
	



/*
 * Methods
 * */
	public void cal_Price(Gas_Station obj){
		
		if (obj.getType()=="87(E10)") {
			
			double price = obj.getAmount() * 113.25;
			obj.setPrice(price);
		}
		if (obj.getType()=="90(E10)") {
			
			double price = obj.getAmount() * 119.40;
			obj.setPrice(price);
		}
		if (obj.getType()=="USLD") {
			
			double price = obj.getAmount() * 123.87;
			obj.setPrice(price);
		}
		
		
		
	}
	
	public void save(Gas_Station obj) {
		
		cal_Price(obj);
		JOptionPane.showMessageDialog(null, obj.getName()+" should pay $"+ obj.getPrice(), "Message", JOptionPane.INFORMATION_MESSAGE);
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream("Pete_Gas_Station.txt"));
			oos.writeObject(obj.getName()+" should pay $"+ obj.getPrice());
		} catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "Empty Object", "Message", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	public void setObj(Gas_Station gas) {
		// TODO Auto-generated method stub
		
	}

}
