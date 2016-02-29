public class Tabell <E> implements AbstraktTabell<E>{
	private E[] tabell;

	public Tabell(int storrelse){
		this.tabell =  (E[]) new Object[storrelse];
	}

	public boolean settInnPaaIndeks(E e, int indeks){
		if(indeks > tabell.length){
			System.out.println("Array ikke stor nok.");
			return false;
		}else if(tabell[indeks] != null){
			System.out.println("Plass ikke tom.");
			return false;
		}else{
			tabell[indeks] =  e;
			return true;
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
