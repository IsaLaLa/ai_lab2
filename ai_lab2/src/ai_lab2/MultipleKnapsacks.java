package ai_lab2;

import java.util.ArrayList;

public class MultipleKnapsacks {
	private ArrayList<Knapsack> knapsacks;
	private Items itemz;
	private Items leftoverItems;
	
	public MultipleKnapsacks() {
		knapsacks = new ArrayList<Knapsack>();
		itemz = new Items();
		leftoverItems = new Items();
	}
	
	public MultipleKnapsacks(Items itemz, ArrayList<Knapsack> knapsacks) {
		this(knapsacks, itemz, new Items());
		greedySolution(this.itemz);
	}
	
	// Used internally for copy
	private MultipleKnapsacks(ArrayList<Knapsack> knapsacks, Items itemz, Items leftoverItems) {
		this.itemz = itemz;
		this.knapsacks = knapsacks;
		this.leftoverItems = leftoverItems;
	}
	
	public MultipleKnapsacks copy() {
		ArrayList<Knapsack> knapsacksCopy = new ArrayList<>();
		for(Knapsack k : this.knapsacks) {
			knapsacksCopy.add(k.copy());
		}
		return new MultipleKnapsacks(knapsacksCopy, itemz.copy(), leftoverItems.copy());
	}

    /**
     * a greedy solution to the multiple knapsack problem
     * @param items
     */
    private void greedySolution(Items items) {
    	while (!items.isEmpty() && !isAllKnapsacksFull()) {
    		int bestBenefintIndex = items.getBestBenefitIndex();
    		Item item = items.remove(bestBenefintIndex);
        	for (Knapsack k : knapsacks) {
        		if (k.doesItemFit(item)) {
        			k.addItem(item);
        			item = null;
        			break;
        		}
        	}
        	if (item != null) {
        		leftoverItems.add(item);
        	}
    	}
    }
	
    /**
     * solving the multiple knapsack problem by using neighborhood search
     * @param strategy 
     */
	public void neighborSearchSolution(int strategy) {
		// Get nearby feasible solutions by different strategies:
		
		if (strategy == 0) {		// Move leftover items into knapsacks if possible
			for (Knapsack knapsack : knapsacks) {
				if (!knapsack.isFull()) {
					for (int leftoverIndex = 0; leftoverIndex < leftoverItems.size(); leftoverIndex++) {
						Item leftoverItem = leftoverItems.peek(leftoverIndex);
						if (knapsack.doesItemFit(leftoverItem)) {
							knapsack.addItem(leftoverItems.remove(leftoverIndex));
							leftoverIndex--;
						}
					}
				}
			}
		} else if (strategy == 1) {	// Move item from one knapsack to another
			for (int i = 0; i < knapsacks.size(); i++) {
				Knapsack freeSpaceKnap = knapsacks.get(i);
				int freeWeight = freeSpaceKnap.getFreeWeight();
				if (freeWeight > 0) {
					int next = getNextKnapsackIndex(i);
					while(next != i) {
						Knapsack nextKnap = knapsacks.get(next);
						int tryItemIndex = nextKnap.items.getHeaviestItemBelowWeightIndex(freeWeight);
						if(tryItemIndex != -1) {
							Item tryItem = nextKnap.items.peek(tryItemIndex);
							if (freeSpaceKnap.doesItemFit(tryItem)) {
								freeSpaceKnap.addItem(nextKnap.removeItem(tryItemIndex));
								break;
							}
						}
						next = getNextKnapsackIndex(next);
					}
				}
			}
		} else if (strategy == 2) {	// Remove item from knapsack to make room for leftover items
			Items rotationItems = new Items();
			for (Knapsack makeRoom : knapsacks) {
				Item removedItem = makeRoom.removeItem(makeRoom.items.getHighestWeightIndex());
				// Go through leftover items any try to fit
				for (int leftoverIndex = 0; leftoverIndex < leftoverItems.size() && !makeRoom.isFull(); leftoverIndex++) {
					Item tryLeftoverItem = leftoverItems.peek(leftoverIndex);
					if (makeRoom.doesItemFit(tryLeftoverItem)) {
						makeRoom.addItem(leftoverItems.remove(leftoverIndex));
					}
				}
				rotationItems.add(removedItem);
			}
			greedySolution(rotationItems);
		}
	}
	
	public int getNextKnapsackIndex(int currentIndex) {
		return (currentIndex + 1) % knapsacks.size();
	}
	
    public boolean isAllKnapsacksFull() {
    	for(Knapsack k : knapsacks) {
    		if (!k.isFull()) return false;
    	}
    	return true;
    }
    
    public boolean hasLeftOverItems() {
    	return !leftoverItems.isEmpty();
    }
	
	public int getTotalWeight() {
		int weight = 0;
		for (Knapsack k : knapsacks) {
			weight += k.getWeight();
		}
		return weight;
	}
	
