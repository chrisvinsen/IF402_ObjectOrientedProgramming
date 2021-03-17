package week05.christianto.ac.id.umn;

import java.util.*;

import Tutorial2.Circle;

public class Main {
	
	public static void menuCircle() {
		//Initialize Scanner
		Scanner s = new Scanner(System.in);
		
		//Declaration
		String color;
		double radius;
		
		System.out.println("\n-------------------Lingkaran-------------------");
		System.out.print("Masukkan jari-jari       : ");
		radius = s.nextDouble();
		System.out.print("Masukkan warna           : ");
		color = s.next();
		
		Circle circle = new Circle(radius, color);
		
		System.out.println("\n---------------------Hasil---------------------");
		System.out.println("Warna                    : " + color);
		System.out.println("Jari-jari                : " + radius);
		System.out.println("Keliling Lingkaran       : " + circle.getPerimeter());
		System.out.println("Luas Lingkaran           : " + circle.getArea());
	}
	
	public static void menuSquare() {
		//Initialize Scanner
		Scanner s = new Scanner(System.in);
		
		//Declaration
		String color;
		double side;
		
		System.out.println("\n--------------------Persegi--------------------");
		System.out.print("Masukkan panjang sisi    : ");
		side = s.nextDouble();
		System.out.print("Masukkan warna           : ");
		color = s.next();
		
		Square square = new Square(side, color);
		
		System.out.println("\n---------------------Hasil---------------------");
		System.out.println("Warna                    : " + color);
		System.out.println("Panjang Sisi             : " + side);
		System.out.println("Keliling Persegi         : " + square.getPerimeter());
		System.out.println("Luas Persegi             : " + square.getArea());
		
	}
	
	public static void menuRectangle() {
		//Initialize Scanner
		Scanner s = new Scanner(System.in);
		
		//Declaration
		double length, width;
		String color;
		
		System.out.println("\n----------------Persegi Panjang----------------");
		System.out.print("Masukkan panjang         : ");
		length = s.nextDouble();
		System.out.print("Masukkan lebar           : ");
		width = s.nextDouble();
		System.out.print("Masukkan warna           : ");
		color = s.next();
		
		Rectangle rectangle = new Rectangle(length, width, color);
		
		System.out.println("\n---------------------Hasil---------------------");
		System.out.println("Warna                    : " + color);
		System.out.println("Panjang & Lebar          : " + length + " & " + width);
		System.out.println("Keliling Persegi Panjang : " + rectangle.getPerimeter());
		System.out.println("Luas Persegi Panjang     : " + rectangle.getArea());
		
	}
	
	public static void menuTriangle() {
		//Initialize Scanner
		Scanner s = new Scanner(System.in);
		
		//Declaration
		double base, height;
		String color;
		System.out.println("\n--------------Segitiga Siku-Siku---------------");
		System.out.print("Masukkan alas            : ");
		base = s.nextDouble();
		System.out.print("Masukkan tinggi          : ");
		height = s.nextDouble();
		System.out.print("Masukkan warna           : ");
		color = s.next();
		
		Triangle triangle = new Triangle(height, base, color);
		
		System.out.println("\n---------------------Hasil---------------------");
		System.out.println("Warna                    : " + color);
		System.out.println("Alas & Tinggi            : " + base + " & " + height);
		System.out.println("Keliling Segitiga        : " + triangle.getPerimeter());
		System.out.println("Luas Segitiga            : " + triangle.getArea());
	}

	
	public static void main(String[] args) {
		
		//Initialize Scanner
		Scanner s = new Scanner(System.in);
		
		//Declaration
		int menu;
		boolean login = true;
		
		while(login) {
			System.out.println("\n--------Program Menghitung Bangun Ruang--------");
			System.out.println("1. Lingkaran");
			System.out.println("2. Persegi");
			System.out.println("3. Persegi Panjang");
			System.out.println("4. Segitiga");
			System.out.println("5. Keluar");
			System.out.print("Pilihan : ");
			menu = s.nextInt();
			switch(menu) {
				case 1 :
					menuCircle();
					break;
				case 2 :
					menuSquare();
					break;
				case 3 :
					menuRectangle();
					break;
				case 4 :
					menuTriangle();
					break;
				case 5 :
					login = false;
					System.out.println("Keluar program...");
					System.out.println("Terimakasih Telah Menggunakan Program Menghitung Bangun Ruang ini");
					System.out.println("- Christianto Vinsen B. (00000028917)");
					break;
				default :
					System.out.println("Input tidak valid");
			}
		}

	}

}
