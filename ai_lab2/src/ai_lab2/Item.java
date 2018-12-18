package ai_lab2;

/**
 * Represents an item that can be added to a knapsack
 * Each item has a value and a weight, and a benefit-attribute
 */
public final class Item implements Comparable<Item> {
	private int value;
	private int weight;
	private double benefit;
	
	/**
	 * constructor
	 * @param value
	 * @param weight
	 */
	public Item(int value, int weight) {
		if (value < 0 || weight < 0) throw new IllegalArgumentException("Only positive value and weight allowed.");
		this.value = value;
		this.weight = weight;
		this.benefit = ((double)value / weight);
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
		return benefit;
	}

	@Override
	public int compareTo(Item o) {
		return Double.compare(o.benefit, this.benefit);
	}
	
	@Override
	public String toString() {
		return "value: " + value + ", weight: " + weight + ", benefit: " + benefit;
	}
}
