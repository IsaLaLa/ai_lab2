package ai_lab2;

import java.util.ArrayList;

/**
 * Represents a knapsack that can hold a set of items.
 * The knapsack has a limited amount of weight 
 * that it can hold (i.e. maximum capacity)
 * Other attributes include a knapsacks total value and weight
 *
 */
public class Knapsack {
	private final int maxCapacity; //how much weight the knapsack can hold, unchangeable once set
	private int value; //how much value the knapsack currently has
	private int weight; //how much the knapsack is currently weighting
	private ArrayList<Item> items; //to keep track of the added items to the knapsack
	
	/**
	 * constructor
	 * @param maxCapacity
	 */
	public Knapsack(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.value = 0;
		this.weight = 0;
		items = new ArrayList<Item>();
	}
	
	/**
	 * returns the knapsacks maximum capacity
	 * @return maxCapacity
	 */
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	/**
	 * calculates and returns the knapsacks current weight
	 * @return
	 */
	public int getTotalWeight() {
		for(int i = 0; i < items.size(); i++) {
			weight += items.get(i).getWeight();
		}
		return weight;
	}
	
	/**
	 * calculates and returns the knapsacks current value
	 * @return
	 */
	public int getTotalValue() {
		for(int i = 0; i < items.size(); i++) {
			value += items.get(i).getValue();
		}
		return value;
	}
	
	/**
	 * adds an item to the knapsack
	 * @param item
	 */
	public void addItem(Item item) {
		if(item != null) {
			items.add(item);
			value += item.getValue();
			weight += item.getWeight();
		}
	}
	
	/**
	 * removes an item from the knapsack
	 * @param item
	 */
	public void removeItem(Item item) {
		if(item != null) {
			items.remove(item);
			value -= item.getValue();
			weight -= item.getWeight();	
		}
	}
	
	/**
	 * returns the knapsack´s items
	 * @return
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
}
