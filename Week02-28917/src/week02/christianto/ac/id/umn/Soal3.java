package week02.christianto.ac.id.umn;

import java.util.Scanner;

public class Soal3 {

	public static void main(String[] args) {
		int min, max, total, flag;
		boolean rules;
		
		//initialize scanner
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("------ SOAL 3 ------");
		
		for(;;) {
			total = 0;
			flag = 0;
			rules = true;
			System.out.print("Masukan nilai terkecil : ");
			min = scanner.nextInt();
			System.out.print("Masukan nilai terbesar : ");
			max = scanner.nextInt();
			
			if(min > max) {
				System.out.println("- Invalid the smallest value is greater than the largest value\n");
				rules = false;
			}
			if(min < 2) {
				System.out.println("- The smallest number of prime numbers is 2\n");
				rules = false;
			}
			if(rules) {
				for(int i = min; i <= max; i++) {
					for(int j = 1; j <= max; j++) {
						if(i % j == 0) {
							flag++;
						}
					}
					if(flag == 2) {
						total += i;
					}
					flag = 0;
				}
				System.out.println("Jumlah dari semua nilai prima dari "+ min + " sampai " + max + " adalah " + total + "\n");
			}	
		}
					
	}
}
