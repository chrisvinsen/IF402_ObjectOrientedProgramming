package week06.christianto.ac.id.umn;

public class Handphone extends Barang {
	
	private String warna;
	public static int total;
	
	public Handphone() { }
	
	public Handphone(int id, String nama, double harga, int stok, String warna) {
		super(id, nama, harga);
		this.stok = stok;
		this.warna = warna;
	}
	
	public String getWarna() {
		return warna;
	}
	
	public void minusStock(int ordered) {
		this.stok = this.stok - ordered;
	}

}
