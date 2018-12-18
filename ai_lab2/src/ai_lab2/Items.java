package ai_lab2;

import java.util.LinkedList;

public class Items {
	private LinkedList<Item> items;
	
	public Items() {
		items = new LinkedList<>();
	}
	
	// Used internally for copy
	private Items(LinkedList<Item> items) {
		this.items = items;
	}
	
	/**
	 * Add item and keep list sorted. O(N)
	 */
	public void add(Item item) {
		if (item != null) {
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).getBenefit() < item.getBenefit()) {
					items.add(i, item);
					return;
				}
			}
			items.addLast(item);
		}
	}
	
	public Item remove(int index) {
		if (index < 0 || index >= items.size()) return null;
		return items.remove(index);
	}
	
	public Item peek(int index) {
		if (index < 0 || index >= items.size()) return null;
		return items.get(index);
	}
	
	public int getHeaviestItemBelowWeightIndex(int maxWeight) {
		if (items.isEmpty()) return -1;
		int bestWeightSoFarIndex = Integer.MIN_VALUE;
		int bestIndex = -1;
		for (int i = 0; i < items.size(); i++) {
			int itemWeight = items.get(i).getWeight();
			if (itemWeight > bestWeightSoFarIndex && itemWeight <= maxWeight) {
				bestIndex = i;
				if (itemWeight == maxWeight) break;
			}
		}
		return bestIndex;
	}
	
	/**
	 *  O(1)
	 */
	public int getBestBenefitIndex() {
		if (items.isEmpty()) return -1;
		return 0;
	}
	
	/**
	 *  O(1)
	 */
	public int removeWorstBenefitItem() {
		if (items.isEmpty()) return -1;
		return items.size() - 1;
	}
	
	/**
	 * O(N) 
	 */
	public int getHighestValueIndex() {
		if (items.isEmpty()) return -1;
		int bestValue = Integer.MIN_VALUE;
		int bestIndex = -1;
		for (int i = 0; i < items.size(); i++) {
			int currentItemValue = items.get(i).getValue();
			if (currentItemValue > bestValue) {
				bestValue = currentItemValue;
				bestIndex = i;
			}
		}
		return bestIndex;
	}
	
	
	public int getLowestValueIndex() {
		if (items.isEmpty()) return -1;
		int lowestValue = Integer.MAX_VALUE;
		int lowestIndex = -1;
		for (int i = 0; i < items.size(); i++) {
			int currentItemValue = items.get(i).getValue();
			if (currentItemValue < lowestValue) {
				lowestValue = currentItemValue;
				lowestIndex = i;
			}
		}
		return lowestIndex;
	}
	
	public int getHighestWeightIndex() {
		if (items.isEmpty()) return -1;
		int bestWeight = Integer.MIN_VALUE;
		int bestIndex = -1;
		for (int i = 0; i < items.size(); i++) {
			int currentItemWeight = items.get(i).getWeight();
			if (currentItemWeight > bestWeight) {
				bestWeight = currentItemWeight;
				bestIndex = i;
			}
		}
		return bestIndex;
	}
	
	public int getLowestWeightIndex() {
		if (items.isEmpty()) return -1;
		int bestWeight = Integer.MAX_VALUE;
		int bestIndex = -1;
		for (int i = 0; i < items.size(); i++) {
			int currentItemWeight = items.get(i).getWeight();
			if (currentItemWeight < bestWeight) {
				bestWeight = currentItemWeight;
				bestIndex = i;
			}
		}
		return bestIndex;
	}
	
	public void printItems() {
		for (Item i : items) {
			System.out.println("\titem: " + i.toString());
		}
	}
	
	public Items copy() {
		LinkedList<Item> items = new LinkedList<Item>();
		for(Item i : this.items) {
			items.addLast(i);
		}
		return new Items(items);
	}
	
	public int size() {
		return items.size();
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}
}
