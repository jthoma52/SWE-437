import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class CalTests {

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("CalTests");
	}	
	

	
	@Test //predicate 1.1, Pa
	public void test1() {
		
		assertEquals(0, Cal.cal(1,1,1,1, 2000)); //row 1
		assertEquals(31, Cal.cal(1,1,2,1,1000)); //row 2
		
	}

	@Test //predicate 1.2, Pa
	public void test2() {
		
		assertEquals(31, Cal.cal(1,1,2,1,1000)); //row 1
		assertEquals(0, Cal.cal(1,1,1,1, 2000)); //row 2
	}

	@Test //predicate 1.3, Pa
	public void test3() {
		
		assertEquals(0, Cal.cal(1,1,1,1, 900)); //row 5
		assertEquals(31, Cal.cal(1,1,2,1, 900)); //row 13

	}
	
	@Test //predicate 1.3, Pb
		  //satisfies 1.4, Pb as well
	public void test4() {
		
		assertEquals(31, Cal.cal(1,1,2,1, 5)); //row 11
		assertEquals(31, Cal.cal(1,1,2,1, 4)); //row 15
	}

	@Test //predicate 1.3, Pc
		  //satisfies 1.4, Pc as well
	public void test5() {
		
		assertEquals(31, Cal.cal(1,1,2,1, 900)); //row 13
		assertEquals(31, Cal.cal(1,1,2,1, 901)); //row 15
		
	}
	
	@Test //predicate 1.3, Pd
		  //satisfies 1.4, Pd as well
	public void test6() {
		
		assertEquals(31, Cal.cal(1,1,2,1,900)); //row 13
		assertEquals(31, Cal.cal(1,1,2,1, 400)); //row 14

	}
		
	@Test //predicate 1.4, Pa
	public void test7() {
		
		assertEquals(0, Cal.cal(1,1,1,1, 400)); //row 6
		assertEquals(31, Cal.cal(1,1,2,1, 400)); //row 14

	}
	
	@Test //predicate 1.5, Pa
	public void test8() {
		
		//row 1 is uncreachable, so we can't satisfy this
		assertEquals(60, Cal.cal(1,1,3,1, 400)); //row 3
	}
	
	@Test //predicate 1.5, Pe 
	public void test9() {
		
		assertEquals(60, Cal.cal(1,1,3,1, 400)); //row 3
		assertEquals(31, Cal.cal(1,1,2,1, 400)); //row 4
	}
}
