public interface AbstraktTabell<E>{
	public boolean settInnPaaIndeks(E e, int indeks);
	public E finnFraIndeks(int indeks);
	public NodeIterator<E> iterator();
}
