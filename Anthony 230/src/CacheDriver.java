import java.util.Scanner;

public class CacheDriver {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		//Read Cache Information
		System.out.println("Cache Information:");
		System.out.print("   Address size, in bits? ");
		int addressSize = keyboard.nextInt();
		System.out.print("   Word size, in bits? ");
		int wordSize = keyboard.nextInt();
		System.out.print("   Block size, in words? ");
		int blockSize = keyboard.nextInt();
		System.out.print("   Number of Lines? ");
		int numLines = keyboard.nextInt();

		// Read Test Parameters
		System.out.println("\nTest Parameters:");
		System.out.print("   Starting Address? ");
		int startAddr = keyboard.nextInt();
		System.out.print("   Ending Address? ");
		int endAddr = keyboard.nextInt();
		System.out.print("   Increment? ");
		int incAddr = keyboard.nextInt();

		// Create the cache
		Cache c =  new Cache("CSC230", addressSize, wordSize, blockSize, numLines);

		// Run the test
		testCache(c, startAddr, endAddr, incAddr);	
		
		keyboard.close();
	}
	
	private static void testCache(Cache c, int startAddr, int endAddr, int inc) {
		System.out.println("\n");
		
		c.print();
		
		for(int address = startAddr; address <= endAddr; address += inc) {
			c.readLocation(address);
			System.out.println();
		}
		
		c.stats();
	}
}