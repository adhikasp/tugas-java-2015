package parkirin.model;

import java.util.ArrayList;

public class ParkManager
{
	private ParkSpot[] parkingSpots;
	private int current = 0;

	public ParkManager(int parkSize)
	{
		parkingSpots = new ParkSpot[parkSize];
		for (int i = 0; i < parkSize; i++) {
			parkingSpots[i] = new ParkSpot(i+1);
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
}