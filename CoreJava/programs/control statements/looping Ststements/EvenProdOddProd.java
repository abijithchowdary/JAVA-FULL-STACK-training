import java.util.Scanner;
class  EvenProdOddProd
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number : ");
		int fn = sc.nextInt();
		System.out.println("Enter the first number : ");
		int sn = sc.nextInt();
		int res1=1,res2=1;
		for (int i = fn;i<=sn;i++)
		{
			if(i%2==0){
			res1 *= i;
			}else{
			res2 *= i;
			}
		}
		System.out.println("SUM of EVEN numbers is : " + res1); 
		System.out.println("SUM of ODD numbers is : " + res2); 
	}
}
