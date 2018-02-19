import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class CalTests {

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("CalTests");
	}
	@Before
	public void init() {
		System.out.println("Running tests.....");
	}
	
	@Test
	public void test1() {
		assertTrue(true);
	}


}

