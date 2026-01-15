import java.util.Scanner;
class HappyNumber 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first number : "); 
		int num1 = sc.nextInt();
		System.out.print("Enter the Second number : "); 
		int num2 = sc.nextInt();
		
		for(int i = num1;i<=num2;i++){
			if(m1(i)){
				System.out.print(i + " ");
			}
		}
	}
	public static boolean m1(int num){
		if((num == 1) || (num == 7)){
			return true;
		}
		if(num/10 == 0){
			return false;
		}
		
		int digrem = num;
		int digsum = 0;
		while(digrem > 0){
			int dig = digrem % 10;
			digsum += (dig*dig);
			digrem /= 10;
		}
		return m1(digsum);
	}
}
