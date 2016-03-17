public class Circle{
   private double radius;

   public Circle(double radius){
      this.radius = radius;
   }

   public double beregnOmkrets(){
      return (radius * 2) * Math.PI;
   }
}
