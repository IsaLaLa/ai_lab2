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
	private Items items = new Items(); //to keep track of the added items to the knapsack
	
	/**
	 * constructor
	 * @param maxCapacity
	 */
	public Knapsack(int maxCapacity) {
		if (maxCapacity < 0) throw new IllegalArgumentException("Knapsack capacity must be greater than 0");
		this.maxCapacity = maxCapacity;
		this.value = 0;
		this.weight = 0;
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
	public int getWeight() {
		return weight;
	}
	
	/**
	 * calculates and returns the knapsacks current value
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	public boolean doesItemFit(Item item) {
		if (item.getWeight() <= getFreeWeight()) return true;
		return false;
	}
	
	public int getFreeWeight() {
		return maxCapacity - weight;
	}
	
	public boolean isFull() {
		if (weight == maxCapacity) return true;
		return false;
	}
	
	public void printItems() {
		items.printItems();
	}
	
	/**
	 * adds an item to the knapsack
	 * @param item
	 * @throws Exception 
	 */
	public void addItem(Item item) throws IllegalArgumentException {
		if(item != null) {
			if (isFull()) throw new IllegalArgumentException("Knapsack is already full");
			if (!doesItemFit(item)) throw new IllegalArgumentException("item " + item.getWeight() + " does not fit, maxCap: " + maxCapacity);
			items.add(item);
			value += item.getValue();
			weight += item.getWeight();
		}
	}
	
//	/**
//	 * removes an item from the knapsack
//	 * @param item
//	 */
//	public void removeItem(Item item) {
//		if(item != null) {
//			if (items.items.remove(item)) {
//				value = value - item.getValue();
//				weight = weight - item.getWeight();	
//			}
//		}
//	}
	
//	/**
//	 * returns the knapsack´s items
//	 * @return
//	 */
//	public Items getItems() {
//		return items;
//	}
	
//	/**
//	 * returns the knapsacks item at a specific index
//	 * @return
//	 */
//	public Item getItem(int index) {
//		return items.get(index);
//	}
//	
//	/**
//	 * prints the items and properties of the knapsack
//	 */
//	public void printItems() {
//		String format1 = "%-7s %s\n";
//		String format2 = "%-7s %d\n";
//		Item currentItem;
//		
//		System.out.println("--- Items ---------------------------");
//		System.out.printf(format1, "Value", "Weight");
//		
//		for(int i = 0; i < items.size(); i++) {
//			currentItem = items.get(i);
//			System.out.printf(format2, currentItem.getValue(), currentItem.getWeight());
//		}
//		
//		System.out.println("--- Knapsack properties -------------");
//		System.out.println("Total value: " + value);
//		System.out.println("Total weight: " + weight);
//		System.out.println("Maximum capacity: " + maxCapacity);
//		System.out.println("\n");
//	}
}
