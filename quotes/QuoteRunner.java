import java.util.Scanner;

public class QuoteRunner{

	private Scanner sc;

	public QuoteRunner() {
		sc = new Scanner(System.in);
	}

	public void run() {

		System.out.println("Welcome to quotes!");
		printMenu();
		int choice = 0;
		while(choice != 1 && choice != 2){
			try{
				choice = Integer.parseInt(sc.next());
			} catch(Exception e) {
				System.out.println("Invalid option. Valid options are \"1\" and \"2\". Try again.");
				printMenu();
			}
		}
		System.out.println("nice");


	}

	public void printMenu() {
		System.out.println("What would you like to do?");
		System.out.println("\n\t1: search for a quote.");
		System.out.println("\t2: get a random quote.\n");
		System.out.print(">> ");
	}

}
