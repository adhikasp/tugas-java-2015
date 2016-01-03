package parkirin.controller;

import parkirin.model.*;
import parkirin.view.*;

public class MainController
{
	ParkManager pm;
	ParkirinView pv;

	public MainController()
	{
		// TODO menambahkan fungsi loading
		pm = new ParkManager(10);
		pv = new ParkirinView();
	}

	public void start()
	{
		pv.landing();
		pv.show(pm.getCurrent());
		pv.menu();
	}

	public void index()
	{
		pv.index(pm);
		pv.menu();
	}

	public void viewNext()
	{
		pm.next();
		pv.show(pm.getCurrent());
		pv.menu();
	}

	public void viewPrev()
	{
		pm.prev();
		pv.show(pm.getCurrent());
		pv.menu();
	}

	public void update()
	{
		// Input function
		ParkSpot ps = pv.update(pm.getCurrentIndex());

		pm.update(ps);
		pv.menu();
	}

	public void menu()
	{
		pv.menu();
	}

	public void exit()
	{
		pv.exit();
		System.exit(0);
	}
}
