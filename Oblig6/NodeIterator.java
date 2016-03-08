public class NodeIterator<E> implements Iterator<E>{

	private Node<E> foran;
	private Node<E> denne;

	public NodeIterator(Node<E> foran){
		this.foran = foran;
		denne = foran.getNeste();
	}

	public E neste(){
		E innhold = denne.hentInnhold();
		denne = denne.getNeste();
		return innhold;
	}

	public boolean harNeste(){
		return denne.hentInnhold() != null;
	}

	public E hentDenne(){
		
		return denne.hentInnhold();
	}

}
