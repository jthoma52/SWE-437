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
		assertEquals(q.getKeywords().contains("President"));
	}


}
