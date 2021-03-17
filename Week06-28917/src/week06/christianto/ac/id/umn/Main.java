package week06.christianto.ac.id.umn;

import java.util.*;

public class Main {
	private static int barang = 0, hp = 0, vc = 0;
	static ArrayList<Handphone> handphone = new ArrayList<Handphone>();
	static ArrayList<Voucher> voucher = new ArrayList<Voucher>();
	static ArrayList<Order> orders = new ArrayList<Order>();
	
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
			vc++;
			voucher.add(new Voucher(vc, nama, harga, stok, ppn));
		}else if(tipe.toLowerCase().equals("h")) {
			System.out.print("Warna : ");
			warna = s.next();
			tipe = "Handphone";
			hp++;
			handphone.add(new Handphone(hp, nama, harga, stok, warna));
		}
		
		System.out.println( tipe + " telah berhasil diinput\n" );
	}
	
	public static void menuPesanBarang() {
		//Scanner
		Scanner s = new Scanner(System.in);
		
		//Declaration
		int pilihan, pesanan, jumlah;
		double uang;
		boolean stockHP = false;
		boolean stockVC = false;
		
		System.out.println("\nDaftar Barang Toko Voucher & HP");
		System.out.println("1. Handphone");
		System.out.println("2. Voucher");
		for(;;) {
			System.out.print("Pilihan : ");
			pilihan = s.nextInt();
			if(pilihan == 1) {
				if(!handphone.isEmpty()) {
					for(Handphone hp : handphone) {
						if(hp.getStok() > 0) {
							System.out.println("ID         : " + hp.getId());
							System.out.println("Nama       : " + hp.getNama() + ' ' + hp.getWarna());
							System.out.println("Harga      : " + (int) (hp.getHarga()));
							System.out.println("Stok       : " + hp.getStok());
							System.out.println("----------------------------------------------");
							stockHP = true;
						}
					}					
					if(stockHP) {
						System.out.println("Ketik 0 untuk batal");
						System.out.print("Pesan Barang (ID) : ");
						pesanan = s.nextInt();
						for(Handphone hp : handphone) {
							if(pesanan == hp.getId()) {
								System.out.print("Masukkan Jumlah : ");
								jumlah = s.nextInt();
								if(jumlah < 1) {
									System.out.println("Jumlah barang yang Anda masukkan tidak valid!\n");
								}else if(jumlah > hp.getStok()) {
									System.out.println("Stok tidak mencukupi\n");
								}else {
									int temp = (int) (jumlah * hp.getHarga());
									System.out.println(jumlah + " @ " + hp.getNama() + " dengan total harga " + temp);
									System.out.print("Masukkan jumlah uang : ");
									uang = s.nextInt();
									if(uang >= temp) {
										pesanHP(hp.getId(), hp, jumlah);
										System.out.println("Berhasil dipesan\n");
										hp.minusStock(jumlah);
										break;
									}else {
										System.out.println("Pesanan dibatalkan!\nUang tidak mencukupi.\n");
									}
								}
							} 
						}
					}else {
						System.out.println("Handphone tidak tersedia.\n");
						break;
					}
				}else {
					System.out.println("Handphone tidak tersedia.\n");
					break;
				}
				break;
		
			}else if(pilihan == 2) {
				if(!voucher.isEmpty()) {
					for(Voucher vc : voucher) {
						if(vc.getStok() > 0) {
							System.out.println("ID         : " + vc.getId());
							System.out.println("Nama       : " + vc.getNama());
							System.out.println("Nominal    : " + (int) (vc.getHargaJual()));
							System.out.println("Stok       : " + vc.getStok());
							System.out.println("Harga      : " + (int) (vc.getHargaJual()*(1+vc.getPajak())));
							System.out.println("----------------------------------------------");
							stockVC = true;
						}
					}
					if(stockVC) {
						System.out.println("Ketik 0 untuk batal");
						System.out.print("Pesan Barang (ID) : ");
						pesanan = s.nextInt();
						for(Voucher vc : voucher) {
							if(pesanan == vc.getId()) {
								System.out.print("Masukkan Jumlah : ");
								jumlah = s.nextInt();
								if(jumlah < 1) {
									System.out.println("Jumlah barang yang Anda masukkan tidak valid!\n");
								}else if(jumlah > vc.getStok()) {
									System.out.println("Stok tidak mencukupi\n");
								}else {
									int temp = (int) (jumlah * vc.getHarga() * (1+vc.getPajak()));
									System.out.println(jumlah + " @ " + vc.getNama() + " dengan harga " + temp);
									System.out.print("Masukkan jumlah uang : ");
									uang = s.nextInt();
									if(uang >= temp) {
										pesanVC(vc.getId(), vc, jumlah);
										System.out.println("Berhasil dipesan\n");
										vc.minusStock(jumlah);
										break;
									}else {
										System.out.println("Pesanan dibatalkan!\nUang tidak mencukupi.\n");
									}
								}
							}
						}
					}else {
						System.out.println("Voucher tidak tersedia.\n");
						break;
					}
				}else {
					System.out.println("Voucher tidak tersedia.\n");
					break;
				}
				break;
			}else {
				break;
			}
		}
	}
	
	public static void lihatPesanan() {
		System.out.println("Daftar pesanan Toko Multiguna Sen");
		int totalPesanan = 0;
		if(!orders.isEmpty()) {
			for(Order or : orders) {
				if(or.getHandphone() != null) {
					System.out.println("ID      : OH" + totalPesanan);
					System.out.println("Nama    : " + or.getHandphone().getNama() + " " + or.getHandphone().getWarna());
					System.out.println("Jumlah  : " + or.getJumlah());
					System.out.println("Total   : " + (int) (or.getJumlah() * or.getHandphone().getHarga()));
				}else if(or.getVoucher() != null) {
					System.out.println("ID      : OV" + totalPesanan);
					System.out.println("Nama    : " + or.getVoucher().getNama() + " " + (int) (or.getVoucher().getHarga()));
					System.out.println("Jumlah  : " + or.getJumlah());
					System.out.println("Total   : " + (int) ((or.getJumlah() * or.getVoucher().getHarga()) * (1 + or.getVoucher().getPajak())));
				}
				totalPesanan++;
				System.out.println("----------------------------------------------");
			}
		}else {
			System.out.println("-Tidak ada pesanan\n");
		}
			
	}
	
	public static void pesanHP(int id, Handphone handphone, int jumlah ) {
		orders.add(new Order(id, handphone, jumlah));
	}
	
	public static void pesanVC(int id, Voucher voucher, int jumlah) {
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
