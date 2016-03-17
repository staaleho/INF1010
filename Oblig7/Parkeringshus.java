public class Parkeringshus{
   public static void main(String[] args) {
      Parkeringsplass[] firstfloor = new Parkeringsplass[10];
      Parkeringsplass[] secondfloor = new Parkeringsplass[10];

      Bil bil1 = new Bil("AB89347", 7);
      Bil bil2 = new Bil("CD34923", 5);
      Bil bil3 = new Bil("EF349012", 5);

      Motorsykkel motorsykkel1 = new Motorsykkel("GH89238", 89);
      Motorsykkel motorsykkel2 = new Motorsykkel("HJ98389", 67);
      Motorsykkel motorsykkel3 = new Motorsykkel("KO89238", 87);

      Parkeringsplass parkplass1a = new Parkeringsplass<Bil>();
      Parkeringsplass parkplass1b = new Parkeringsplass<Bil>();
      Parkeringsplass parkplass2a = new Parkeringsplass<Motorsykkel>();
      Parkeringsplass parkplass2b = new Parkeringsplass<Motorsykkel>();

      parkplass1a.park(bil1);
      parkplass1b.park(bil3);
      parkplass2a.park(motorsykkel2);
      parkplass2b.park(motorsykkel3);

      firstfloor[0] = parkplass1a;
      firstfloor[1] = parkplass1b;
      secondfloor[0] = parkplass2b;
      secondfloor[1] = parkplass2a;

   }
}
