package javaOops;


class animal{
	
	public animal() {
		System.out.println("animal construtor");
	}
	
	public void animalMethod() {
		System.out.println("animal method");
	}
}

class bird extends animal{
	public bird() {
		System.out.println("bird construtor");
	}
	
	public void birdMethod() {
		System.out.println("bird method");
	}
	
	public void birdMethodOverRide() {
		System.out.println("over riden bird method");
	}
}

class Inheritance extends bird{
	
	public Inheritance() {
		System.out.println("Inheritance construtor");
	}
	
	public void InheritanceMethod() {
		System.out.println("Inheritance method");
	}
	
	@Override
	public void birdMethodOverRide() {
		System.out.println("over riden bird method in inheritance class");
	}
	
	public static void main(String[] args) {
		Inheritance obj = new Inheritance();
		obj.InheritanceMethod();
		obj.animalMethod();
		obj.InheritanceMethod();
		// creating object for child class with parent class reference. we can only access parent class methods and overriden child class methods
		bird obj1 = new Inheritance();
		obj1.birdMethod();
		obj1.animalMethod();
		obj1.birdMethodOverRide();
		
		// when object is created for the same class then it can access its and parents methods only
		bird obj2 = new bird();
		obj2.birdMethodOverRide();
		
	}
}
