package umn.ac.id.ChristiantoVinsenBudijanto;

public class Aktor extends Orang {

	private int fans;
	private String fanClub;

	public Aktor() { }

	public Aktor(String nama, int umur, int tinggiBadan, int beratBadan, int fans, String fanClub){
		super(nama, 2000*fans, umur, tinggiBadan, beratBadan);
		this.fans = fans;
		this.fanClub = fanClub;
	}

	public int getFans() {
		return fans;
	}

	public String getFanClub() {
		return fanClub;
	}

}
