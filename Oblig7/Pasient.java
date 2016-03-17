public class Pasient {
	private String navn;
	private String adresse;
	private String postnr;
	private String fnummer;
	private YngsteForstReseptListe pasientresepter = new YngsteForstReseptListe();
	static int pasientnummer = 0;
	int dettepasientnummer = 0;


	public Pasient(String navn,String fnummer, String adresse, String postnr) {
		this.navn = navn;
		this.adresse = adresse;
		this.postnr = postnr;
		this.fnummer = fnummer;
		dettepasientnummer = pasientnummer;
		pasientnummer++;

	}

	public int getPasientNummer(){
		return dettepasientnummer;
	}

	public String toString(){
		return "Navn: " + navn + System.lineSeparator()
			+ "Adresse: " + adresse + System.lineSeparator()
			+ "Postnummer: " + postnr + System.lineSeparator()
			+ "Pasientnummer: " + dettepasientnummer;
	}

	public void nyReseptPasient(Resept nyResept){
		pasientresepter.settInnYngsteForst(nyResept);
	}

	public String returNavn(){
		return navn;
	}

	}
