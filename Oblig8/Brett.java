import java.util.*;
import java.io.*;
import java.util.ArrayList;

class Brett{
    protected int riboks;
    protected int kiboks;
    protected int brettstorrelse;
    protected static char TOM_RUTE_TEGN = '.';

    protected Rute[][] rutearray;
    protected ArrayList<Rad> rader = new ArrayList<>();
    protected ArrayList<Kolonne> kolonner = new ArrayList<>();
    protected ArrayList<Boks> bokser = new ArrayList<>();

    public Brett(int riboks, int kiboks, char[][] nyttbrett) {
        this.riboks = riboks;
        this.kiboks = kiboks;
        brettstorrelse = riboks * kiboks;
        opprettDataStruktur(nyttbrett);


    }

    protected static char getTomRuteTegn() {
        return TOM_RUTE_TEGN;
    }

    protected static void setTomRuteTegn(char tomRuteTegn) {
        TOM_RUTE_TEGN = tomRuteTegn;
    }

    public void skrivBrett(){
        int radteller = 0;
        int kolonneteller = 0;
        int understrekteller = -1;
        int m = -1;
        while(m < (brettstorrelse + 2)){
            System.out.print("-");
            m++;
        }
        System.out.println();
        m = 0;

        for(Rute[] rarr : rutearray){
            System.out.print("|");
            for(Rute r : rarr){

                if(r.getTall() == 0){
                    System.out.print(" ");
                }else{
                    System.out.print(r.getTall());
                }

                if(kolonneteller == (kiboks - 1)){
                    System.out.print("|");
                }
                kolonneteller++;
            }
            System.out.print("|");
            System.out.println();
            kolonneteller = 0;
            radteller++;
            if(radteller == riboks){
                while(understrekteller < brettstorrelse + 2){
                    if(understrekteller == (riboks+1)){
                        System.out.print("+");
                    }else{
                        System.out.print("-");
                    }
                    understrekteller++;
                }
                System.out.println();
                understrekteller = -1;
                radteller = 0;
            }

        }/*
        for(Rute[] rarr : rutearray){
            for(Rute r : rarr){
                if(r.getTall() == 0){
                    System.out.print(" ");
                }else{
                    System.out.print(r.getTall());
                }

                if(kolonneteller == (kiboks - 1)){
                    System.out.print("|");
                }
                kolonneteller++;
            }

            System.out.println();
            kolonneteller = 0;
            radteller++;
            if(radteller == riboks){
                while(understrekteller < brettstorrelse + 1){
                    System.out.print("-");
                    understrekteller++;
                }
                System.out.println();
                understrekteller = 0;
                radteller = 0;
            }

        }*/
        rutearray[2][2].getAllRuteInfo();
    }

    public void opprettDataStruktur(char[][] chararray){
        for(int radid = 0; radid < brettstorrelse; radid++){
            Rad temprad = new Rad(radid, brettstorrelse);
            rader.add(temprad);
        }

        for(int kolid = 0; kolid < brettstorrelse; kolid++){
            Kolonne tempkol = new Kolonne(kolid, brettstorrelse);
            kolonner.add(tempkol);
        }

        for(int boksid = 0; boksid < brettstorrelse; boksid++){
            Boks tempboks = new Boks(boksid, brettstorrelse);
            tempboks.settDisseVerdier(riboks, kiboks, rader.get(0), kolonner.get(0));
            bokser.add(tempboks);
        }

        int k = 0;
        int l = 0;

        int rad = 0;
        int kol = 0;
        int radforboks = 0;
        int kolforboks = 0;
        rutearray = new Rute[brettstorrelse][brettstorrelse];

        int bokstall = 0;

        Boks nyboks = bokser.get(0);

        while(rad < rutearray.length){
            for(char c : chararray[rad]){
                Rad temprad = rader.get(rad);
                Kolonne tempkol = kolonner.get(kol);
                Rute temprute = new Rute(tegnTilVerdi(c), temprad, tempkol, brettstorrelse);

                while(!(nyboks.settInnVerdi(temprute, rad, kol))){
                    if(bokstall < bokser.size() - 1){
                        bokstall++;
                    }
                    nyboks = bokser.get(bokstall);
                }
                temprute.setBoks(nyboks);
                rutearray[rad][kol] = temprute;


                if(temprute.getTall() > brettstorrelse){
                    throw new NumberFormatException();
                }

                temprute.setBoks(nyboks);

                if(temprute.getTall() != 0){
                    nyboks.fjernVerdi(temprute.getTall());
                    temprad.fjernVerdiIRad(temprute.getTall());
                    tempkol.fjernVerdiIKol(temprute.getTall());
                }

                bokstall = 0;
                nyboks = bokser.get(bokstall);
                kol++;
            }
            kol = 0;
            rad++;
        }


        int i = 0;
        l = 0;
    }

    public static int tegnTilVerdi(char tegn) {
        if (tegn == TOM_RUTE_TEGN) {                // tom rute, DENNE KONSTANTEN MAA DEKLARERES
            return 0;
        } else if ('1' <= tegn && tegn <= '9') {    // tegn er i [1, 9]
            return tegn - '0';
        } else if ('A' <= tegn && tegn <= 'Z') {    // tegn er i [A, Z]
            return tegn - 'A' + 10;
        } else if (tegn == '@') {                   // tegn er @
            return 36;
        } else if (tegn == '#') {                   // tegn er #
            return 37;
        } else if (tegn == '&') {                   // tegn er &
            return 38;
        } else if ('a' <= tegn && tegn <= 'z') {    // tegn er i [a, z]
            return tegn - 'a' + 39;
        } else {                                    // tegn er ugyldig
            return -1;
        }
    }

}