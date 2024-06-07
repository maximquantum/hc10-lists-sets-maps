import static org.junit.jupiter.api.Assertions.*;

class Test {

	Object[] myArray = {1, 2, 3};
	
	void test() {
		assertEquals( 1, myArray[0]);
		myArray[1] = 16;
		assertEquals( 16, myArray[1]);
	}

}
