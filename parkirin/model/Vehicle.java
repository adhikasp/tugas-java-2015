package parkirin.model;

public class Vehicle
{
	private String licensePlate;
	private String ownerName;
	private String type = "Car";

	public Vehicle(String ownerName, String licensePlate)
	{
		this.ownerName    = ownerName;
		this.licensePlate = licensePlate;
	}

	public String getLicense()
	{
		return licensePlate;
	}

	public String getOwner()
	{
		return ownerName;
	}
}