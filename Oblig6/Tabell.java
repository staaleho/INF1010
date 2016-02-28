public class Tabell <E> implements AbstraktTabell{
	private E[] tabell;

	public Tabell(int storrelse){
		tabell =  (E[]) new Object[storrelse];
	}

	public boolean settInnPaaIndeks(E e, int indeks){
		if(indeks > tabell.length){
			System.out.println("Array ikke stor nok.");
			return false;
		}else{
			tabell[indeks] = e;
		}
	}
	public E returFraIndeks(int indeks){
		return tabell[indeks];
	}
	public void iterate(){
		int counter = 0;
		for(E e : tabell){

			System.out.println(tabell[counter]);
			counter++;
		}
	}
}
