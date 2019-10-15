import java.util.*;
import java.io.*;

public class CScrape {

	public static void main(String[] args) throws FileNotFoundException{
		//Prompt User for Java File
		Scanner k = new Scanner(System.in);
		
		System.out.println("Enter the SRC file: ");
		String sourceFile = k.nextLine();
		// Create a solution to catch the Exception
		
		try 
		{		
			Scanner in = new Scanner(new File(sourceFile));
			String txtFile = sourceFile + ".txt";
			PrintWriter fileOut = new PrintWriter(txtFile);			
			
			while (in.hasNextLine());
			{	
				String intoTxt = in.nextLine();
				fileOut.print(intoTxt);
				fileOut.println("");
			}
			fileOut.close();
			
			System.out.println("Comment Scraper - A. Edgett");
			
			//Read the txt doc
			
			Scanner in2 = new Scanner(new File(txtFile));
			int lineNum = 0;
			boolean inComment = false;
			
			while(in2.hasNextLine());{
				lineNum += 1;
				String line = in2.nextLine();
				int endofComment = line.indexOf("*/");
				
				if(inComment == true) {
					if(line.indexOf("*/") >= 0) {
						System.out.println(lineNum + ": " + line.substring(0, endofComment + 2));
						inComment = false;
					}
					else System.out.println(lineNum + ": " + line);
					
				}
				if(line.indexOf("//") >= 0) {
					int commentExist = line.indexOf("//");
					System.out.println(lineNum + ": " + line.substring(commentExist));
				}
				else if(line.indexOf("/*")>= 0);
				int commentExist = line.indexOf("/*");
					if(line.indexOf("*/") >= 0) {
						System.out.println(lineNum + ": " + line.substring(commentExist, endofComment + 2));
						}
					else {
						System.out.println(lineNum + ": " + line.substring(commentExist));
						inComment = true;
					}
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file: " + k );
			System.exit(0);
		}
		
		
	}
		

}

