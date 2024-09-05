package javaOops;

abstract class test {
	// abstract method which has to be implement in the class that extends the abstract class
	abstract void animal();
	// abstract class can contain constructors as well.
	public test() {
		System.out.println("abs"
				+ "tract class constructor");
	}
	
	// abstract class can contain normal methods as well and can be overriden in the child class
	public void normalMethod() {
		
		System.out.println("normal method in abstract class");
	}
	public void normalMethod2() {
		
		System.out.println("normal method2 in abstract class");
	}
	
}

 class Abstraction extends test{

	@Override
	void animal() {
		// TODO Auto-generated method stub
		
		System.out.println("animal in extended class");
		
	}
	
	public Abstraction() {
		System.out.println("extended class constructor");
	}
	
	
	@Override
	public void normalMethod() {
		
		System.out.println("normal method in overridden class");
	}
	
	
	public static void main(String[] args) {
		
		// creating object for extended class with extended class reference only.
		Abstraction obj = new Abstraction();
		obj.animal();
		obj.normalMethod();		
		// creating object for extended class with abstract class reference.
		test obj1 = new Abstraction();
		obj1.animal();
		obj1.normalMethod();
		obj1.normalMethod2();
		
		
		// we cannot create an object for the abstract class using the abstract class reference.
		// test object = new test();
		
	}

}
