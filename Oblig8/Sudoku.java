class Sudoku {
    static char TOM_RUTE_TEGN = '.';
    static Brett brett;


    public static void main(String[] args) {

        lesFraFil();

    }

    static private void lesFraFil() {
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
        Reader reader;
        Scanner filscanner;


        Scanner in = new Scanner(System.in);
        System.out.println("Hvilken fil vil du lese fra?");
        String filstring = in.nextLine();

        try {
            FileReader fis = new FileReader(filstring + ".txt");
            BufferedReader buffreader = new BufferedReader(fis);
            int character;
            int totruter = 0;
            while((character = fis.read()) != -1) {

                try {
                    counter++;
                    if(counter == 1 && character != -1){
                        riboks = tegnTilVerdi((char) character);
                        System.out.println("riboks er " + riboks);
                    }
                    if(counter == 3 && character != -1){
                        kiboks = tegnTilVerdi((char) character);
                        System.out.println("kiboks er " + kiboks);
                        System.out.println("character er " + character);
                        //Brett brett = new Brett(riboks, kiboks);
                        totruter = riboks * kiboks;
                    }

                    System.out.println(counter + " teller");
                    System.out.println("character er " + character + ", totruter er " + totruter);
                    System.out.println("tegn til verdi " + tegnTilVerdi((char) character));
                    System.out.println(verdiTilTegn(tegnTilVerdi((char) character), TOM_RUTE_TEGN));
                    if(tegnTilVerdi((char) character) > totruter){
                        throw new IllegalArgumentException("meek");
                    }
                    //char ch = verdiTilTegn(fis.read(), TOM_RUTE_TEGN);

                }
                catch (UgyldigVerdiUnntak uvu) {
                    System.out.println("Ugyldig verdi");
                    //System.out.println(fis.read());
                }

                catch (IllegalArgumentException iae){
                    System.out.println("Verdien er for stor for brettet");
                }
            }
        }catch (IOException e){
            System.out.println("IOException");
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