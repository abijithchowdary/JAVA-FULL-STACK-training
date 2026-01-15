import java.util.Scanner;

class q7 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		double Bill = sc.nextDouble();
		int AmountPaid = sc.nextInt();
		String result = (((Bill - AmountPaid) < 1)?"Bill Paid":"Bill is Still Pending");
		System.out.println(result);
	}
}
