import java.util.*;
public class Josephus {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int last = 0;
		String input, again;
		int P, K;
		Scanner kb = new Scanner(System.in);
		System.out.println("Josephus - A. Edgett");
		do {		
			System.out.println("How many member are in the group");
			input = kb.nextLine();
			try {
				P = Integer.parseInt(input);
			}catch(NumberFormatException e) {
				System.out.println("Please Enter an Integer");
				P = kb.nextInt();
			}
			System.out.println("What is the Skip count");
			K = kb.nextInt();
		
			for(int i = 1; i <= P; ++i) {
				queue.add(i);
			}
			while(!(queue.isEmpty())) {
				for(int i = 1; i <= K - 1; ++i) {
					int ele = queue.remove();
					last = ele;
					queue.add(ele);
				}
				queue.remove();
			}
			System.out.println("You want to be in position # " + last);
			System.out.print("Evaluate another expression [Y/N]? ");
			again = kb.nextLine();
			System.out.println();
			}
		while(again.equalsIgnoreCase("y"));
        	kb.close();
		
	}

}