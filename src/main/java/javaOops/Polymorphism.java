package javaOops;


interface AnimalInterface{
	// methods in the interface are by default abstract method which has to be implement in the class that implements the interface
	// Interface  can not contain constructors and data fileds as well.
	void animal();
	
}

public class Polymorphism implements AnimalInterface{

	@Override
	public void animal() {
		// TODO Auto-generated method stub
		
		System.out.println("over riding the interface method in the implemented class");
		
	}
	
	
	public void overLoadMethod() {
		System.out.println("method without parameter");
	}
	
	public void overLoadMethod(String method) {
		System.out.println("method with parameters: "+method);
	}
	
	
	public static void main (String[] args) {
		
		
		
		Polymorphism obj = new Polymorphism();
		obj.animal();
		obj.overLoadMethod();
		obj.overLoadMethod("executed");
		
		
		//Interface Cannot be instantiated directly. Classes that implement the interface provide the implementation for the methods.
		//AnimalInterface obj1 = new AnimalInterface();
		
		//we can create object for implemented class with reference of interface.
		AnimalInterface obj1 = new Polymorphism();
		obj1.animal();
		
	}

}
