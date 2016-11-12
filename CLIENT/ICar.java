
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface ICar extends Remote {

    long getId() throws RemoteException;

    void setId(long id) throws RemoteException;

    String getModel() throws RemoteException;

    void setModel(String model) throws RemoteException;

    String getComment() throws RemoteException;

    void setComment(String comment) throws RemoteException;

    boolean getIsSold() throws RemoteException;

    void setIsSold(boolean value) throws RemoteException;

    boolean getIsRented() throws RemoteException;

    void setIsRented(boolean value) throws RemoteException;

    int getYear() throws RemoteException;

    void setYear(int year) throws RemoteException;

    String getToString() throws RemoteException;
}
