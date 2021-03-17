package umn.ac.id.ChristiantoVinsenBudijanto;

public class Majalah extends Objek {

	private String bidang;

	public Majalah() { };

	public Majalah(String nama, int luas, String letak, String bidang){
		super(nama, 50000*luas, luas, letak);
		this.bidang = bidang;
	}

	public String getBidang() {
		return bidang;
	}

}
