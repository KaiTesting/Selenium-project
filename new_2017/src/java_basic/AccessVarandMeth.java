package java_basic;

public class AccessVarandMeth {
int StudentNum;

public AccessVarandMeth(String name){
	System.out.println("Student name is "+name);
}
public void setStudentnum(int num){
	StudentNum=num;
}
public int getNum(){
	System.out.println("Student number is "+StudentNum);
	return StudentNum;
}
public static void main (String[]arg){
	
	
	AccessVarandMeth StuObj= new AccessVarandMeth("Tommy");
	StuObj.setStudentnum(101);
	StuObj.getNum();
	System.out.println("AccessVar is "+StuObj.StudentNum);
}
}
