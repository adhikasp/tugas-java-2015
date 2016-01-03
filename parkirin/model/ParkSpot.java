package parkirin.model;

public class ParkSpot
{
	private int number;
	private String type = "Car";
	private Vehicle vehicle;

	public ParkSpot(int number)
	{
		this.number = number;
	}

	public int getLocation()
	{
		return this.number;
	}

	public boolean isEmpty()
	{
		return (this.vehicle == null);
	}

	public Vehicle getVehicle()
	{
		if (this.isEmpty()) {
			return null;
		}
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle)
	{
		this.vehicle = vehicle;
	}
}