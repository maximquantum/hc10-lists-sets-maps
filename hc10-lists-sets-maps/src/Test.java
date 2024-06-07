import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class Test {
	
	ArrayList myArray;
	
	@BeforeEach
	void setUp() throws Exception {
		myArray = new ArrayList(10);
		myArray.add(1);
		myArray.add(2);
		myArray.add(3);
	}
	
	@org.junit.jupiter.api.Test
	void test() {
		assertEquals( 1, myArray.get(0));
		myArray.set(1, 16);
		myArray.add(2, 42);
		assertEquals( 16, myArray.get(1));
		assertEquals( 42, myArray.get(2));
	}

}
