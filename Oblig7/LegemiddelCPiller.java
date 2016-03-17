public class LegemiddelCPiller extends Legemiddel implements Piller{
    private int pillerieske;
    private double virkestoffipille;

    public LegemiddelCPiller(String navn, int pris, double virkestofftotalt,
	double virkestoffipille, int pillerieske) {
        super(navn, pris, virkestofftotalt);
		this.pillerieske = pillerieske;
        this.virkestoffipille = virkestoffipille;
    }

    public int getPillerieske() {
        return pillerieske;
    }

    public double getVirkestoffipille() {
        return virkestoffipille;
    }


}
