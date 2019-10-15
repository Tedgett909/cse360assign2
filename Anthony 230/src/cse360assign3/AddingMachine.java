package cse360assign3;

/* Anthony Edgett
 * CSE 360-70641
 * Assignment #3-*New Adding Machine
 * This is the Adding Machine class that 
 * has to call the Calculator class to do the
 * mathematical computations for the given information
 */

public class AddingMachine {

	protected int total;
	protected StringBuffer history;
	
	public AddingMachine () 
	{
		total = 0;  // not needed - included for clarity
		history = new StringBuffer("0");//makes a new buffer
	}
	
	public int getTotal () //returns the total at its current position
	{
		return total;//returns the total value
	}
	
	public void add (int value)//add the value to total and puts it in total
	{
		total = total + value;
		history.append("+" + value);
	}
	
	public void subtract (int value)//subtracts the value from total and puts it in total
	{
		total = total - value;
		history.append("-" +value);
	}
	
	public String toString () //prints the operations in the order they happened
	{
		return history.toString();//returns the full expression
	}
	
	public void clear() 
	{
		
	}
	
}
