


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
public interface IUser extends Remote {

    long getUid() throws RemoteException;

    void setUid(long uid) throws RemoteException;

    long getPin() throws RemoteException;

    void setPin(long pin) throws RemoteException;

    String getName() throws RemoteException;

    void setName(String name) throws RemoteException;

    String getSurname() throws RemoteException;

    void setSurname(String surname) throws RemoteException;

    String getEmail() throws RemoteException;

    void setEmail(String email) throws RemoteException;

    char getProfession() throws RemoteException;

    void setProfession(char profession) throws RemoteException;

    float getBalance() throws RemoteException;

    void setBalance(float balance) throws RemoteException;

    String getCurrency() throws RemoteException;

    void setCurrency(String currency) throws RemoteException;

    String getToString() throws RemoteException;
}
