package javaOops;

public class ThisSuper {

	public ThisSuper() {
		System.out.println("parent default constructor");
	}
	
	public ThisSuper(String name) {
		System.out.println("parent parameterized constructor "+name);
	}
	
	public void parentMethod() {
		String name = "prashanth";
		System.out.println("in parent method");
		System.out.println(name.length());
	}
	
	//Main method written here as the main java class(the class with filename called as main javaClass) should have main method if  given below class it fails as main method not found
	
	
	public static void main(String[] args) {
		child ChildObj = new child();
		ChildObj.parentMethod();
		
		ThisSuper ParentObj = new child();
		ParentObj.parentMethod();
		
		child ChildObj1 = new child("prashanth");
		// The above line first call child parameterized constructor as we have this() then it calls current child class's default constructor
		//This time it by default calls parent class's default parameter (super()) but we explicitly called parent's parameterized constructor with super 
		
		
		
		
	}
}

class child extends ThisSuper{
	
	public child() {
		super("prashanth");  // JVM automatically performs super() i.e. calls parent class constructor if explicity mentioned with parameters then calls only parameterized constructor only.
		System.out.println("child default constructor");
		super.parentMethod();
	}
	
	public child(String name) {
		this();  // this calls constructor of the current class
		System.out.println("child parameterized constructor "+name);
		
	}
	
	public void parentMethod() {
		String name = "ParentPrashanth";
		System.out.println("in child method");
		System.out.println(name.length());
	}
	
	

}
