package learning_selenium_2017;

import java.util.Scanner;
public class Scaner_calculator {

	public static void main(String[] args) {
		
		Scanner var1= new Scanner(System.in);
		int fnum,snum,ans;
		
		System.out.println("Enter first number: ");
		fnum=var1.nextInt();
		System.out.println("Enter Second number: ");
		snum=var1.nextInt();
		ans=fnum+snum;
		System.out.println(ans);
		
		
		 
	}

}
