
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Varun
 */
public class User extends UnicastRemoteObject implements Serializable, IUser {

    private long uid;
    private long pin;
    private String name;
    private String surname;
    private String email;
    private char profession;
    private float balance;
    private String currency;

    public User() throws RemoteException {
    }

    public User(long uid, long pin, String name, String surname, String email, char profession, float balance, String currency) throws RemoteException {
        this.uid = uid;
        this.pin = pin;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.profession = profession;
        this.balance = balance;
        this.currency = currency;
    }

    @Override
    public long getUid() {
        return uid;
    }

    @Override
    public void setUid(long uid) {
        this.uid = uid;
    }

    @Override
    public long getPin() {
        return pin;
    }

    @Override
    public void setPin(long pin) {
        this.pin = pin;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public char getProfession() {
        return profession;
    }

    @Override
    public void setProfession(char profession) {
        this.profession = profession;
    }

    @Override
    public float getBalance() {
        return balance;
    }

    @Override
    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String getToString() {
        return "User {" + "name=" + name + ", surname=" + surname + ", email=" + email + ", profession=" + profession + "}";
    }
}
