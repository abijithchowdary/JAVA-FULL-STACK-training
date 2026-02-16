import java.util.Scanner;

class q1 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int Stock = sc.nextInt();
		String Result = ((Stock > 0)?"Stock is avaliable":"Stock is not avaliable");
		System.out.println(Result);
	}
}
