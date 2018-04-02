import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import javax.net.ssl.*;
import javax.net.ssl.X509TrustManager;

public class QuoteServerTests {
	
	WebClient client;
	HtmlPage page, result;
	HtmlForm form;
	HtmlSubmitInput search;
	HtmlTextInput textField;
	HtmlRadioButtonInput searchType;

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("QuoteServerTests");
	}
	
	@Before
	public void init() {
		try{
			client = new WebClient();
			page = (HtmlPage)client.getPage("https://cs.gmu.edu:8443/offutt/servlet/quotes.quoteserve");
			form = page.getFormByName("quoteServ");
			search = form.getInputByName("submit");
			textField = form.getInputByName("searchText");
		} catch(Exception e) {
			System.out.println("Something went wrong!!");
			assertTrue(false);
		}
	}

	@Test
	public void getRandomQuote() {
		try{
			form = page.getFormByName("random");
			HtmlSubmitInput rand = form.getInputByName("submit");
			result = (HtmlPage) rand.click();
			String output1 = result.asText();
			result = (HtmlPage) rand.click();
			String output2 = result.asText();
			assertNotEquals(output1, output2);
		} catch(Exception e) {
			assertTrue(false);
		}	


	}

	@Test
	public void testQuoteUndercase() {
		String output = query("quote", "I know that you believe you understand what you think");
		assertTrue(output.contains("Richard Nixon"));
	}

	@Test
	public void testQuoteUppercase() {
		String output = query("quote", "I KNOW THAT YOU BELIEVE YOU UNDERSTAND WHAT YOU THINK");
		assertTrue(output.contains("Richard Nixon"));
	}

	@Test
	public void testAuthorUndercase() {
		String output = query("author", "richard nixon");
		assertTrue(output.contains("I know that you believe you understand what you think I said"));
	}

	@Test
	public void testBothUndercase() {
		String output = query("both", "help");
		assertTrue(output.contains("Mark Helprin"));
		assertTrue(output.contains("but it is so honest that god can't help but smile on it."));
	}
	
	@Test
	public void testQuoteEmptyString() {
		String output = query("both", "");
		//just make sure it didn't throw an error
		assertTrue(true);
	}

	@Test
	public void testQuoteLargeString() {
		
		//101 char input
		String searchString = "Lest I continue My complacent way, Help me to remember Somewhere out there A man died for me today. A";
		String output = query("quote", searchString);
		assertTrue(output.contains("Sir William Stephenson"));
	}


	public String query(String stype, String sstring) {
		try{
			searchType = form.getInputByValue(stype);
			searchType.setChecked(true);
			textField = form.getInputByName("searchText");
			
			textField.setText(sstring);
			result = (HtmlPage) search.click();
		} catch(Exception e) {

		}
		return result.asText();
	}
}
