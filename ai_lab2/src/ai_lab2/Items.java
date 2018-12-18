package ai_lab2;

import java.util.LinkedList;

public class Items {
	private LinkedList<Item> items = new LinkedList<>();
	
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
		return items.remove(index);
	}
	
	public Item peek(int index) {
		return items.get(index);
	}
	
	/**
	 *  O(1)
	 */
	public Item removeBestBenefitItem() {
		if (items.isEmpty()) return null;
		return items.removeFirst();
	}
	
	/**
	 *  O(1)
	 */
	public Item removeWorstBenefitItem() {
		if (items.isEmpty()) return null;
		return items.removeLast();
	}
	
	/**
	 * O(N) 
	 */
	public Item removeHighestValue() {
		if (items.isEmpty()) return null;
		int bestValue = Integer.MIN_VALUE;
		int bestIndex = -1;
		for (int i = 0; i < items.size(); i++) {
			int currentItemValue = items.get(i).getValue();
			if (currentItemValue > bestValue) {
				bestValue = currentItemValue;
				bestIndex = i;
			}
		}
		return items.remove(bestIndex);
	}
	
	
	public Item removeLowestValue() {
		if (items.isEmpty()) return null;
		int lowestValue = Integer.MAX_VALUE;
		int lowestIndex = -1;
		for (int i = 0; i < items.size(); i++) {
			int currentItemValue = items.get(i).getValue();
			if (currentItemValue < lowestValue) {
				lowestValue = currentItemValue;
				lowestIndex = i;
			}
		}
		return items.remove(lowestIndex);
	}
	
	/**
	 * O(N) 
	 */
	public Item removeLowestWeight() {
		if (items.isEmpty()) return null;
		int bestWeight = Integer.MAX_VALUE;
		int bestIndex = -1;
		for (int i = 0; i < items.size(); i++) {
			int currentItemWeight = items.get(i).getWeight();
			if (currentItemWeight < bestWeight) {
				bestWeight = currentItemWeight;
				bestIndex = i;
			}
		}
		return items.remove(bestIndex);
	}
	
	public void printItems() {
		for (Item i : items) {
			System.out.println("\titem: " + i.toString());
		}
	}
	
	public int size() {
		return items.size();
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}
}
