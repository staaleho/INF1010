/*
*Oblig 7 INF1010 V2016 staaleho
*/

class Test2 {
static Scanner in = new Scanner(System.in);
static String[] tempstringarray;
/*
 * Beholdere for diverse objekttyper som behoves i oppgaven.
 */
private static Tabell<Legemiddel> legemiddeltabell = new Tabell<Legemiddel>(1000);
private static EnkelReseptListe reseptliste = new EnkelReseptListe();
private static SortertEnkelListe<Lege> legeliste = new SortertEnkelListe<Lege>();
private static Tabell<Pasient> pasienttabell = new Tabell<Pasient>(1000);

public static void main(String[] args) throws Exception {

	int menyvalg = 0; //Int for aa velge meny

	while(menyvalg != 99) {
		System.out.println("Velkommen til Oblig7!");
		System.out.println("Velg oensket meny:");
		System.out.println("1: Les data.");
		System.out.println("2: Skriv alle data til fil.");
		System.out.println("3: Legg inn pasient.");
		System.out.println("4: Legg inn resept.");
		System.out.println("5: Legg inn lege.");
		System.out.println("6: Legg inn legemiddel.");
		System.out.println("7: Statistikk.");
		System.out.println("8: Hent legemiddel.");
		System.out.println("9: Avslutt.");

		String menystring = in.nextLine();
		menyvalg = Integer.parseInt(menystring);

		switch(menyvalg) {
		case 1:
			lesFraFil();
			break;

		case 2:
			//skriv til fil;
			skrivTilFil();
			break;

		case 3:
			nyPasientFraMeny();
			break;

		case 4:
			nyReseptFraMeny();
			break;

		case 5:
			nyLegeFraMeny();
			break;

		case 6:
			nyttLegeMiddelFraMeny();
			break;

		case 7:
			skrivStatistikk();
			break;

		case 8:
			hentLegemiddelFraResept();
			break;

		case 9:
			menyvalg = 99;
			break;

		default:
			break;

		}
	}

}

//Innleser. Leser streng, setter inn i array.
public static void lesFraFil() throws Exception {

	Reader reader = new FileReader("dataset.txt");
	BufferedReader breader = new BufferedReader(reader);
	String str = null;
	String[] leserarray;


	while((str = breader.readLine()) != null) {//Kjoerer saa lenge str ikke er tom.
		String fase = "";

		if(str.startsWith("#")) {

			if(str.equals("# Slutt")) { //Sjekker om filen er tom.
				break;
			}
			String[] fasearray = str.split(" "); //Leser og splitter stringen som angir fase
			fase = fasearray[1];
			str = breader.readLine();
			while(!str.equals("")) {

				switch(fase) { //Leser fase og sender array inn i metode.
				case "Personer":
					leserarray = str.split(", ");
					nyPasientFraArray(leserarray);

					break;

				case "Legemidler":
					leserarray = str.split(", ");
					nyttLegeMiddelFraArray(leserarray, str);

					break;

				case "Leger":
					leserarray = str.split(", ");
					nyLegeFraArray(leserarray);

					break;

				case "Resepter":
					leserarray = str.split(", ");
					nyReseptFraArray(leserarray);

					break;

				default:
					break;
				}

				str = breader.readLine();
			}
		}

	}

	System.out.println("Fil lest.");
}
//Oppretter en ny pasient fra array.
static public void nyPasientFraArray(String[] personarray){
	Pasient nypasient = new Pasient(personarray[1], personarray[2],
	                                personarray[3], personarray[4]);
	pasienttabell.settInnPaaIndeks(nypasient, nypasient.getPasientNummer());

}
//Oppretter nytt legemiddel fra array.
static public void nyttLegeMiddelFraArray(String[] legemiddelarray, String fildata){
	String navn = legemiddelarray[1];
	int pris = Integer.parseInt(legemiddelarray[4]);
	double virkestofftotalt = Double.parseDouble(legemiddelarray[6]);
	int narkostyrke = 0;


	if(legemiddelarray[3].equals("a")) {

		narkostyrke = Integer.parseInt(legemiddelarray[7]);

		if(legemiddelarray[2].equals("mikstur")) {
			double cm3iflaske = Double.parseDouble(legemiddelarray[5]);
			double virkestofficm3 = (virkestofftotalt/cm3iflaske);

			LegemiddelAFlytende nyttlegemiddel = new LegemiddelAFlytende(navn,
			pris, virkestofftotalt, cm3iflaske, virkestofficm3, narkostyrke);
			legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
			nyttlegemiddel.setFilData(fildata);

		}

		if(legemiddelarray[2].equals("pille")) {
			int pillerieske = Integer.parseInt(legemiddelarray[5]);
			double virkestofficm3 = (virkestofftotalt/pillerieske);

			LegemiddelAPiller nyttlegemiddel = new LegemiddelAPiller(navn,
			pris, virkestofftotalt, virkestofficm3, pillerieske, narkostyrke);
			legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
			nyttlegemiddel.setFilData(fildata);

		}


	}

	if(legemiddelarray[3].equals("b")) {

		if(legemiddelarray[2].equals("mikstur")) {
			double cm3iflaske = Double.parseDouble(legemiddelarray[5]);
			double virkestofficm3 = (virkestofftotalt/cm3iflaske);

			LegemiddelBFlytende nyttlegemiddel = new LegemiddelBFlytende(navn,
			pris, virkestofftotalt, cm3iflaske, virkestofficm3, narkostyrke);
			legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
			nyttlegemiddel.setFilData(fildata);
		}

		if(legemiddelarray[2].equals("pille")) {
			int pillerieske = Integer.parseInt(legemiddelarray[5]);
			double virkestofficm3 = (virkestofftotalt/pillerieske);

			LegemiddelBPiller nyttlegemiddel = new LegemiddelBPiller(navn,
			pris, virkestofftotalt, virkestofficm3, pillerieske, narkostyrke);
			legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
			nyttlegemiddel.setFilData(fildata);

		}
	}

	if(legemiddelarray[3].equals("c")) {

		if(legemiddelarray[2].equals("mikstur")) {
			double cm3iflaske = Double.parseDouble(legemiddelarray[5]);
			double virkestofficm3 = (virkestofftotalt/cm3iflaske);

			LegemiddelCFlytende nyttlegemiddel = new LegemiddelCFlytende(navn,
			pris, virkestofftotalt, cm3iflaske, virkestofficm3);
			legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
			nyttlegemiddel.setFilData(fildata);
		}

		if(legemiddelarray[2].equals("pille")) {
			int pillerieske = Integer.parseInt(legemiddelarray[5]);
			double virkestofficm3 = (virkestofftotalt/pillerieske);

			LegemiddelCPiller nyttlegemiddel = new LegemiddelCPiller(navn,
			pris, virkestofftotalt, virkestofficm3, pillerieske);
			legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
			nyttlegemiddel.setFilData(fildata);

		}
	}

}
//Oppretter ny lege fra array.
static public void nyLegeFraArray(String[] legearray){
	Lege nylege = new Lege(legearray[0]);

	if(legearray[1].equals("1")) {
		nylege.opprettAvtale();
	}
	legeliste.settInnSortert(nylege);
}
//Oppretter ny resept fra array.
static public void nyReseptFraArray(String[] reseptarray){
	Legemiddel reseptpaa = legemiddeltabell.finnFraIndeks((Integer.parseInt(reseptarray[4])));
	Lege utstedtav = legeliste.finnElementFraString(reseptarray[3]);
	Pasient utstedttil = pasienttabell.finnFraIndeks((Integer.parseInt(reseptarray[2])));
	int reit = Integer.parseInt(reseptarray[5]);
	int pris = reseptpaa.getPris();

	if(reseptarray[1].equals("blaa")) {
		pris = 0;
	}

	Resept nyresept = new Resept(reseptpaa, utstedtav, utstedttil, reit, pris);
	reseptliste.settInn(nyresept);
	utstedttil.nyReseptPasient(nyresept);
	utstedtav.nyReseptLege(nyresept);
	utstedttil.nyReseptPasient(nyresept);

}
//Ny lege fra meny. Bruker videre arrayfunksjonen.
static public void nyLegeFraMeny(){

	String[] innlegearray;
	System.out.println("Skriv inn lege paa formatet Navn(mellomrom)1 (hvisavtale)0(hvis ikke)");
	String menylege = in.nextLine();
	innlegearray = menylege.split(", ");
	nyLegeFraArray(innlegearray);
}
//Nytt legemiddel fra meny.
static public void nyttLegeMiddelFraMeny(){
	System.out.println("Skriv inn legemiddel paa foelgende format:");
	System.out.println("nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])");
	String menylegemiddel = in.nextLine();
	tempstringarray = menylegemiddel.split(", ");
	nyttLegeMiddelFraArray(tempstringarray, menylegemiddel);
}
//Ny resept fra meny.
static public void nyReseptFraMeny(){
	System.out.println("Skriv inn resept paa foelgende format:");
	System.out.println("nr, hvit/blaa, persNummer, legeNavn, legemiddelNummer, reit");
	String menyresept = in.nextLine();
	tempstringarray = menyresept.split(", ");
	nyReseptFraArray(tempstringarray);
}
//Ny pasient fra meny.
static public void nyPasientFraMeny(){
	System.out.println("Skriv inn person paa foelgende format");
	System.out.println("(nr, navn, fnr, adresse, postnr)");
	String menypasient = in.nextLine();
	tempstringarray = menypasient.split(", ");
	nyPasientFraArray(tempstringarray);
}
//Skriver til fil.
static public void skrivTilFil() throws Exception {
	String str2;
	File file = new File("utskrift.txt");
	file.createNewFile();
	PrintWriter writer = new PrintWriter(file);

	NodeIterator<Pasient> pasientiterator = pasienttabell.iterator();
	writer.println("# Personer (nr, navn, fnr, adresse, postnr)");

	while(pasientiterator.harNeste()) {
		String str = pasientiterator.neste().pasientFilData();
		writer.println(str);
		writer.flush();
	}

	writer.flush();
	writer.println();
	writer.flush();

	NodeIterator<Legemiddel> legemiddeliterator = legemiddeltabell.iterator();
	writer.println("# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])");
	while(legemiddeliterator.harNeste()) {
		String str = legemiddeliterator.neste().getFilData();
		writer.println(str);
		writer.flush();
	}

	writer.flush();
	writer.println();
	writer.flush();

	NodeIterator<Lege> legeiterator = legeliste.iterator();
	writer.println("# Leger (navn, avtalenr / 0 hvis ingen avtale)");
	while(legeiterator.harNeste()) {
		String str = legeiterator.neste().getFilData();
		writer.println(str);
		writer.flush();
	}

	writer.flush();
	writer.println();
	writer.flush();

	NodeIterator<Resept> reseptiterator = reseptliste.iterator();
	writer.println("# Resepter (nr, hvit/bla, persNummer, legeNavn, legemiddelNummer, reit)");
	while(reseptiterator.harNeste()) {
		String str = reseptiterator.neste().getFilData();
		writer.println(str);
		writer.flush();
	}

	writer.println();
	writer.println("# Slutt");
	writer.flush();

}
//Statistikkmenyen.
static public void skrivStatistikk(){
	int statistikkint = 0;
	while(statistikkint != 99) {

		System.out.println("Velg et alternativ");
		System.out.println("1: Vanedannende resepter totalt");
		System.out.println("2: Vanedanende resepter i Oslo");
		System.out.println("3: Info om gitt person");
		System.out.println("4: Reseptsammensetning for gitt lege");
		System.out.println("5: Finn misbruk");
		System.out.println("6: Avslutt");
		String strstatmenyvalg = in.nextLine();
		statistikkint = Integer.parseInt(strstatmenyvalg);

		switch(statistikkint) {
		case 1:
			vanedannendeResepter();
			break;

		case 2:
			vanedannendeResepterOslo();
			break;

		case 3:
			blaaResepterPerson();
			break;

		case 4:
			dataOmResepter();
			break;

		case 5:
			narkotiskeResepterLege();
			narkotiskeResepterPasient();
			break;

		case 6:
			statistikkint = 99;
			break;

		default:

			break;


		}
	}
}
//Henter vanedannende resepter.
static public void vanedannendeResepter(){
	NodeIterator<Resept> resepter = reseptliste.iterator();
	int vadnresepter = 0;

	while(resepter.harNeste()) {

		Resept tempresept = resepter.neste();
		if(tempresept.getLegemiddel() instanceof LegemiddelBPiller) {
			vadnresepter++;
		}
		if(tempresept.getLegemiddel() instanceof LegemiddelBFlytende) {
			vadnresepter++;
		}
	}
	System.out.println("Det er " + vadnresepter + " vanedannende resepter.");
}
//Henter vanedannende resepter Oslo.
static public void vanedannendeResepterOslo(){
	NodeIterator<Resept> resepter = reseptliste.iterator();
	int osloresepter = 0;
	while(resepter.harNeste()) {
		Resept tempresept = resepter.neste();
		String postnr = tempresept.getReseptTil().getPostnummer();
		int postnrint = Integer.parseInt(postnr);
		if(postnrint < 1400 && postnrint > 0) {

			if(tempresept.getLegemiddel() instanceof LegemiddelBPiller) {
				osloresepter++;
			}
			if(tempresept.getLegemiddel() instanceof LegemiddelBFlytende) {
				osloresepter++;
			}
		}
	}
	System.out.println("Det er " + osloresepter + " vanedannende resepter i Oslo.");
}
//Blaa resepter paa person.
static public void blaaResepterPerson(){
	System.out.println("Skriv inn pasientnr: ");
	String personstring = in.nextLine();
	int personint = Integer.parseInt(personstring.trim());

	NodeIterator<Pasient> pasienter = pasienttabell.iterator();
	while(pasienter.harNeste()) {
		Pasient finnpasient = pasienter.neste();
		if(finnpasient.getPasientNummer() == personint) {
			finnpasient.getBlaaResepter();

		}
	}
}
//reseptinformasjon.
static public void dataOmResepter(){
	System.out.println("Hvilken lege vil du finne data om?");
	String legenavn = in.nextLine();
	NodeIterator<Lege> legeiterator = legeliste.iterator();
	while(legeiterator.harNeste()) {
		Lege templege = legeiterator.neste();
		if(templege.getNavn().equals(legenavn)) {
			templege.reseptData();
		}

	}
}
//Narkotiske resepter lege.
static public void narkotiskeResepterLege(){
	NodeIterator<Lege> legeiterator = legeliste.iterator();
	while(legeiterator.harNeste()) {
		Lege templege = legeiterator.neste();
		if(templege.narkoResepter() > 0) {
			System.out.println(templege.getNavn() + " har skrevet ut " + templege.narkoResepter() +
			                   " resepter paa narkotiske legemidler.");
		}
	}
}
//Narkotiske resepter pasient.
static public void narkotiskeResepterPasient(){
	NodeIterator<Pasient> pasienter = pasienttabell.iterator();
	Pasient temppasient;
	while(pasienter.harNeste()) {
		temppasient = pasienter.neste();
		if(temppasient.narkoResepterPasient() > 0) {
			System.out.println(temppasient.returNavn() + " har " + temppasient.narkoResepterPasient()
			                   + " resepter paa narkotiske legemidler.");
		}
	}
}
//Hent ut legemiddel og juster resept.
static public void hentLegemiddelFraResept(){
	System.out.println("Tast foedselsnummer paa reseptinnehaver: ");
	String reseptpasient = in.nextLine();


	NodeIterator<Pasient> pasienter = pasienttabell.iterator();
	Pasient temppasient;
	while(pasienter.harNeste()){
		temppasient = pasienter.neste();
		if(temppasient.getPersonNummerString().equals(reseptpasient)){
			temppasient.alleResepter();
		}
	}

	System.out.println("Velg resept: ");
	String reseptvalg = in.nextLine();
	int reseptvalgint = Integer.parseInt(reseptvalg);
	NodeIterator<Resept> resepter = reseptliste.iterator();
	while(resepter.harNeste()){
		Resept tempresept = resepter.neste();
		if(tempresept.getReseptnummer() == reseptvalgint){
			if(tempresept.reduserReit()){
				System.out.println("Legemiddel tatt ut.");
				System.out.println("Pris: " + tempresept.getPris());
				System.out.println(tempresept.toString());
			}else{
				System.out.println("Resepten er tom.");
			}

		}
	}


}

}
