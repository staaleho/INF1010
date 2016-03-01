public class Tabell<E> implements AbstraktTabell<E>{

private E[] tabell;

public Tabell(int storrelse){
	tabell =  (E[]) new Object[storrelse];
	this.tabell =  (E[]) new Object[storrelse];
}

public boolean settInnPaaIndeks(E e, int indeks){
	if(tabell[indeks] == null) {
		tabell[indeks] = e;
		return true;
	}else{
		System.out.println("Plass ikke ledig.");
		return false;
	}
}
public E finnFraIndeks(int indeks){
	if(indeks < tabell.length) {
		return tabell[indeks];
	}else{
		System.out.println("Element ikke funnet.");
		return null;
	}
}
public NodeIterator<E> iterator(){
	Node foran = new Node();
	for(int i = 0; i < tabell.length; i++) {
		if(tabell[i] != null) {
			Node nynode = new Node(tabell[i]);
			nynode.settNeste(foran);
			foran = nynode;
		}
	}

	return new NodeIterator<E>(foran);
}

}
