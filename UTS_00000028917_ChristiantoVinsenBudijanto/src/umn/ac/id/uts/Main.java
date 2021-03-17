package umn.ac.id.uts;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static Healthy healthy_person = new Healthy();
	public static Unhealthy unhealthy_person = new Unhealthy();
	
	public static ArrayList<Food> food = new ArrayList<Food>();
	public static ArrayList<Exercise> exercise = new ArrayList<Exercise>();
	
	
//	SEED DATA FOOD & EXERCISE
	public static void seed_data() {
		food.add(new Food("Pizza", 3, 10));
		food.add(new Food("Risotto", 2, 4));
		food.add(new Food("Burger", 4, 9));
		food.add(new Food("Noodle", 3, 5));
		food.add(new Food("Salad", 1, 1));
		
		exercise.add(new Exercise("Plank", 1, 2));
		exercise.add(new Exercise("Crunch", 2, 3));
		exercise.add(new Exercise("Squat", 3, 3));
		exercise.add(new Exercise("Pull up", 2, 2));
		exercise.add(new Exercise("Comandos", 5, 2));
	}
	
//	MENU 1 - YOUR DETAIL
	public static void your_detail() {
//		Scanner Initialize
		Scanner s = new Scanner(System.in);
		
//		Declaration
		int character_input;
		
		System.out.println("--------------------------------------");
		System.out.println("              Living Life             ");
		System.out.println("--------------------------------------\n");
		System.out.println("1. Healthy");
		System.out.println("2. Unhealthy");
		
		for(;;) {
			System.out.print("Choose your character: ");
			character_input = s.nextInt();
			if(character_input == 1) {
				System.out.println("Healthy");
				System.out.println("Name         : " + healthy_person.getName());
				System.out.println("Age          : " + healthy_person.getAge());
				System.out.println("Weight       : " + healthy_person.getWeight());
				System.out.println("Muscle       : " + healthy_person.getMuscle());
				System.out.println("Fat          : " + healthy_person.getFat());
				System.out.println("Stress Level : " + healthy_person.getStressLevel());
				System.out.println("");
				break;
			}else if(character_input == 2){
				System.out.println("Unhealthy");
				System.out.println("Name         : " + unhealthy_person.getName());
				System.out.println("Age          : " + unhealthy_person.getAge());
				System.out.println("Weight       : " + unhealthy_person.getWeight());
				System.out.println("Muscle       : " + unhealthy_person.getMuscle());
				System.out.println("Fat          : " + unhealthy_person.getFat());
				System.out.println("Stress Level : " + unhealthy_person.getStressLevel());
				System.out.println("");
				break;
			}else {
				System.out.println("Invalid Input.");
			}
		}		
	}
	
	
	
//	MENU 2 - Eat
	public static void eat() {
//		Scanner Initialize
		Scanner s = new Scanner(System.in);
		
//		Declaration
		int input_food, i = 1, character_input;
		
		System.out.println("--------------------------------------");
		System.out.println("Foods");
		System.out.println("---------------");
		for(Food results : food) {
			System.out.println("ID     : " + i);
			System.out.println("Name   : " + results.name);
			System.out.println("Muscle : " + results.muscle);
			System.out.println("Fat    : " + results.fat);
			System.out.println("---------------");
			i++;
		}
		for(;;) {
			System.out.print("Choose your Food: ");
			input_food = s.nextInt();
			if(input_food > 0 && input_food <= i) {
				System.out.println("1. Healthy");
				System.out.println("2. Unhealthy");
				for(;;) {
					System.out.print("Choose your character: ");
					character_input = s.nextInt();
					if(character_input == 1) {
						if(healthy_person.getStressLevel() <= 10) {
							System.out.println(healthy_person.getName() + " doesn't really like it");
							System.out.println("");
							healthy_person.eat(food.get(input_food-1));
							healthy_person.activities.add("Eating      : " + food.get(input_food-1).name);
						}else if(healthy_person.getStressLevel() > 10) {
							System.out.println(healthy_person.getName() + " is stressed out");
							System.out.println("");
						}
						break;
					}else if(character_input == 2) {
						if(unhealthy_person.getMuscle() >= food.get(input_food-1).muscle) {
							System.out.println(unhealthy_person.getName() + " loves it");
							System.out.println("");
							unhealthy_person.eat(food.get(input_food-1));
							unhealthy_person.activities.add("Eating      : " + food.get(input_food-1).name);
						}else if(unhealthy_person.getMuscle() < food.get(input_food-1).muscle) {
							System.out.println(unhealthy_person.getName() + " is way too unhealthy");
							System.out.println("");
						}
						break;
					}else {
						System.out.println("Invalid Input.");
					}
				}
				break;
			}else {
				System.out.println("Invalid Input.");
				continue;
			}
		}		
	}
	
