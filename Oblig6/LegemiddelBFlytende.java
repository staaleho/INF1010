public class LegemiddelBFlytende extends Legemiddel implements Flytende{
	private int vanedannende;
    private double cm3iflaske;
    private double virkestofficm3;

    public LegemiddelBFlytende(String navn, int pris, int virkestofftotalt,
	int vanedannende, double cm3iflaske, double virkestofficm3) {
        super(navn, pris, virkestofftotalt);
        this.vanedannende = vanedannende;
		this.cm3iflaske = cm3iflaske;
        this.virkestofficm3 = virkestofficm3;
    }

    public void innholdIFlaske(double cm3iflaske, double virkestoff){
        this.cm3iflaske = cm3iflaske;
        this.virkestofficm3 = virkestoff;
    }

    public int getVanestyrke() {
        return vanedannende;
    }

    public double getCm3iflaske() {
        return cm3iflaske;
    }

    public double getVirkestofficm3() {
        return virkestofficm3;
    }
}
