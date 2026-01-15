import java.util.Scanner;

class q9 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int DaysOfPurchased = sc.nextInt();
		String result = ((DaysOfPurchased <= 7)?"You can return the item":"you cannot return the item, you're returning it after a week");
		System.out.println(result);
	}
}
