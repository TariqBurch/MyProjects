package server;

public class Server_Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Server server = new Server();
		server.initServer();
		System.out.println("Intializing server....");
		server.waitForRequests();
		System.out.println("Server is connected and waiting....");
		
		
	}
}
