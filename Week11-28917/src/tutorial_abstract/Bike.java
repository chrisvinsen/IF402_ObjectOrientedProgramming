package tutorial_abstract;

public abstract class Bike {

	public Bike() {
		System.out.println("Bike is created");
	}

	abstract void run();

	void changeGear() {
		System.out.println("gear changed");
	}

}

