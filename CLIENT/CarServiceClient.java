import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;

public class CarServiceClient {
	public static void main(String[] args) {

		ICarService c = null;
		try {
			String codebase = "file:/home/davide/RMI_PROJECT/CLIENT";
			System.setProperty("java.rmi.server.codebase", codebase);

			System.setProperty("java.security.policy", "sec.policy");
			System.setSecurityManager(new RMISecurityManager());
			c = (ICarService) Naming.lookup("rmi://localhost:1099/CarService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Car newCar = new Car();
			newCar.setId(0);
			newCar.setModel("fiat 500");
			c.addCar(newCar);
			System.out.println(c.findByModel("fiat 500").getToString());			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

