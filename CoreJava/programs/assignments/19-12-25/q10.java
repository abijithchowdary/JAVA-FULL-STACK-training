import java.util.Scanner;

class q10 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int wishlist = sc.nextInt();
		String result = ((wishlist < 100)?"you can add this item":"you cannot add this item");
		System.out.println(result);
	}
}
