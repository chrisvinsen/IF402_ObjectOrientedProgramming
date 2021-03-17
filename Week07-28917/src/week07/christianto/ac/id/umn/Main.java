package week07.christianto.ac.id.umn;

import java.util.Scanner;
import java.util.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main {
	private static int mgr = 0, mgng = 0, ttp = 0;
	static ArrayList<Manager> manager = new ArrayList<Manager>();
	static ArrayList<Magang> magang = new ArrayList<Magang>();
	static ArrayList<Tetap> tetap = new ArrayList<Tetap>();
	
	static DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    static DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
	
	public static void tambahKaryawan() {
		//Initialize Scanner
		Scanner s = new Scanner(System.in);
		
		//Declaration
		int menuTambah;
		String nama, tempId;
		
		System.out.println("----------Tambah Karyawan----------");
		System.out.println("1. Manajer");
		System.out.println("2. Karyawan Tetap");
		System.out.println("3. Karyawan Magang");
		System.out.print("Pilih : ");
		menuTambah = s.nextInt();
		s.nextLine();
		
		switch(menuTambah) {
			case 1:
				mgr++;
				tempId = "M" + mgr;
				System.out.print("Nama : ");
				nama = s.nextLine();
				System.out.println("Manajer baru telah ditambahkan\n");
				manager.add(new Manager(tempId, nama));
				break;
			case 2:
				ttp++;
				tempId = "R" + ttp;
				System.out.print("Nama : ");
				nama = s.nextLine();
				System.out.println("Karyawan Tetap baru telah ditambahkan\n");
				tetap.add(new Tetap(tempId, nama));
				break;
			case 3:
				mgng++;
				tempId = "I" + mgng;
				System.out.print("Nama : ");
				nama = s.nextLine();
				System.out.println("Karyawan Magang baru telah ditambahkan\n");
				magang.add(new Magang(tempId, nama));
				break;
			default:
				System.out.println("");
				
		}
		
	}
	
	public static void lihatKaryawan() {
	
		//Declaration
		formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
		
		System.out.println("\n-----------Daftar Manajer----------");
		if(!manager.isEmpty()) {
			for(Manager m : manager) {
				System.out.println("ID   : " + m.getId());
				System.out.println("Nama : " + m.getNama());
				System.out.printf("Gaji : %s %n", kursIndonesia.format(m.getGaji()));
				System.out.println("-----------------------------------");
			}
		}else {
			System.out.println("Tidak ada");
		}
		
		System.out.println("\n-------Daftar Pegawai Tetap--------");
		if(!tetap.isEmpty()) {
			for(Tetap t : tetap) {
				System.out.println("ID   : " + t.getId());
				System.out.println("Nama : " + t.getNama());
				System.out.printf("Gaji : %s %n", kursIndonesia.format(t.getGaji()));
				System.out.println("-----------------------------------");
			}
		}else {
			System.out.println("Tidak ada");
		}
		
		System.out.println("\n-------Daftar Pegawai Magang-------");
		if(!magang.isEmpty()) {
			for(Magang i : magang) {
				System.out.println("ID   : " + i.getId());
				System.out.println("Nama : " + i.getNama());
				System.out.printf("Gaji : %s %n", kursIndonesia.format(i.getGaji()));
				System.out.println("-----------------------------------");
			}	
			System.out.println("");
		}else {
			System.out.println("Tidak ada\n");
		}
			
		
	}

	public static void main(String[] args) {
		//Initialize Scanner
		Scanner s = new Scanner(System.in);
		
		//Declaration
		int menu;
		
		for(;;) {
			System.out.println("-------Program Data Karyawan-------");
			System.out.println("1. Lihat Karyawan");
			System.out.println("2. Tambah Karyawan");
			System.out.println("3. Keluar");
			System.out.print("Pilih : ");
			menu = s.nextInt();
			
			switch(menu) {
				case 1:
					lihatKaryawan();
					break;
				case 2:
					tambahKaryawan();
					break;
				case 3:
					System.out.println("Terimakasih telah menggunakan program ini.");
					System.out.println("- Christianto Vinsen-00000028917");
					System.exit(0);
				default:
					continue;
			}
		}

	}

}
