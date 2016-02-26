public class LegemiddelAFlytende extends Legemiddel implements Flytende{
    private int narkostyrke;
    private double cm3iflaske;
    private double virkestofficm3;

    public LegemiddelAFlytende(String navn, int pris, int virkestofftotalt,
	int narkostyrke, double cm3iflaske, double virkestoff){
        super(navn,pris, virkestofftotalt);
        this.narkostyrke = narkostyrke;
		this.cm3iflaske = cm3iflaske;
        this.virkestofficm3 = virkestoff;
    }

    public int getNarkostyrke() {
        return narkostyrke;
    }

    public double getCm3iflaske() {
        return cm3iflaske;
    }

    public double getVirkestofficm3() {
        return virkestofficm3;
    }
}
