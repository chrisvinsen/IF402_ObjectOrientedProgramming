package model;

public class Voucher extends Barang {
	
	private double pajak;
	public static int total;
	
	public Voucher() { }

	public Voucher(String id, String nama, double harga, int stok, double pajak) {
		super(id, nama, harga);
		this.stok = stok;
		this.pajak = pajak;
	}
	
	public double getPajak() {
		return pajak;
	}
	
	public double getHargaJual() {
		return getHarga();
	}
	
	public void minusStock(int ordered) {
		this.stok = this.stok - ordered;
	}


}
