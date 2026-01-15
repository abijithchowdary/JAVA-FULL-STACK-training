import java.util.*;
class minofarray
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
		int max = 0;
		for(int i=0;i<a.length;i++){
			if(max < a[i]){
				max = a[i];
			}
		}
		int min = max;
		for(int i=0;i<a.length;i++){
			if(min > a[i]){
				min = a[i];
			}
		}
		System.out.println("min element is : "+min);
		
	}
}
