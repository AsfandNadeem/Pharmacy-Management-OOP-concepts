package Model;

import java.io.Serializable;

public class MedicineDetail implements Serializable{
	private String name;
	private String id;
	private Date manufacturing;
	private Date expiry;
	private Company ma;
	private String quantity;
	private String cost;

	
	public MedicineDetail(String n,String i,Date m,Date e,Company c,String q,String co)
	{
		name=n;
		id=i;
		manufacturing=m;
		expiry=e;
		ma=c;
		quantity=q;
		cost=co;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getManufacturing() {
		return manufacturing;
	}
	public void setManufacturing(Date manufacturing) {
		this.manufacturing = manufacturing;
	}
	public Date getExpiry() {
		return expiry;
	}
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	public Company getMa() {
		return ma;
	}
	public void setMa(Company ma) {
		this.ma = ma;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String toString() {
		return this.name + ", " + this.id+ ", " + this.manufacturing+ ", " + this.expiry+ ", " + this.ma+ ", " + this.quantity;
	}
}
