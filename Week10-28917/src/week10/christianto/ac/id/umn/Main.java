package week10.christianto.ac.id.umn;

import java.util.*;

//Import Packages
import model.Barang;
import model.Handphone;
import model.Voucher;
import model.Order;

public class Main {
	private static int hp = 1, vc = 1, pesanan = 0;	
	static ArrayList<Order> orders = new ArrayList<Order>();
	static ArrayList<Barang> list_barang = new ArrayList<Barang>();
	
	public static void menuBarangBaru() {
		//Scanner
		Scanner s = new Scanner(System.in);
		
		//Declaration
		String tipe = "", nama, warna;
		int stok;
		double harga;
		float ppn;
		
		for(;;) {
			System.out.print("Voucher / Handphone (V/H): ");	
			tipe = s.nextLine();
			if(tipe.toLowerCase().equals("v") || tipe.toLowerCase().equals("h")) {
				break;
			}
		}
		System.out.print("Nama  : ");
		nama = s.nextLine();
		System.out.print("Harga : ");
		harga = s.nextInt();
		for(;;) {
			System.out.print("Stok  : ");
			stok = s.nextInt();
			if(stok > 0) {
				break;
			}
		}
		
		if(tipe.toLowerCase().equals("v")) {
			System.out.print("PPN   : ");
			ppn = s.nextFloat();
			tipe = "Voucher";
			String tempVc = String.format("V%02d", vc);
			list_barang.add(new Voucher(tempVc, nama, harga, stok, ppn));
//			barangVC[vc] = new Voucher(tempVc, nama, harga, stok, ppn);
			vc++;
		}else if(tipe.toLowerCase().equals("h")) {
			System.out.print("Warna : ");
			warna = s.next();
			tipe = "Handphone";
			String tempHp = String.format("H%02d", hp);
			list_barang.add(new Handphone(tempHp, nama, harga, stok, warna));
//			barangHP[hp] = new Handphone(tempHp, nama, harga, stok, warna);
			hp++;
		}
		
		System.out.println( tipe + " telah berhasil diinput\n" );
	}

	public static void menuPesanBarang() {
		//Scanner
		Scanner s = new Scanner(System.in);
		
		//Declaration
		int pilihan, jumlah;
		String barang_dipesan;
		double uang;
		boolean stock = false;

		System.out.println("\nDaftar Barang Toko Voucher & HP");
		if(!list_barang.isEmpty()) {
			for(Barang bg : list_barang) {
				if(bg.getId().contains("H")) {
					if(bg.getStok() > 0) {
						System.out.println("ID         : " + bg.getId());
						System.out.println("Nama       : " + bg.getNama() + ' ' + ((Handphone) bg).getWarna()); //
						System.out.println("Stok       : " + bg.getStok()); 
						System.out.println("Harga      : " + (int) (bg.getHarga()));
						System.out.println("----------------------------------------------");
						stock = true;
					}
				}else if(bg.getId().contains("V")) {
					if(bg.getStok() > 0) {
						System.out.println("ID         : " + bg.getId());
						System.out.println("Nama       : " + bg.getNama());
						System.out.println("Nominal    : " + (int) ((Voucher) bg).getHargaJual());
						System.out.println("Stok       : " + bg.getStok());
						System.out.println("Harga      : " + (int) (((Voucher) bg).getHargaJual()*(1+((Voucher) bg).getPajak())));
						System.out.println("----------------------------------------------");
						stock = true;
					}
				}
			}	
			if(stock) {
				boolean founded = false;
				System.out.println("Ketik 0 untuk batal");
				System.out.print("Pesan Barang (ID) : ");
				barang_dipesan = s.next();
				for(Barang bg : list_barang) {
					if(barang_dipesan.equals(bg.getId())) {
						founded = true;
						if(bg.getId().contains("V")) {
							System.out.print("Masukkan Jumlah : ");
							jumlah = s.nextInt();
							if(jumlah < 1) {
								System.out.println("Jumlah barang yang Anda masukkan tidak valid!\n");
								break;
							}else if(jumlah > bg.getStok()) {
								System.out.println("Stok tidak mencukupi\n");
								break;
							}else {
								int temp = (int) (jumlah * bg.getHarga() * (1+((Voucher) bg).getPajak()));
								System.out.println(jumlah + " @ " + bg.getNama() + " dengan harga " + temp);
								System.out.print("Masukkan jumlah uang : ");
								uang = s.nextInt();
								if(uang >= temp) {
//									pesanVC(bg.getId(), bg.getVoucher(), jumlah);
									orders.add(new Order('O' + bg.getId() + '-' + pesanan, bg, jumlah));
									System.out.println("Berhasil dipesan\n");
									pesanan = pesanan + 1;
									bg.minusStock(jumlah);
									break;
								}else {
									System.out.println("Pesanan dibatalkan!\nUang tidak mencukupi.\n");
									break;
								}
							}
						}else if(bg.getId().contains("H")) {
							founded = true;
							System.out.print("Masukkan Jumlah : ");
							jumlah = s.nextInt();
							if(jumlah < 1) {
								System.out.println("Jumlah barang yang Anda masukkan tidak valid!\n");
								break;
							}else if(jumlah > bg.getStok()) {
								System.out.println("Stok tidak mencukupi\n");
								break;
							}else {
								int temp = (int) (jumlah * bg.getHarga());
								System.out.println(jumlah + " @ " + bg.getNama() + " dengan total harga " + temp);
								System.out.print("Masukkan jumlah uang : ");
								uang = s.nextInt();
								if(uang >= temp) {
//									pesanHP(bg.getId(), bg.getHandphone(), jumlah);
									orders.add(new Order('O' + bg.getId() + '-' + pesanan, bg, jumlah));
									System.out.println("Berhasil dipesan\n");
									pesanan = pesanan + 1;
									bg.minusStock(jumlah);
									break;
								}else {
									System.out.println("Pesanan dibatalkan!\nUang tidak mencukupi.\n");
									break;
								}
							}	
						}
					}
					
				}
				if(!founded) {
					System.out.println("Barang tidak ditemukan\n");
				}
			}else {
				System.out.println("Barang tidak tersedia.\n");
			}
		}else {
			System.out.println("-Belum ada barang yang didaftarkan\n");
		}
	}
	
