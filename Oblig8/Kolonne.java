import java.util.*;
import java.io.*;

class Kolonne{
    protected int kolid;
    protected int antalltall;
    protected ArrayList<Integer> verdierikol = new ArrayList<>();

    public Kolonne(int kolid, int antalltall){
        this.kolid = kolid;
        this.antalltall = antalltall;
        for(int i = 1; i < (antalltall + 1); i++){
            verdierikol.add(i);
        }

    }

    public ArrayList<Integer> ledigeVerdierIKol(){
        return verdierikol;
    }

    public void fjernVerdiIKol(int verdi){
        int fjerneindeks = verdierikol.indexOf(verdi);
        verdierikol.remove(fjerneindeks);
    }

    public int getKolId(){
        return kolid;
    }


    protected int getKolid() {
        return kolid;
    }

    protected void setKolid(int kolid) {
        this.kolid = kolid;
    }

    protected int getAntalltall() {
        return antalltall;
    }

    protected void setAntalltall(int antalltall) {
        this.antalltall = antalltall;
    }

    protected ArrayList<Integer> getVerdierikol() {
        return verdierikol;
    }

    protected void setVerdierikol(ArrayList<Integer> verdierikol) {
        this.verdierikol = verdierikol;
    }
}