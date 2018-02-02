package quotes;
import java.util.Scanner;

public class QuoteRunner{

	private Scanner sc; //the scanner used to grab input
	private QuoteList list; //the list to represent the quotes
	private QuoteSaxParser parser; //the parser used to parse the quotes

	public QuoteRunner() {
		sc = new Scanner(System.in);
		parser = new QuoteSaxParser("quotes/quotes.xml");
		list = parser.getQuoteList();
	}

	//main routine that handles logic flow
	public void run() {

		System.out.println("Welcome to quotes!");
		int choice = 0;

		while(choice != 3){
			choice = getChoice();

			//if we're searching for a quote
			if(choice == 1) {
				int searchType = getSearchType();
				System.out.print("Search for: ");
				String mySearch = sc.next();
				if(mySearch == null){
					System.out.println("You can't search for nothing!!\n");
					continue;
				}
				QuoteList result = list.search(mySearch, searchType);
				if(result.getSize() == 0){
					System.out.println("Your search returned no results!!\n");
					continue;
				}
				for(int i = 0; i < result.getSize(); i++){
					Quote q = result.getQuote(i);
					System.out.println("\n" + q.getAuthor() + ": " + q.getQuoteText() + "\n");
				}

			//if we're getting a random quote
			} else if(choice ==2){
				Quote q = list.getRandomQuote();
				System.out.println("\n" + q.getAuthor() + ": " + q.getQuoteText() + "\n");
			//the choice must be 3 because of error handling, so exit.
			} else {
				System.out.println("Goodbye!");
			}

		}


	}
	
	//prints the main options menu
	public void printMenu() {
		System.out.println("What would you like to do?");
		System.out.println("\n\t1: search for a quote.");
		System.out.println("\t2: get a random quote.");
		System.out.println("\t3: exit.\n");
		System.out.print(">> ");
	}

	//grabs the choice for the main option menu
	public int getChoice() {
		int choice = 0;
		while(choice != 1 && choice != 2 && choice != 3){
			printMenu();
			try{
				choice = Integer.parseInt(sc.next());
			} catch(Exception e) {
				System.out.println("Invalid option. Valid options are \"1\" and \"2\". Try again.");
			}
		}
		return choice;
		
	}

	//grabs the desired search type
	public int getSearchType() {
		
		int choice = 0;
		do{
			choice = 0;
			System.out.println("What type of search would you like to do?\n");
			System.out.println("\t1: Search by author.");
			System.out.println("\t2: Search by quote.");
			System.out.println("\t3: Search by both.");
			System.out.print("\n>> ");
			try{
				choice = Integer.parseInt(sc.next());
			} catch(Exception e) {
				System.out.println("Invalid option. Valid options are 1-3.");
			}
			
		} while(choice != 1 && choice !=2 && choice != 3);
		
		return choice -1;

	}
	
}
