public class Cache
{
	private String name;
	private int addressSize, wordSize, blockSize, numLines, b;
	private int requests = 0;
	private int hits = 0;
	private int misses = 0;
	private boolean block[];
	private int tagArray[];
	
	public Cache(String name, int addressSize, int wordSize, int blockSize, int numLines) {
		this.name = name;
		this.addressSize = addressSize;
		this.wordSize = wordSize;
		this.blockSize = blockSize;
		this.numLines = numLines;
		this.b = (blockSize * wordSize) / 8;
		
		block = new boolean[b];
		tagArray = new int[b];
	}
	
	private String binary(int x, int size) {
		return String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0").substring(32-size);
	}
	
	private int log(int x, int base) {
	    return (int) (Math.log(x) / Math.log(base));
	}
	
	public void readLocation(int address) {
		String result;
		int blockAddress = address / b;
		
		int offset       = address % b;
		int index        = blockAddress % b;
		
		int offsetSize   = log(numLines, 2);
		int indexSize    = log(b, 2);
		int temp         = (int) Math.pow(2, (indexSize + offsetSize));
		int tag          = address / temp;
		
		
		if (block[index] && tagArray[index] == tag) {
			result = "** Hit **";
			hits += 1;
		} else {
			result = "Miss";
			misses += 1;
			block[index] = true;
			tagArray[index] = tag;
		}

		requests += 1;
		
		System.out.println("Read Mem           : " 
				+ address + " (" 
				+ binary(address, 32) 
				+ ")");
		System.out.println("	Block Addr : " 
				+ blockAddress 
				+ " (" 
				+ binary(blockAddress, 28) 
				+ ")");
		System.out.println("	Offset     : " 
				+ offset + " (" 
				+ binary(offset, 4) 
				+ ")");
		System.out.println("	Block Num  : " 
				+ index + " (" 
				+ binary(index, 6) 
				+ ")");
		System.out.println("	Tag        : " 
				+ tag + " (" 
				+ binary(tag, 22) 
				+ ")");
		System.out.println("	Result     : " 
				+ result);
	}
	
	public void print() {
		int s  = wordSize;
		int w  = (int) ( (Math.pow(2, addressSize)) / (s / 8) );
		long t = (long) w * (s / 8);
		int c  = (numLines * (blockSize + 1) * s) / 8;
		int l  = numLines;
		int b  = blockSize;
		
		System.out.println("********** " 
				+ name 
				+ " Cache Size Report **********");
		System.out.println("Memory : " 
				+ w 
				+ " words of " 
				+ s 
				+ " bits (" 
				+ t 
				+ " bytes)");
		System.out.println("Cache : " 
				+ l 
				+ " lines with 1 word tag and " 
				+ b 
				+ " words data each (" 
				+ c 
				+ " bytes");
	}
	
public void stats() {
		
		System.out.println("********** " 
				+ name 
				+ " Cache Size Report **********");
		
		System.out.println("Requests: "
				+ requests);
		
		float h = percent(hits, requests);
		float m = percent(misses, requests);
		System.out.println("Hits : "
				+ hits 
				+ " (" 
				+ h 
				+ "%)");
		System.out.println("Misses : " 
				+ misses 
				+ " (" 
				+ m 
				+ "%)");
	}
	
	private float percent(int value, int total) {
		float percent = ( (float) value / total ) * 100;		
		return percent;
	}
}