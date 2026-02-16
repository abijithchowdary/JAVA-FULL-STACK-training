import java.util.Scanner;

class AreasWithMethod 
{
	public static void main(String[] args) 
	{
		int choiceOfCalculationOrExit;
		do{
			Scanner sc = new Scanner(System.in);
	        System.out.print("Enter the choice 1.Square , 2.Rectangle , 3.Circle , 4.Rectangle : ");
	        int choiceOfAreaCalculation = sc.nextInt();
			switch (choiceOfAreaCalculation){
			case 1:
				System.out.println(Square());
			break;
			case 2:
				System.out.println(Rectangle());
			break;
			case 3:
				System.out.println(Circle());
			break;
			case 4:
				System.out.println(Triangle());
			break;
			}
			
			System.out.println("Enter your Choice true(calculateAgain) , false(Exit) : ");
			choiceOfCalculationOrExit = sc.nextInt();
			
		}while(choiceOfCalculationOrExit == 1);
	}
	public static double Square(){
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the Side to calculate area of Square : ");
	double s = sc.nextDouble();
	double res = s*s;
	return res;
	}
	public static double Rectangle(){
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the length to calculate area of Rectangle : ");
	double l = sc.nextDouble();
	System.out.print("Enter the bredth to calculate area of Rectangle : ");
	double b = sc.nextDouble();
	double res = l*b;
	return res;
	}
	public static double Circle(){
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the radius to calculate area of Circle : ");
	double r = sc.nextDouble();
	double res = 3.14 * r * r;
	return res;
	}
	public static double Triangle(){
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the base to calculate area of Triangle : ");
	double b = sc.nextDouble();
	System.out.print("Enter the height to calculate area of Triangle : ");
	double h = sc.nextDouble();
	double res = 0.5 * b * h;
	return res;
	}
}
