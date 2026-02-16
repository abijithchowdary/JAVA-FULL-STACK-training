class VowOrCon 
{
	public static void main(String[] args) 
	{
		char a = 'A';
		String res = (((a == 'a') || (a == 'i') || (a == 'e') || (a == 'o') || (a == 'u')||(a == 'A') || (a == 'E') || (a == 'I') || (a == 'O') || (a == 'U'))?"vowel":"consonent");
		System.out.println(res);
	}
}
