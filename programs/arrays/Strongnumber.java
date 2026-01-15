import java.util.Scanner;
class DisariumNumber 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the num1: ");
		int num1 = sc.nextInt();
		System.out.print("Enter the num2: ");
		int num2 = sc.nextInt();
		
		
		for(int i=num1;i<=num2;i++){
			if(isDisariumNumber(i)){
				System.out.print(i + " ");
			}
		}
	}
	public static boolean isDisariumNumber(int num){
		double res = 0;
		int len = 0;
		int dup1 = num;
		int dup2 = num;
		while (dup1 > 0)
		{
			len++;
			dup1 /= 10;
		}
		while (num > 0)
		{
			int rem = num % 10;
			res += Math.pow(rem,len);
			len--;
			num /= 10;
		}
		if(res == dup2){
			return true;
		}
		return false;
	}
}
