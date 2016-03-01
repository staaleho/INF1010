public class Oblig6{
	public static void main(String[] args) {
		Tabell<Legemiddel> tab = new Tabell<Legemiddel>(10);

		LegemiddelAPiller paracet = new LegemiddelAPiller("Paracet", 10, 10, 10, 10, 10.0);
		tab.settInnPaaIndeks(paracet, 0);
		LegemiddelAPiller xanax = new LegemiddelAPiller("Xanax", 25, 25, 25, 25, 25.0);
		tab.settInnPaaIndeks(xanax, 1);
		LegemiddelAPiller prozac = new LegemiddelAPiller("Prozac", 50, 25, 50, 50, 50.0);
		tab.settInnPaaIndeks(prozac, 2);
		LegemiddelAPiller norlevo = new LegemiddelAPiller("norlevo", 50, 25, 50, 50, 50.0);
		tab.settInnPaaIndeks(norlevo, 3);
		LegemiddelAPiller penicilin = new LegemiddelAPiller("Penicilin", 50, 25, 50, 50, 50.0);
		tab.settInnPaaIndeks(penicilin, 4);


		NodeIterator<Legemiddel> itr = tab.iterator();
		while(itr.harNeste()){
			Legemiddel temp = itr.neste();
			System.out.println(temp.getNavn());
		}
	}
}
