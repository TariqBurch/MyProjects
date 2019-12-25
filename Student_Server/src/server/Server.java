package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

import model.Student;

public class Server implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServerSocket servSocket;
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public void initServer() {

		try {
			servSocket = new ServerSocket(8001, 1);

		} catch (IOException e) {

			System.out.println("Error: " + e.getMessage());
		}
	}

	public void waitForRequests() {
		if (servSocket == null) {// safe coding to prevent errors
			System.out.println("Server not intialized");
			return;
		}

		try {

			while (true) {
				socket = servSocket.accept();
				getStreams();
				String action = "";
				try {
					do {

						try {
							action = (String) ois.readObject();
							if (action.equals("get_Special")) {
								try {
									oos.writeObject("Buy One Get One Free!");

								} catch (NullPointerException e) {
									e.printStackTrace();
								}
							}

						} catch (ClassNotFoundException | ClassCastException e) {

							e.printStackTrace();
						}

					} while (!action.equals("EXIT"));
				} catch (EOFException e) {
					// ignore- unable to communicate
				}
			}
		} catch (IOException e) {

		}
	}

	public void getStreams() {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

		} catch (IOException e) {

			System.out.println("Error: " + e.getMessage());
		}
	}

	public void closeConnection() {
		try {

			oos.writeObject("EXIT");
			ois.close();
			oos.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	

}
