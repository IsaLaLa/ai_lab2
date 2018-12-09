package ai_lab2;

public class Item {
	private int value;
	private int weight;
	
	public Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
	
	//en lösning --> ge slumpmässade values och weight inom visst intervall?
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getWeight() {
		return weight;
	}

}
