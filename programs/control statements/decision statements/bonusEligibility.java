import java.util.Scanner;
class  bonusEligibility
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee experience : ");
		int exp = sc.nextInt();
		System.out.print("Enter employee rating : ");
		int rating = sc.nextInt();
		
		if( exp >= 5 && rating >= 4){
			System.out.print("employee is eligible for bonus");
		}else{
			System.out.print("Employee is not eligible for bonus");
		}
	}
}