	public static void lihatPesanan() {
		System.out.println("\nDaftar pesanan Toko Multiguna Sen");
		if(!orders.isEmpty()) {
			for(Order or : orders) {
				if(or.getBarang().getId().contains("H")) {
					System.out.println("ID      : " + or.getId());
					System.out.println("Nama    : " + or.getBarang().getNama() + " " + ((Handphone) or.getBarang()).getWarna());
					System.out.println("Jumlah  : " + or.getJumlah());
					System.out.println("Total   : " + (int) (or.getJumlah() * or.getBarang().getHarga()));
				}else if(or.getBarang().getId().contains("V")) {
					System.out.println("ID      : " + or.getId());
					System.out.println("Nama    : " + or.getBarang().getNama());
					System.out.println("Nominal : " + (int) or.getBarang().getHarga());
					System.out.println("Jumlah  : " + or.getJumlah());
					System.out.println("Total   : " + (int) ((or.getJumlah() * or.getBarang().getHarga()) * (1 + ((Voucher) or.getBarang()).getPajak())));
				}					
				System.out.println("----------------------------------------------");
			}
		}else {
			System.out.println("-Tidak ada pesanan\n");
		}
			
	}
	
	
	public static void pesanHP(String id, Handphone handphone, int jumlah ) {
		orders.add(new Order(id, handphone, jumlah));
	}
	
	public static void pesanVC(String id, Voucher voucher, int jumlah) {
		orders.add(new Order(id, voucher, jumlah));
	}
	

	public static void main(String[] args) {
		//Scanner
		Scanner s = new Scanner(System.in);
		
		//Declaration
		int menu;
		
		for(;;) {
			System.out.println("------------Menu Toko Voucher & HP------------");
			System.out.println("1. Pesan Barang");
			System.out.println("2. Lihat Pesanan");
			System.out.println("3. Barang Baru");
			System.out.print("Pilihan : ");
			menu = s.nextInt();
			
			switch(menu) {
				case 1 :
					menuPesanBarang();
					break;
				case 2 :
					lihatPesanan();
					break;
				case 3 :
					menuBarangBaru();
					break;
				default :
					System.out.println("Pilihan tidak valid.");
			}
		}
		
		
	}

}
