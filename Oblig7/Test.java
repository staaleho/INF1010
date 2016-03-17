public class Test{
   public static void main(String[] args) {
      Person p = new Person("Andreas");
      Person q = new Person("Tonje");

      System.out.println(p.returNavn());
      System.out.println(q.returNavn());

      Hus h = new Hus(p);
      p.kjopHus(h);

   }
}
