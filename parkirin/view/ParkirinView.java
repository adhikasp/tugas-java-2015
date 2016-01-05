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
		if (ps.isEmpty()) {
			System.out.println("Lahan ini kosong.");
		}
		else {
			System.out.println("Pemilik    : " + ps.getVehicle().getOwner());
			System.out.println("Plat nomor : " + ps.getVehicle().getLicense());
		}
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
		System.out.println("Lahan parkir " + spot.getLocation());
		if (spot.isEmpty()) {
			System.out.println("Checkin kendaraan");
			System.out.print("Plat nomor : ");
			String plate = inputScanner.nextLine();
			System.out.print("Pemilik : ");
			String owner = inputScanner.nextLine();

			spot.setVehicle(new Vehicle(owner, plate));
		}
		else {
			System.out.println("Checkout kendaraan");
			System.out.println("Biaya parkir : Rp " + spot.getBill() + ",00");
			spot.setVehicle(null);
		}
		return spot;
	}

	public void exit()
	{
		System.out.println("Terimakasih sudah menggunakan program Parkir.in");
	}
}