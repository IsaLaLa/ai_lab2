package ai_lab2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Main program for the multiple knapsack problem
 * Course: Artificial Intelligence, da272a ht2018 
 *
 */
public class Main {
	public static final Random rand = new Random();
	
	public static Items fixedTestItems() {
		Items i = new Items();
		i.add(new Item(2600, 70)); // (value, weight)
		i.add(new Item(50, 2));
		i.add(new Item(40, 9));
		i.add(new Item(25, 9));
		i.add(new Item(35, 14));
		return i;
	}
	
	public static ArrayList<Knapsack> fixedTestKnapsacks() {
		ArrayList<Knapsack> knapsacks = new ArrayList<Knapsack>();
		knapsacks.add(new Knapsack(30));
		knapsacks.add(new Knapsack(15));
		return knapsacks;
	}
	
	public static Items randomizeTestItems(int nbrOfItems) {
		Items items = new Items();
		for (int i = 0; i < nbrOfItems; i++) {
			items.add(new Item(1+rand.nextInt(1000), 1+rand.nextInt(100)));
		}
		return items;
	}
	
	public static ArrayList<Knapsack> randomizeKnapsacks(int nbrOfKnapssacks) {
		ArrayList<Knapsack> knapsacks = new ArrayList<Knapsack>();
		for (int i = 0; i < nbrOfKnapssacks; i++) {
			knapsacks.add(new Knapsack(1+rand.nextInt(100)));
		}
		return knapsacks;
	}
	
	// Get greedy solution
	public static MultipleKnapsacks runGreedy() {
		MultipleKnapsacks bestSolutionSoFar = new MultipleKnapsacks(randomizeTestItems(15), randomizeKnapsacks(3));
		return bestSolutionSoFar;
	}
	
	// Do neighborhood search if solution can be improved	
	public static MultipleKnapsacks runNeighborhoodSearch(MultipleKnapsacks bestSolutionSoFar) {
		if (!bestSolutionSoFar.isAllKnapsacksFull() && bestSolutionSoFar.hasLeftOverItems()) {
			for (int strategy = 0; strategy < 3; strategy++) { // Set neighborhood strategy
				MultipleKnapsacks rotateSolution = bestSolutionSoFar.copy();
				rotateSolution.neighborSearchSolution(strategy);
				System.out.println("Rotation strategy(" + strategy + "): Neighborhood value: " + rotateSolution.getTotalValue() + ", previousSolution value: " + bestSolutionSoFar.getTotalValue());
				if (rotateSolution.getTotalValue() > bestSolutionSoFar.getTotalValue()) {
					bestSolutionSoFar = rotateSolution;
					strategy = -1; // Start over with first strategy on new best solution
					System.out.println("New best solution found, value: " + rotateSolution.getTotalValue());
				}
			}
		} else {
			System.out.println("Solution can't be improved");
		}
		return bestSolutionSoFar;
	}

	public static void main(String[] args) {
		MultipleKnapsacks greedySolution = runGreedy();
		MultipleKnapsacks bestSolutionSoFar = runNeighborhoodSearch(greedySolution);
		System.out.println("Chosen solution: ");
		bestSolutionSoFar.printKnapsacks();
		bestSolutionSoFar.printStats();	
	}
}
