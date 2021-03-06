public class LegemiddelAPiller extends Legemiddel implements Piller{
    private int narkostyrke;
    private int pillerieske;
    private double virkestoffipille;

    public LegemiddelAPiller(String navn, int pris, double virkestofftotalt,
	double virkestoffipille, int pillerieske,  int narkostyrke){
        super(navn, pris, virkestofftotalt);
		this.pillerieske = pillerieske;
		this.virkestoffipille = virkestoffipille;
		this.narkostyrke = narkostyrke;
    }

    public int getNarkostyrke() {
        return narkostyrke;
    }

	public int getPillerieske() {
        return pillerieske;
    }

    public double getVirkestoffipille() {
        return virkestoffipille;
    }
}
