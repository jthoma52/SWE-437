import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class KeywordTests {

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("KeywordTests");
	}

	@Test
	public void testPresidentKeyword() {
		Quote q = new Quote("Richard Nixon", "This is some quote that doesn't matter!", Arrays.asList("President"));
		assertTrue(q.getKeywords().contains("President"));
	}

	@Test
	public void testNoMoreThanFiveKeywords() {
		Quote q = new Quote("test", "test", Arrays.asList("1", "2", "3", "4", "5", "6"));
		assertEquals(5, q.getKeywords().size());
	}

	@Test
	public void testAddKeywordToSchema() {

		//add a quote to a test file with keywords in it, write it to the file.
		Quote q = new Quote("FakeAuthor", "FakeQuote", Arrays.asList("one", "two", "three"));
		QuoteList list = new QuoteList();
		list.setQuote(q);   
		QuoteWriter.write("quotesTest.xml", list);

		//make sure it wrote correctly
		try {
			Scanner sc = new Scanner(new File("quotesTest.xml"));
			int count = 0;
			while(sc.hasNext()) {
				String curr = sc.next();
				if(curr.contains("<keyword>"))
					count++;
				if(curr.contains("</keyword>"))
					count++;
			}
			assertEquals(6, count);
		} catch(Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void testAddQuoteWithKeyword() {
		
		//make a new quotelist.
		QuoteList list = new QuoteList();

		//add the quotes, write the new file
		list.setQuote(new Quote("test", "test", Arrays.asList("one", "two", "three")));
		list.setQuote(new Quote("test2", "test2", Arrays.asList("four")));
		QuoteWriter.write("quotesTest.xml", list);
		
		//make sure the count of the quotes went up by two
		list = (new QuoteSaxParser("quotesTest.xml")).getQuoteList();
		assertEquals(2, list.getSize());

		//make sure ALL of the keywords got added
		assertTrue(list.getQuote(0).getKeywords().contains("one"));
		assertTrue(list.getQuote(0).getKeywords().contains("two"));
		assertTrue(list.getQuote(0).getKeywords().contains("three"));
		assertTrue(list.getQuote(1).getKeywords().contains("four"));
	}

	@Test
	public void testAddQuoteWithOrWithoutKeywords() {
	
		//add 2 quotes, write it to the file
		QuoteList list = new QuoteList();
		list.setQuote(new Quote("test", "test", Arrays.asList("one")));
		list.setQuote(new Quote("test", "no keywords"));
		QuoteWriter.write("quotesTest.xml", list);

		//make sure there was no keyword tag inserted on the second quote
		//make sure the first quote got its quote
		list = (new QuoteSaxParser("quotesTest.xml")).getQuoteList();
		assertTrue(list.getQuote(0).getKeywords().contains("one"));
		assertEquals(0, list.getQuote(1).getKeywords().size());

	}

	@Test
	public void testSearchByKeyword() {
		
		//write out two quotes to the file
		QuoteList list = new QuoteList();
		list.setQuote(new Quote("test1", "returned in search", Arrays.asList("one")));
		list.setQuote(new Quote("test2", "returned in search", Arrays.asList("two")));
		QuoteWriter.write("quotesTest.xml", list);
		
		//search by the letter o, make sure both were returned.
		list = (new QuoteSaxParser("quotesTest.xml")).getQuoteList();
		QuoteList results = list.search("o", 3);
		assertEquals(2, results.getSize());

	}
	

}
