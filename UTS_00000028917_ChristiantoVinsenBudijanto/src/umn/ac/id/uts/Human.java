package umn.ac.id.uts;

public class Human {
	
	private String name;
	private int age;
	
	public Human() { }
	
	public Human(String name,int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public void eat(Food food) { }
	
	public void workout(Exercise exercise) { }
	
}
