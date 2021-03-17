package umn.ac.id.uts;

import java.util.ArrayList;

public class Healthy extends Human {
	
	private int muscle;
	private int fat;
	private int stressLevel;
	private double weight;
	public ArrayList<String> activities = new ArrayList<String>();
	
	public Healthy() { }
	
	public Healthy(String name, int age) {
		super(name, age);
		this.muscle = 50;
		this.fat = 15;
		this.weight = (fat*0.3) + (muscle*0.6);
		this.stressLevel = 4;
	}
	
	public double getWeight() {
		return weight;
	}

	public int getFat() {
		return fat;
	}

	public int getMuscle() {
		return muscle;
	}

	public int getStressLevel() {
		return stressLevel;
	}
	
	public void updateWeight() {
		this.weight = (fat*0.3) + (muscle*0.6);
	}
	
	public void eat(Food food) {
		this.fat += food.fat;
		this.muscle -= food.muscle;
		this.stressLevel += 2;
		updateWeight();
	}
	
	public void workout(Exercise exercise) {
		this.fat -= exercise.fat;
		this.muscle += exercise.muscle;
		this.stressLevel -= 2;
		updateWeight();
	}
	
}
