import java.util.Scanner;

class q3 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int CartValue = sc.nextInt();
		String Result = ((CartValue >= 499)?"Free Delivery":"Delivery charge will be added");
		System.out.println(Result);
	}
}
