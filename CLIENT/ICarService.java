import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICarService extends Remote {

	void addCar(ICar l) throws RemoteException;

	void deleteCar(ICar l) throws RemoteException;

	void deleteCar(Long ID) throws RemoteException;
	
	void updateCar(ICar c) throws RemoteException;

	ICar findByModel(String model) throws RemoteException;
	
	int totalCars() throws RemoteException;
}
