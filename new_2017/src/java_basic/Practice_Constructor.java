package java_basic;

public class Practice_Constructor{
//set String variable,value as name.
	String name;
	
	//create Constructor  
	Practice_Constructor(){
		System.out.println("constrator is called");
	}
	
	Practice_Constructor(String t){
		name=t;
	}
	
	public static void main(String[] args) {
		Practice_Constructor obj1= new Practice_Constructor();
		Practice_Constructor obj2= new Practice_Constructor("java");
		
		obj1.setName("vb");
		obj1.getName();
		obj2.getName();

	}

	void setName(String t){
		name=t;
		
	}
	
	void getName(){
		System.out.println("Practice_Constructorr name   "+ name);
	}
}
