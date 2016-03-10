class IndreKlasse{
	static int tall1 = 0;
	int tall2 = 0;

	public IndreKlasse(){
		tall1++;
		tall2 = tall1;
	}
	public int sendTall2(){
		return tall2;
	}
}
