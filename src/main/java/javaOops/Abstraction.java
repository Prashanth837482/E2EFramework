package javaOops;

abstract class test {
	// abstract method which has to be implement in the class that extends the abstract class
	abstract void animal();
	// abstract class can contain constructors as well.
	public test() {
		System.out.println("abstract class constructor");
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
	
	
	public static void main(String[] args) {
		
		// creating object for extended class with extended class reference only.
		Abstraction obj = new Abstraction();
		obj.animal();
		// creating object for extended class with abstract class reference.
		test obj1 = new Abstraction();
		obj1.animal();
		
	}

}
