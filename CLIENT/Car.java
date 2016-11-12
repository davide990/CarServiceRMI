import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class Car extends UnicastRemoteObject implements Serializable, ICar {

	private static final long serialVersionUID = 5549581594949403841L;
	private String model;
	private Date purchaseDate;
	private long ID;

	protected Car() throws RemoteException {
		super();
	}

	@Override
	public long getId()
	{
		return ID;
	}

	@Override
	public void setId(long id)
	{
		ID = id;
	}

	@Override
	public String getModel()
	{
		return model;
	}

	@Override
	public void setModel(String model)
	{
		this.model = model;
	}

	@Override
	public Date getPurchaseDate()
	{
		return purchaseDate;
	}

	@Override
	public void setPurchaseDate(Date date)
	{
		purchaseDate = date;
	}
	
	public String getToString()
	{
		return "Car: "+ model;
	}

}
