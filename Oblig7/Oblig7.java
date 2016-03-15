class Oblig7{
	Tabell<Legemiddel> legemiddeltabell = new Tabell<Legemiddel>(1000);
	EnkelReseptListe reseptliste = new EnkelReseptListe();
	SortertEnkelListe<Lege> legeliste = new SortertEnkelListe<Lege>();
	Tabell<Pasient> pasienttabell = new Tabell<Pasient>(1000);

	public static void main(String[] args) {


	}

	public void nyLege(String navn){
		Lege nylege = new Lege(navn);
		legeliste.settInnSortert(nylege);
	}

	public void nyPasient(String navn, String fnummer, String adresse, String postnr){
		Pasient nypasient = new Pasient(navn, fnummer, adresse, postnr);
		pasienttabell.settInnPaaIndeks(nypasient, nypasient.getPasientNummer());
	}

	public void nyttLegeMiddel(String navn, String form, char type, int pris,
	double virkestofftotalt, double virkestoffienhet, double mengdeavenheter, int styrke){
		if(type == 'a'){
			if(form.equals("mikstur")){
				LegemiddelAFlytende nyttlegemiddel = new LegemiddelAFlytende(navn,
				pris, virkestofftotalt, virkestoffienhet, mengdeavenheter, styrke);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
				break;
			}

			if(form.equals("piller")){
				LegemiddelAPiller nyttlegemiddel = new LegemiddelAPiller(navn,
				pris, virkestofftotalt, virkestoffienhet, mengdeavenheter, styrke);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttLegeMiddel.getNummer());
				break;
			}else{
				System.out.println("Type A, men ikke pille eller mikstur");
			}
		}

		if(type == 'b'){
			if(form.equals("mikstur")){
				LegemiddelBFlytende nyttlegemiddel = new LegemiddelBFlytende(navn,
				pris, virkestofftotalt, virkestoffienhet, mengdeavenheter, styrke);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttLegeMiddel.getNummer());
				break;
			}

			if(form.equals("piller")){
				LegemiddelBPiller nyttlegemiddel = new LegemiddelBPiller(navn,
				pris, virkestofftotalt, virkestoffienhet, mengdeavenheter, styrke);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttLegeMiddel.getNummer());
				break;
			}else{
				System.out.println("Type B, men ikke pille eller mikstur");
			}


		}
	}
}
