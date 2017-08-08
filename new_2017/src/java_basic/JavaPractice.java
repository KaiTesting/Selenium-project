package java_basic;

import java.util.Scanner;


public class JavaPractice {
	
	String s1="Parentclass";
	String 	s2="OutputString";
	public  JavaPractice(){
		
	
		
	}
	
public static class ChildCla extends JavaPractice{
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
}



	//local variable only can hava final modifier
//Instance variable should placed ouside of method, it can access inside any method,constructor or block in that particular class

