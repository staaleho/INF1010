public class Parkeringsplass <T> {
   private boolean opptatt = false;
   private T vehicle;

   public void park(T newVehicle){
      if(!opptatt){
         vehicle = newVehicle;
      }
      else{
         System.out.println("Space occupied.");
      }

   }

   public void leave (){
      vehicle = null;
      opptatt = false;
   }
}
