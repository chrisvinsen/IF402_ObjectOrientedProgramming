package tutorial_interface;

public class MammalInt implements Animal {
	
	public MammalInt() {}

	@Override
	public void eat() {
		System.out.println("Mammal eats");
	}

	@Override
	public void travel() {
		System.out.println("Mammal travel");
	}
	
	public static void main(String[] args) {
		MammalInt m = new MammalInt();
		m.eat();
		m.travel();
		
	}

}

