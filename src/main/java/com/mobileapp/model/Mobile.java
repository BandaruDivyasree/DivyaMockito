package com.mobileapp.model;

public class Mobile {
	private String model;
	private String brand;
	private String mobileId;
	private String storage;
	private String Os;
	private String price;

	public Mobile(int i, String string, String string2, double d) {
		// TODO Auto-generated constructor stub
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMobileId() {
		return mobileId;
	}

	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}

	
	  public String getPrice() { return price; } public void setPrice(String price)
	  { this.price = price; }
	 
	@Override
	public String toString() {
		return "Mobile [brand=" + brand + ", mobileId=" + mobileId + "]";
	}

}
