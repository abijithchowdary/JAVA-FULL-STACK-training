class WithdrawableOrNot 
{
	public static void main(String[] args) 
	{
		double balance = 4345.76;
		double withdraw = 538;
		String res = ((balance>0 && withdraw<balance)?"withdrawable":"Not withdrawable");
		System.out.println(res);
	}
}
