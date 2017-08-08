package java_basic;

public class Employee {
String name;
int age;
double salary;
String designation;
public static final String word="hello";

public Employee(String name){
	this.name=name;//(this key word)refer to current class instance variable
}
public void empAge(int empAge){
	age=empAge;
}

public void empSalary(double empSalary)
{
salary=empSalary;
}

public void empDesination(String empDesination)
{
	designation=empDesination;
}

public void printEmployInfon()
{
	System.out.println("Employee name "+name);
	System.out.println("Employee name "+age);
	System.out.println("Employee name "+salary);
	System.out.println("Employee name "+designation);
	
}
}
