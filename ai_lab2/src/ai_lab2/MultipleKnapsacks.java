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
	
	/**
	 * prints all the knapsacks and their content
	 */
	public void printKnapsSacks() {
		String format = "%-7s %f\n";
		Knapsack currentKnapsack;
		ArrayList<Item> items;
		Item item;
		
		for(int i = 0; i < knapsacks.size(); i++) {
			
			System.out.println("Knapsack " + i);
			currentKnapsack = knapsacks.get(i);
			items = currentKnapsack.getItems();
			
			//skriver ut varje items value och weight för knapsack
			for(int j = 0; j < items.size(); j++) {
				item = items.get(i);
				System.out.printf(format, item.getValue(), item.getWeight());
			}
			
			System.out.println("Total value: " + currentKnapsack.getValue());
			System.out.println("Total weight: " + currentKnapsack.getWeight());
			System.out.println("Maximum capacity: " + currentKnapsack.getMaxCapacity());
			System.out.println();
		}
	}
	
	//bara för att testa att lägga till items i en knapsack, ska bort sen
	public void testAdding() {
		Knapsack currentKnapsack;
		
		for(int i = 0; i < knapsacks.size(); i++) {
			currentKnapsack = knapsacks.get(i);
			
			for(int j = 0; j < 2; j++) {
				currentKnapsack.addItem(new Item(2, 5));
			}
		}
	}
}
