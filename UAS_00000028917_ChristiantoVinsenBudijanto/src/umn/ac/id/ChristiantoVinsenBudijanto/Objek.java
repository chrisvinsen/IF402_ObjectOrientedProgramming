package umn.ac.id.ChristiantoVinsenBudijanto;

public class Objek extends MediaPromosi {

	private int luas;
	private String letak;

	public Objek(){ }

	public Objek(String nama, int harga, int luas, String letak){
		super(nama, harga);
		this.luas = luas;
		this.letak = letak;
	}

	public int getLuas() {
		return luas;
	}

	public String getLetak() {
		return letak;
	}

}
