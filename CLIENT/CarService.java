import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

@SuppressWarnings("serial")
public class CarService extends UnicastRemoteObject implements ICarService {

	private HashMap<Long, ICar> cars;

	public CarService() throws RemoteException {
		cars = new HashMap<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see carsInterface#ajouteCar(Car)
	 */
	@Override
	public void ajouteCar(ICar l) {
		try {
			cars.put(l.getId(), l);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see carsInterface#supprimeCar(Car)
	 */
	@Override
	public void supprimeCar(ICar l) {
		try {
			cars.remove(cars.get(l.getId()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see carsInterface#supprimeCar(java.lang.Long)
	 */
	@Override
	public void supprimeCar(Long ID) {
		cars.remove(ID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see carsInterface#rechercheParAuteur(java.lang.String)
	 */
	@Override
	public ICar rechercheParModel(String model) {
		for (ICar car : cars.values()) {
			try {
				if (car.getModel().equals(model))
					return car;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}


}
