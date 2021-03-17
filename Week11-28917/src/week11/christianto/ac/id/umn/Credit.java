package week11.christianto.ac.id.umn;

public class Credit extends Cash {
	
	public int installment;
	public int maxInstallmentAmount;
	
	public Credit(Item item, int maxInstallmentAmount) {
		super(item);
		this.maxInstallmentAmount = maxInstallmentAmount;
		this.installment = 0;
	}
	
	@Override
	public int pay() {
		if((item.getPrice() * (maxInstallmentAmount-1)/maxInstallmentAmount) == installment) {
			isPaidOff = true;
		}
		if(item.getPrice() == installment) {
			return 0;
		}
		installment += (item.getPrice()/maxInstallmentAmount);
		return item.getPrice()/maxInstallmentAmount;
	}
	
	@Override
	public int getRemainingAmount() {
		if(isPaidOff) {
			return 0;
		}
		return (item.getPrice()-installment);
	}
	
	public String getClassName() {
		return "CREDIT";
	}
	
}
