package week03.christianto.ac.id.umn;

import java.util.Scanner;

public class Tugas2 {

	public static void main(String[] args) {
		String name;
		int input;
		
		//initialize scanner
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Masukkan Nama Anda : ");
		name = scanner.nextLine();
		
		for(;;) {
			System.out.println("----------------------------");
			
			System.out.println("String Anda : " + name);
			System.out.println("1. charAt \t\t 2. length");
			System.out.println("3. substring(n) \t 4. substring(m,n)");
			System.out.println("5. contains \t\t 6. concat");
			System.out.println("7. replace \t\t 8. split");
			System.out.println("9. lowerCase \t\t 10. upperCase");
			System.out.print("Pilih menu : ");
			input = scanner.nextInt();
			
			switch(input) {
				case 1 :
					iCharAt(name);
					break;
				case 2 :
					iLength(name);
					break;
				case 3 :
					iSubstring1(name);
					break;
				case 4 :
					iSubstring2(name);
					break;
				case 5 :
					iContains(name);
					break;
				case 6 :
					iConcat(name);
					break;
				case 7 :
					iReplace(name);
					break;
				case 8 :
					iSplit(name);
					break;
				case 9 :
					iLowerCase(name);
					break;
				case 10 :
					iUpperCase(name);
					break;
				default :
					System.out.println("Pilihan tidak valid");
				
			}
			
		}
		
		
	}
	
	public static void iCharAt(String name) {
		//initialize scanner
		Scanner scanner = new Scanner(System.in);
		
		int input;
		System.out.println("-----chartAt-----");
		System.out.println("Nama : " + name);
		System.out.print("Input : ");
		input = scanner.nextInt();
		System.out.println("Hasil : " + name.charAt(input));
	}
	public static void iLength(String name) {
		System.out.println("-----length-----");
		System.out.println("Nama : " + name);
		System.out.println("Hasil : " + name.length());
	}
	public static void iSubstring1(String name) {
		//initialize scanner
		Scanner scanner = new Scanner(System.in);
		
		int input;
		System.out.println("-----substring(n)-----");
		System.out.println("Nama : " + name);
		System.out.print("Input : ");
		input = scanner.nextInt();
		System.out.println("Hasil : " + name.substring(input));
	}
	public static void iSubstring2(String name) {
		//initialize scanner
		Scanner scanner = new Scanner(System.in);
		
		int input1, input2;
		System.out.println("-----substring(m,n)-----");
		System.out.println("Nama : " + name);
		System.out.print("Input mulai : ");
		input1 = scanner.nextInt();
		System.out.print("Input akhir : ");
		input2 = scanner.nextInt();
		System.out.println("Hasil : " + name.substring(input1, input2));
	}
	public static void iContains(String name) {
		//initialize scanner
		Scanner scanner = new Scanner(System.in);
		
		String input;
		System.out.println("-----contains-----");
		System.out.println("Nama : " + name);
		System.out.print("Input : ");
		input = scanner.next();
		boolean isFound = name.contains(input);
		System.out.println("Hasil : " + isFound);
	}
	public static void iConcat(String name) {
		//initialize scanner
		Scanner scanner = new Scanner(System.in);
		
		String input;
		System.out.println("-----concat-----");
		System.out.println("Nama : " + name);
		System.out.print("Input : ");
		input = scanner.next();
		System.out.println("Hasil : " + name.concat(input));
	}
	public static void iReplace(String name) {
		//initialize scanner
		Scanner scanner = new Scanner(System.in);
		
		String input1, input2;
		System.out.println("-----replace-----");
		System.out.println("Nama : " + name);
		System.out.print("Input kata yang diganti : ");
		input1 = scanner.next();
		System.out.print("Input kata pengganti : ");
		input2 = scanner.next();
		System.out.println("Hasil : " + name.replace(input1, input2));
	}
	public static void iSplit(String name) {
		//initialize scanner
		Scanner scanner = new Scanner(System.in);
		
		//Declaration
		String[] hasil;
		String input;
		System.out.println("-----split-----");
		System.out.println("Nama : " + name);
		System.out.print("Input : ");
		input = scanner.next();
		hasil = name.split(input);
		for(String i : hasil) {
			System.out.println("Hasil : " + i);
		}
		
	}
	public static void iLowerCase(String name) {
		System.out.println("-----lowerCase-----");
		System.out.println("Nama : " + name);
		System.out.println("Hasil : " + name.toLowerCase());
	}
	public static void iUpperCase(String name) {
		System.out.println("-----upperCase-----");
		System.out.println("Nama : " + name);
		System.out.println("Hasil : " + name.toUpperCase());
	}
	

}
