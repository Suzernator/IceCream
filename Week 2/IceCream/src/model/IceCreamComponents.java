package model;
/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Jan 26, 2022
 */
public class IceCreamComponents {
	private String vessel;
	private int scoop;
	private String flavor;
	private boolean topping;
	
	public IceCreamComponents() {
		//default no-arg constructor
	}
	
	public IceCreamComponents(String vessel, int scoop, String flavor, boolean topping) {
		this.vessel = vessel;
		this.scoop = scoop;
		this.flavor = flavor;
		this.topping = topping;
	}

	public String getVessel() {
		return vessel;
	}

	public void setVessel(String vessel) {
		this.vessel = vessel;
	}

	public int getScoop() {
		return scoop;
	}

	public void setScoop(int scoop) {
		this.scoop = scoop;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public boolean getTopping() {
		return topping;
	}

	public void setTopping(boolean topping) {
		this.topping = topping;
	}
	

}
