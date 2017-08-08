package java_basic;

public class Counter2 {
  int code;
	
	
	
	
	
	 
	
	 
	 public static void main(String[]arg){
		 Counter2 obj = new Counter2();
		 Counter2 obj1 = new Counter2();
		 obj.setcode(456);
		 obj.setcode(789);
		 
		 System.out.println(obj.getcode());
		 System.out.println(obj1.getcode());
		
	 }
	 
	 public int getcode(){
		 
		 return code;
		 
	 }
	 public void setcode(int value){
		 code=value;
	 }
}

