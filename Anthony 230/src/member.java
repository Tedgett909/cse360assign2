import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
public class member implements Serializable {
	
		String name;
		int year;
		

		interestList<interest> memberInterest;
		compatibilityList<member> compatibilityList;
		
		compatibilityList<Compatibility> compList;
		//public double compareTo(member i)
		//{
		//	return (this.compatibilityCal(i) - i.compatibilityCal(this));
		//}

		public void newInterestList(interestList<interest> i) {
			memberInterest = i;
		}
		
		public void newCompList(compatibilityList<Compatibility> i) {
			compList = i;
		}
		
		public void newCompatiblityList(compatibilityList<member> i)
		{
			compatibilityList = i;
		}
		
		public compatibilityList<Compatibility> getCompList()
		{
			return compList;
		}

		public compatibilityList<member> getCompatibilityList()
		{
			return compatibilityList;
		}
		
		
		public interestList<interest> getInterestList() //added this to allow an interest list to be tied to the member that was created
		{
			return memberInterest;
		}
		
		public member(String n, int y) 
		{
			name = n;
			year = y;
		}
		
		public String getName() 
		{
			return name;
		}
		
		public int getyear()
		{
			return year;
		}
		
		public String toString() 
		{
			 String result = "Name: " + this.name + " " + "Year: " + this.year + "\n" + memberInterest.toString();
			 return result;
		}
		
		public String CompString()
		{
			String compResult = "";
			compResult = "" +compList.toString();
			return compResult;
		}
		
		public void addCal(Compatibility i)
		{
			compList.add(i);
		}
		public void addInterest(interest i) 
		{
			memberInterest.add(i);
		}

		public double compatibilityCal(member member2)
		{
		double compatibility = 0;
		boolean found =false;
		
		for (interest y: member2.memberInterest)
		{
			for (interest z: this.memberInterest)
			{
				if (y.getName().equalsIgnoreCase(z.getName()))
				{
					found = true;
					compatibility += (z.getRank() * y.getRank());
					
					//System.out.println("match  " +compatibility);
				}
			}

				if (!found)
				{
					compatibility+= y.getRank()/2;
					found = false;
					//System.out.println("not match  " +compatibility);
				}

			}
		return compatibility;
		}
}