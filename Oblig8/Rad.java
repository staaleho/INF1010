import java.util.*;
import java.io.*;
import java.util.ArrayList;

class Rad{
    protected int radid;
    protected int antalltall;
    protected ArrayList<Integer> verdierirad = new ArrayList<>();

    public Rad(int radid, int antalltall){
        this.setRadid(radid);
        this.antalltall = antalltall;
        for(int i = 1; i < (antalltall + 1); i++){
            verdierirad.add(i);
        }

    }

    public ArrayList<Integer> ledigeVerdierIRad(){
        return verdierirad;
    }

    public void fjernVerdiIRad(int verdi){
        int fjerneindeks = verdierirad.indexOf(verdi);
        verdierirad.remove(fjerneindeks);
    }

    public int getRadId(){
        return radid;
    }
}