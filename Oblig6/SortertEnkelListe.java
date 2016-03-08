class SortertEnkelListe<E extends Comparable<E> & Lik> implements AbstraktSortertEnkelListe<E>{

	Node<E> hode = new Node<E>();
	Node<E> hale = new Node<E>();
	Node<E> foran = new Node<E>();
	int size = 0;

	public SortertEnkelListe(){
		hode.settNeste(hale);
	}

	public void settInn(E e){
		Node<E> nynode = new Node<E>(e);
			nynode.settNeste(foran.getNeste());
			foran.settNeste(nynode);
			System.out.println("Satt inn " + nynode.hentInnhold());
		}

	public void settInnSortert(E e){

		Node<E> nynode = new Node<E>(e);
		Node<E> tempnode = hode.getNeste();


		if(hode.getNeste().equals(hale)){
			nynode.settNeste(hale);
			hode.settNeste(nynode);
			foran = nynode;

			size++;
			return;
		}

		if(nynode.hentInnhold().compareTo(tempnode.hentInnhold()) <= 0){

			nynode.settNeste(hode.getNeste());
			hode.settNeste(nynode);

			size++;
			return;
		}

		Node<E> ettertemp = new Node<E>();
		Node<E> minste = new Node<E>();

		while(tempnode.harNeste()){
			ettertemp = tempnode.getNeste();
			//Sjekker om vi er i slutten av kjeden
			if(ettertemp.equals(hale)){
				nynode.settNeste(ettertemp);
				tempnode.settNeste(nynode);
				return;
			}
			if(nynode.hentInnhold().compareTo(ettertemp.hentInnhold()) <= 0){
				nynode.settNeste(ettertemp);

				tempnode.settNeste(nynode);

				return;
			}

			//ettertemp = ettertemp.getNeste();
			tempnode = tempnode.getNeste();

		}

		/*
		if((nynode.hentInnhold().compareTo(temp.hentInnhold())) < 0){
			nynode.settNeste(temp.getNeste());
			temp.settNeste(nynode);
			System.out.println("Satt inn " + nynode.hentInnhold());
		}*/
	}


	public NodeIterator<E> iterator(){
		return new NodeIterator<E>(hode);
	}

	public E finnElementFraString(String sokestring){
		if(!tom()){
			Node<E> tempnode = hode.getNeste();

			while(tempnode != hale){
				if(tempnode.hentInnhold().samme(sokestring)){
					return tempnode.hentInnhold();
				}
				tempnode = tempnode.getNeste();
			}
		}
		return null;
	}

	public boolean tom(){
		return hode.equals(hale);
	}

}
