import java.util.Scanner;

class ticketConformation 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter avaliable Steats : ");
		int avaliableSeats = sc.nextInt();
		System.out.print("Enter if rac is avaliable or not : ");
		boolean rac = sc.nextBoolean();
		if(avaliableSeats > 0 && rac == false){
			System.out.println("your Seat is conformed");
		}else if(avaliableSeats > 0 && rac == true){
			System.out.println("your Seat is conformed in rac");
		}else if(avaliableSeats < 0 && rac == true){
			System.out.println("Your ticket is in waiting list");
		}else{
			System.out.println("out of tickets");
		}
	}
}
