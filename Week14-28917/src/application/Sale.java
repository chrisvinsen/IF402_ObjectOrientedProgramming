package application;

public class Sale extends Transaction {

	private Integer sellingPrice;

	public Sale(Item item, Integer amount, Integer sellingPrice){
		this.item = item;
		this.amount = amount;
		this.sellingPrice = sellingPrice;
	}

	@Override
	public Integer calculateTransaction() {
		// TODO Auto-generated method stub
		return sellingPrice * amount;
	}

	@Override
	public String getTransactionInfo() {
		// TODO Auto-generated method stub
		return item.getName() + "(" + amount + " * " + sellingPrice + ")";
	}

}
