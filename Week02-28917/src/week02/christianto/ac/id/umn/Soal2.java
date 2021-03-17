package week02.christianto.ac.id.umn;

import java.util.Scanner;

public class Soal2 {

	public static void main(String[] args) {
		int input, flag;
		
		//initialize scanner
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("------ SOAL 2 ------");
		
		for(;;) {
			flag = 0;
			System.out.print("Masukkan angka : ");
			input = scanner.nextInt();
			
			if(input > 1) {
				for(int i = 1; i <= input; i++) {
					if(input % i == 0) {
						flag++;
					}
				}
			}
				
			if(flag == 2) {
				System.out.println("Angka " + input + " adalah angka prima\n");
			}else {
				System.out.println("Angka " + input + " adalah bukan angka prima\n");
			}
		}	

	}

}
