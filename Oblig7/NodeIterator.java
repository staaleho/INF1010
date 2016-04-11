import java.util.*;

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
		return denne.getNeste() != null;
	}

	public E hentDenne(){
		return denne.hentInnhold();
	}

	public boolean hasNext(){
		return denne.getNeste() != null;
	}

	public E next(){
		return denne.hentInnhold();
	}

	public void remove(){

	}

}
