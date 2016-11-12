
import java.rmi.Naming;
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
public class UserServiceServer {

    public static void main(String[] args) {
        /*
		IMPORTANTE: pour lancer le serveur, il doit executer avant ce:
		$ /usr/java/default/bin/rmiregistry &
		dans le meme repertoire ou se trouvent les classes java concernantes le serveur.
		Aprés, il est possible de lancer le serveur
         */
        UserService c = null;
        try {
            c = new UserService();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            Naming.bind("rmi://127.0.0.1:1099/UserService", c);
            System.out.println("Launched service on localhost...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
