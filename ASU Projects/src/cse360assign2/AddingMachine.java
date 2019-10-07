package cse360assign2;

public class AddingMachine {

	private int total;
	StringBuffer all;
	
	public AddingMachine () 
	{
		total = 0;  // not needed - included for clarity
		all = new StringBuffer("0");//makes a new buffer
	}
	
	public int getTotal () //returns the total at its current position
	{
		return total;
	}
	
	public void add (int value)//add the value to total and puts it in total
	{
		total = total + value;
		all.append("+" + value);
	}
	
	public void subtract (int value)//subtracts the value from total and puts it in total
	{
		total = total - value;
		all.append("-" +value);
	}
	
	public String toString () //prints the operations in the order they happened
	{
		return all.toString();
	}
	
	public void clear() 
	{
		
	}
	
}

