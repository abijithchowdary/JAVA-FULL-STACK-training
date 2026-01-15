import java.util.Scanner;

class q8 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int OrderAmount = sc.nextInt();
		int AvgOrderAmount = 10000;
		String result = ((OrderAmount <= AvgOrderAmount)?"Happy Shoping":"This Order is under Froud");
		System.out.print(result);
	}
}
