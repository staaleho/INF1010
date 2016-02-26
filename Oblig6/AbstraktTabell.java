public interface AbstraktTabell<E>{
	public boolean settInnPaaIndeks(int indeks);
	public E returFraIndeks(int indeks);
	public void iterate();
}
