package umn.ac.id.ChristiantoVinsenBudijanto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

//	Scanner Initialization
	static Scanner s = new Scanner(System.in);

	static ArrayList<Aktor> aktor = new ArrayList<Aktor>();
	static ArrayList<Celebgram> celebgram = new ArrayList<Celebgram>();
	static ArrayList<Majalah> majalah = new ArrayList<Majalah>();
	static ArrayList<Baliho> baliho = new ArrayList<Baliho>();
	static ArrayList<Order> order = new ArrayList<Order>();

//	Seeding Data
	public static void seeding_data(){
//		Aktor
		aktor.add(new Aktor("Chris Evans", 30, 170, 60, 100000, "Captain America Lovers"));
		aktor.add(new Aktor("Robert Downey Jr", 31, 171, 61, 120000, "Ironman Lovers"));
		aktor.add(new Aktor("Chris Hemsworth", 32, 172, 62, 140000, "Thor Lovers"));

//		Celebgram
		celebgram.add(new Celebgram("Awkarin", 25, 165, 45, 100000, "Instagram", "Furnitur"));
		celebgram.add(new Celebgram("Anya Geraldine", 26, 166, 46, 120000, "Twitter", "Makanan"));
		celebgram.add(new Celebgram("Devina Aurel", 27, 167, 47, 140000, "Youtube", "Tanaman"));

//		Majalah
		majalah.add(new Majalah("Home Decor", 15, "Halaman 2", "Furnitur"));
		majalah.add(new Majalah("Sedap", 18, "Halaman 3", "Makanan"));
		majalah.add(new Majalah("Otomotif", 21, "Halaman 4", "Tanaman"));

//		Baliho
		baliho.add(new Baliho("Baliho Jakarta Pusat", 6, "Jakarta Pusat"));
		baliho.add(new Baliho("Baliho Jakarta Barat", 8, "Jakarta Barat"));
		baliho.add(new Baliho("Baliho Jakarta Utara", 9, "Jakarta Utara"));
	}

//	Wemen Marketing Agent Header
	public static void wemen_header(){
		System.out.println("================================");
		System.out.println("     Wemen Marketing Agent      ");
		System.out.println("================================");
	}

//	Break row
	public static void hr(){
		System.out.println("================================");
	}

//	Get Bidang Name
	public static String getBidangName(int bidang){
		switch(bidang){
		case 1:
			return "Furnitur";
		case 2:
			return "Makanan";
		case 3:
			return "Tanaman";
		case 4:
			return "Otomotif";
		case 5:
			return "Musik";
		default:
			return "";
		}
	}

