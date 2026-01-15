import java.util.Scanner;
class  OddNumbers
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number : ");
		int fn = sc.nextInt();
		System.out.println("Enter the first number : ");
		int sn = sc.nextInt();
		
		for (int i = fn;i<=sn;i++)
		{
			if(i%2!=0){
			System.out.println(i);
			}
		}
	}
}
