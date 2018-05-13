package Model;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

	private String salary;
	private String ID;
	private String post;
	
	public Employee()
	{
		super();
	}
	public Employee(String n,Date d,Address a,String p,String e,String s,String i,String po)
	{
		super(n,d,a,p,e);
		salary=s;
		ID=i;
		post=po;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public void DisplayE()
	{
		super.DisplayP();
		System.out.println("Salary is: "+salary);
		System.out.println("Post is: "+post);
	}
	
}
