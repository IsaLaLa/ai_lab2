package ai_lab2;

import java.util.List;

public class Knapsack {
	private int benefit;
	private int capacity; //how many items the bag can fit
	private Item[] items;
	
	public Knapsack(int capacity) {
		this.capacity = capacity;
		items = new Item[capacity];
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getBenefit() {
		return benefit;
	}
	
	public int calcBenefit(Item item) {
		return (item.getValue() / item.getWeight());
	}
	
	//......

}
