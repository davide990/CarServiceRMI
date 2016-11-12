import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class Car extends UnicastRemoteObject implements Serializable, ICar {

	private static final long serialVersionUID = 5549581594949403841L;
	private String model;

    private String comment;
    boolean isSold, isRented;
    private int year;
	private long ID;

	protected Car() throws RemoteException {
		super();
	}

	@Override
	public String getComment()
	{
		return comment;
	}
	
	@Override
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	
	@Override
	public boolean getIsSold()
	{
		return isSold;
	}
	
	@Override
	public void setIsSold(boolean value)
	{
		isSold = value;
	}
	
	@Override
	public boolean getIsRented()
	{
		return isRented;
	}
	
	@Override
	public void setIsRented(boolean value)
	{
		isRented = value;
	}
	
	@Override
	public int getYear()
	{
		return year;
	}
	
	@Override
	public void setYear(int year)
	{
		this.year = year;
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
	
	public String getToString()
	{
		return "Car: "+ model;
	}

}
