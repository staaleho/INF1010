public class Pasient {
	private String navn;
	private String adresse;
	private String postnr;
	private String fnummer;
	static int pasientnummer = 0;
	int dettepasientnummer = 0;


	public Pasient(String navn, String adresse, String postnr, String fnummer) {
		this.navn = navn;
		this.adresse = adresse;
		this.postnr = postnr;
		this.fnummer = fnummer;
		pasientnummer++;
		dettepasientnummer = pasientnummer;
	}

	public int getPasientNummer(){
		return dettepasientnummer;
	}

	public String toString(){
		return "Navn: " + navn + System.lineSeparator() + "Adresse: " + adresse +
		       System.lineSeparator() + "Pasientnummer: " + dettepasientnummer;
	}

	}
