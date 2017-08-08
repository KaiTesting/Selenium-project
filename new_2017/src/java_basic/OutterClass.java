package java_basic;

public class OutterClass {
    String msg2="C++";
	static String msg="Java";
	static String msgS="VB";
	
	 int []arrVar=new int[5];
	 int []arrVar2={1,2,3,4,5};
	 
	
	
	//Create nested static class
	public static class NestedStaticClass
	{
		public void printMessage()
	{
			System.out.println("Message from nasted static class "+msgS);
			
	}
	}
	//Create Non-static inner class
			public class InnerNonStaticClass
			{
				public void display()
			{
				System.out.println("Message from NonStatic inner class "+msg);	
				System.out.println("Message from NonStatic inner class "+msg2);	

				
			}	
			}
		
	public static void main (String []args)
	{
		//Create instance of nested static class
		OutterClass.NestedStaticClass StaticClassObj = new OutterClass.NestedStaticClass();
		StaticClassObj.printMessage();
		
		//Create instance of inner non static class
		OutterClass.InnerNonStaticClass innerNonStaticObj = new OutterClass().new InnerNonStaticClass();
		innerNonStaticObj.display();
		
		
		
		
	}

}
