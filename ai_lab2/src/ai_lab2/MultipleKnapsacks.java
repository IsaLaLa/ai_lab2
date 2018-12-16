package ai_lab2;

import java.util.ArrayList;

public class MultipleKnapsacks {
	private ArrayList<Knapsack> knapsacks;
	private ArrayList<Item> items;

	/**
	 * constructor
	 */
	public MultipleKnapsacks() {
		knapsacks = new ArrayList<Knapsack>();
		items = new ArrayList<Item>();
	}
	
	/**
	 * returns the list of knapsacks
	 * @return
	 */
    public ArrayList<Knapsack> getKnapsacks() {
        return knapsacks;
    }
    
    /**
     * returns the list of items
     * @return
     */
    public ArrayList<Item> getItems() {
        return items;
    }
    
    /**
     * adds a knapsack to the knapsack-list
     * @param knapsack
     */
    public void addKnapsack(Knapsack knapsack) {
    	if(knapsack != null) {
    		knapsacks.add(knapsack);
    	}
    }
    
    /**
     * a greedy solution to the multiple knapsack problem
     * @param items
     */
    public void greedySolution(ArrayList<Item> items) {
    	//to be implemented
    }
	
    /**
     * solving the multiple knapsack problem by using neighborhood search
     */
	public void neighborSearchSolution(ArrayList<Item> items) {
		//to be implemented
	}
	
	//.....
}
