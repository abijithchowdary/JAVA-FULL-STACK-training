import java.util.Scanner;

class q2 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int Quantity = sc.nextInt();
		int PurchasingQuantity = ;
		String Result = ((Quantity < 0)?"Out of Stock":((PurchasingQuantity <= 5)?"Happy Shoping":"You Cant Buy, Your Purchasing Quantity is more than 5"));
		System.out.println(Result);
	}
}
