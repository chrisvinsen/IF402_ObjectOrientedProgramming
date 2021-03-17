package week11.christianto.ac.id.umn;

public abstract class Payment implements ClassInfo {
	
	protected boolean isPaidOff;
	protected Item item;
	
	public abstract int pay();
	
	public Payment() {
		this.isPaidOff = false;
		this.item = null;
	}
	
	public Payment(Item item) {
		this.isPaidOff = false;
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}
	
	public String getItemName() {
		return item.getName();
	}
	
	public String getStatus() {
		if(isPaidOff) {
			return "FINISHED";
		}
		return "ON PROGRESS";
	}
	
	public int getRemainingAmount() {
		if(isPaidOff) {
			return 0;
		}
		return item.getPrice();
	}
	
	public boolean getPaidOff() {
		return isPaidOff;
	}
	
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}

}
