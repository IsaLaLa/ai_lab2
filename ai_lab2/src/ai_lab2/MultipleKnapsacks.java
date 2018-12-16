package ai_lab2;

import java.util.ArrayList;

public class MultipleKnapsacks {
	private static ArrayList<Knapsack> knapsacks;
	private static ArrayList<Item> items;

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
		String format = "%-7s %d\n";
//		Knapsack currentKnapsack;
		ArrayList<Item> itemList;
		Item item;
		
		for(int i = 0; i < knapsacks.size(); i++) {
			
			System.out.println("Knapsack " + i);
//			currentKnapsack = knapsacks.get(i);
			itemList = knapsacks.get(i).getItems();
			
			//skriver ut varje items value och weight för knapsack
			for(int j = 0; j < itemList.size(); j++) {
				item = itemList.get(i);
				System.out.printf(format, item.getValue(), item.getWeight());
			}
			
			System.out.println("Total value: " + knapsacks.get(i).getValue());
			System.out.println("Total weight: " + knapsacks.get(i).getWeight());
			System.out.println("Maximum capacity: " + knapsacks.get(i).getMaxCapacity());
			System.out.println();
		}
	}
	
	//bara för att testa att lägga till items i en knapsack, ska bort sen
	public void testAdding(ArrayList<Item> items) {
		this.items = items;
		Item item;
		int knapsackNbr;
		
		for(int i = 0; i < items.size(); i++) {
			if(i == 0 || i == 1) {
				knapsackNbr = 0;
			} else {
				knapsackNbr = 1;
			}
			
			item = items.get(i);
			knapsacks.get(knapsackNbr).addItem(item);
			
				
			System.out.println("Added item in knapsack " + knapsackNbr);
			System.out.println("Item value: " + item.getValue());
			System.out.println("Item weight: " + item.getWeight());
			System.out.println("current value in knapsack " + knapsackNbr + " is now: " + knapsacks.get(knapsackNbr).getValue());
			System.out.println("current weight in knapsack " + knapsackNbr + " is now: " + knapsacks.get(knapsackNbr).getWeight());
			System.out.println();
		}
	}
}