//	Penambahan Media
	public static void penambahan_media(){
//		Declaration
		int pilih_media, pilih_kategori;
		String nama;
//		Celebgram Attribute
		int umur, tinggi_badan, berat_badan, followers;
		String akun_media;
//		Majalah Attribute
		int luas;
		String letak;


		wemen_header();
		System.out.println("1. Celebgram");
		System.out.println("2. Majalah");
		hr();

		while(true){
			try{
				System.out.print("Pilih Media (1-2) : ");
				pilih_media = s.nextInt();

				if(pilih_media >= 1 && pilih_media <= 2){
					break;
				}else{
					System.out.println("Please enter a number in range 1-2");
				}
			}catch(InputMismatchException ex){
				System.out.println("Please enter a valid number");
				s.next();
			}
		}

		hr();
		System.out.println("1. Furnitur");
		System.out.println("2. Makanan");
		System.out.println("3. Tanaman");
		System.out.println("4. Otomotif");
		System.out.println("5. Musik");
		hr();

		while(true){
			try{
				System.out.print("Pilih Kategori (1-5) : ");
				pilih_kategori = s.nextInt();
				s.nextLine();

				if(pilih_kategori >=1 && pilih_kategori <= 5){
					break;
				}else{
					System.out.println("Please enter a number in range 1-5.");
				}
			}catch(InputMismatchException ex){
				System.out.println("Please enter a valid number.");
				s.nextLine();
			}
		}

		switch(pilih_media){
		case 1:
//			Celebgram
			System.out.print("Masukkan nama : ");
			nama = s.nextLine();
			while(true){
				try{
					System.out.print("Masukkan umur : ");
					umur = s.nextInt();

					break;
				}catch(InputMismatchException ex){
					System.out.println("Please enter a valid number");
					s.nextLine();
				}
			}
			while(true){
				try{
					System.out.print("Masukkan tinggi badan : ");
					tinggi_badan = s.nextInt();
					s.nextLine();

					break;
				}catch(InputMismatchException ex){
					System.out.println("Please enter a valid number");
					s.nextLine();
				}
			}
			while(true){
				try{
					System.out.print("Masukkan berat badan : ");
					berat_badan = s.nextInt();
					s.nextLine();

					break;
				}catch(InputMismatchException ex){
					System.out.println("Please enter a valid number");
					s.nextLine();
				}
			}
			while(true){
				try{
					System.out.print("Masukkan jumlah followers : ");
					followers = s.nextInt();
					s.nextLine();

					break;
				}catch(InputMismatchException ex){
					System.out.println("Please enter a valid number");
					s.nextLine();
				}
			}
			System.out.print("Masukkan media sosial yang digunakan : ");
			akun_media = s.nextLine();

			celebgram.add(new Celebgram(nama, umur, tinggi_badan, berat_badan, followers, akun_media, getBidangName(pilih_kategori)));
			System.out.println("Media baru telah ditambahkan");

			break;
		case 2:
//			Majalah
			System.out.print("Masukkan nama : ");
			nama = s.nextLine();
			while(true){
				try{
					System.out.print("Masukkan luas : ");
					luas = s.nextInt();
					s.nextLine();

					break;
				}catch(InputMismatchException ex){
					System.out.println("Please enter a valid number");
					s.nextLine();
				}
			}
			System.out.print("Masukkan letak halaman promosi : ");
			letak = s.nextLine();

			majalah.add(new Majalah(nama, luas, letak, getBidangName(pilih_kategori)));
			System.out.println("Media baru telah dimasukkan");

			break;
		default:
			break;
		}

	}

