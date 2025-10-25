package javaOops;

public class EncapsulationPrepTest{
	
	private int id;
	private String name;
	
	public EncapsulationPrepTest(int id, String name) {
      // Read the explanation for usage of this at the end		
		this.id = id;
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static void main(String[] args) {
		EncapsulationPrepTest obj = new EncapsulationPrepTest(1,"prash");
		EncapsulationPrepTest obj2 = obj;
		
		
		obj.setId(2);
		System.out.println("Id: "+ obj.getId() +" Name: "+obj.getName());
		System.out.println("Id: "+ obj2.getId() +" Name: "+obj2.getName());
		obj2.setName("Prashanth");
		System.out.println("Id: "+ obj.getId() +" Name: "+obj.getName());
		System.out.println("Id: "+ obj2.getId() +" Name: "+obj2.getName());
	}
	
	
}

/*
You’re asking about the use of the keyword this in your code. Let’s break it down clearly.

1. What this does here

In your class:

private int id;
private String name;

public EncapsulationPrepTest(int id, String name) {
    this.id = id;
    this.name = name;
}


this.id refers to the instance variable id of the current object.

id (without this)14 refers to the parameter id of the constructor.

Because your constructor parameters have the same names as the instance variables, this is needed to distinguish between the two.

Without this:

id = id;   // assigns the parameter id to itself (useless, instance variable unchanged)
name = name; // same issue


So the fields this.id and this.name would remain uninitialized (default values):

id = 0

name = null

2. What happens in your setters
public void setId(int id) {
    this.id = id;   // assign parameter to the object's field
}
public void setName(String name) {
    this.name = name;
}


Again, without this, the assignment would just set the parameter to itself and do nothing to the actual field.

3. What if we don’t use this?

Your constructor won’t initialize the object’s fields properly.

Setters won’t work — they’ll look like they’re doing something, but the instance variables won’t change.

Example:

EncapsulationPrepTest obj = new EncapsulationPrepTest(1,"prash");
System.out.println(obj.getId());   // prints 0 instead of 1
System.out.println(obj.getName()); // prints null instead of "prash"


Because the constructor would be effectively:

id = id;       // does nothing
name = name;   // does nothing


this is required when local variable names shadow instance variables (like in your constructor and setters).

Without this, assignments won’t work as intended, and fields will remain with their default values.

*/