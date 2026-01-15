import java.util.Scanner;
class ProductAlphabet 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		long res=1;
		for(long i='A';i<'Z';i++)
		{
			if(i%2 != 0){
				res *= i; 
				
			}
		}
		System.out.println(res);
}
}