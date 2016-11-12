

import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            Car c2 = new Car();
            Car c3 = new Car();
            Car c4 = new Car();

            c2.setId(0);
            c2.setModel("fiat 500");
            c2.setYear(2005);

            c3.setId(1);
            c3.setModel("audi a5");
            c3.setYear(2016);

            c4.setId(3);
            c4.setModel("Toyota bog");
            c4.setYear(2009);

            c.addCar(newCar);
            c.addCar(c2);
            c.addCar(c3);
            c.addCar(c4);
            System.out.println(c.findByModel("fiat 500").getToString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//
//        try {
//            List<ICar> onSale = c.getCarsOnSale();
//            for (ICar car : onSale) {
//                System.out.println("On sale: " + car.getToString());
//            }
//        } catch (RemoteException ex) {
//            Logger.getLogger(CarServiceClient.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
}
