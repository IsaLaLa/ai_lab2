package ai_lab2;

/**
 * Represents an item that can be added to a knapsack
 * Each item has a value and a weight, and a benefit-attribute
 */
public class Item {
	private int value;
	private int weight;
	
	/**
	 * constructor
	 * @param value
	 * @param weight
	 */
	public Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
	
	/**
	 * returns the item´s value
	 * @return value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * returns the item´s weight
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * calculates and returns the item´s benefit
	 * @return the items benefit
	 */
	public double getBenefit() {
		return (double) (value / weight);
	}
}
