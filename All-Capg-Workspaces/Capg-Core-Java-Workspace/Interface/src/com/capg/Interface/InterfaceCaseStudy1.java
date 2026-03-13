import java.util.Scanner;
import java.util.*;
interface Room{

    public double calculateTotalBill(int nightStayed,int joiningYear);

    default int calculateMembershipYears(int joiningYear){
        return 2025 - joiningYear;
    }
}
class HotelRoom implements Room{

    String roomType;
    double ratePerNight;
    String guestName;

    HotelRoom(String roomType,double ratePerNight,String guestName){
        this.roomType = roomType;
        this.ratePerNight = ratePerNight;
        this.guestName = guestName;
    }
    
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getRatePerNight() {
        return ratePerNight;
    }

    public void setRatePerNight(double ratePerNight) {
        this.ratePerNight = ratePerNight;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public double calculateTotalBill(int nightStayed,int joiningYear){

        double totalBill = ratePerNight * nightStayed;

        if(calculateMembershipYears(joiningYear) > 3){
            return (0.9) * totalBill;
        }
        return totalBill;
    }
}
public class InterfaceCaseStudy1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Deluxe Room Details: ");

        System.out.print("Guest Name: ");
        String name = sc.nextLine();
        System.out.print("Rate per Night: ");
        double rate = sc.nextDouble();
        System.out.print("Nights Stayed: ");
        int nightStayed = sc.nextInt();
        System.out.print("Joining Year: ");
        int year = sc.nextInt();

        sc.nextLine();
        
        HotelRoom obj1 = new HotelRoom("Deluxe",rate, name);

        System.out.println("Enter Suite Room Details: ");

        System.out.print("Guest Name: ");
        String name1 = sc.nextLine();
        System.out.print("Rate per Night: ");
        double rate1 = sc.nextDouble();
        System.out.print("Nights Stayed: ");
        int nightStayed1 = sc.nextInt();
        System.out.print("Joining Year: ");
        int year1 = sc.nextInt();

        HotelRoom obj2 = new HotelRoom("Suite",rate1, name1);

        System.out.println("Room Summary:");

        System.out.println("Deluxe Room:" + obj1.getGuestName() + ", " + obj1.getRatePerNight() + " per night, Membership: " + obj1.calculateMembershipYears(year));
        System.out.println("Suite Room:" + obj2.getGuestName() + ", " + obj2.getRatePerNight() + " per night, Membership: " + obj2.calculateMembershipYears(year1));

        System.out.println("Total Bill:");

        System.out.println("For " + obj1.getGuestName() + "(" + obj1.getRoomType() + "):" + obj1.calculateTotalBill(nightStayed, year));
        System.out.println("For " + obj2.getGuestName() + "(" + obj2.getRoomType() + "):" + obj2.calculateTotalBill(nightStayed1, year1));

    }
}
