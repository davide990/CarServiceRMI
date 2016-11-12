import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface ICar extends Remote {

	long getId() throws RemoteException;

	void setId(long id) throws RemoteException;

	String getModel() throws RemoteException;

	void setModel(String model) throws RemoteException;

	Date getPurchaseDate() throws RemoteException;

	void setPurchaseDate(Date date) throws RemoteException;
	
	public String getToString() throws RemoteException;
}
