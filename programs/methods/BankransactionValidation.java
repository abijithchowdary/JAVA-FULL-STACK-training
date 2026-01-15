import java.util.Scanner;
class BankransactionValidation
{
	public static void main(String[] args) 
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("enter your balance : ");
	int balance = sc.nextInt();
	System.out.println("enter your balance Withdraw Amount: ");
	int withdrawAmount = sc.nextInt();
	System.out.println(m1(balance,withdrawAmount));
	}
	public static String m1(int balance,int withdrawAmount){
	if(balance >= withdrawAmount && withdrawAmount > 0){
	return "You transaction can process Scussfully";
	}else { 
	return "You cannot process this Transaction becouse you have less balance ";
	}
	}
}
