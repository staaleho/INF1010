class UgyldigVerdiUnntak extends Exception{
    public UgyldigVerdiUnntak(int verdi) {
        super("Ugyldig tegn " + verdi);
    }
}