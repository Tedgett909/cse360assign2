import java.util.*;
import java.io.*;

public class Compatibility implements Serializable, Comparable<Compatibility>
{
	String memOne;
	String memTwo;
	int cal;
	
	public int compareTo(Compatibility i)
	{
		return (i.getCal() - this.getCal());
	}
	
	public Compatibility (String m1, String m2,int Cal)
	{
		memOne = m1;
		memTwo = m2;
		cal = Cal;
	}
	
	
	public int getCal()
	{
		return cal;
	}
	
	public String getMem1()
	{
		return memOne;
	}
	
	public String getMem2()
	{
		return memTwo;
	}
	
	public String toString()
	{
		String result ="Interest score of " +memOne +" to " +memTwo +" is: " +cal; ; 
		return result;
	}
	
}
