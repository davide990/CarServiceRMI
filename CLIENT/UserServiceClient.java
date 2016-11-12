
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Davide Andrea Guastella <davide.guastella90@gmail.com>
 */
public class UserServiceClient {

    public static void main(String[] args) {

        IUserService c = null;
        try {
            String codebase = "file:/home/davide/RMI_PROJECT/CLIENT";
            System.setProperty("java.rmi.server.codebase", codebase);

            System.setProperty("java.security.policy", "sec.policy");
            System.setSecurityManager(new RMISecurityManager());
            c = (IUserService) Naming.lookup("rmi://localhost:1099/UserService");
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            User newUser = new User();
            newUser.setUid(0);
            newUser.setName("davide");
            c.addUser(newUser);
            System.out.println(c.findUser(0).getToString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
