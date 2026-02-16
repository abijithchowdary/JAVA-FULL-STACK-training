import java.util.*;
class Secondhalfofarray
{
	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter the size of a array : ");
		int[] a = new int[sc.nextInt()];
		
		for(int i=0;i<a.length;i++){
			System.out.println("Enter the element number " + (i+1) +" :");
			a[i] = sc.nextInt();
		}
		for(int i=a.length/2;i<a.length;i++){
			System.out.println(a[i]);
		}
		
	}
}
