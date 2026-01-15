import java.util.Scanner;

class movieRating
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the rating :");
		double rating = sc.nextDouble();
		
		switch (rating){
		case (0 - 2.5):
			System.out.println("poor movie");
		break;
		case (2.5 - 3.5):
			System.out.println("average");
		break;
		case (3.5 to 4.5):
			System.out.println("good");
		break;
		case (4.5 to 5):
			System.out.println("Excellent");
		break;
		
		}
	}
}
