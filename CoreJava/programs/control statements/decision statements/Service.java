import java.util.Scanner;
class Service 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter youre age : ");
		int age = sc.nextInt();
		System.out.println("Enter your gender Male(M) , female(F)");
		char gender = sc.next().charAt(0);
		if(gender == 'F' || ((gender == 'M') && (age>40 && age<=60))){
			System.out.println("Employee will Work in Urban ares");
		}else if((gender == 'M') && (age>20 && age<=40)){
			System.out.println("Employee can Work Anyware");
		}else{
			System.out.println("ERROR");
		}
	}
}
