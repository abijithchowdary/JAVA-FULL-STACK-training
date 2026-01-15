import java.util.Scanner;

class bankStatus 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int minBalance = 5000;
		System.out.print("Enter your Balance : ");
		int balance = sc.nextInt();
		if(balance < minBalance){
			System.out.println("Your Account has low balance");
		}else if(balance > 5000000){
			System.out.println("Your account is Freezed");
		}else{
			System.out.println("Your Account is Active");
		}
	}
}
