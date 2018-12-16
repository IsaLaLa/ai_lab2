package ai_lab2;

import java.util.ArrayList;

/**
 * Main program for the multiple knapsack problem
 * Course: Artificial Intelligence, da272a ht2018 
 *
 */
public class Main {
	private static MultipleKnapsacks knapsacks;
	private static ArrayList<Item> items;
	
	/**
	 * method for testing the greedy solution
	 */
	public static void testGreedySolution() {
		knapsacks.greedySolution(items);
	}
	
	/**
	 * method for testing the neighbor search solution
	 */
	public static void testNeighborSearchSolution() {
		knapsacks.neighborSearchSolution(items);
	}
	
	public static void main(String[] args) {
		//creates a list of knapsacks with varying maximum weight capacity
		knapsacks = new MultipleKnapsacks();
		knapsacks.addKnapsack(new Knapsack(25));
		knapsacks.addKnapsack(new Knapsack(15));
		//knapsacks.addKnapsack(new Knapsack(15));
		//knapsacks.addKnapsack(new Knapsack(40));
		
		//creates a list of items
		items = new ArrayList<Item>();
		items.add(new Item(2, 88)); //(value, weight)
		items.add(new Item(6, 2));
		items.add(new Item(1, 3));
		items.add(new Item(5, 99));
//		items.add(new Item(7, 4));
//		items.add(new Item(4, 3));
//		items.add(new Item(8, 6));
//		items.add(new Item(11, 5));
		
		//testGreedySolution();
		//testNeighborSearchSolution();
		
		knapsacks.testAdding(items);
		knapsacks.printKnapsSacks();
		//not complete yet
		//some method to print solution to verify its correctness
	}
}
