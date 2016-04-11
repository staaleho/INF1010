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
		while(itr.hasNext()){
			Legemiddel temp = itr.next();
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
		Lege tarje = new Lege("Tyrje");
		sell.settInnSortert(tarje);


		NodeIterator<Lege> itr2 = sell.iterator();

		while(itr2.hasNext()){
			System.out.println(itr2.next());
		}

		EnkelReseptListe enkreslis = new EnkelReseptListe();

		Pasient silje = new Pasient("Silje", "Bergen", "4545", "09091990");
		Pasient eli = new Pasient("Eli", "Oslo", "3434", "10101986");
		Pasient ina = new Pasient("Ina", "Oslo", "0567", "05051986");
		Pasient live = new Pasient("Live", "St. Hans-haugen", "0909", "01011983");
		Resept siljeresept = new Resept(norlevo, andreas, silje, 10, 100);
		Resept eliresept = new Resept(xanax, staale, eli, 10, 100);
		Resept inaresept = new Resept(prozac, julie, ina, 10, 100);
		Resept liveresept = new Resept(paracet, finn, live, 10, 100);

		enkreslis.settInn(siljeresept);
		enkreslis.settInn(eliresept);
		enkreslis.settInn(inaresept);
		enkreslis.settInn(liveresept);


		Iterator itr3 = enkreslis.iterator();
		while(itr3.hasNext()){
			System.out.println(itr3.next().toString());
		}

		enkreslis.finnResept(3);

		EldsteForstReseptListe eldstfrst = new EldsteForstReseptListe();
		eldstfrst.settInnEldsteForst(siljeresept);
		eldstfrst.settInnEldsteForst(eliresept);
		eldstfrst.settInnEldsteForst(inaresept);
		eldstfrst.settInnEldsteForst(liveresept);


		Iterator itr4 = eldstfrst.iterator();
		while(itr4.hasNext()){
			System.out.println(itr4.next().toString());

		}

		YngsteForstReseptListe yngstforst = new YngsteForstReseptListe();
		yngstforst.settInnYngsteForst(siljeresept);
		yngstforst.settInnYngsteForst(eliresept);
		yngstforst.settInnYngsteForst(inaresept);
		yngstforst.settInnYngsteForst(liveresept);


		Iterator itr5 = yngstforst.iterator();
		while(itr5.hasNext()){
			System.out.println(itr5.next().toString());
		}
	}
}
