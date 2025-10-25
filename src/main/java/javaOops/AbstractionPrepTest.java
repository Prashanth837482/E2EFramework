package javaOops;



abstract class absClass{
	
	abstract void absMethod();
	
	public void interfaceMethod() {
		System.out.println("In abs class..");
	}
	
	public absClass() {
		System.out.println("Abs cons.");
	}
	
	public absClass(int num) {
		System.out.println("Abs cons."+num);
	}
}


public class AbstractionPrepTest extends absClass{	
	
	@Override
	public void interfaceMethod() {
		System.out.println("In extended class..");
		
	}
	
	public void absMethod() {
		System.out.println("Abs method in child..");
	}
	
	public void absMethod(String test) {
		System.out.println("Abs method in child.."+test);
	}
	
	public AbstractionPrepTest() {
		//super(2);
		System.out.println("Child constructore");
	}
	
	public AbstractionPrepTest(String param) {
		this();		
		System.out.println("Child constructore"+param);
	}
	
	
	public static void main(String[] args) {
		AbstractionPrepTest obj = new AbstractionPrepTest();
		obj.interfaceMethod();
		
		AbstractionPrepTest obj1 = new AbstractionPrepTest("test");
		
		absClass obj2 = new AbstractionPrepTest();
		obj2.interfaceMethod();
		obj2.absMethod();
	}

	
	

	
}

