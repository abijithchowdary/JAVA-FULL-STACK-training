import java.util.*;
class avgOfevenindex
{
	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter the size of a Array : ");
		int[] a = new int[sc.nextInt()];
		
		for(int i=0;i<a.length;i++){
			System.out.println("Enter the element number " + (i+1) +" :");
			a[i] = sc.nextInt();
		}
		int sum = 0;
		for(int i=0;i<a.length;i++){
			if(i%2==0){
			sum += a[i];
			}
		}
		System.out.println("avg of even indexes are :" +(sum/(a.length/2)));
	}
}
