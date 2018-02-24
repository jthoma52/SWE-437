import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class CalTests {

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("CalTests");
	}
	
	@Test
	public void test1() {
		assertEquals(1, Cal.cal(1,1,1,2,1997)); //same month, one day apart
	}

	@Test
	public void test2() {
		assertEquals(0, Cal.cal(1,1,1,1,1400)); //given the same day
	}
	
	@Test
	public void test3() {
		assertEquals(31, Cal.cal(3,1,4,1,9000)); //Tests across one month
	}
	@Test
	public void test4() {
		assertEquals(2, Cal.cal(1,3,1,1,9999)); //dates in reverse order
	}

	@Test
	public void test5() {
		assertEquals(20, Cal.cal(1,1,1,21,1)); //more than one day apart in same month
	}
	
	@Test
	public void test6() {
		assertEquals(364, Cal.cal(1,1,12,31,2018)); //tests across all months
	}
	
	@Test
	public void test7() {
		assertEquals(365, Cal.cal(1,1,12,31,2012)); //Standard leap year test
	}

	@Test
	public void test8() {
		assertEquals(364, Cal.cal(1,1,12,31,1700)); //Tests century year non-leap
	}

	@Test 
	public void test9() {
		assertEquals(2, Cal.cal(2,28,3,1,2000)); //tests century leap year
	}

	@Test
	public void test10() {
		try {
			
			//These inputs should not be allowed, 
			//but the prereqs don't say that day1 should be <=31. 
			//It also doesn't specifiy day2 >= 1, so these inputs are valid.
			
			Cal.cal(1,40,1,-5,2000);
			assertTrue(false);

		} catch(Exception e) {
			assertTrue("Test correctly threw exception", true);
		}
	
	}

}

