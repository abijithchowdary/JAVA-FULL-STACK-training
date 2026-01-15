import java.util.Scanner;
class ElecBillCal
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter units: ");
		double cUnits=sc.nextDouble();	
		System.out.print("Consumer type: ");
		sc.nextLine();
		String type = sc.nextLine();
		String mess=calculateBill(cUnits,type);
		System.out.println(mess);
	}
	public static String calculateBill(double cUnits,String type){
		double prevUnits=50;
		double units=cUnits-prevUnits;
		double price=0;
		if(units>=0){
			if(type.equals("domestic")){
				price=50;
				if(units>0 && units<=100){
					price+=units*4.29;
				}
			    else if(units>100 && units<=300){
				    price+=(units-100)*6.67+(100*4.29);
			    }
			    else{
				    price+=(units-300)*7.75+(200*6.67)+(100*4.29);
			    }
			}
			else if (type.equals("commercial"))
			{
				price=70;	
				if(units>0 && units<=100){
					price+=units*6.91;
				}
			    else if(units>100 && units<=500){
				    price+=(units-100)*7.17+(100*6.91);
			    }
			    else{
				    price+=(units-500)*7.75+(400*7.17)+(100*6.91);
			    }
			}
			else{
				return "Invalid Type!";
			}
		}
		else{
			return "Invalid range of units";
		}
		return "Your bill: "+price;
		
	}
}
