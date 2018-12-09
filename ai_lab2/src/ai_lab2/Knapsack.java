package ai_lab2;

import java.util.ArrayList;

public class Knapsack {
	private final int maxCapacity; //how much weight the knapsack can hold, unchangeable once set
	private int value; //how much value the knapsack currently has
	private int weight; //how much the knapsack is currently weighting
	private ArrayList<Item> items; //to keep track of the added items to the knapsack
	
	public Knapsack(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.value = 0;
		this.weight = 0;
		items = new ArrayList<Item>();
	}
	
	/**
	 * returns the knapsacks maximum capacity
	 * @return
	 */
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public int getTotalWeight() {
		for(int i = 0; i < items.size(); i++) {
			weight += items.get(i).getWeight();
		}
		
		return weight;
	}
	
	public int getTotalValue() {
		for(int i = 0; i < items.size(); i++) {
			value += items.get(i).getValue();
		}
		
		return value;
	}
	
	public void addItem(Item item) {
		items.add(item);
		value += item.getValue();
		weight += item.getWeight();
	}
	
	public void removeItem(Item item) {
		items.remove(item);
		value -= item.getValue();
		weight -= item.getWeight();
	}
	
	//......

}
