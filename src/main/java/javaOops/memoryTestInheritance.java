package javaOops;

class parent{
	
	public parent() {
		System.out.println("super class parameterless constructor");
	}
	public parent(String name, int age) {
		System.out.println("super class parameterized constructor where name: "+name+" age: "+age);
	}
	
	public void superMethod() {
		int a =1;
		int b=2;
		System.out.println("superMethod parameterless outputs is: "+a+b);
	}
	
	public void superMethodParameterized(int num1, int num2) {
		int num3 = num1+ num2;
		System.out.println("superMethodParameterized output is : "+num3);
	}
}

public class memoryTestInheritance extends parent{
	
	public memoryTestInheritance() {
		super("prashanth",25);
		super.superMethod();
		System.out.println("child class parameterless constructor");
	}
	
	public memoryTestInheritance(String name, int age) {
		super("check",5);
		System.out.println("super class parameterized constructor where name: "+name+" age: "+age);
	}
	
	public void superMethod() {
		int a =3;
		int b=4;
		System.out.println("superMethod parameterless outputs is: "+a+b);
	}
	
	public void superMethodParameterized(int num1, int num2) {
		int num3 = num1 - num2;
		System.out.println("superMethodParameterized output is : "+num3);
	}
	
	public static void main(String args[]) {
		memoryTestInheritance test = new memoryTestInheritance("prash2",52);
		test.superMethod();
		parent tes2 = new memoryTestInheritance();
		tes2.superMethod();
	}
}