package week06.christianto.ac.id.umn;

public class Barang {
	
	//Declaration
	protected int id, stok;
	protected double harga;
	protected String nama;
	
	public Barang() { }
	
	public Barang(int id, String nama, double harga) {
		this.id = id;
		this.nama = nama;
		this.harga = harga;
	}
	
	public int getId() {
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
