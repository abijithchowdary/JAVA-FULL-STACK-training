import java.util.Scanner;

class calculater 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the action you want to perform 1.add(+), 2.sub(-), 3.mul(*), 4.div(/): ");
		int choice = sc.nextInt();
		int fn,sn;
		
		switch (choice){
			case 1:
				System.out.print("Enter first number : ");
		        fn = sc.nextInt();
		        System.out.print("Enter Second number : ");
		        sn = sc.nextInt();
				System.out.println(fn+sn);
			break;
			case 2:
				System.out.print("Enter first number : ");
		        fn = sc.nextInt();
		        System.out.print("Enter Second number : ");
		        sn = sc.nextInt();
				System.out.println(fn-sn);
			break;
			case 3:
				System.out.print("Enter first number : ");
		        fn = sc.nextInt();
		        System.out.print("Enter Second number : ");
		        sn = sc.nextInt();
				System.out.println(fn*sn);
			break;
			case 4:
				System.out.print("Enter first number : ");
		        fn = sc.nextInt();
		        System.out.print("Enter Second number : ");
		        sn = sc.nextInt();
				System.out.println(fn/sn);
			break;
			}
	}
}
