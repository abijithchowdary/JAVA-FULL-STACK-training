import java.util.Scanner;

class workSchedule 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the day in number : ");
		int day = sc.nextInt();
		
		switch (day){
			case 1:
				System.out.println("It's  a weekday");
			break;
			case 2:
				System.out.println("It's  a weekday");
			break;
			case 3:
				System.out.println("It's  a weekday");
			break;
			case 4:
				System.out.println("It's  a weekday");
			break;
			case 5:
				System.out.println("It's  a weekday");
			break;
			case 6:
				System.out.println("It's  a weekend");
			break;
			case 7:
				System.out.println("It's  a weekend");
			break;
		}
	}
}
