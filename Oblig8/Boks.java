import java.util.*;
import java.io.*;
import java.util.ArrayList;

class Boks{
    protected ArrayList<Integer> bruktetall = new ArrayList<Integer>();
    protected int rader = 0;
    protected int boksid;
    protected int riboks;
    protected int kiboks;
    protected int antalltall;

    protected Rute[][] disseverdier;
    protected Rute nullrute;
    protected ArrayList<Integer> verdieriboks = new ArrayList<>();


    public Boks(int boksid, int antalltall) {
        this.boksid = boksid;
        this.antalltall = antalltall;
        for(int i = 1; i < (antalltall + 1); i++){
            verdieriboks.add(i);
        }
    }

    public void leggTilTall(int tall){
        bruktetall.add(tall);
    }

    public int getBoksId() {
        return boksid;
    }

    public void settDisseVerdier(int riboks, int kiboks, Rad radid, Kolonne kolid){

        disseverdier = new Rute[riboks][kiboks];
        this.riboks = riboks;
        this.kiboks = kiboks;

        int j = 0;

        for(int i = 0; i < riboks; i++){
            for(j = 0; j < kiboks; j++){
                Rute nullrute = new Rute(-1, radid, kolid, antalltall);
                disseverdier[i][j] = nullrute;
            }
            j = 0;
        }
    }

    public boolean settInnVerdi(Rute temprute, int rad, int kol){

        while(rad > (riboks-1)){
            rad = rad - riboks;
        }
        while(kol > (kiboks - 1)){
            kol = kol - kiboks;
        }
        if(disseverdier[rad][kol].getTall() == -1){
            disseverdier[rad][kol] = temprute;
            return true;
        }else{
            return false;
        }
    }

    public void fjernVerdi(int verdi){
        Integer intgverdi = verdi;
        if(verdieriboks.contains(intgverdi)){
            verdieriboks.remove(intgverdi);
        }

    }

    public ArrayList<Integer> ledigeVerdierIBoks(){
        return verdieriboks;
    }


}