//	Penyewaan Media
	public static void penyewaan_media(){
//		Declaration
		int pilih_kategori, durasi, pilih_tipe, pilih_sewa, nomor_media, temp_harga = 0, i;
		double uang_pembayaran;
		String tanggal_mulai;

		wemen_header();
		System.out.println("1. Furnitur");
		System.out.println("2. Makanan");
		System.out.println("3. Tanaman");
		System.out.println("4. Otomotif");
		System.out.println("5. Musik");
		hr();

		while(true){
			try{
				System.out.print("Pilih Kategori (1-5) : ");
				pilih_kategori = s.nextInt();
				s.nextLine();

				if(pilih_kategori >= 1 && pilih_kategori <= 5){
					break;
				}else{
					System.out.println("Please enter a number in range 1-5");
				}
			}catch(InputMismatchException ex){
				System.out.println("Please input a valid number");
				s.nextLine();
			}
		}
		while(true){
			System.out.print("Tanggal mulai (DDMMYYYY) : ");
			tanggal_mulai = s.nextLine();

			if(String.valueOf(tanggal_mulai).length() >= 7 && Integer.parseInt(tanggal_mulai) > 0 && Integer.parseInt(tanggal_mulai) < 31123000){
				break;
			}else{
				System.out.println("Please enter a valid date");
			}

		}
		while(true){
			try{
				System.out.print("Banyak hari penyewaan : ");
				durasi = s.nextInt();
				s.nextLine();

				if(durasi > 0 && durasi < 1000){
					break;
				}else{
					System.out.println("Please enter a valid duration time. Maximum duration is 999.");
				}
			}catch(InputMismatchException ex){
				System.out.println("Please enter a valid number");
				s.nextLine();
			}
		}

		wemen_header();
		System.out.println("1. Sewa Influencer");
		System.out.println("2. Pasang Iklan");
		hr();

		while(true){
			try{
				System.out.print("Pilih Jenis (1-2) : ");
				pilih_tipe = s.nextInt();
				s.nextLine();

				if(pilih_tipe >= 1 && pilih_tipe <= 2){
					break;
				}else{
					System.out.println("Please enter a number in range 1-2.");
				}
			}catch(InputMismatchException ex){
				System.out.println("Please enter a valid number");
				s.nextLine();
			}
		}

		hr();

		switch(pilih_tipe){
		case 1:
			System.out.println("1. Aktor");
			System.out.println("2. Celebgram");
			hr();
			while(true){
				try{
					System.out.print("Pilih Jenis (1-2) : ");
					pilih_sewa = s.nextInt();
					s.nextLine();

					if(pilih_sewa >= 1 && pilih_sewa <= 2){
						break;
					}else{
						System.out.println("Please enter a number in range 1-2.");
					}
				}catch(InputMismatchException ex){
					System.out.println("Please enter a valid number");
					s.nextLine();
				}
			}

			hr();

			if(pilih_sewa == 1){
				i = 0;
				for(Aktor data : aktor){
					i++;
					System.out.println("No            : " + i);
					System.out.println("Media         : Aktor");
					System.out.println("Nama          : " + data.getNama());
					System.out.println("Umur          : " + data.getUmur());
					System.out.println("Tinggi Badan  : " + data.getTinggiBadan());
					System.out.println("Berat Badan   : " + data.getBeratBadan());
					System.out.println("Jumlah Fans   : " + data.getFans());
					System.out.println("Nama Fansclub : " + data.getFanClub());
					temp_harga = data.getHarga() * durasi;
					System.out.println("Harga         : " + temp_harga);
					hr();
				}

				while(true){
					try{
						System.out.print("Masukkan Nomor Aktor : ");
						nomor_media = s.nextInt();
						s.nextLine();

						if(nomor_media >= 1 && nomor_media <= i){
							break;
						}else{
							System.out.println("Please enter a number in range 1-" + i);
						}
					}catch(InputMismatchException ex){
						System.out.println("Please enter a valid number");
						s.nextLine();
					}
				}

				while(true){
					try{
						System.out.print("Masukkan uang untuk pembayaran : ");
						uang_pembayaran = s.nextInt();
						s.nextLine();

						temp_harga = aktor.get(nomor_media-1).getHarga() * durasi;

						if(uang_pembayaran >= temp_harga){
							System.out.println("Pemesanan Anda sukses");
							order.add(new Order(aktor.get(nomor_media-1), getBidangName(pilih_kategori), tanggal_mulai, durasi));
						}else{
							System.out.println("Uang tidak mencukupi");
						}
						break;
					}catch(InputMismatchException ex){
						System.out.println("Please enter a valid number");
						s.nextLine();
					}
				}

			}else if(pilih_sewa == 2){
				i = 0;
				for(Celebgram data : celebgram){
					i++;
					System.out.println("No           : " + i);
					System.out.println("Media        : Celebgram");
					System.out.println("Nama         : " + data.getNama());
					System.out.println("Umur         : " + data.getUmur());
					System.out.println("Tinggi Badan : " + data.getTinggiBadan());
					System.out.println("Berat Badan  : " + data.getBeratBadan());
					System.out.println("Followers    : " + data.getFollowers());
					System.out.println("Social Media : " + data.getAkunMedia());
					System.out.println("Bidang       : " + data.getBidang());
					if(getBidangName(pilih_kategori).equals(data.getBidang())){
						temp_harga = (data.getHarga() + 500000) * durasi;
					}else{
						temp_harga = data.getHarga() * durasi;
					}
					System.out.println("Harga        : " + temp_harga);
					hr();
				}

				while(true){
					try{
						System.out.print("Masukkan Nomor Celebgram : ");
						nomor_media = s.nextInt();
						s.nextLine();

						if(nomor_media >= 1 && nomor_media <= i){
							break;
						}else{
							System.out.println("Please enter a number in range 1-" + i);
						}
					}catch(InputMismatchException ex){
						System.out.println("Please enter a valid number");
						s.nextLine();
					}
				}

				while(true){
					try{
						System.out.print("Masukkan uang untuk pembayaran : ");
						uang_pembayaran = s.nextInt();
						s.nextLine();

						if(getBidangName(pilih_kategori).equals(celebgram.get(nomor_media-1).getBidang())){
							temp_harga = (celebgram.get(nomor_media-1).getHarga() + 500000) * durasi;
						}else{
							temp_harga = celebgram.get(nomor_media-1).getHarga() * durasi;
						}

						if(uang_pembayaran >= temp_harga){
							System.out.println("Pemesanan Anda sukses");
							order.add(new Order(celebgram.get(nomor_media-1), getBidangName(pilih_kategori), tanggal_mulai, durasi));
						}else{
							System.out.println("Uang tidak mencukupi");
						}
						break;
					}catch(InputMismatchException ex){
						System.out.println("Please enter a valid number");
						s.nextLine();
					}
				}
			}

			break;
		case 2:
			System.out.println("1. Majalah");
			System.out.println("2. Baliho");
			hr();
			while(true){
				try{
					System.out.print("Pilih Jenis (1-2) : ");
					pilih_sewa = s.nextInt();
					s.nextLine();

					if(pilih_sewa >= 1 && pilih_sewa <= 2){
						break;
					}else{
						System.out.println("Please enter a number in range 1-2.");
					}
				}catch(InputMismatchException ex){
					System.out.println("Please enter a valid number");
					s.nextLine();
				}
			}

			hr();

			if(pilih_sewa == 1){
				i = 0;
				for(Majalah data : majalah){
					i++;
					System.out.println("No           : " + i);
					System.out.println("Media        : Majalah");
					System.out.println("Nama         : " + data.getNama());
					System.out.println("Luas         : " + data.getLuas());
					System.out.println("Letak        : " + data.getLetak());
					System.out.println("Bidang       : " + data.getBidang());
					if(getBidangName(pilih_kategori).equals(data.getBidang())){
						temp_harga = (data.getHarga() + 200000) * durasi;
					}else{
						temp_harga = data.getHarga() * durasi;
					}
					System.out.println("Harga        : " + temp_harga);
					hr();
				}

				while(true){
					try{
						System.out.print("Masukkan Nomor Majalah : ");
						nomor_media = s.nextInt();
						s.nextLine();

						if(nomor_media >= 1 && nomor_media <= i){
							break;
						}else{
							System.out.println("Please enter a number in range 1-" + i);
						}
					}catch(InputMismatchException ex){
						System.out.println("Please enter a valid number");
						s.nextLine();
					}
				}

				while(true){
					try{
						System.out.print("Masukkan uang untuk pembayaran : ");
						uang_pembayaran = s.nextInt();
						s.nextLine();

						if(getBidangName(pilih_kategori).equals(majalah.get(nomor_media-1).getBidang())){
							temp_harga = (majalah.get(nomor_media-1).getHarga() + 200000) * durasi;
						}else{
							temp_harga = majalah.get(nomor_media-1).getHarga() * durasi;
						}

						if(uang_pembayaran >= temp_harga){
							System.out.println("Pemesanan Anda sukses");
							order.add(new Order(majalah.get(nomor_media-1), getBidangName(pilih_kategori), tanggal_mulai, durasi));
						}else{
							System.out.println("Uang tidak mencukupi");
						}
						break;
					}catch(InputMismatchException ex){
						System.out.println("Please enter a valid number");
						s.nextLine();
					}
				}

			}else if(pilih_sewa == 2){
				i = 0;
				for(Baliho data : baliho){
					i++;
					System.out.println("No           : " + i);
					System.out.println("Media        : Baliho");
					System.out.println("Nama         : " + data.getNama());
					System.out.println("Luas         : " + data.getLuas());
					System.out.println("Letak        : " + data.getLuas());
					temp_harga = data.getHarga() * durasi;
					System.out.println("Harga        : " + temp_harga);
					hr();
				}

				while(true){
					try{
						System.out.print("Masukkan Nomor Baliho : ");
						nomor_media = s.nextInt();
						s.nextLine();

						if(nomor_media >= 1 && nomor_media <= i){
							break;
						}else{
							System.out.println("Please enter a number in range 1-" + i);
						}
					}catch(InputMismatchException ex){
						System.out.println("Please enter a valid number");
						s.nextLine();
					}
				}

				while(true){
					try{
						System.out.print("Masukkan uang untuk pembayaran : ");
						uang_pembayaran = s.nextInt();
						s.nextLine();

						temp_harga = baliho.get(nomor_media-1).getHarga() * durasi;

						if(uang_pembayaran >= temp_harga){
							System.out.println("Pemesanan Anda sukses");
							order.add(new Order(baliho.get(nomor_media-1), getBidangName(pilih_kategori), tanggal_mulai, durasi));
						}else{
							System.out.println("Uang tidak mencukupi");
						}
						break;
					}catch(InputMismatchException ex){
						System.out.println("Please enter a valid number");
						s.nextLine();
					}
				}
			}

			break;
		}

	}

