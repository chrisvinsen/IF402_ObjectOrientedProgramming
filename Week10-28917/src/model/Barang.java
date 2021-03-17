package model;

public class Barang {
	
	//Declaration
	protected int stok;
	protected double harga;
	protected String id, nama;
	
	public Barang() { }
	public Barang(String id, String nama, double harga) {
		this.id = id;
		this.nama = nama;
		this.harga = harga;
	}
	
	public String getId() {
		return id;
	}
	
	public String getNama() {
		return nama;
	}
	
	public double getHarga() {
		return harga;
	}
	
	public int getStok() {
		return stok;
	}
	
	public void minusStock(int jml) {
		this.stok = this.stok - jml;
	}
	
}
