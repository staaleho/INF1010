public class NodeIterator<E> implements Iterator<E>{

	private Node<E> foran;

	public NodeIterator(Node foran){
		this.foran = foran;
	}

	public E neste(){
		E innhold = foran.hentInnhold();
		foran = foran.getNeste();
		return innhold;
	}

	public boolean harNeste(){
		return foran.getNeste() != null;
	}

}
