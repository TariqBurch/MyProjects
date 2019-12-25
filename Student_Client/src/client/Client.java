package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import model.Student;

public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Socket connection;
	
	
	public void initConnection(){
		
		try {
			connection = new Socket(InetAddress.getLocalHost(), 8800 );
			getStreams();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getStreams() {
		
		try {
			
			oos=new ObjectOutputStream(connection.getOutputStream());
			ois=new ObjectInputStream(connection.getInputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void closeConnection() {
		
		try {
			
			ois.close();
			oos.close();
			connection.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendAction(String action) {
		
		try {
			oos.writeObject(action);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendStudent(Student student) {
		
		try {
			
			oos.writeObject(student);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
