package ai_lab2;

public class Item {
	private double value;
	private double weight;
	
	public Item(double value, double weight) {
		this.value = value;
		this.weight = weight;
	}
	
	//another solution ---> give random values to weight resp. value within given interval?
	public void setValue(double value) {
		this.value = value;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getValue() {
		return value;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double calcBenefit() {
		return (value / weight);
	}

}
