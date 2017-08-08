package java_basic;

import java.util.Arrays;

public class Arr 
{
	
		
	public static int [] breakUp(String [] myArray){
		int n = myArray.length;
		int a[] = new int[n];
		int counter=0;
		for( int i = 0; i < n; i++ ) {
			try {
			int currentValue = Integer.parseInt(myArray[i]);
			a[counter++] = currentValue;
			}catch(NumberFormatException e){}
		}
		if (counter==n)
		return a;
		if (counter !=0){
			int aa[]= new int[counter];
			for (int i=0; i<counter;i++)
			aa[i]=a[i];
			return aa;
		}
		return null;
		
	}
	
	public static Object[] process(int a[]) {
		int max=a[0];
		int min=a[0];
		int sum=a[0];
		int product=a[0];
		for (int i=1;i<a.length;i++){
			sum += a[i];
			product *=a[i];
			if(max<a[i])
			max=a[i];
			else if(min>a[i])
			min=a[i];
		}
		Object o[]=new Object[10];
		o[0]="Maximum: ";
		o[1]=max;
		o[2]="Minimum: ";
		o[3]=min;
		o[4]="Total: ";
		o[5]=sum;
		o[6]="Product";
		o[7]=product;
		o[8]="Average: ";
		o[9]=(double)sum/(double)a.length;
		return o;
	}
	
	public static void main(String args[]){
		for (Object n:process(breakUp(args)))
		System.out.println(100);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	
