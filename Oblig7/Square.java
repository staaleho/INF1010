public class Square{
   private double side;

   public Square(double side){
      this.side = side;
   }

   public double beregnOmkrets(){
      return side * 4;
   }

   public double beregnAreal(){
      return side * side;
   }
}
