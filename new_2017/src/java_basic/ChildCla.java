package java_basic;

/**
 * @author kevser
 *
 */
public class ChildCla extends JavaPractice{
	String s1,s2;
	public ChildCla()
	
	{
		
		s1="FromChildclass";
		s2="newOutput";
	
		
	}
	public void dis()
	{
		System.out.println("String1 is "+super.s1);
		System.out.println("String12 is "+super.s2);
	}
	public static void main(String[]arg){
		ChildCla obj = new ChildCla();
		obj.dis();
		
	}
}
