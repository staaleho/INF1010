class EldsteForstReseptListe extends EnkelReseptListe{

	public void settInnEldsteForst(Resept nyresept){
		Node<Resept> nynode = new Node<Resept>(nyresept);
		hale.settNeste(nynode);
		nynode.settNeste(new Node<Resept>());
		hale = nynode;
	}
}
