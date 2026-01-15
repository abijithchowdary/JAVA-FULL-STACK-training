import java.util.Scanner;
class Tables
{
	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the number to print table : ");
		int n = sc.nextInt();
		System.out.println("Enter the numbers to print in table : ");
		int m = sc.nextInt();
		
		for(int i=1;i<=m;i++)
		{
			System.out.println(n + " * " + i + " = " + (n*i));
		}
}
}