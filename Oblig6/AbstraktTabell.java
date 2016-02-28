public interface AbstraktTabell<E>{
	public boolean settInnPaaIndeks(E e, int indeks);
	public E returFraIndeks(int indeks);
	public void iterate();
}
