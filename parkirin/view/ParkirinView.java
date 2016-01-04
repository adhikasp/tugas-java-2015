package parkirin.view;

import parkirin.model.*;

public class ParkirinView
{
	private java.util.Scanner inputScanner;

	public ParkirinView()
	{
		inputScanner = new java.util.Scanner(System.in);
	}

	public void landing()
	{
		System.out.println("Aplikasi Parkir.in");
	}

	public void show(ParkSpot ps)
	{
		System.out.println("Melihat lahan parkir ke " + ps.getLocation());
	}

	public void menu()
	{
		System.out.println("view (a)ll, (u)pdate, (n)ext, (p)revious, atau e(x)it");
		System.out.print("Pilih menu: ");
	}

	public void index(ParkSpot[] spots)
	{
		System.out.println("Melihat daftar lahan parkir");
		for (ParkSpot spot : spots) {
			if (spot.isEmpty()) {
				System.out.println(spot.getLocation() + ". --kosong--");
			}
			else {
				Vehicle v = spot.getVehicle();
				System.out.println(spot.getLocation() + ". " + v.getOwner() + " -- " + v.getLicense());
			}
		}
	}

	public ParkSpot update(ParkSpot spot)
	{
		System.out.println("Mengedit lahan parkir");
		if (spot.isEmpty()) {
			System.out.println("Mobil masuk");
			System.out.print("Plat nomor : ");
			String plate = inputScanner.nextLine();
			System.out.print("Pemilik : ");
			String owner = inputScanner.nextLine();

			spot.setVehicle(new Vehicle(owner, plate));
		}
		else {
			spot.setVehicle(null);
		}
		return spot;
	}

	public void exit()
	{
		System.out.println("Terimakasih sudah menggunakan program Parkir.in");
	}
}