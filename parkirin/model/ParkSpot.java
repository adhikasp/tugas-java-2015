package parkirin.model;

public class ParkSpot
{
	private int number;
	private String type = "Car";
	private Vehicle vehicle;

	public ParkSpot(int number)
	{
		this(number, null, null);
	}

	public ParkSpot(int number, String owner, String plate)
	{
		this.number = number;
		if (owner != null) {
			this.vehicle = new Vehicle(owner, plate);
		}
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