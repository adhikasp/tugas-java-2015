package parkirin.view;

import parkirin.model.*;

public class ParkirinView
{
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

	public void index(ParkManager pm)
	{
		System.out.println("Melihat daftar lahan parkir");
	}

	public ParkSpot update(int index)
	{
		System.out.println("Mengedit lahan parkir");
		return new ParkSpot(index);
	}

	public void exit()
	{
		System.out.println("Terimakasih sudah menggunakan program Parkir.in");
	}
}