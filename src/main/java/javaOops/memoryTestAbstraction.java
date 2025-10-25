package javaOops;

abstract class test3{
	abstract void abstractMethod();
	
	public void normalMethodInAbstractClass() {
		System.out.println("normalMethodInAbstractClass");
	}
	
	public test3() {
		System.out.println("normalConstructtorInAbstractClass");
	}
	
	public test3(String Param) {
		System.out.println("normalConstructtorInAbstractClass with param: " + Param);
	}
}

public class memoryTestAbstraction extends test3{
	public void abstractMethod() {
		System.out.println("This is result of abstract method calling in child class");
	}
	
	public memoryTestAbstraction() {
		super();
		System.out.println("Constructor in child class");
	}
	
	
	public static void main(String args[]) {
		memoryTestAbstraction obj = new memoryTestAbstraction();
		obj.abstractMethod();
		
		
	}
}
