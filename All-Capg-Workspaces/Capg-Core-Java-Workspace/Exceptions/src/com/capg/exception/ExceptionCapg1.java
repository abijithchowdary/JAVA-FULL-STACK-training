package com.capg.exception;
import java.util.*;

public class ExceptionCapg1 {
	public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        EntryUtility obj = new EntryUtility();

        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){

            String input = sc.nextLine(); // GOAIR/8924:Security:4
            String[] arr = input.split(":");

            try{
                obj.validateEmployeeId(arr[0]);
                obj.validateDuration(Integer.parseInt(arr[2]));

                System.out.println("Valid entry details");

            }catch(InvalidEntryException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
class InvalidEntryException extends Exception{
    InvalidEntryException(String msg){
        super(msg);
    }
}

class EntryUtility{

    public boolean validateEmployeeId(String empId) throws InvalidEntryException{

        if(empId.matches("GOAIR/\\d{4}")){
            return true;
        }
        throw new InvalidEntryException("Invalid entry details");
    }

    public boolean validateDuration(int duration) throws InvalidEntryException{

        if(duration >=1 && duration <=5){
            return true;
        }
        throw new InvalidEntryException("Invalid entry details");
    }
}
