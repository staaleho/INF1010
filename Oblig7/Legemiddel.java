abstract class Legemiddel{
    protected String navn;
	protected int pris;
	protected static int legemiddelnummer = 0;
    protected int dettelegemiddelnummer;
	protected double virkestofftotalt;

    public Legemiddel(String navn, int pris, double virkestofftotalt){
		this.navn = navn;
        this.pris = pris;
		this.virkestofftotalt = virkestofftotalt;
        dettelegemiddelnummer = legemiddelnummer;
		legemiddelnummer++;
    }

	public String getNavn(){
		return navn;
	}

    public int getNummer() {
        return dettelegemiddelnummer;
    }

    public double getVirkestoff() {
        return virkestofftotalt;
    }

	public int getPris(){
		return pris;
	}
}
