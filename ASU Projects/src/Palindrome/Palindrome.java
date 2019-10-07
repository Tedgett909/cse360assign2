package Palindrome;

import java.lang.String;
import java.lang.Character;

public class Palindrome {
	
	public static void Plalindrome(String[] args)
	{
		Palindrome palindrome = new Palindrome();
		
		String str = "Red rum, sir, is murder";
	}
	
	static boolean isPalindrome(String str)
	{
		// makes the all input lowercase and gets rid of white spacing
		str = str.toLowerCase().replaceAll("\\s+", "");
		
		//sets strlength to the lenght of the string
		int strlength = str.length();
		
		//if there are any chars outside of the ones allowed it sends a false result
		if(!str.matches("^([a-z0-9]+)?$"))
		{
			return false;
		}
		
		
		//compares the characters in the string
		for(int i = 0; i < strlength / 2; i++) 
		{
			if(str.charAt(i) != str.charAt(strlength - i - 1))
				return false;
			
		}
		return true;
	}
}


	

