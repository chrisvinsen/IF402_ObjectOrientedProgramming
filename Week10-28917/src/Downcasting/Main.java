package Downcasting;

public class Main {

	public static void main(String[] args) {
		
		//Downcasting
		CEO c = new CEO();
		Pekerja p = new CEO();
		
		c = (CEO)p;
		c.tanyaPendapatan();
		
		//Upcasting
		Pekerja pekerja = new Pekerja();
		pekerja = new CEO();
		//atau
		CEO ceo = new CEO();
		pekerja = (Pekerja)ceo;

		
		//Downcasting
		CEO ceoo = new CEO();
		
		//Pekerja pekerjaa = new Pekerja(); //Will ERROR
		Pekerja pekerjaa = new CEO(); //WORK
		
		ceoo = (CEO)pekerjaa;
		ceoo.tanyaPendapatan();
	}

}
