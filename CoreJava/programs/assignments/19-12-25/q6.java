import java.util.Scanner;

class q6
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int Price = sc.nextInt();
		int UpdatedPrice = sc.nextInt();
		String Result = ((UpdatedPrice < Price)?"Price Droped":((UpdatedPrice > Price)?"Price increased":"Price is Same"));
		System.out.println(Result);
	}
}
