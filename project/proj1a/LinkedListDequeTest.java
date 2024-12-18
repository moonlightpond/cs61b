/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	public static int test() {
		int n = 3;
		while (n != 0) {
			n -= 1;
			if (n == 2) {
				return n;
			}
		}
		return n;
	}
	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addLast("front");
		//lld1.printDeque();
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		//passed = checkSize(1, lld1.size()) && passed;
		//passed = checkEmpty(false, lld1.isEmpty()) && passed;

		//lld1.addLast("middle");
		//passed = checkSize(2, lld1.size()) && passed;

		//lld1.addLast("back");
		//passed = checkSize(3, lld1.size()) && passed;

		//lld1.removeLast();
		//lld1.removeLast();
		//lld1.removeLast();
		//passed = checkSize(1, lld1.size()) && passed;

		//System.out.println("Printing out deque: ");
		//lld1.printDeque();
		lld1.printDeque();
		//printTestStatus(passed);
		System.out.println(lld1.getRecursive(0));
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {
		System.out.println("Running add/remove test.");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());
		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);
	}

	public static void ArrayDequeTest1() {
		ArrayDeque<Integer> ad = new ArrayDeque<>();
		boolean passed = checkEmpty(true, ad.isEmpty());
		passed = checkSize(0, ad.size()) && passed;

		ad.addLast(1);
		ad.addLast(2);
		passed = checkSize(2, ad.size()) && passed;
		passed = checkSize(2, ad.length()) && passed;
		ad.addLast(3);
		passed = checkSize(3, ad.size()) && passed;
		passed = checkSize(4, ad.length()) && passed;
		ad.removeLast();
		passed = checkSize(2, ad.size()) && passed;
		passed = checkSize(4, ad.length()) && passed;
		ad.printDeque();

		printTestStatus(passed);
	}

	public static void ArrayDequeTest2() {
		ArrayDeque<Integer> ad = new ArrayDeque<>();
		boolean passed = checkEmpty(true, ad.isEmpty());
		passed = checkSize(0, ad.size()) && passed;

		ad.addFirst(1);
		ad.addFirst(2);
		passed = checkSize(2, ad.size()) && passed;
		passed = checkSize(2, ad.length()) && passed;
		ad.addFirst(3);
		passed = checkSize(3, ad.size()) && passed;
		passed = checkSize(4, ad.length()) && passed;
		ad.removeFirst();
		passed = checkSize(2, ad.size()) && passed;
		passed = checkSize(4, ad.length()) && passed;
		ad.printDeque();

		printTestStatus(passed);
	}

	public static void ArrayDequeTest3() {
		ArrayDeque<Integer> ad = new ArrayDeque<>();
		ad.addLast(0);
		ad.removeLast();
		ad.addLast(2);
		ad.removeLast();
		ad.addLast(4);
		ad.removeLast();
		ad.isEmpty();
		ad.isEmpty();
		ad.addLast(8);
		ad.removeLast();
		ad.addLast(10);
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		//addIsEmptySizeTest();
		//addRemoveTest();
		//System.out.println(test());
		ArrayDequeTest3();
	}
}
