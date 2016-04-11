import java.util.*;
import java.io.*;

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
        int fjerneindeks = verdieriboks.indexOf(verdi);
        verdieriboks.remove(fjerneindeks);
    }

    public ArrayList<Integer> ledigeVerdierIBoks(){
        return verdieriboks;
    }

    protected ArrayList<Integer> getBruktetall() {
        return bruktetall;
    }

    protected void setBruktetall(ArrayList<Integer> bruktetall) {
        this.bruktetall = bruktetall;
    }

    protected int getRader() {
        return rader;
    }

    protected void setRader(int rader) {
        this.rader = rader;
    }

    protected int getBoksid() {
        return boksid;
    }

    protected void setBoksid(int boksid) {
        this.boksid = boksid;
    }

    protected int getRiboks() {
        return riboks;
    }

    protected void setRiboks(int riboks) {
        this.riboks = riboks;
    }

    protected int getKiboks() {
        return kiboks;
    }

    protected void setKiboks(int kiboks) {
        this.kiboks = kiboks;
    }

    protected int getAntalltall() {
        return antalltall;
    }

    protected void setAntalltall(int antalltall) {
        this.antalltall = antalltall;
    }

    protected Rute[][] getDisseverdier() {
        return disseverdier;
    }

    protected void setDisseverdier(Rute[][] disseverdier) {
        this.disseverdier = disseverdier;
    }

    protected Rute getNullrute() {
        return nullrute;
    }

    protected void setNullrute(Rute nullrute) {
        this.nullrute = nullrute;
    }

    protected ArrayList<Integer> getVerdieriboks() {
        return verdieriboks;
    }

    protected void setVerdieriboks(ArrayList<Integer> verdieriboks) {
        this.verdieriboks = verdieriboks;
    }
}