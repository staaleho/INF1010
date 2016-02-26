public class LegemiddelBPiller extends Legemiddel implements Piller{
    private int vanestyrke;
    private int pillerieske;
    private double virkestoffipille;

    public LegemiddelBPiller(String navn, int pris, int virkestofftotalt,
	int vanestyrke, int pillerieske, double virkestoffipille) {
        super(navn, pris, virkestofftotalt);
        this.vanestyrke = vanestyrke;
		this.pillerieske = pillerieske;
		this.virkestoffipille = virkestoffipille;
    }

    public void innholdIEske(int pillerieske, double virkestoffipille) {
        this.pillerieske = pillerieske;
        this.virkestoffipille = virkestoffipille;
    }

    public int getVanestyrke() {
        return vanestyrke;
    }

    public int getPillerieske() {
        return pillerieske;
    }

    public double getVirkestoffipille() {
        return virkestoffipille;
    }
}
