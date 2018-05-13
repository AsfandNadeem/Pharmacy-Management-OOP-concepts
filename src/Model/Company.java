package Model;

import java.io.Serializable;

public class Company implements Serializable {
private String name;
private String license;

public Company(){
	
}
public Company(String n,String l)
{
	name=n;
	license=l;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLicense() {
	return license;
}
public void setLicense(String license) {
	this.license = license;
}


}
