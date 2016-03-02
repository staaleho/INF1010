class SortertEnkelListe<E> extends AbstraktSortertEnkelListe<E extends Comparable<E>>{

	Node<E> hode, hale;

	public SortertEnkelListe(){
		Node<E> hode = new Node();
		Node<E> hale = new Node();
		hode.settNeste(hale);
	}

	public void settInnSortert(E e){
		Node nynode = new Node(e);
		Node temp = null;
		if(hode.getNeste() == hale){
			hode.settNeste(nynode);
			nynode.settNeste(hale);
			return;
		}

		temp = hode;
		while(temp.getNeste().hentInnhold().compareTo(nynode.hentInnhold()) < 0){
			temp = temp.getNeste();
		}
		nynode.settNeste(temp.getNeste());
		temp.settNeste(nynode);
	}

	public NodeIterator<E> iterator(){
		return new NodeIterator<E>(hode);
	}

	public E finnElementFraString(String sokestring){
		if(!tom()){
			Node temp = hode;
			while(!(temp.getNeste().equals(hale))){
				if(temp.hentInnhold().equals(sokestring)){
					return temp.hentInnhold();
				}
			}
		}

	}

	public boolean tom(){
		return hode.getNeste() != hale;
	}



}
