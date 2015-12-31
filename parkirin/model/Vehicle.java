package parkirin.model;

public class Vehicle
{
	private String licensePlate;
	private String ownerName;
	private String type = "Car";

	Vehicle(String ownerName, String licensePlate)
	{
		this.ownerName    = ownerName;
		this.licensePlate = licensePlate;
	}

	public String getLicensePlate()
	{
		return licensePlate;
	}

	public String getOwner()
	{
		return ownerName;
	}
}