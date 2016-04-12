import java.util.*;
import java.io.*;
import java.util.ArrayList;



class Sudoku {
    static char TOM_RUTE_TEGN = '.';
    static Brett brett;


    public static void main(String[] args) {
        lesFil();
    }

    static private void lesFil() {
        try {
            findFile();
        } catch (FileNotFoundException e) {
            System.out.println("Fil ikke funnet.");
        }
    }

    static private void findFile() throws FileNotFoundException {
        int riboks = 0;
        int kiboks = 0;
        int counter = 0;
        int kbrtall;
        int brettstorrelse;
        int hoyestetall = 0;
        int maksstorrelse = 64;
        Reader reader;
        Scanner filscanner;
        Brett nyttbrett;

        Scanner in = new Scanner(System.in);
        System.out.println("Hvilken fil vil du lese fra?");
        String filstring = in.nextLine();

        try {
            FileReader fis = new FileReader(filstring + ".txt");
            BufferedReader buffreader = new BufferedReader(fis);
            int character;
            int totruter = 0;
            char[][] innlestfil = new char[63][63];
            char[] tempchararray;

            String s;
            riboks = Integer.parseInt(buffreader.readLine());

            kiboks = Integer.parseInt(buffreader.readLine());

            brettstorrelse = (riboks * kiboks);
            if((brettstorrelse * brettstorrelse) > (maksstorrelse * maksstorrelse)){
                throw new IndexOutOfBoundsException();
            }

            int i = 0;
            int j = 0;
            while((s = buffreader.readLine()) != null) {

                tempchararray = s.toCharArray();
                innlestfil[i] = tempchararray;
                i++;
            }

            char[][] ferdigbrett = new char[i][i];

            while(j < i){
                ferdigbrett[j] = innlestfil[j];
                j++;
            }


            nyttbrett = new Brett(riboks, kiboks, ferdigbrett);

            nyttbrett.skrivBrett();

        }catch (IOException e){
            System.out.println("Filen finnes ikke.");
        }catch (ArrayIndexOutOfBoundsException ar){
            System.out.println("Array Exception.");
        }catch (NumberFormatException nfe){
            System.out.println("Ugyldig tall funnet.");
        }catch(IndexOutOfBoundsException ioobe){
            System.out.println("Brettet er for stort.");
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