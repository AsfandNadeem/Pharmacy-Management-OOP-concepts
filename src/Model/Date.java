package Model;

import java.io.Serializable;

public class Date implements Serializable{
private String date,month,year;

public Date(){
	
}
public Date(String d,String m,String y){
		
	date=d;
	month=m;
	year=y;			
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}


}
