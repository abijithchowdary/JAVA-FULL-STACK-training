import java.util.Scanner;
class EvenAlphabet 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		for(char i='A';i<'Z';i++)
		{
			if(i%2 == 0){
				System.out.println(i);
			}
		}
}
}