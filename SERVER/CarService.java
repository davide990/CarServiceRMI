import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class CarService extends UnicastRemoteObject implements ICarService {

	private HashMap<Long, ICar> cars;

	private final static Logger logger = Logger.getLogger(CarService.class.getName());

	private int totalCars;

	public CarService() throws RemoteException {
		cars = new HashMap<>();
		totalCars = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see carsInterface#addCar(Car)
	 */
	@Override
	public void addCar(ICar l) {
		try {
			cars.put(l.getId(), l);
			totalCars++;
			logger.log(Level.INFO, "Car " + l.getModel() + " added");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see carsInterface#deleteCar(Car)
	 */
	@Override
	public void deleteCar(ICar l) {
		try {
			cars.remove(cars.get(l.getId()));
			totalCars--;
			logger.log(Level.INFO, "Car " + l.getModel() + " removed");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see carsInterface#deleteCar(java.lang.Long)
	 */
	@Override
	public void deleteCar(Long ID) {
		cars.remove(ID);
		totalCars--;
		logger.log(Level.INFO, "Car with ID " + ID + " removed");
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see carsInterface#updateCar(Car)
	 */
	@Override
	public void updateCar(ICar c)
	{
		deleteCar(c);
		addCar(c);	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see carsInterface#findByModel(java.lang.String)
	 */
	@Override
	public ICar findByModel(String model) {
		for (ICar car : cars.values()) {
			try {
				if (car.getModel().equals(model))
				{
					logger.log(Level.INFO, "Car " + model + " found");
					return car;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see carsInterface#totalCars()
	 */
	public int totalCars()
	{
		return totalCars;
	}


}
