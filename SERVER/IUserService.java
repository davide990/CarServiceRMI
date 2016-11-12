
import java.rmi.Remote;
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
public interface IUserService extends Remote {

    void addUser(IUser user) throws RemoteException;

    void addUser(long uid, long pin, String name, String surname, String email, char profession, float balance, String currency) throws RemoteException;

    void delUser(long id) throws RemoteException;

    IUser findUser(long id) throws RemoteException;

    int totalUser() throws RemoteException;

    void updateUser(long id, User u) throws RemoteException;
}
