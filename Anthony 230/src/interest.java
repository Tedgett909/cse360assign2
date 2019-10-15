import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class interest implements Serializable, Comparable<interest>
{

		String name;
		int rank;
		//String result;
		
		public int compareTo(interest i)
		{
			return (i.getRank()- this.getRank());
		}
		
		public interest (String ni, int r)
		{
			name = ni;
			rank = r;
		}

		public String getName()
		{
			return name;
		}
		
		public int getRank()
		{
			return rank;
		}
		
		public String toString()
		{
			String result = "Interest name: " + this.name + "  Rank: " + this.rank;
			return result;
		}
}
