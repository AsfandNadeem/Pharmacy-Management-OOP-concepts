package Model;

import java.io.Serializable;

public class Address implements Serializable {

private String home;
private String street;
private String town;

public Address(){
	
}
public Address(String h,String s,String t){
	home=h;
	street=s;
	town=t;
}
public void setHome(String h){
	home=h;
}
public void setStreet(String s){
	street=s;
}
public void setTown(String t){
	town=t;
}
public String getHome(){
	return home;
}
public String getStreet(){
	return street;
}
public String getTown(){
	return town;
}
public void DisplayAd(){
	System.out.println("House no is: "+home);
	System.out.println("Street no is: "+street);
	System.out.println("Town is: "+town);
}


}
