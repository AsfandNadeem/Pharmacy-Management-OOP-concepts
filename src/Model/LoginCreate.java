package Model;

import java.io.Serializable;

public class LoginCreate implements Serializable{
private String username;
private String password;

public LoginCreate()
{
	
}
public LoginCreate(String u,String p)
{
	username=u;
	password=p;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public void DisplayP()
{
	System.out.println("Username is: "+username);
	System.out.println("Password is: "+password);
}
}
