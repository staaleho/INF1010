public class Hus{
   private Person eier;

   public Hus(Person eier){
      this.eier = eier;
   }

   public void returnEier(){
      System.out.println(eier.returNavn());
   }
}
