class Brett{
    int riboks;
    int kiboks;
    int kbrtall;
    Rute[][] brett;

    public Brett(int riboks, int kiboks) {
        this.riboks = riboks;
        this.kiboks = kiboks;
        kbrtall = riboks * kiboks;
        brett = new Rute[riboks][kiboks];
    }
}