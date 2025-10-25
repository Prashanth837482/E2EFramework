package javaOops;

public class memoryTestEncapsulsation {
	
	private String name;
	private int age;
	
	public memoryTestEncapsulsation(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
		
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	
	public static void main(String args[]) {
		memoryTestEncapsulsation test = new memoryTestEncapsulsation("test",25);
		System.out.println(test.getAge());
		System.out.println(test.getName());
		memoryTestEncapsulsation test2 = new memoryTestEncapsulsation("test2",26);
		test = test2;		
		System.out.println(test.getAge());
		System.out.println(test.getName());
		System.out.println(test2.getAge());
		System.out.println(test2.getName());
		test2.setName("EditedName");
		System.out.println(test.getName());
		System.out.println(test2.getName());
	}

}
