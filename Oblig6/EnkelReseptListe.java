class EnkelReseptListe<Resept>{

	Node<Resept> hode = new Node<Resept>();
	Node<Resept> hale = new Node<Resept>();

	public EnkelReseptListe(){
		hale = hode;
		hale.settNeste(new Node<Resept>());
	}

	public boolean erTom(){
		return hode.equals(hale);
	}

	public void settInn(Resept nyresept){
		Node<Resept> nynode = new Node<Resept>(nyresept);
		if(erTom()){
			nynode.settNeste(hode.getNeste());
			hode.settNeste(nynode);
			hale = nynode;
			hale.settNeste(new Node<Resept>());
		}else{
			hale.settNeste(nynode);
			nynode.settNeste(new Node<Resept>());
			hale = nynode;
		}


	}

	public Resept finnResept(int reseptnummer){
		if(!erTom()){
			if(reseptnummer == hale.hentInnhold().getReseptnummer()){
				return hale.hentInnhold();
			}

			Node<Resept> tempnode = hode.getNeste();

			while(tempnode != hale){
			if(reseptnummer == tempnode.hentInnhold().getReseptnummer()){
				return tempnode.hentInnhold();
			}
			tempnode = tempnode.getNeste();
			}


		}
		throw new IllegalArgumentException("Resept finnes ikke.");
	}

	public Iterator iterator(){
		return new Iterator(hode);
	}
}
