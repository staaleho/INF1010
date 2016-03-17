public class Main{
   public static void main(String[] args) {
      Square newsquare = new Square(23);
      System.out.println(newsquare.beregnOmkrets());
      System.out.println(newsquare.beregnAreal());
      Circle newcircle = new Circle(23);
      System.out.println(newcircle.beregnOmkrets());
   }
}
