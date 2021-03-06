public class Lege implements Lik, HarAvtale, Comparable<Lege>{
   private String navn;
   private static int avtalenummer;
   private int detteavtalenummer;
   private boolean avtalemedkomm;

   public Lege(String navn){
      this.navn = navn;
	  detteavtalenummer = avtalenummer++;
   }

   public boolean samme(String sammenlign){
      return sammenlign.equals(navn);
   }

   public String toString(){
      return "Navn: " + navn + ".";
   }

   public boolean harAvtale(){
      return avtalemedkomm;
   }

   public void putAvtalenummer(int avtalenummer){
      detteavtalenummer = avtalenummer;
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
}
