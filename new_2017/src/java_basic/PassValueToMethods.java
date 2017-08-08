package java_basic;

//pass multiple value to methods
public class PassValueToMethods {

	static int[] getsumofAB(int a, int b,int c){
		int[]ans=new int [3];
		ans[0]=a+b;
		ans[1]=a-b;
		ans[2]=a+b+c;
		return ans;
		
		
	}
	public static void main(String []args){
		PassValueToMethods obj=new PassValueToMethods();
		//int[]ans=obj.getsumofAB(10, 20, 30);
		int[]ans=getsumofAB(45, 45, 45);
System.out.println("sum of a+b is "+ans[0]);
System.out.println("subtration of a-b is "+ans[1]);
System.out.println("sum of a+b+c is "+ans[2]);
	}
}
