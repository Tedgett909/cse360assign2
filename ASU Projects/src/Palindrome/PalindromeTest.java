package Palindrome;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PalindromeTest 
{
	
	private Palindrome palindrome;
	private String str;

	@Before//sets the initial for every test
	public void setUp() throws Exception
	{
		str = null;
		palindrome = new Palindrome();
	}

	@After//clears out all of the test cases after each test
	public void tearDown() throws Exception 
	{
		
	}

	@Test(expected = NullPointerException.class)//test for a null string
	public void nullStringTest() throws Exception
	{
		palindrome.isPalindrome(null);//passes
	}
	
	@Test//test for an empty string
	public void emptyStringTest() throws Exception
	{
		str = "";
		
		assertTrue(palindrome.isPalindrome(str));//passes
	}
	
	@Test//tests for over use of whitespace between words
	public void whiteSpaceTest() throws Exception
	{
		str = "Red  rum   sir is     murder";
		
		assertTrue(palindrome.isPalindrome(str));//passes
		
	}
	
	@Test//test for one char
	public void oneCharTest() throws Exception
	{
		str = "A";
		
		assertTrue(palindrome.isPalindrome(str));//passes
	}
	
	
	@Test//tests for a valid palindrome
	public void validPalindromeTest() throws Exception
	{
		str = "Taco cat";//This is my favorite palindrome
		
		assertTrue(palindrome.isPalindrome(str));//passes
	}
	
	@Test//tests for an invalid palindrome
	public void invalidPalidromeTest() throws Exception
	{
		str = "This is a palindrome Tester";
		
		assertFalse(palindrome.isPalindrome(str));//passes
	}
	
	@Test//tests for punctuation, and if there is any it messes up the palindrome
	public void punctTest() throws Exception
	{
		str = "King, are you glad you are king?";
		
		assertFalse(palindrome.isPalindrome(str));//passes
	}

}
