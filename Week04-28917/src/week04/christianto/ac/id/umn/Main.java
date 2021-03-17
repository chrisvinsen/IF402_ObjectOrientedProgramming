package week04.christianto.ac.id.umn;

import java.util.*;
import java.util.Scanner;

public class Main {
	private static int pesanan = 0;
	
	static Barang[] barangs = new Barang[5]; 
	static ArrayList<Order> orders = new ArrayList<Order>();
	
	public static void seedBarang() {
		barangs[0] = new Barang(1, 120, 2000, "Pulpen Easy Gel 0.5mm");
		barangs[1] = new Barang(2, 30, 5000, "Penggaris 30cm");
		barangs[2] = new Barang(3, 30, 7000, "Tipe-x Roller");
		barangs[3] = new Barang(4, 50, 5000, "Pensil Mekanik");
		barangs[4] = new Barang(5, 100, 6000, "Buku Tulis");
	}
	
	public static void mainMenu() {
		System.out.println("\n---------------Menu Toko Multiguna---------------");
		System.out.println("1. Pesan Barang");
		System.out.println("2. Lihat Pesanan");
	}
	
	public static void daftarBarang() {		
		System.out.println("\nDaftar Barang Toko Multiguna");
		for(Barang barang : barangs) {
			if(barang.getStock() > 0) {
				System.out.println("ID         : " + barang.getId());
				System.out.println("Nama       : " + barang.getNama());
				System.out.println("Stock      : " + barang.getStock());
				System.out.println("Harga      : " + barang.getHarga());
				System.out.println("-------------------------------------------------");	
			}
		}
		pesanBarang();
	}
	
	public static void pesanBarang() {
		Scanner scanner = new Scanner(System.in);
		int p_id, p_jumlah = 0;
		int stock, harga, total, uang;
		String nama;
		System.out.println("Ketik 0 untuk batal");
		System.out.print("Pesan Barang (ID) : ");
		p_id = scanner.nextInt();
		for(Barang barang : barangs) {
			if(barang.getStock() > 0) {
				if(barang.getId() == p_id) {
					stock = barang.getStock();
					harga = barang.getHarga();
					nama = barang.getNama();
					while(true) {
						System.out.print("Masukkan Jumlah   : ");
						p_jumlah = scanner.nextInt();
						if(p_jumlah > 0 && p_jumlah <= stock) {
							break;
						}
					}
					total = harga * p_jumlah;
					System.out.println(p_jumlah + " @ " + nama + " dengan total harga " + total);
					System.out.print("Masukkan jumlah uang : ");
					uang = scanner.nextInt();
					if(uang == total) {
						System.out.println("Berhasil dipesan");
						pesanan++;
						objPesanan(pesanan, p_jumlah, barang);
						barang.minusStock(p_jumlah);
					}else if(uang < total) {
						System.out.println("Jumlah uang tidak mencukupi");
					}else {
						System.out.println("Jumlah uang melebihi harga barang");					
					}				
				}
			}	
		}
	}
	
	public static void objPesanan( int id, int jumlah, Barang barang) {
		orders.add(new Order(id, jumlah, barang));
	}
	
	public static void daftarPesanan() {
		System.out.println("\nDaftar Pesanan Toko Multiguna");
		int i = 0;
		for(Order order : orders) {
			int temp = order.getJumlah() * order.getBarang().getHarga();
			System.out.println("ID         : " + order.getId());
			System.out.println("Nama       : " + order.getBarang().getNama());
			System.out.println("Jumlah     : " + order.getJumlah());
			System.out.println("Total      : " + temp);
			System.out.println("-------------------------------------------------");
			i++;
			if(i == pesanan) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		seedBarang();		
		int menu;
		for(;;) {
			mainMenu();
			System.out.print("Pilihan : ");
			menu = scanner.nextInt();			
			switch(menu) {
				case 1 :
					daftarBarang();					
					break;
				case 2 :
					daftarPesanan();
					break;
				default :
					System.out.println("Input tidak valid");
			}
		}

	}

}
