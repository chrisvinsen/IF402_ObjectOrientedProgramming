package application;

public class Purchase extends Transaction {

	public Purchase(Item item, Integer amount){
		this.item = item;
		this.amount = amount;
	}

	@Override
	public Integer calculateTransaction() {
		// TODO Auto-generated method stub
		return -item.getPrice()*amount;
	}

	@Override
	public String getTransactionInfo() {
		// TODO Auto-generated method stub
		return item.getName() + "(" + amount + ")";
	}

}
