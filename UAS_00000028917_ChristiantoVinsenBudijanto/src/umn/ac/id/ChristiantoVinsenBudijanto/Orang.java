package umn.ac.id.ChristiantoVinsenBudijanto;

public class Orang extends MediaPromosi {

	private int umur;
	private int tinggiBadan;
	private int beratBadan;

	public Orang() { }

	public Orang(String nama, int harga, int umur, int tinggiBadan, int beratBadan){
		super(nama, harga);
		this.umur = umur;
		this.tinggiBadan = tinggiBadan;
		this.beratBadan = beratBadan;
	}

	public int getUmur() {
		return umur;
	}

	public int getTinggiBadan() {
		return tinggiBadan;
	}

	public int getBeratBadan() {
		return beratBadan;
	}

}
