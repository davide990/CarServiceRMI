/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davide Andrea Guastella <davide.guastella90@gmail.com>
 */
public class ClientController {

    private static final String CODEBASE = "file:/home/davide/NetBeansProjects/TestRMI0/src";
    private static ICarService carService = null;
    private static IUserService userService = null;
    private static boolean isConnected = false;
    private static IUser loggedUser;
    private static ICar selectedCar;

    public static ICar getSelectedCar() {
        return selectedCar;
    }

    public static void setSelectedCar(ICar selectedCar) {
        ClientController.selectedCar = selectedCar;
    }

    public static boolean isIsConnected() {
        return isConnected;
    }

    public static void setIsConnected(boolean isConnected) {
        ClientController.isConnected = isConnected;
    }

    public static IUser getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(IUser loggedUser) {
        ClientController.loggedUser = loggedUser;
    }

    public static boolean isConnected() {
        return isConnected;
    }

    public static ICarService getCarService() {
        return carService;
    }

    public static void setCarService(ICarService carService) {
        ClientController.carService = carService;
    }

    public static IUserService getUserService() {
        return userService;
    }

    public static void setUserService(IUserService userService) {
        ClientController.userService = userService;
    }

    public static void connectToServices() {
        connectToCarService();
        connectToUserService();

        addDefaultCars();
        addDefaultUsers();

        isConnected = true;
    }

    private static void connectToUserService() {

        try {
            System.setProperty("java.rmi.server.codebase", CODEBASE);

            System.setProperty("java.security.policy", "sec.policy");
            System.setSecurityManager(new RMISecurityManager());
            userService = (IUserService) Naming.lookup("rmi://localhost:1099/UserService");
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void connectToCarService() {
        try {
            System.setProperty("java.rmi.server.codebase", CODEBASE);

            System.setProperty("java.security.policy", "sec.policy");
            System.setSecurityManager(new RMISecurityManager());
            carService = (ICarService) Naming.lookup("rmi://localhost:1099/CarService");
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void addDefaultUsers() {

        try {
            User newUser = new User();
            newUser.setUid(0);
            newUser.setPin(1234);
            newUser.setName("davide");
            newUser.setProfession('S');

            userService.addUser(newUser);

        } catch (RemoteException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void addDefaultCars() {
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

            carService.addCar(newCar);
            carService.addCar(c2);
            carService.addCar(c3);
            carService.addCar(c4);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
