package java_basic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {

	String content = "one1two2three3four";
	String delimiter="\\d";
 
	Pattern pattern= Pattern.compile(delimiter,Pattern.CASE_INSENSITIVE);
	
	
	String []result=pattern.split(content);
	

	for(int i=0;i<result.length;i++){
		String Vtext=result[i];
		System.out.println(Vtext);
	}
		
		
}
}


