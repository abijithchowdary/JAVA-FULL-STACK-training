import java.util.*;
class avgoffirsthalfofarray
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
		int sum = 0;
		for(int i=0;i<(a.length/2);i++){
			sum += a[i];
		}
		System.out.println("avg of first half of elements are : " + sum/(a.length/2));
	}
}
