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
        this.reit = reit;
        dettereseptnummer = reseptnummer++;
		this.pris = pris;

    }
    public int getReseptnummer(){
      return reseptnummer;
   }

   public String toString(){
      return "Legemiddel: " + reseptpaa.getNavn() + System.lineSeparator() +
	  "Utsteder: " + utstedtav.getNavn() + System.lineSeparator() +
	  "Pasient: " + utstedttil.toString() +  System.lineSeparator() +
	  "Reit: " + reit + System.lineSeparator() +
	  "Reseptnummer: " + reseptnummer;
   }

   public boolean erBlaa(){
	   if(pris == 0){
		   return true;
	   }
	   else{
		   return false;
	   }
   }
}