//	MENU 3 - Workout
	public static void workout() {
//		Scanner Initialize
		Scanner s = new Scanner(System.in);
		
//		Declaration
		int input_workout, i = 1, character_input;
		
		System.out.println("--------------------------------------");
		System.out.println("Exercises");
		System.out.println("---------------");
		for(Exercise results : exercise) {
			System.out.println("ID     : " + i);
			System.out.println("Name   : " + results.name);
			System.out.println("Muscle : " + results.muscle);
			System.out.println("Fat    : " + results.fat);
			System.out.println("---------------");
			i++;
		}
		for(;;) {
			System.out.print("Choose your Workout: ");
			input_workout = s.nextInt();
			if(input_workout > 0 && input_workout <= i) {
				System.out.println("1. Healthy");
				System.out.println("2. Unhealthy");
				for(;;) {
					System.out.print("Choose your character: ");
					character_input = s.nextInt();
					if(character_input == 1) {
						if(healthy_person.getFat() >= exercise.get(input_workout-1).fat) {
							System.out.println(healthy_person.getName() + " loves it");
							System.out.println("");
							healthy_person.workout(exercise.get(input_workout-1));
							healthy_person.activities.add("Working out : " + exercise.get(input_workout-1).name);
						}else if(healthy_person.getFat() < exercise.get(input_workout-1).fat) {
							System.out.println(healthy_person.getName() + " is way too healthy");
							System.out.println("");
						}
						break;
					}else if(character_input == 2) {
						if(unhealthy_person.getStressLevel() <= 10) {
							System.out.println(unhealthy_person.getName() + " doesn't really like it");
							System.out.println("");
							unhealthy_person.workout(exercise.get(input_workout-1));
							unhealthy_person.activities.add("Working out : " + exercise.get(input_workout-1).name);
						}else if(unhealthy_person.getStressLevel() > 10) {
							System.out.println(unhealthy_person.getName() + " is stressed out");
							System.out.println("");
						}
						break;
					}else {
						System.out.println("Invalid Input.");
					}
				}
				break;
			}else {
				System.out.println("Invalid Input.");
				continue;
			}
		}		
	}
	
	
//	MENU 4 - List of Activities
	public static void list_of_activities() {
//		Scanner Initialize
		Scanner s = new Scanner(System.in);
		
//		Declaration
		int character_input;
		
		System.out.println("--------------------------------------");
		System.out.println("              Living Life             ");
		System.out.println("--------------------------------------");
		System.out.println("Activities");
		System.out.println("---------------\n");
		
		System.out.println("1. Healthy");
		System.out.println("2. Unhealthy");
		for(;;) {
			System.out.print("Choose your character: ");
			character_input = s.nextInt();
			if(character_input == 1) {
				System.out.println("Healthy");
				if(!healthy_person.activities.isEmpty()) {
					for(String result : healthy_person.activities) {
						System.out.println(result);
					}
				}else {
					System.out.println("There is no activities");
				}
				System.out.println("");
				break;
			}else if(character_input == 2) {
				System.out.println("Unhealthy");
				if(!unhealthy_person.activities.isEmpty()) {
					for(String result : unhealthy_person.activities) {
						System.out.println(result);
					}
				}else {
					System.out.println("There is no activities");
				}
				System.out.println("");
				break;
			}else {
				System.out.println("Invalid Input.");
			}
		}
		
	}

	
//	MENU 5 - Credit
	public static void credit() {
		System.out.println("--------------------------------------");
		System.out.println("              Living Life             ");
		System.out.println("--------------------------------------");
		System.out.println("Name : Christianto Vinsen Budijanto");
		System.out.println("NIM  : 00000028917");
		System.out.println("");
	}
	

	public static void main(String[] args) {
//		Scanner Initialize
		Scanner s = new Scanner(System.in);
		
//		Declaration
		int main_input;
		String name;
		int age;
		
//		Seed Data
		seed_data();
		
		System.out.println("--------------------------------------");
		System.out.println("              Living Life             ");
		System.out.println("--------------------------------------");
//		Healthy
		System.out.println("Healthy");
		System.out.print("Name : ");
		name = s.nextLine();
		System.out.print("Age  : ");
		age = s.nextInt();
		s.nextLine();
		healthy_person = new Healthy(name, age);
		System.out.println("Healthy character is added");
//		Unhealthy
		System.out.println("Unhealthy");
		System.out.print("Name : ");
		name = s.nextLine();
		System.out.print("Age  : ");
		age = s.nextInt();
		s.nextLine();
		unhealthy_person = new Unhealthy(name, age);
		System.out.println("Unhealthy character is added");
		
		for(;;) {
			System.out.println("--------------------------------------");
			System.out.println("              Living Life             ");
			System.out.println("--------------------------------------");
			System.out.println("1. Your Detail");
			System.out.println("2. Eat");
			System.out.println("3. Workout");
			System.out.println("4. List of activities");
			System.out.println("5. Credits");
			System.out.println("0. Exit");
			System.out.print("Input : ");
			
			main_input = s.nextInt();
			
			switch(main_input) {
			case 1:
				your_detail();
				break;
			case 2:
				eat();
				break;
			case 3:
				workout();
				break;
			case 4:
				list_of_activities();
				break;
			case 5:
				credit();
				break;
			case 0:
				System.out.println("Terimakasih telah menggunakan program ini.");
				System.out.println("- Christianto Vinsen B. - 28917");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input.");
			}
		}
		

	}

}
