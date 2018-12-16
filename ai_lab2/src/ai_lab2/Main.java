package ai_lab2;

import java.util.ArrayList;

/**
 * Main program for the multiple knapsack problem
 * Course: Artificial Intelligence, da272a ht2018 
 *
 */
public class Main {
	
	public static void main(String[] args) {
		//creates a list of knapsacks
		MultipleKnapsacks knapsacks = new MultipleKnapsacks();
		knapsacks.addKnapsack(new Knapsack(25));
		knapsacks.addKnapsack(new Knapsack(30));
		knapsacks.addKnapsack(new Knapsack(15));
		knapsacks.addKnapsack(new Knapsack(40));
		
		//creates a list of items
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item(2, 8));
		items.add(new Item(6, 10));
		items.add(new Item(1, 3));
		items.add(new Item(5, 5));
		items.add(new Item(7, 5));
		items.add(new Item(4, 6));
		items.add(new Item(8, 6));
		items.add(new Item(11, 9));
		
		//not complete yet
	}
}
