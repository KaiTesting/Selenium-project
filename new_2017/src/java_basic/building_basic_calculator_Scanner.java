package java_basic;

import java.util.Scanner;

public class building_basic_calculator_Scanner {

	public static void main(String[] args) {
		Scanner var = new Scanner(System.in);
		double fn,sn,an;
		System.out.println("Enter first number");
		fn=var.nextDouble();
		System.out.println("Enter second number");
		sn=var.nextDouble();
		an=fn+sn;
		
		if (an<fn+sn){
			System.out.println("This is not possible");
		}else{
			System.out.println(an);

		}
		
	}

}
