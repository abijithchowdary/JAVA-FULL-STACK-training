package com.capg.exception;
import java.util.*;

public class ExceptionCapg2 {
	public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        GadgetValidator obj = new GadgetValidator();

        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){

            String input = sc.nextLine(); // T283:Television:10
            String[] arr = input.split(":");

            try{
                obj.validateGadgetID(arr[0]);
                obj.validateWarrantyPeriod(Integer.parseInt(arr[2]));

                System.out.println("Warranty accepted, stock updated");

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
class InvalidGadgetException extends Exception{
    InvalidGadgetException(String msg){
        super(msg);
    }
}

class GadgetValidator{

    public boolean validateGadgetID(String id) throws InvalidGadgetException{

        if(id.matches("[A-Z]\\d+")){
            return true;
        }
        throw new InvalidGadgetException("Invalid gadget ID");
    }

    public boolean validateWarrantyPeriod(int period) throws InvalidGadgetException{

        if(period>=6 && period<=36){
            return true;
        }
        throw new InvalidGadgetException("Invalid warranty period");
    }
}