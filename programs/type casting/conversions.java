import java.util.Scanner;

class conversions 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		//implicit //wideing
		int a = sc.nextByte();
		
		//explicit //narrowing
		short s = (short) sc.nextInt();
		
		System.out.println(a);
		System.out.println(s);
	}
}
