package model;

public class Order {
	private String id;
	private Voucher voucher;
	private Handphone handphone;
	private Barang barang;
	private int jumlah;
	
	public static int total;
	
	public Order() { }
	
	public Order(String id, Barang barang, int jumlah) {
		this.id = id;
		this.barang = barang;
		this.jumlah = jumlah;
	}
	
	public String getId() {
		return id;
	}
	
	public Voucher getVoucher() {
		return voucher;
	}
	
	public Handphone getHandphone() {
		return handphone;
	}
	
	public Barang getBarang() {
		return barang;
	}
	
	public int getJumlah() {
		return jumlah;
	}
	
}