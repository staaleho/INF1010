public interface AbstraktSortertEnkelListe <E extends Comparable<E> & Lik>{
	public void settInnSortert(E e);
	public E finnElementFraString(String sokestring);
	public NodeIterator<E> iterator();
}
