class YngsteForstReseptListe extends EnkelReseptListe{

	public void settInnYngsteForst(Resept nyresept){
		Node<Resept> nynode = new Node<Resept>(nyresept);
		
		nynode.settNeste(hode.getNeste());
		hode.settNeste(nynode);
		if(erTom()){
			hale = nynode;
		}
	}
}
