package ai_lab2;

/**
 * Represents an item that can be added to a knapsack
 * Each item has a value and a weight, and a benefit-attribute
 */
public class Item {
	private double value;
	private double weight;
	
	/**
	 * constructor
	 * @param value
	 * @param weight
	 */
	public Item(double value, double weight) {
		this.value = value;
		this.weight = weight;
	}
	
	//another solution ---> give random values to weight resp. value within given interval?
	/**
	 * sets the item큦 value
	 * @param value
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	/**
	 * sets the item큦 weight 
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	 * returns the item큦 value
	 * @return value
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * returns the item큦 weight
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * calculates and returns the item큦 benefit
	 * @return the items benefit
	 */
	public double getBenefit() {
		return (value / weight);
	}
}
