public class LegemiddelAPiller extends Legemiddel implements Piller{
    private int narkostyrke;
    private int pillerieske;
    private double virkestoffipille;

    public LegemiddelAPiller(String navn, int pris, int virkestofftotalt,
	int narkostyrke, int pillerieske, double virkestoffipille){
        super(navn, pris, virkestofftotalt);
        this.narkostyrke = narkostyrke;
		this.pillerieske = pillerieske;
		this.virkestoffipille = virkestoffipille;
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
