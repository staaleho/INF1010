public class LegemiddelCFlytende extends Legemiddel implements Flytende{

    private double cm3iflaske;
    private double virkestofficm3;

    public LegemiddelCFlytende(String navn, int pris, int virkestofftotalt,
	double cm3iflaske, double virkestoff) {
        super(navn,pris, virkestofftotalt);
		this.cm3iflaske = cm3iflaske;
        this.virkestofficm3 = virkestoff;
    }

    public void innholdIFlaske(double cm3iflaske, double virkestofficm3){
        this.cm3iflaske = cm3iflaske;
        this.virkestofficm3 = virkestofficm3;
    }

    public double getCm3iflaske() {
        return cm3iflaske;
    }

    public double getVirkestofficm3() {
        return virkestofficm3;
    }
}
