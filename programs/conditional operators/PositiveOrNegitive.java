class PositiveOrNegitive 
{
	public static void main(String[] args) 
	{
		int a = 3;
		String res = ((a > 0)?"Positive":((a < 0)?"Negitive":"neutral"));
		System.out.println(res);
	}
}
