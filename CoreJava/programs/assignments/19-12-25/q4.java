import java.util.Scanner;

class q4 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int CartValue = sc.nextInt();
		String Result = ((CartValue > 2000)?"Youre eigible for Discount":"Youre not eligible for discount");
		System.out.println(Result);
	}
}
