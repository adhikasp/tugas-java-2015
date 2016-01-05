package parkirin.model;

public class ParkSpot
{
	private int number;
	private String type = "Car";
	private Vehicle vehicle;
	private int startTimestamp;
	private static final tariffPerHour = 6000;

	public ParkSpot(int number)
	{
		this(number, null, null, 0);
	}

	public ParkSpot(int number, String owner, String plate, int startTimestamp)
	{
		this.number = number;
		if (owner != null) {
			this.vehicle = new Vehicle(owner, plate);
			this.startTimestamp = startTimestamp;
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
		this.startTimestamp = (int) (System.currentTimeMillis() / 1000L);
		this.vehicle = vehicle;
	}

	public int getStartTime()
	{
		return startTimestamp;
	}

	public int getBill()
	{
		int timeNow  = (int) (System.currentTimeMillis() / 1000L);
		int timeDiff = timeNow - startTimestamp;
		int bill = timeDiff * tariffPerHour / 3600;
		return bill;
	}
}