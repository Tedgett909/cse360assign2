import java.util.Scanner;
public class HWMult {
	private static Scanner k = new Scanner( System.in );
	public static void main(String[] args) 
	{	
		System.out.println("Hardware Multiply - A. Edgett");
		long Mul, Cand;
		long product;
		long JP;
		product = 0;
		JP = 0;
		System.out.println("Enter a Multipler: ");
		Mul = k.nextInt();
		System.out.println("Enter a Multiplicand: ");
		Cand = k.nextInt();
		// Java Multiply
		JP = Mul*Cand;
		System.out.println("Java: "+JP);
		// HW MUL
		while (Mul != 0) {
			if ((Mul & 1)!=0) {
				product = product + Cand;
			}//IF
			Mul = Mul >> 1;
			Cand = Cand << 1;
		}//WL
		System.out.println("HWMultiplication value is: "+product);
		
	}//Main

}//END
