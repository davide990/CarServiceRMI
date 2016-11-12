import java.rmi.Naming;
import java.rmi.RemoteException;

public class CarServiceServer {

	public static void main(String[] args) {

		/*
		IMPORTANTE: pour lancer le serveur, il doit executer avant ce:
		$ /usr/java/default/bin/rmiregistry &
		dans le meme repertoire ou se trouvent les classes java concernantes le serveur.
		Aprés, il est possible de lancer le serveur
		*/
			CarService c = null;
			try {
				c = new CarService();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Naming.bind("rmi://127.0.0.1:1099/CarService", c);
				System.out.println("Launched service on localhost...");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	
	
}
