package Prelude;

import java.util.Scanner;

public class PreludeScanner {

	public static void main(String[] args) {
		int umur;
		String nama;
		
		//Inisialiasi objek Scanner
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nama: ");
		nama = scanner.next();
		
		System.out.print("Umur: ");
		umur = scanner.nextInt();
		
		System.out.println("--------------");
		System.out.println("Nama  : "+ nama);
		System.out.println("Umur : "+ umur);

	}

}
