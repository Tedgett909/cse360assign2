package cse360assign2;

/* Anthony Edgett
 * CSE 360-70641
 * Assignment #2
 * This is the Adding Mchaine class that 
 * has add and subract for mathmatical
 * expressions as well as can get the 
 * total of the expression and pring 
 * the expression to the current position
 */

public class AddingMachine {

	private int total;
	StringBuffer history;
	
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

