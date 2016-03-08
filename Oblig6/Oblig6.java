public class Oblig6{
	public static void main(String[] args) {
		Tabell<Legemiddel> tab = new Tabell<Legemiddel>(10);

		LegemiddelAPiller paracet = new LegemiddelAPiller("Paracet", 10, 10, 10, 10, 10.0);
		tab.settInnPaaIndeks(paracet, 0);
		LegemiddelAPiller xanax = new LegemiddelAPiller("Xanax", 25, 25, 25, 25, 25.0);
		tab.settInnPaaIndeks(xanax, 1);
		LegemiddelAPiller prozac = new LegemiddelAPiller("Prozac", 50, 25, 50, 50, 50.0);
		tab.settInnPaaIndeks(prozac, 2);
		LegemiddelAPiller norlevo = new LegemiddelAPiller("Norlevo", 50, 25, 50, 50, 50.0);
		tab.settInnPaaIndeks(norlevo, 3);
		LegemiddelAPiller penicilin = new LegemiddelAPiller("Penicillin", 50, 25, 50, 50, 50.0);
		tab.settInnPaaIndeks(penicilin, 4);


		NodeIterator<Legemiddel> itr = tab.iterator();
		while(itr.harNeste()){
			Legemiddel temp = itr.neste();
			System.out.println(temp.getNavn());
		}


		SortertEnkelListe<Lege> sell = new SortertEnkelListe<Lege>();
		Lege tonje = new Lege("Tonje");
		sell.settInnSortert(tonje);

		Lege staale = new Lege("Staale");
		sell.settInnSortert(staale);
		Lege andreas = new Lege("Andreas");
		sell.settInnSortert(andreas);

		Lege julie = new Lege("Julie");
		sell.settInnSortert(julie);
		Lege finn = new Lege("Finn");
		sell.settInnSortert(finn);
		Lege bendik = new Lege("Bendik");
		sell.settInnSortert(bendik);
		Lege irene = new Lege("Irene");
		sell.settInnSortert(irene);
		Lege henrik = new Lege("Henrik");
		sell.settInnSortert(henrik);

		NodeIterator<Lege> itr2 = sell.iterator();

		while(itr2.harNeste()){
			System.out.println(itr2.neste());
		}


	}
}
