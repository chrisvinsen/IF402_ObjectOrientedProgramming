package week11.christianto.ac.id.umn;

public class Item {

	protected String name;
	protected String type;
	protected int price;
	
	public Item() { }
	
	public Item(String name, String type, int price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public int getPrice() {
		return price;
	}
	
}
