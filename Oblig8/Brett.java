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
        try{
            opprettDataStruktur(nyttbrett);
        }catch (NumberFormatException n){
            System.out.println("Systemet avslutter pga ulovlig tegn.");
            System.exit(0);
        }

    }

    protected static char getTomRuteTegn() {
        return TOM_RUTE_TEGN;
    }

    protected static void setTomRuteTegn(char tomRuteTegn) {
        TOM_RUTE_TEGN = tomRuteTegn;
    }

    public void skrivBrett() {
        int radteller = 0;
        int kolonneteller = 1;
        int understrekteller = 1;
        int plussteller = 0;
        try {
            for (Rute[] rarr : rutearray) {
                for (Rute r : rarr) {
                    if (r.getTall() == 0) {
                        System.out.print(" ");
                    } else if (r.getTall() > 9) {
                        System.out.println(verdiTilTegn(r.getTall(), ' '));
                    } else {
                        System.out.print(r.getTall());

                    }
                    if (kolonneteller > 1 && kolonneteller % kiboks == 0 && kolonneteller != brettstorrelse) {
                        System.out.print("|");
                    }
                    kolonneteller++;
                }
                System.out.println();
                kolonneteller = 0;
                radteller++;

                if (radteller % riboks == 0 && radteller > 1 && radteller < brettstorrelse) {
                    while (understrekteller < brettstorrelse+riboks) {
                        if (understrekteller % (kiboks+1) == 0 && understrekteller > 1) {
                            System.out.print("+");
                            understrekteller++;
                        } else {
                            System.out.print("-");
                            understrekteller++;
                        }
                    }
                    understrekteller = 1;
                    System.out.println();

                    plussteller = 0;
                }
                kolonneteller = 1;
            }
            System.out.println("riboks " + riboks);
        }catch(UgyldigVerdiUnntak ug){
            System.out.println("Ugyldig verdi.");/*
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
        }
        rutearray[2][2].getAllRuteInfo();
        System.out.println("Mulige tall er: ");
        for(int i : rutearray[2][2].finnAlleMuligeTall()){
            System.out.println(i);
        }

    }

    public void opprettDataStruktur(char[][] chararray) throws NumberFormatException{

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
        int charteller = 0;

        Boks nyboks = bokser.get(0);
        System.out.println(chararray[3][0] + " char");
        while(rad < rutearray.length){

            for(char c : chararray[rad]){
                charteller++;
                System.out.println(c);
                if(tegnTilVerdi(c) > brettstorrelse){
                    System.out.println("For stort for dette brettet.");
                    throw new NumberFormatException();
                }
                else if(tegnTilVerdi(c) < 0){
                    System.out.println("Ugyldig tegn.");
                    throw new NumberFormatException();
                }
                else if(charteller > (brettstorrelse * brettstorrelse)){
                    System.out.println("For mange tegn.");
                    throw new NumberFormatException();
                }

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

    public static char verdiTilTegn(int verdi, char tom) throws UgyldigVerdiUnntak{
        if (verdi == 0) {                           // tom
            return tom;
        } else if (1 <= verdi && verdi <= 9) {      // tegn er i [1, 9]
            return (char) (verdi + '0');
        } else if (10 <= verdi && verdi <= 35) {    // tegn er i [A, Z]
            return (char) (verdi + 'A' - 10);
        } else if (verdi == 36) {                   // tegn er @
            return '@';
        } else if (verdi == 37) {                   // tegn er #
            return '#';
        } else if (verdi == 38) {                   // tegn er &
            return '&';
        } else if (39 <= verdi && verdi <= 64) {    // tegn er i [a, z]
            return (char) (verdi + 'a' - 39);
        } else {                                    // tegn er ugyldig
            throw new UgyldigVerdiUnntak(verdi);    // HUSK DEFINISJON AV UNNTAKSKLASSE
        }
    }

}