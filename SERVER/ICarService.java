import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICarService extends Remote {

	void ajouteCar(ICar l) throws RemoteException;

	void supprimeCar(ICar l) throws RemoteException;

	void supprimeCar(Long ID) throws RemoteException;

	ICar rechercheParModel(String model) throws RemoteException;
}