//	Check Employement / Rental
	public static void check(){
//		Declaration
		int i, pilih_menu, pilih_batal;

		wemen_header();
		if(order.size() > 0){
			i = 0;
			for(Order data : order){
				i++;
				System.out.println("No             : "  + i);
				try{
					if((Aktor) data.getMediaPromosi() != null)
						System.out.println("Media          : Aktor");
				}catch(Exception ex){ }
				try{
					if((Celebgram) data.getMediaPromosi() != null)
						System.out.println("Media          : Celebgram");
				}catch(Exception ex){ }
				try{
					if((Majalah) data.getMediaPromosi() != null)
						System.out.println("Media          : Majalah");
				}catch(Exception ex){ }
				try{
					if((Baliho) data.getMediaPromosi() != null)
						System.out.println("Media          : Baliho");
				}catch(Exception ex){ }
				System.out.println("Nama           : " + data.getMediaPromosi().getNama());
				System.out.println("Tanggal        : " + data.getTanggal());
				System.out.println("Durasi Kontrak : " + data.getJangkaWaktu());
				hr();
			}

			System.out.println("1. Batalkan Order");
			System.out.println("2. Kembali ke menu utama");
			hr();

			while(true){
				try{
					System.out.print("Pilih menu (1-2) : ");
					pilih_menu = s.nextInt();
					s.nextLine();

					if(pilih_menu >= 1 && pilih_menu <= 2 ){
						break;
					}else{
						System.out.println("Please enter a number in range 1-2");
					}
				}catch(InputMismatchException ex){
					System.out.println("Please input a valid number");
					s.nextLine();
				}
			}

			if(pilih_menu == 1){
				while(true){
					try{
						System.out.print("Masukkan nomor yang ingin dibatalkan : ");
						pilih_batal = s.nextInt();
						s.nextLine();

						if(pilih_batal >= 0 && pilih_batal <= i){
							break;
						}else{
							System.out.println("Please enter a number in range 1-" + i);
						}
					}catch(InputMismatchException ex){
						System.out.println("Please input a valid number");
						s.nextLine();
					}
				}

				if(order.get(pilih_batal-1).getTanggal().contains("03062020")){
					System.out.println("Pesanan ini tidak bisa dibatalkan");
				}else{
					System.out.println("Pesanan berhasil dibatalkan");
					order.remove(pilih_batal-1);
				}
			}

		}else{
			System.out.println("No Order History\n");
		}
	}

