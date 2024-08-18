package javaOops;

public class Encapsulation {
	private int empId;
	private String name;
	private String company;
	
	
	public Encapsulation(int empId, String name, String company) {
		this.empId = empId;
		this.name = name;
		this.company = company;
	}
	
	
	public void setEmpid(int empId) {
		this.empId=empId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCompany(String company) {
		this.company=company;
	}
	public String getName() {
		return name;
	}
	
	
	public int getEmpid() {
		return empId;
	}
	
	public String getCompany() {
		return company;
	}
	
	
	public static void main (String [] args) {
		Encapsulation enc = new Encapsulation(1177580,"prashanth","infosys");
		
		System.out.println("empId is: "+enc.getEmpid());
		System.out.println("name is: "+enc.getName());
		System.out.println("company is: "+enc.getCompany());
		
		Encapsulation enc1 = enc;
		enc1.setEmpid(1);
		
		System.out.println("empId is: "+enc.getEmpid());
		System.out.println("empId is: "+enc1.getEmpid());
		
	}
	
}
