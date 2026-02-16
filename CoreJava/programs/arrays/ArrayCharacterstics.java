import java.util.Arrays;
import java.util.Scanner;

class  ArrayCharacterstics
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		//initialization of array
		
		int[] a = {1,2,3,4,5};
		
		int b[] = {1,2,3,4,5};
		
		int c[] = new int[]{1,2,3,4,5};
		
		int d[] = new int[5];
		
		int e[] = new int[sc.nextInt()];
		
		//int c[] = new int[5]{}; this is an error of illigal expression cuz [5] gives size and {}also generates size so the error occer
		
		//int c[] = new int[]{}; this doesnt give error but it cant give any output becouse the size is defined two times and compiler got confused
		
		
		
		//printing 2 types
		
		System.out.println(a[1]);
		
		System.out.println(Arrays.toString(a));
		
		
		
		//
		
		
	}
}
