package Prelude;

public class PreludeEnhancedForLoop {

	public static void main(String[] args) {
		String[] films = {"The Meg", "Slender Man", "Mile 22"};
		System.out.println("Now Playing :");
		
		for(String film : films) {
			System.out.println("- " + film);
		}

	}

}
