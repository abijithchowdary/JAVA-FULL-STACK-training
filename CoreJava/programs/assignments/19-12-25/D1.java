import java.util.Scanner;

class D1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		byte s1 = sc.nextByte();
		short s2 = sc.nextShort();
		int num = sc.nextInt();
		long a = sc.nextLong();
		float b = sc.nextFloat();
		double c = sc.nextDouble();
		char d = sc.next().charAt(0);
		sc.nextLine();
		String st = sc.nextLine();
		
		System.out.println(s1 + " " + s2 + " " + num + " " + a + " " + b + " " + c + " " + d + " " + st);
		
}
}