package Upcasting;

public class Main {

	public static void main(String[] args) {
		Pekerja pekerja = new Pekerja();

		pekerja.tanyaIdentitas();
		//Upcasting
		pekerja = new CEO();
		pekerja.tanyaIdentitas();
		//Upcasting
		Karyawan karyawan = new Karyawan();
		pekerja = (Pekerja)karyawan;
		pekerja.tanyaIdentitas();
	}

}

