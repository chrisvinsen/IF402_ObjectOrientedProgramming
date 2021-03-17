package umn.ac.id.ChristiantoVinsenBudijanto;

public class Celebgram extends Orang {

	private int followers;
	private String akunMedia;
	private String bidang;

	public Celebgram() { }

	public Celebgram(String nama, int umur, int tinggiBadan, int beratBadan, int followers, String akunMedia, String bidang) {
		super(nama, 1000*followers, umur, tinggiBadan, beratBadan);
		this.followers = followers;
		this.akunMedia = akunMedia;
		this.bidang = bidang;
	}

	public int getFollowers() {
		return followers;
	}

	public String getAkunMedia() {
		return akunMedia;
	}

	public String getBidang() {
		return bidang;
	}

}
