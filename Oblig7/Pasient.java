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

	public String pasientFilData(){
		String utstring = "";
		String mellom = ", ";
		utstring += this.dettepasientnummer;
		utstring += mellom;
		utstring += this.navn;
		utstring += mellom;
		utstring += this.adresse;
		utstring += mellom;
		utstring += this.postnr;

		return utstring;

	}

	public String getPostnummer(){
		return postnr;
	}

	public int getPersonNummer(){
		int fnummerint = Integer.parseInt(fnummer);
		return fnummerint;
	}

	public void getBlaaResepter(){
		NodeIterator<Resept> resepter = pasientresepter.iterator();
		while(resepter.harNeste()){
			Resept tempresept = resepter.neste();
			if(tempresept.erBlaa()){
				System.out.println(tempresept.toString());
			}
		}
	}

	public int narkoResepterPasient(){
		NodeIterator<Resept> resepter = pasientresepter.iterator();
		int antallnarkoresepter = 0;
		Resept tempresept;
		Legemiddel templegemiddel;
		while(resepter.harNeste()){
 		    tempresept = resepter.neste();
 		    templegemiddel = tempresept.getLegemiddel();
 			if(templegemiddel instanceof LegemiddelAFlytende || templegemiddel instanceof LegemiddelAPiller){
 				antallnarkoresepter++;
 			}
 	   }

	   return antallnarkoresepter;
	}



	}
