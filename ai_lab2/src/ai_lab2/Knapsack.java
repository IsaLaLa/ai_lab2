package ai_lab2;

import java.util.ArrayList;

public class Knapsack {
	private int benefit;
	private int capacity; //how much weight the knapsack is currently holding
	private int maxCapacity; //how much weight the knapsack can hold
	private ArrayList<Item> items; //keep track of the added items to the knapsack
	
	public Knapsack(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		//maxCapacity.isMutable = false; //possible to make unchangable after giving value?
		items = new ArrayList<Item>();
	}
	
	/**
	 * returns the knapsacks current capacity
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * returns the knapcacks maximum capacity
	 * @return
	 */
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public int calcBenefit(Item item) {
		return (item.getValue() / item.getWeight());
	}
	
	public void addItem(Item item) {
		
	}
	
	public void removeItem(Item item) {
		
	}
	
	//......

}
