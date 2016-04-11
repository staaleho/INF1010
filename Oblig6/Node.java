class Node<E>{
	private E innhold;
	private Node next;

	public Node (E innhold){
		this.innhold = innhold;
	}

	public Node(){

	}

	public void settNeste(Node<E> next){
		this.next = next;
	}

	public Node getNeste(){
		return this.next;
	}

	public E hentInnhold(){
		return innhold;
	}

	public boolean hasNext(){
		return this.next != null;
	}

}
