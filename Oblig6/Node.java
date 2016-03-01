class Node<E>{
	private E innhold;
	private Node neste;

	public Node (E innhold){
		this.innhold = innhold;
	}

	public Node(){

	}

	public void settNeste(Node neste){
		this.neste = neste;
	}

	public Node getNeste(){
		return this.neste;
	}

	public E hentInnhold(){
		return this.innhold;
	}
}