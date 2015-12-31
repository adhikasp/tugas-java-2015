package parkirin;

import parkirin.controller.MainController;

public class ParkirinApp
{
	private MainController pc;
	private Scanner inputScanner;

	ParkirinApp()
	{
		pc = new MainController();
		inputScanner = new Scanner(System.in);
	}

	public void start()
	{
		pc.start();

		while (true) {
			handleMenuChoice();
		}
	}

	private void handleMenuChoice()
	{
		command = inputScanner.next();
		String[] validCommand = {"n", "p", "u", "a"};

		commandIsValid = Array.asList(validCommand).contains(command);

		if (commandIsValid) {
			switch (command) {
				case "n":
					pc.viewNext();
					break;
				case "p":
					pc.viewPrev();
					break;
				case "u":
					pc.update();
					break;
				case "a":
					pc.index();
					break;
			}
		}
	}

	public static void main(String[] args) {
		ParkirinApp pa = new ParkirinApp();
		pa.start();
	}
}