public class Lege implements Lik, HarAvtale, Comparable<Lege>{
   private String navn;
   private static int avtalenummer;
   private int detteavtalenummer = 0;
   private int avtalemedkomm;
   private EldsteForstReseptListe legeresepter = new EldsteForstReseptListe();
   protected String fildata = "";

   public Lege(String navn){
      this.navn = navn;

   }

   public boolean samme(String sammenlign){
      return sammenlign.equals(navn);
   }

   public String toString(){
      return "Navn: " + navn + ".";
   }

   public int harAvtale(){
      return avtalemedkomm;
   }

   public void opprettAvtale(){
	   avtalemedkomm = 1;
   }

   public void putAvtalenummer(int avtalenummer){
      detteavtalenummer = avtalenummer++;
   }

   public String getNavn(){
	   return navn;
   }

   public int getAvtaleNummer(){
      return avtalenummer;
   }

   public int compareTo(Lege complege){
	   String complegenavn = complege.getNavn();
	   return navn.compareTo(complegenavn);
   }

   public void nyReseptLege(Resept nyresept){
	   legeresepter.settInnEldsteForst(nyresept);
   }

   public String getFilData(){
	   String returstring = navn + ", " + detteavtalenummer;
	   return returstring;
   }

   public void reseptData(){
	   NodeIterator<Resept> resepter = legeresepter.iterator();
	   double virkestofftotalt = 0;
	   double virkestoffflytende = 0;

	   while(resepter.harNeste()){
		   Resept tempresept = resepter.neste();
		   Legemiddel templegemiddel = tempresept.getLegemiddel();
		   virkestofftotalt += templegemiddel.getVirkestoff();
		   if(templegemiddel instanceof LegemiddelAFlytende){
			   tempresept.toString();
			   virkestoffflytende += templegemiddel.getVirkestoff();
		   }
		   if(templegemiddel instanceof LegemiddelBFlytende){
			   tempresept.toString();
			   virkestoffflytende += templegemiddel.getVirkestoff();
		   }
		   if(templegemiddel instanceof LegemiddelCFlytende){
			   tempresept.toString();
			   virkestoffflytende += templegemiddel.getVirkestoff();
		   }
	   }

	   System.out.println("Totalt " + virkestofftotalt + " virkestoff totalt. " + virkestoffflytende
	   + " i flytende form, og " + (virkestofftotalt-virkestoffflytende) + " i pilleform.");
   }

   public int narkoResepter(){
	   	NodeIterator<Resept> resepter = legeresepter.iterator();
	    Resept tempresept;
		Legemiddel templegemiddel;
		int antallnarkoresepter = 0;
	   while(resepter.harNeste()){
		    tempresept = resepter.neste();
		    templegemiddel = tempresept.getLegemiddel();
			if(templegemiddel instanceof LegemiddelAFlytende || templegemiddel instanceof LegemiddelAPiller){
				antallnarkoresepter++;
			}
	   }

	   return antallnarkoresepter;

   }
}
