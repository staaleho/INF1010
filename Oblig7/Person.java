public class Person{
   private String navn = "";
   private Hus egethus;

   public Person(String navn){
      this.navn = navn;

   }

   public String returNavn(){
      return navn;
   }

   public void kjopHus(Hus h){
      egethus = h;
   }

}
