import java.util.*;
import java.io.*;

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



        /*
        for(int i : rad.ledigeVerdierIRad()){
            muligetall.add(i);
            System.out.println("lagt til " + i);
            System.out.println("storrelse er " + muligetall.size());
        }

        for(int i : kolonne.ledigeVerdierIKol()){
            muligetall.add(i);
            System.out.println("lagt til " + i);
            System.out.println("storrelse er " + muligetall.size());
        }

        for(int i : boks.ledigeVerdierIBoks()){
            muligetall.add(i);
            System.out.println("lagt til " + i);
            System.out.println("storrelse er " + muligetall.size());
        }
        */

        int[] intarray = new int[verdierirute.size()];
        Object[] obar = verdierirute.toArray();

        for(int i = 0; i < verdierirute.size(); i++){
            intarray[i] = (int )obar[i];
        }

        return intarray;
    }


    protected void setTall(int tall) {
        this.tall = tall;
    }

    protected void setRad(Rad rad) {
        this.rad = rad;
    }

    protected void setKolonne(Kolonne kolonne) {
        this.kolonne = kolonne;
    }

    protected int getBrettstorrelse() {
        return brettstorrelse;
    }

    protected void setBrettstorrelse(int brettstorrelse) {
        this.brettstorrelse = brettstorrelse;
    }

    protected ArrayList<Integer> getVerdierirute() {
        return verdierirute;
    }

    protected void setVerdierirute(ArrayList<Integer> verdierirute) {
        this.verdierirute = verdierirute;
    }
}




