package Model;

import java.io.Serializable;

public class Person implements Serializable  {
private String name;
private Date d;
private Address address;
private String phone;
private String email;

public Person(){
	
}
public Person(String n,Date da,Address a,String p,String e){
	name=n;
	d=da;
	address=a;
	phone=p;
	email=e;
}
public void setName(String n){
	name=n;
}

public Date getD() {
	return d;
}
public void setD(Date d) {
	this.d = d;
}
public void setAdd(Address a){
	address=a;
}
public void setPh(String p){
	phone=p;

}
public void setEmail(String e){
	email=e;
}
public String getName(){
	return name;
}
public Address getAdd(){
	return address;
}
public String getPh(){
	return phone;
}
public String getEmail(){
	return email;
}
public void DisplayP(){
	System.out.println("\nThe name is: "+name);
	address.DisplayAd();
	System.out.println("The phone is: "+phone);
	System.out.println("The email is: "+email);
}
}
