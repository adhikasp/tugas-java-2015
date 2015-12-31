package parkirin.model;

public class ParkManager
{
	private ArrayList parkingSpots;
	private int current = 0;

	ParkManager(int parkSize)
	{
		parkingSpots = new ArrayList();
		for (int i = 0; i < parkSize; i++) {
			parkingSpots.add(new ParkSpot(i));
		}
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
		if (current + 1 < parkingSpots.size()) {
			current++;
		}
	}

	public void prev()
	{
		if (current - 1 > 0) {
			current--;
		}
	}

	public void update(ParkSpot ps)
	{
		parkingSpots[current] = ps;
	}
}