package parkirin.model;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ParkManager
{
	private ParkSpot[] parkingSpots;
	private int current = 0;
	private static final String dbName = "database-parkir.txt";

	public ParkManager(int parkSize)
	{
		if (new File(dbName).isFile()) {
			load();
		}
		else {
			parkingSpots = new ParkSpot[parkSize];
			for (int i = 0; i < parkSize; i++) {
				parkingSpots[i] = new ParkSpot(i+1);
			}
		}
	}

	public ParkSpot[] getAll()
	{
		return parkingSpots;
	}

	public int getCurrentIndex()
	{
		return current;
	}

	public ParkSpot getCurrent()
	{
		return parkingSpots[current];
	}

	public void next()
	{
		if (current + 1 < parkingSpots.length) {
			current++;
		}
	}

	public void prev()
	{
		if (current - 1 >= 0) {
			current--;
		}
	}

	public void update(ParkSpot ps)
	{
		parkingSpots[current] = ps;
	}

	public void save()
	{
		try {
			PrintWriter writer = new PrintWriter(dbName, "UTF-8");
			writer.print(parkingSpots.length);
			for (ParkSpot spot : parkingSpots) {
				writer.print(spot.getLocation());
				if (!spot.isEmpty()) {
					Vehicle v = spot.getVehicle();
					writer.print(',' + v.getOwner());
					writer.print(',' + v.getLicense());
				}
				writer.print('\n');
			}
			writer.close();
		}
		catch (Exception e) {
			System.out.println("Tidak bisa save data.");
		}
	}

	public void load()
	{
		try {
			int location;
			String vehiclePlate = null, vehicleOwner = null;
			Scanner reader = new Scanner (new File(dbName));
			reader.useDelimiter(",");

			int size = reader.nextInt();
			parkingSpots = new ParkSpot[size];

			while (reader.hasNext()) {
				String input = reader.nextLine();
				String[] ar  = input.split(",");
				location = Integer.parseInt(ar[0]);
				if (ar.length == 3) {
					vehiclePlate = ar[1];
					vehicleOwner = ar[2];
				}
				parkingSpots[location] = new ParkSpot(location, vehicleOwner, vehiclePlate);
			}
			reader.close();
		}
		catch (Exception e) {
			System.out.println("Tidak bisa load data.");
		}
	}
}