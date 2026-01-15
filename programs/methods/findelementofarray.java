import java.util.*;
class findelementofarray
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
		System.out.print("Enter the element to find : ");
		int n = sc.nextInt();
		int m=0;
		for(int i=0;i<(a.length);i++){
			if(n == a[i]){
				m++;
				break;
			}
		}
		if(m > 0){
			System.out.println("element is in the Array");
		}else{
			System.out.println("element is not in the Array");
		}
		
	}
}
