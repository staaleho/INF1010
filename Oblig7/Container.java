public class Container <T>{
   private T innhold;

   public void put(T innhold){
      this.innhold = innhold;
   }

   public void remove(){
      innhold = null;
   }
}