//	Credits
	public static void credits(){
		wemen_header();
		System.out.println(" Name : Christianto Vinsen B.");
		System.out.println(" NIM  : 00000028917");
		hr();
		System.out.print("Tekan enter untuk melanjutkan...");
		s.next();
	}

	public static void main(String[] args) {
//		Declaration
		int pilihan_menu;

		seeding_data();

		while(true){
			wemen_header();
			System.out.println("1. Penambahan Media");
			System.out.println("2. Penyewaan Media");
			System.out.println("3. Check Employment / Rental");
			System.out.println("4. Credits");
			System.out.println("5. Exit");
			hr();

			while(true){
				System.out.print("Pilih Menu (1-5) : ");
				try{
					pilihan_menu = s.nextInt();

					if(pilihan_menu >= 1 && pilihan_menu <= 5)
						break;
					else
						System.out.println("Please enter a number in range 1-5");

				}catch(InputMismatchException  ex){
					System.out.println("Please enter a valid number.");
					s.next();
				}
			}

			switch(pilihan_menu){
			case 1:
				penambahan_media();
				break;
			case 2:
				penyewaan_media();
				break;
			case 3:
				check();
				break;
			case 4:
				credits();
				break;
			case 5:
				System.out.println("Thankyou for using Wemen Marketing Agent.");
				System.exit(0);
				break;
			}

		}

	}

}
