package ai_lab2;


/**
 * Main program for the multiple knapsack problem
 * Course: Artificial Intelligence, da272a ht2018 
 *
 */
public class Main {
//	private static MultipleKnapsacks mk;
//	private static ArrayList<Item> items;
	
//	/**
//	 * method for testing the greedy solution
//	 */
//	public static void testGreedySolution() {
//		mk.greedySolution(items);
//	}
//	
//	/**
//	 * method for testing the neighbor search solution
//	 */
//	public static void testNeighborSearchSolution() {
//		mk.neighborSearchSolution(items);
//	}
	
//	public static void someTest() {
//		//creates a list of knapsacks with varying maximum weight capacity
//		mk = new MultipleKnapsacks();
//		mk.addKnapsack(new Knapsack(25));
//		mk.addKnapsack(new Knapsack(15));
//		//mk.addKnapsack(new Knapsack(40));
//		
//		//creates a list of items
//		items = new ArrayList<Item>();
//		items.add(new Item(2, 88)); //(value, weight)
//		items.add(new Item(6, 2));
//		items.add(new Item(1, 3));
//		items.add(new Item(5, 99));
////		items.add(new Item(7, 4));
////		items.add(new Item(4, 3));
////		items.add(new Item(8, 6));
////		items.add(new Item(11, 5));
//		
//		mk.setItemList(items);
//		mk.testAdding();
//		mk.printKnapsacks();
//		
//		//testGreedySolution();
//		//testNeighborSearchSolution();
//		
//		//not complete yet
//	}
	
	public static Items generateTestItems() {
		Items i = new Items();
		i.add(new Item(200, 88)); //(value, weight)
		i.add(new Item(600, 2));
		i.add(new Item(100, 3));
		i.add(new Item(500, 99));
		i.add(new Item(7, 4));
		i.add(new Item(4, 3));
		i.add(new Item(8, 6));
		i.add(new Item(11, 5));
		
		i.add(new Item(200, 88)); //(value, weight)
		i.add(new Item(600, 2));
		i.add(new Item(100, 3));
		i.add(new Item(500, 99));
		i.add(new Item(7, 4));
		i.add(new Item(4, 3));
		i.add(new Item(8, 6));
		i.add(new Item(11, 5));
		
		i.add(new Item(10, 2));
		i.add(new Item(10, 2));
		return i;
	}
	
	public static void main(String[] args) {
		MultipleKnapsacks mk = new MultipleKnapsacks();
		mk.setItemList(generateTestItems());
		mk.addKnapsack(new Knapsack(15));
		mk.addKnapsack(new Knapsack(5));
		mk.addKnapsack(new Knapsack(400));
		mk.greedySolution();
		mk.printKnapsacks();
		mk.printStats();
	}
}
