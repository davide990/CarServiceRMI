


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class CarService extends UnicastRemoteObject implements ICarService {

    private final HashMap<Long, ICar> cars;

    private final static Logger logger = Logger.getLogger(CarService.class.getName());

    private int totalCars;

    public CarService() throws RemoteException {
        cars = new HashMap<>();
        totalCars = 0;
    }

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

    @Override
    public void deleteCar(Long ID) {
        cars.remove(ID);
        totalCars--;
        logger.log(Level.INFO, "Car with ID " + ID + " removed");
    }

    @Override
    public void updateCar(ICar c) {
        deleteCar(c);
        addCar(c);
    }

    @Override
    public ICar findByModel(String model) {
        for (ICar car : cars.values()) {
            try {
                if (car.getModel().equals(model)) {
                    logger.log(Level.INFO, "Car " + model + " found");
                    return car;
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<ICar> getAllCars() {
        return new ArrayList<>(cars.values());
    }

    @Override
    public int totalCars() {
        return totalCars;
    }

    @Override
    public List<ICar> getCarsOnSale() throws RemoteException {
        List<ICar> cc = new ArrayList<>();
        for (ICar car : cars.values()) {
            if (getDiffYears(car.getYear()) > 2/* && NUMBER OF PREVIOUS RENTAL > 1 */) {
                cc.add(car);
            }
        }
        return cc;
    }

    private static int getDiffYears(int purchaseYear) {

        Calendar a = Calendar.getInstance();
        a.set(purchaseYear, 1, 1, 0, 0);
        //Calendar a = //getCalendar(first);
        Calendar b = getCalendar(new Date());
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.DAY_OF_YEAR) > b.get(Calendar.DAY_OF_YEAR)) {
            diff--;
        }
        return diff;
    }

    private static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTime(date);
        return cal;
    }

}
