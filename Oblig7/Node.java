class Node<E>{
	private E innhold;
	private Node neste;

	public Node (E innhold){
		this.innhold = innhold;
	}

	public Node(){

	}

	public void settNeste(Node<E> neste){
		this.neste = neste;
	}

	public Node getNeste(){
		return this.neste;
	}

	public E hentInnhold(){
		return innhold;
	}

	public boolean harNeste(){
		return this.neste != null;
	}

}
