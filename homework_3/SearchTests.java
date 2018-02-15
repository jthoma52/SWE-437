
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class SearchTests{
	
	private QuoteList list;
	private QuoteSaxParser parser;
	private final String FILE_NAME = "quotes.xml";

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("SearchTests");
	}

	@Before
	public void init() {
		parser = new QuoteSaxParser(FILE_NAME);
		list = parser.getQuoteList();
	}
	
	@Test
	public void testSearchByAuthor() {
		String expectedAuthor = "Richard Nixon";
		String expectedText = "I know that you believe you understand what you think I said, but I am not sure you realize that what you heard is not what I meant.";
		
		QuoteList results = list.search("Nixon", 0); //seach for the author
		assertEquals(1, results.getSize()); //Make sure it only found 1
		Quote resultQuote = results.getQuote(0); //get the only quote
		assertEquals(expectedAuthor, resultQuote.getAuthor());
		assertEquals(expectedText, resultQuote.getQuoteText());
	}

	@Test
	public void testSearchByText() {

		String expectedAuthor = "Richard Nixon";
		String expectedText = "I know that you believe you understand what you think I said, but I am not sure you realize that what you heard is not what I meant.";
		
		QuoteList results = list.search("I know that you", 1); //search by quote text
		assertEquals(1, results.getSize()); //make sure we only found 1
		Quote resultQuote = results.getQuote(0); //get the only quote
		assertEquals(expectedAuthor, resultQuote.getAuthor());
		assertEquals(expectedText, resultQuote.getQuoteText());
	}
	
	@Test
	public void testSearchByBoth() {

		String expectedAuthor1 = "H. L. Mencken";
		String expectedQuoteText1 = "For every problem there is one solution which is simple, neat, and wrong.";

		String expectedAuthor2 = "George Bernard Shaw";
		String expectedQuoteText2 = "The only man who behaves sensibly is my tailor; he takes my measure anew every time he sees me, whilst all the rest go on with their old measurements, expecting them to fit me.";
		
		QuoteList results = list.search("men", 2);
		assertEquals(2, results.getSize());
		assertEquals(expectedAuthor1, results.getQuote(0).getAuthor());
		assertEquals(expectedQuoteText1, results.getQuote(0).getQuoteText());
		assertEquals(expectedAuthor2, results.getQuote(1).getAuthor());
		assertEquals(expectedQuoteText2, results.getQuote(1).getQuoteText());




	}

}
