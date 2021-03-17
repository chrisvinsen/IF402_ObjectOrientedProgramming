package week11.christianto.ac.id.umn;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static ArrayList<Item> listOfItems = new ArrayList<Item>();
	static ArrayList<Payment> listOfPayments = new ArrayList<Payment>();
	static Scanner s = new Scanner(System.in);
	static int pesanan = 0;

	public static void seedData() {
		listOfItems.add(new Item("Kulkas", "Electronic", 4800000));
		listOfItems.add(new Item("TV", "Electronic", 1280000));
		listOfItems.add(new Item("Laptop", "Computer", 6000000));
		listOfItems.add(new Item("PC", "Computer", 12000000));
	}

	public static void printItem(Item item) {
		System.out.println("Nama  : " + item.getName());
		System.out.println("Tipe  : " + item.getType());
		System.out.println("Harga : " + item.getPrice());
	}

	public static void printOrders(Payment payment) {
		System.out.println("Nama            : " + payment.getItem().getName());
		System.out.println("Tipe            : " + payment.getItem().getType());
		System.out.println("Status          : " + payment.getStatus());
		System.out.println("Sisa Pembayaran : " + payment.getRemainingAmount());
	}

	public static void main(String[] args) {

		int opt = 0, id = 0, pilihan, pembayaran, bayar, credit, transaksi;
		String cash;
		seedData();
		do {
			System.out.println("----Program Toko Elektronik----");
			System.out.println("1. Pesan Barang");
			System.out.println("2. Lihat Pesanan");
			System.out.println("0. Keluar");
			System.out.print("Pilihan : ");
			opt = s.nextInt();
			if(opt == 1) {
				System.out.println("----Daftar Barang----");
				for(int i = 0; i < listOfItems.size(); i++) {
					System.out.println("No    : " + (i+1));
					printItem(listOfItems.get(i));
					System.out.println("----------------------------");
				}
				System.out.println("0 untuk pembatalan");
				while(true) {
					System.out.print("Pilih : ");
					pilihan = s.nextInt();
					if(pilihan > 0 && pilihan <= listOfItems.size()) {
						printItem(listOfItems.get(pilihan-1));
						System.out.println("----Tipe Pembayaran----");
						System.out.println("1. Cash");
						System.out.println("2. Credit");
						System.out.println("0. Cancel");
						while(true) {
							System.out.print("Pilih : ");
							pembayaran = s.nextInt();
							if(pembayaran == 1) {
								while(true) {
									System.out.print("Bayar (Y/N) : ");
									cash = s.next();
									if(cash.toUpperCase().equals("Y")) {
										listOfPayments.add(new Cash(listOfItems.get(pilihan-1)));
										System.out.println("Harga Pembayaran : " + listOfPayments.get(pesanan).pay());
										while(true) {
											System.out.print("Bayar : ");
											bayar = s.nextInt();
											if(bayar == listOfItems.get(pilihan-1).getPrice()) {
												System.out.println("Transaksi telah dibayar lunas\n");
												pesanan++;
//
												break;
											}
										}
										break;
									}else if(cash.toUpperCase().equals("N")) {
										listOfPayments.add(new Cash(listOfItems.get(pilihan-1)));
										System.out.println("Transaksi telah disimpan\n");
										pesanan++;
//
										break;
									}
								}
								break;
							}else if(pembayaran == 2) {
								while(true) {
									System.out.print("Lama Cicilan (3/6/9/12) : ");
									credit = s.nextInt();
									if(credit > 0 && credit <= 12 && credit%3 == 0) {
										listOfPayments.add(new Credit(listOfItems.get(pilihan-1), credit));
										System.out.println("Harga Pembayaran : " + listOfPayments.get(pesanan).pay());
										while(true) {
											System.out.print("Bayar : ");
											bayar = s.nextInt();
											if(bayar == (listOfPayments.get(pesanan).getItem().getPrice() / credit)) {
												System.out.println("Transaksi telah dibayar\n");
												pesanan++;
//
												break;
											}
										}
										break;
									}
								}
								break;
							}else if(pembayaran == 0) {
								break;
							}
						}
						break;
					}else if(pilihan == 0) {
						System.out.println("");
						break;
					}
				}
			}else if(opt == 2) {
				for(int i = 0; i < listOfPayments.size(); i++) {
					System.out.println("No              : " + (i+1));
					printOrders(listOfPayments.get(i));
					System.out.println("----------------------------");
				}

				if(listOfPayments.size() > 0) {
					while(true) {
						System.out.print("Pilih No Transaksi : ");
						transaksi = s.nextInt();
						if(transaksi > 0 && transaksi <= listOfPayments.size()) {
							System.out.println("Nama             : " + listOfPayments.get(transaksi-1).getItem().getName());
							System.out.println("Tipe             : " + listOfPayments.get(transaksi-1).getItem().getType());
							System.out.println("Status           : " + listOfPayments.get(transaksi-1).getStatus());
							System.out.println("Sisa Pembayaran  : " + listOfPayments.get(transaksi-1).getRemainingAmount());
							int harga_pembayaran = listOfPayments.get(transaksi-1).pay();
							System.out.println("Harga Pembayaran : " + harga_pembayaran);
							if(harga_pembayaran == 0) {
								System.out.println("Transaksi telah lunas\n");
//
							}else {
								while(true) {
									System.out.print("Bayar : ");
									bayar = s.nextInt();
									if(bayar == harga_pembayaran) {
										System.out.println("Transaksi telah dibayar\n");
										break;
//
									}
								}
							}
							break;
						}
					}
				}else {
					System.out.println("-Belum ada pesanan\n");
				}
			}else if(opt == 0) {
				System.out.println("Terimakasih telah menggunakan program ini.");
				System.out.println("- Christianto Vinsen-00000028917");
				System.exit(0);
			}else {
				System.out.println("Salah Input\n");
			}
		}while(opt != 0);

	}

}
