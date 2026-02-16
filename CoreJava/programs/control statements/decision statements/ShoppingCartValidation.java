import java.util.Scanner;

class ShoppingCartValidation 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("--- Shppoing Cart Validation ---");
		System.out.print("Is cart Empty?(true/false): ");
		boolean isCartEmpty = sc.nextBoolean();
		System.out.println("Enter your pincode for delivery!!");
		int pincode = sc.nextInt();
		if(!isCartEmpty)
		{
			if(pincode == 533577 || pincode == 123456 || pincode == 3458876)
			{
				System.out.println("You can checkout your items!!");
			}
			else{
				System.out.println("Pincode is not deliverable!!");
			}
		}
		else{
			System.out.println("Your cart is Empty!! Add items for check out!");
		}
	}
}