class SortertEnkelListe<E extends Comparable<E> & Lik> implements AbstraktSortertEnkelListe<E> {

    Node<E> hode = new Node<E>();
    Node<E> hale = new Node<E>();

    public SortertEnkelListe() {
        hode.settNeste(hale);
    }

    public void settInn(E e) {
        Node<E> nynode = new Node<E>(e);
        nynode.settNeste(hode.getNeste());
        hode.settNeste(nynode);
        System.out.println("Satt inn " + nynode.hentInnhold());
    }

    public void settInnSortert(E e) {

        Node<E> nynode = new Node<E>(e);
        Node<E> tempnode = hode.getNeste();

        //Hvis hale kommer etter next er listen tom.
        if (hode.getNeste().equals(hale)) {
            nynode.settNeste(hale);
            hode.settNeste(nynode);
            return;
        }

        if (nynode.hentInnhold().compareTo(tempnode.hentInnhold()) <= 0) {
            nynode.settNeste(hode.getNeste());
            hode.settNeste(nynode);
            return;
        }

        Node<E> ettertemp = new Node<E>();
        while (tempnode.hasNext()) {
            ettertemp = tempnode.getNeste();
            //Sjekker om vi er i slutten av kjeden
            if (ettertemp.equals(hale)) {
                nynode.settNeste(ettertemp);
                tempnode.settNeste(nynode);
                return;
            }
            if (nynode.hentInnhold().compareTo(ettertemp.hentInnhold()) <= 0) {
                nynode.settNeste(ettertemp);
                tempnode.settNeste(nynode);
                return;
            }
            //ettertemp = ettertemp.getNeste();
            tempnode = tempnode.getNeste();
        }

    }


    public NodeIterator<E> iterator() {
        return new NodeIterator<E>(hode);
    }

    public E finnElementFraString(String sokestring) {
        if (!tom()) {
            Node<E> tempnode = hode.getNeste();

            while (tempnode != hale) {
                if (tempnode.hentInnhold().samme(sokestring)) {
                    return tempnode.hentInnhold();
                }
                tempnode = tempnode.getNeste();
            }
        }
        return null;
    }

    public boolean tom() {
        return hode.equals(hale);
    }

}
