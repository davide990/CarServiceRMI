

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService extends UnicastRemoteObject implements Serializable, IUserService {

    private final HashMap<Long, IUser> mlvUsers;
    private int totalUsers;

    private final static Logger logger = Logger.getLogger(UserService.class.getName());

    public UserService() throws RemoteException {
        mlvUsers = new HashMap<>();
        totalUsers = 0;
    }

    @Override
    public void addUser(long uid, long pin, String name, String surname, String email, char profession, float balance, String currency) {
        User u = null;
        try {
            u = new User(uid, pin, name, surname, email, profession, balance, currency);
        } catch (RemoteException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        mlvUsers.put(uid, u);
        totalUsers++;
        logger.log(Level.INFO, "User " + u.getToString() + " added");
    }

    @Override
    public void updateUser(long id, User u) {
        mlvUsers.remove(u.getUid());
        mlvUsers.put(id, u);
        logger.log(Level.INFO, "User " + u.getToString() + " updated");
    }

    @Override
    public int totalUser() {
        return totalUsers;
    }

    @Override
    public void delUser(long id) {
        totalUsers--;
        try {
            logger.log(Level.INFO, "User " + findUser(id).getToString() + " removed");
        } catch (RemoteException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        mlvUsers.remove(id);
    }

    @Override
    public IUser findUser(long id) {
        return mlvUsers.get(id);
    }

    @Override
    public void addUser(IUser user) throws RemoteException {
        mlvUsers.put(user.getUid(), user);
        logger.log(Level.INFO, "User " + user.getToString() + " added");
    }

    @Override
    public boolean authenticateAdministrator(long pin) {
        for (IUser u : mlvUsers.values()) {
            try {
                if (u.getPin() == pin) {
                    return true;
                }
            } catch (RemoteException ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean authenticateUser(long uid, long pin) {
        for (IUser u : mlvUsers.values()) {
            try {
                if (u.getUid() == uid && u.getPin() == pin) {
                    return true;
                }
            } catch (RemoteException ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
