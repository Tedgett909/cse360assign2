import java.util.*;
import java.io.*;
public class UserMenu
{
	//So far you can only add a name I have code written for remove a name and get a member but until contains works I can't use it
	//Waiting on code for checking unique names and printing out the whole members list
	//interest not implemented since there were numerous errors stopping me from being able to use it
	public static final void DisplayMenu()
	{
		System.out.println();
		System.out.println("1. Load all Members ");
		System.out.println("2. Save the Members ");
		System.out.println("3. List all Members ");
		System.out.println("4. Add a Member  ");
		System.out.println("5. Remove a Member  ");
		System.out.println("6. List Member  ");
		System.out.println("7. Add/Remove an Interest to a Member  ");
		System.out.println("8. Quit ");
		System.out.println();
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		int y = 0;
		String n = null;
		String answer = null;
		memberList<member> memberList = new memberList<member>();
		int choice;
		Scanner keyboard = new Scanner(System.in);
		
		/*interestList<interest> johnlist = new interestList<interest>();
		interestList<interest> marylist = new interestList<interest>();
		member john= new member("John", 3);
		member mary= new member("Mary", 1);
		
		
		interest inter1 = new interest("java", 2);
		interest inter2 = new interest("c", 2);
		interest inter3 = new interest("graphic design", 2);
		interest inter4 = new interest("math", 2);
		
		interest inter10 = new interest("java", 2);
		interest inter11 = new interest("c", 2);
		interest inter12 = new interest("c++", 2);
		interest inter13 = new interest("Interior design", 2);
		
		johnlist.add(inter1);
		johnlist.add(inter2);
		johnlist.add(inter3);
		johnlist.add(inter4);
		
		marylist.add(inter10);
		marylist.add(inter11);
		marylist.add(inter12);
		marylist.add(inter13);
		
		john.newInterestList(johnlist);
		mary.newInterestList(marylist);
		
		System.out.println("\n\n\nthe score of john and mary is: " + john.compatibilityCal(mary));
		*/
		
		System.out.println("Welcome to CSC Match.");
		do
		{
			interestList<interest> interestList = new interestList<interest>();
			compatibilityList<Compatibility> compatibilityList = new compatibilityList<Compatibility>();
			member member = new member(n, y);
			do
			{
				DisplayMenu();
				System.out.println("Please enter a number.");
				try 
				{
					choice = keyboard.nextInt();
				}
				catch(Exception exception)
				{
					choice = 0;
					keyboard.nextLine();
				}
			}while(choice == 0);
			switch(choice) {
			case 1:
				try 
				{
					System.out.println("Would you like to load a file?");
					String load = keyboard.next();
					memberList = memberList.load(load);
				}
				catch (IOException exception)
				{
					System.out.println("Could not find file");
				}
				catch (ClassNotFoundException exception)
				{
					System.out.println("Could not find file");
				}
				break;
			case 2:
				try
				{
				System.out.println("Where would you like to save to?");
				String save = keyboard.next();
				memberList.save(save);
				}
				catch(IOException exception)
				{
					System.out.println("Could not save to file");
				}
				break;
			case 3:
				if(memberList.isEmpty())
					System.out.println("There are no members in the program");
				else
				{
					System.out.println("Here's a list of all the members: ");
					for(member x : memberList)
						System.out.println(x.name);
				}
				break;
			case 4:
				keyboard.nextLine();
				System.out.println("Please enter a name.");
				member.name = keyboard.nextLine();
				while(memberList.toString().contains(member.name)) 
				{
					System.out.println("Name is not unique please enter another.");
					System.out.println("Please enter a name");
					member.name = keyboard.next();
				}
				do
				{
					System.out.println("How many years of schooling have you attended?");
					System.out.println("Note: Level of schooling goes from 0-5. 0 being Freshmen and 5 being a graduate");
					member.year = keyboard.nextInt();
					if(member.year >= 6 || member.year <= -1)
						System.out.println("That number is not valid. Please choose a number between 0 and 5");
				} while(member.year >= 6 || member.year <= -1);
				keyboard.nextLine();
				do
				{
					System.out.println("What are your interest?");
					String name = keyboard.nextLine();
					System.out.println("Out of 1-10 what do you rank your interest?");
					int rank = keyboard.nextInt();
					interest interest = new interest(name, rank);
					interestList.add(interest);
					System.out.println("Would you like to add another interest? [Y/N]");
					answer = keyboard.next();
					keyboard.nextLine();
				}while(answer.equalsIgnoreCase("y"));
				member.newInterestList(interestList);
				memberList.add(member);
				break;
			case 5:
				if(memberList.isEmpty())
					System.out.println("There are no members in the program");
				else
				{
					keyboard.nextLine();
					System.out.println("Which name would you like to remove?");
					String name2;
					name2 = keyboard.nextLine();
					for (member x : memberList)
					{
						if(x.name.equalsIgnoreCase(name2)) 
						{
							System.out.println("I removed: " + x.name);
							memberList.remove(x);
							break;
						}
						else
							System.out.println("User does not exist");
					}
				}
				break;
			case 6:
				if(memberList.isEmpty())
					System.out.println("There are no members in the program");
				else
				{
					keyboard.nextLine();
					System.out.println("Enter name of member you would like to list");
					String name;
					name = keyboard.nextLine();
					member find = null;
					member.newCompList(compatibilityList);
					
							
						for (member x : memberList) 
						{
							
							if(x.name.equalsIgnoreCase(name)) 
							{ 
								find = x;
								for (member z: memberList)
							{
								String memOne = find.name;
								String memTwo = z.name;
								int cal = (int) find.compatibilityCal(z);
								if (!z.name.equalsIgnoreCase(find.name))
								{
								Compatibility comp= new Compatibility(memOne, memTwo, cal);
								compatibilityList.add(comp);
								}
								
							}
								break;
							}	
						}
						
						
						if (find != null) 
						{
							
							
							//		System.out.println("user " +find.name +" interest score in " +x.name +"is " +find.compatibilityCal(x));
							//for (member x: memberList)
							//{
							//	System.out.println(x.getCompatibilityList());
							//}
							
							System.out.println(find.toString());
							
							
							if (compatibilityList.size()>5)
							{
							System.out.println(compatibilityList.Top5toString(compatibilityList.size()-5,compatibilityList.size()));
							}
							else
							{
							System.out.println(compatibilityList.toString());
							}
						} 
						else
						{
							System.out.println("The user does not exist");
						}
						
						
				}
				
				break;
			case 7:
				if(memberList.isEmpty())
					System.out.println("There are no members in the program");
				else
				{
					keyboard.nextLine();
					System.out.println("Please enter which user you would like to add an interest to");
					String name3;
					name3 = keyboard.nextLine();
					member find = null;
						for (member x : memberList)
						{
							if(x.name.equalsIgnoreCase(name3))
							{
								find = x;
								break;
							}
						}
						if (find != null)
						{
							do 
							{
								System.out.println("Would you like to add an interest");
								String addName = keyboard.nextLine();
								System.out.println("Out of 1-10 what would you rank this interest?");
								int addRank = keyboard.nextInt();
								interest interest = new interest(addName, addRank);
								find.getInterestList().add(interest);
								System.out.println("Would you like to add another interest? [Y/N]");
								answer = keyboard.next();
								keyboard.nextLine();
							}while(answer.equalsIgnoreCase("y"));
							System.out.println("Added new interests");
						}
						else
							System.out.println("User does not exist");
				}
				break;
			case 8:
				keyboard.nextLine();
				System.out.println("Quitting menu now. Would you like to save? [Y/N]");
				answer = keyboard.nextLine();
				if(answer.equalsIgnoreCase("y"))
				{
					System.out.println("Enter the name of the file you would like to save to?");
					String save = keyboard.nextLine();
					try
					{
					memberList.save(save);
					}
					catch(IOException exception)
					{
						System.out.println("Could not save to file");
					}
				}
				else
					System.out.println("Exiting program now");
				break;
			}
		}while(choice != 8);
		keyboard.close();
	}
}