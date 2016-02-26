abstract class Legemiddel{
    protected String navn;
	protected static int legemiddelnummer = 0;
    protected int pris;
    protected int dettelegemiddelnummer;
	protected int virkestofftotalt;

    public Legemiddel(String navn, int pris, int virkestofftotalt){
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

    public int getVirkestoff() {
        return virkestofftotalt;
    }
}
