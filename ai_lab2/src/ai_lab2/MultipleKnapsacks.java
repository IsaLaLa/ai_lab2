package ai_lab2;

import java.util.ArrayList;

public class MultipleKnapsacks {
	private ArrayList<Knapsack> knapsacks;
	private ArrayList<Item> items;

	public MultipleKnapsacks() {
		knapsacks = new ArrayList<Knapsack>();
		items = new ArrayList<Item>();
	}
	
    public ArrayList<Knapsack> getKnapsacks() {
        return knapsacks;
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }
    
    public void addKnapsack(Knapsack knapsack) {
    	if(knapsack != null) {
    		knapsacks.add(knapsack);
    	}
    }
	
	public MultipleKnapsacks neighborSearch(MultipleKnapsacks knapsacks) {
		//to be implemented
		return null;
	}
}
