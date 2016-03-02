class SortertEnkelListe<E extends Comparable<E> & Lik> implements AbstraktSortertEnkelListe<E>{

	Node<E> hode, hale;

	public SortertEnkelListe(){
		Node<E> hode = new Node();
		Node<E> hale = new Node();
		hode.settNeste(hale);
	}

	public void settInnSortert(E e){
		Node nynode = new Node(e);
		Node temp = hode;

		if(hode.getNeste() == hale){
			hode.settNeste(nynode);
			nynode.settNeste(hale);
			return;
		}

	}

	public NodeIterator<E> iterator(){
		return new NodeIterator<E>(hode);
	}

	public E finnElementFraString(String sokestring){
		return null;
	}

	public boolean tom(){
		return hode.getNeste() != hale;
	}



}
