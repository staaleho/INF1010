public class Resept{
	private static int reseptnummer;
	protected int dettereseptnummer;
    protected Legemiddel reseptpaa;
    protected Lege utstedtav;
    protected Pasient utstedttil;
    protected int reit;
	protected int pris;


    public Resept(Legemiddel reseptpaa, Lege utstedtav, Pasient utstedttil, int reit, int pris) {
        this.reseptpaa = reseptpaa;
        this.utstedtav = utstedtav;
        this.utstedttil = utstedttil;
		reseptnummer++;
        this.reit = reit;
        dettereseptnummer = reseptnummer;
		this.pris = pris;

    }
    public int getReseptnummer(){
      return dettereseptnummer;
   }

   public String toString(){
      return "Legemiddel: " + reseptpaa.getNavn() + System.lineSeparator() +
	  "Utsteder: " + utstedtav.getNavn() + System.lineSeparator() +
	  "Pasient: " + utstedttil.returNavn() +  System.lineSeparator() +
	  "Reit: " + reit + System.lineSeparator() +
	  "Reseptnummer: " + dettereseptnummer;
   }

   public boolean erBlaa(){
	   return (pris == 0);
   }
}
