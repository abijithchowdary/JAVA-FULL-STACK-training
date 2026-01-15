class test 
{
	public static void main(String[] args) 
	{
		m1(m2(),m3(100),200);
	}
	public static void m1(double i,String x,int a){
	    System.out.println("m1() -> " + a);	
		System.out.println("m2() -> " + i);	
		System.out.println(x);	
	}
	public static double m2(){
		return 10.8957;
	}
	public static String m3(int a){
		return "m3 is "+a;
	}
}
