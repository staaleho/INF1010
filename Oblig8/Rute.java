import java.util.*;
import java.io.*;
import java.util.ArrayList;

class Rute {
    protected int tall;
    protected Rad rad;
    protected Kolonne kolonne;
    protected Boks boks;
    protected int brettstorrelse;
    protected ArrayList<Integer> verdierirute = new ArrayList<>();

    public Rute(int tall, Rad rad, Kolonne kolonne, int brettstorrelse) {
        this.tall = tall;
        this.rad = rad;
        this.kolonne = kolonne;
        this.brettstorrelse = brettstorrelse;
    }

    public int getTall() {
        return tall;
    }

    public Rad getRad() {
        return rad;
    }

    public Kolonne getKolonne() {
        return kolonne;
    }

    public void setBoks(Boks boks) {
        this.boks = boks;
    }


    public int getBoks() {
        return boks.getBoksId();
    }

    public void getAllRuteInfo(){
        System.out.println("Verdi = " + tall);
        System.out.println("Rad = " + rad.getRadId());
        System.out.println("Kolonne = " + kolonne.getKolId());
        System.out.println("Boks = " + boks.getBoksId());
    }

    public int[] finnAlleMuligeTall(){
        if(tall != 0){
            int[]verdiirute = new int[1];
            verdiirute[0] = tall;
            System.out.println("Rute har allerede verdi " + tall);
            return verdiirute;
        }
        for(int i = 1; i < (brettstorrelse + 1); i++){
            verdierirute.add(i);
        }

        verdierirute.retainAll(rad.ledigeVerdierIRad());
        verdierirute.retainAll(kolonne.ledigeVerdierIKol());
        verdierirute.retainAll(boks.ledigeVerdierIBoks());

        int[] intarray = new int[verdierirute.size()];
        Object[] obar = verdierirute.toArray();

        for(int i = 0; i < verdierirute.size(); i++){
            intarray[i] = (int)obar[i];
        }

        return intarray;
    }
}