	public int getTotalValue() {
		int value = 0;
		for (Knapsack k : knapsacks) {
			value += k.getValue();
		}
		return value;
	}
	
	public int getTotalFreeWeight() {
		int freeWeight = 0;
		for (Knapsack k : knapsacks) {
			freeWeight += k.getFreeWeight();
		}
		return freeWeight;
	}
    
    public void printStats() {
    	System.out.println("Leftover items(" + leftoverItems.size() + "): ");
    	leftoverItems.printItems();
		System.out.println("MK total value: " + getTotalValue());
		System.out.println("MK total weight: " + getTotalWeight());
		System.out.println("MK free weight: " + getTotalFreeWeight());
		System.out.println("-----------------------------------------------------");
    }

	/**
	 * prints all the knapsacks contents and properties
	 */
	public void printKnapsacks() {
		Knapsack k;
		for (int i = 0; i < knapsacks.size(); i++) {
			k = knapsacks.get(i);
			System.out.println("Knapsack " + i + ", value: " + k.getValue() + ", weightCap: " + k.getMaxCapacity() + ", freeWeight: " + k.getFreeWeight() + ":");
			k.printItems();
			System.out.println();
		}
	}
	
//	/**
//	 * returns the list of knapsacks
//	 * @return
//	 */
//   public ArrayList<Knapsack> getKnapsacks() {
//       return knapsacks;
//   }
//   
//   /**
//    * returns the list of items
//    * @return
//    */
//   public ArrayList<Item> getItems() {
//       return items;
//   }
//	
//    public void addItem(Item item) {
//    	itemz.add(item);
//    }
//	
//    public void setItemList(Items items) {
//    	this.itemz = items;
//    }
//    
//    /**
//     * adds a knapsack to the knapsack-list
//     * @param knapsack
//     */
//    public void addKnapsack(Knapsack knapsack) {
//    	if (knapsack != null) {
//    		knapsacks.add(knapsack);
//    	}
//    }
//
//	public void setKnapsacks(ArrayList<Knapsack> knapsacks) {
//		this.knapsacks = knapsacks;
//	}
	
//	public int getMaxCapacity() {
//	int cap = 0;
//	for (Knapsack k : knapsacks) {
//		cap += k.getMaxCapacity();
//	}
//	return cap;
//}
	
//	// bara f�r att testa att l�gga till items i en knapsack, ska bort sen
//	public void testAdding() {
//		Item item;
//		int knapsackNbr;
//
//		for (int i = 0; i < items.size(); i++) {
//
//			// testar att l�gga till 2 items vardera i de tv� existerande knapsacksen
//			if (i == 0 || i == 1) {
//				knapsackNbr = 0;
//			} else {
//				knapsackNbr = 1;
//			}
//
//			item = items.get(i);
//			knapsacks.get(knapsackNbr).addItem(item);
//
//			System.out.println("Added item in knapsack " + knapsackNbr);
//			System.out.println("Item value: " + item.getValue());
//			System.out.println("Item weight: " + item.getWeight());
//			System.out.println("current value in knapsack " + knapsackNbr + " is now: " + knapsacks.get(knapsackNbr).getValue());
//			System.out.println("current weight in knapsack " + knapsackNbr + " is now: " + knapsacks.get(knapsackNbr).getWeight());
//			System.out.println();
//		}
//	}
	
//	/**
//	 * testing purposes
//	 */
//	public void printItemList() {
//		for(int i = 0; i < items.size(); i++) {
//			System.out.println("Item " + i);
//			System.out.println("value: " + items.get(i).getValue());
//			System.out.println("weight: " + items.get(i).getWeight());
//			System.out.println();
//		}
//	}
	
//	/**
//	 * prints all the knapsacks and their content
//	 */
//	public void printKnapsacks() {
//		String format1 = "%-7s %s\n";
//		String format2 = "%-7s %d\n";
//		Knapsack currentKnapsack;
//		ArrayList<Item> itemList;
//		Item currentItem;
//				
//		for(int i = 0; i < knapsacks.size(); i++) {
//			
//			System.out.println("Knapsack " + i);
//			System.out.println("--- Items ---------------------------");
//			System.out.printf(format1, "Value", "Weight");
//			currentKnapsack = knapsacks.get(i);
//			itemList = currentKnapsack.getItems();
//			
//			//skriver ut varje items value och weight f�r en knapsack
//			for(int j = 0; j < itemList.size(); j++) {
//				currentItem = itemList.get(j);
//				System.out.printf(format2, currentItem.getValue(), currentItem.getWeight());
//			}
//			
//			System.out.println("--- Knapsack properties -------------");
//			System.out.println("Total value: " + currentKnapsack.getValue());
//			System.out.println("Total weight: " + currentKnapsack.getWeight());
//			System.out.println("Maximum capacity: " + currentKnapsack.getMaxCapacity());
//			System.out.println("\n");
//		}
//	}
	
}
