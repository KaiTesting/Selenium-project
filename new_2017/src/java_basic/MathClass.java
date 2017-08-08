package java_basic;

import java.util.Random;

public class MathClass {

	public static void main(String[] args) {
		//Basic math operator
	/*	System.out.println(Math.abs(70.9));
		System.out.println(Math.abs(-70.9));
		System.out.println(Math.ceil(5.1));
		System.out.println(Math.floor(6.9));
		System.out.println(Math.max(8.6, 8.7));
		System.out.println(Math.min(8.6, 5.6));
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.sqrt(25));
		
		//Genrate random number
		Random dice = new Random();
		int num;
		
		for(int counter=1;counter<=5;counter++){
			
			num=dice.nextInt(100);
			System.out.println(num);
			
			
			
		}
		//"\t" is tab function 
		System.out.println("Index\tValue");
		int k[]={10,12,15,20};
		for(int i = 0;i<k.hashCode();i++){
			System.out.println(i+"\t"+k[i]);
		}*/
		int f[]={10,12,15,20};
		int sum=0;
		for(int i = 0;i<f.length;i++){
			sum+=f[i];
			
	}
		System.out.println("sum of these number is "+sum);
}
}