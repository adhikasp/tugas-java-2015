package parkirin;

import parkirin.controller.MainController;

public class ParkirinApp
{
	private MainController pc;
	private java.util.Scanner inputScanner;

	ParkirinApp()
	{
		pc = new MainController();
		inputScanner = new java.util.Scanner(System.in);
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
		String command = inputScanner.next();
		String[] validCommand = {"n", "p", "u", "a", "x"};

		Boolean commandIsValid = java.util.Arrays.asList(validCommand).contains(command);

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
                case "x":
                    pc.exit();
                    break;
			}
		}
		else {
			System.out.println("Pilihan menu tidak valid");
			pc.menu();
		}
	}

	public static void main(String[] args) {
		ParkirinApp pa = new ParkirinApp();
		pa.start();
	}
}
