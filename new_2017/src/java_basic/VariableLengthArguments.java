package java_basic;

public class VariableLengthArguments {

	public static void main(String[] args) {
	System.out.println(average(2,3,4,5));

	}
	
	
	
public static double average(double...num){
	double total=0;
	for(double c:num){
		
		total=c+total;
		
		
		
		
		
	}
	

	return total/num.length;
}


}
