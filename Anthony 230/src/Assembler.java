import java.util.Scanner;

public class Assembler {		

		private static byte regToByte(String reg) {
			
			switch (reg) {
			case "$zero": return 0;	
			case "$v0":	return 2;
			case "$v1": return 3;
			case "$a0":	return 4;
			case "$a1": return 5;
			case "$a2": return 6;
			case "$a3": return 7;
			case "$t0": return 8;
			case "$t1": return 9;
			case "$t2": return 10;
			case "$t3": return 11;
			case "$t4": return 12;
			case "$t5": return 13;
			case "$t6":	return 14;
			case "$t7": return 15;
			case "$t8": return 24;
			case "$t9":	return 25;
			case "$s0": return 16;
			case "$s1": return 17;
			case "$s2": return 18;
			case "$s3": return 19;
			case "$s4": return 20;
			case "$s5": return 21;
			case "$s6": return 22;
			case "$s7": return 23;
			default:
				return 30;
			}
		}
		private static int makeR (byte op, byte rs, byte rt, byte rd, byte shamt, byte func) {

			int x = ((op & 0b00111111) << 26) | 
					((rs & 0b00011111) << 21) | 
					((rt & 0b00011111) << 16) | 
					((rd & 0b00011111) << 11) | 
					((shamt & 0b00011111) << 6) | 
					((func & 0b00111111));
			return x;
		}
		private static int makeI (byte op, byte rs, byte rt, short imm) {
			int x = ((op & 0xFFFF) << 26) | 
					((rs & 0x1F) << 21) | 
					((rt & 0x1F) << 16) | 
					((imm & 0xFFFF) << 0);
			return x;
		}
	private static Scanner keyboard = new Scanner( System.in );
	public static void main(String[] args) {
			// TODO Auto-generated method stub
		boolean halted = false;
		System.out.println("Assembler - A. Edgett");
		System.out.println("*** Begin entering Assember");
		int code[] = new int[100];
		int i = 0;
		
		while (!halted)
		{
			String cmd = keyboard.next().toUpperCase();
			
			
			//code = 0;
			switch (cmd)
			{
				case "ADD":
					byte rd = regToByte(keyboard.next());
					byte rs = regToByte(keyboard.next());
					byte rt = regToByte(keyboard.next());
					code[i] = makeR((byte) 0,rs,rt,rd,(byte)0,(byte) 0x20);
					break;
				case "AND":
					rd = regToByte(keyboard.next());
					rs = regToByte(keyboard.next());
					rt = regToByte(keyboard.next());
					code[i] = makeR((byte)0,rs,rt,rd,(byte)0,(byte)0x24);
					break;
				case "SRL":
					rd = regToByte(keyboard.next());
					rt = regToByte(keyboard.next());
					byte shamt = (keyboard.nextByte());
					code[i] = makeR((byte)0,(byte)0,rt,rd,shamt,(byte)0x02);
					break;
				case "SLL":
					rd =  regToByte(keyboard.next());
					rt = regToByte(keyboard.next());
					shamt = (keyboard.nextByte());
					code[i] = makeR((byte)0,(byte)0,rt,rd,shamt,(byte)0x00);
					break;
				case "ADDI":
					rt = regToByte(keyboard.next());
					rs = regToByte(keyboard.next());
					short imm = (keyboard.nextShort());
					code[i] = makeI((byte)0x8,rs,rt,imm);
					break;
				case "ANDI":
					rt = regToByte(keyboard.next());
					rs = regToByte(keyboard.next());
					imm = (keyboard.nextShort());
					code[i] = makeI((byte)0x8,rs,rt,imm);
					break;
				case "BEQ":
					rt = regToByte(keyboard.next());
					rs = regToByte(keyboard.next());
					imm = (keyboard.nextShort());
					code[i] = makeI((byte)0xc,rs,rt,imm);
					break;
				case "LW":
					rt = regToByte(keyboard.next());
					imm = (keyboard.nextShort());
					rs = regToByte(keyboard.next());
					
					code[i] = makeI((byte)0x23,rs,rt,imm);
					break;
				case "SW":
					rt = regToByte(keyboard.next());
					imm = (keyboard.nextShort());
					rs = regToByte(keyboard.next());
					
					code[i] = makeI((byte)0x2b,rs,rt,imm);
					break;
				case "HALT":
					//default:
					halted = true;
					break;
		} // switch
			
		i++;
	}	
		
	for (int index = 0; index < i-1; index++) {
		System.out.println("***:" +
				String.format("%32s",Integer.toBinaryString(code[index])).replace(" ","0"));
	}
	}
}
