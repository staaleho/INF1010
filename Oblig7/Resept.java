public class Resept{
	private static int reseptnummer = 0;
	protected int dettereseptnummer;
    protected Legemiddel reseptpaa;
    protected Lege utstedtav;
    protected Pasient utstedttil;
    protected int reit;
	protected int pris;
	protected String typestring;


    public Resept(Legemiddel reseptpaa, Lege utstedtav, Pasient utstedttil, int reit, int pris) {
        this.reseptpaa = reseptpaa;
        this.utstedtav = utstedtav;
        this.utstedttil = utstedttil;

        this.reit = reit;
        dettereseptnummer = reseptnummer;
		reseptnummer++;
		this.pris = pris;
		if(pris == 0){
			typestring = "blaa";
		}else{
			typestring = "hvit";
		}

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

   public String getFilData(){
	   return dettereseptnummer + ", " + typestring + ", " + utstedtav.getNavn() +
	   ", " + reseptpaa.getNummer() + ", " + reit;
   }

   public Legemiddel getLegemiddel(){
	   return reseptpaa;
   }

   public Pasient getReseptTil(){
	   return utstedttil;
   }
}
