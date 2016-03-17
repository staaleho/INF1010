import java.util.*;
import java.io.*;

class Test2{
	Scanner in = new Scanner(System.in);
	static Tabell<Legemiddel> legemiddeltabell = new Tabell<Legemiddel>(1000);
	static EnkelReseptListe reseptliste = new EnkelReseptListe();
	static SortertEnkelListe<Lege> legeliste = new SortertEnkelListe<Lege>();
	static Tabell<Pasient> pasienttabell = new Tabell<Pasient>(1000);

	public static void main(String[] args) throws Exception {
		lesFraFil();
		nyLegeFraMeny();
		/*

		NodeIterator<Pasient> pasientiterator = pasienttabell.iterator();
		while(pasientiterator.harNeste()){
			System.out.println(pasientiterator.neste().toString());
		}
		*/
	}

	public void nyLege(String navn){
		Lege nylege = new Lege(navn);
		legeliste.settInnSortert(nylege);
	}

	public void nyPasient(String navn, String fnummer, String adresse, String postnr){
		Pasient nypasient = new Pasient(navn, fnummer, adresse, postnr);
		pasienttabell.settInnPaaIndeks(nypasient, nypasient.getPasientNummer());
	}

	public void nyttLegeMiddel(String navn, String form, char type, int pris,
	double virkestofftotalt, double virkestoffienhet, int mengdeavenheter, int styrke){
		if(type == 'a'){
			if(form.equals("mikstur")){
				LegemiddelAFlytende nyttlegemiddel = new LegemiddelAFlytende(navn,
				pris, virkestofftotalt, virkestoffienhet, mengdeavenheter, styrke);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
				return;
			}

			if(form.equals("piller")){
				LegemiddelAPiller nyttlegemiddel = new LegemiddelAPiller(navn,
				pris, virkestofftotalt, virkestoffienhet, mengdeavenheter, styrke);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
				return;
			}else{
				System.out.println("Type A, men ikke pille eller mikstur");
			}
		}

		if(type == 'b'){
			if(form.equals("mikstur")){
				LegemiddelBFlytende nyttlegemiddel = new LegemiddelBFlytende(navn,
				pris, virkestofftotalt, virkestoffienhet, mengdeavenheter, styrke);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
				return;
			}

			if(form.equals("piller")){
				LegemiddelBPiller nyttlegemiddel = new LegemiddelBPiller(navn,
				pris, virkestofftotalt, virkestoffienhet, mengdeavenheter, styrke);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
				return;
			}else{
				System.out.println("Type B, men ikke pille eller mikstur");
			}
		}

		if(type == 'c'){
			if(form.equals("mikstur")){
				LegemiddelCFlytende nyttlegemiddel = new LegemiddelCFlytende(navn,
				pris, virkestofftotalt, virkestoffienhet, mengdeavenheter);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
				return;
			}

			if(form.equals("piller")){
				LegemiddelCPiller nyttlegemiddel = new LegemiddelCPiller(navn,
				pris, virkestofftotalt, virkestoffienhet, mengdeavenheter);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
				return;
			}else{
				System.out.println("Type B, men ikke pille eller mikstur");
			}


		}
	}

	public static void lesFraFil() throws Exception{

		Reader reader = new FileReader("dataset.txt");
		BufferedReader breader = new BufferedReader(reader);
		String str = null;
		String[] leserarray;


		while((str = breader.readLine()) != null){
			String fase = "";

			if(str.startsWith("#")){
				if(str.equals("# Slutt")){
					break;
				}
				String[] fasearray = str.split(" ");
				fase = fasearray[1];
				str = breader.readLine();
				while(!str.equals("")){

				switch(fase){
					case "Personer" :
					leserarray = str.split(", ");
					nyPasientFraArray(leserarray);

					break;

					case "Legemidler" :
					leserarray = str.split(", ");
					nyttLegeMiddelFraArray(leserarray);

					break;

					case "Leger" :
					leserarray = str.split(", ");
					nyLegeFraArray(leserarray);

					break;

					case "Resepter" :
					leserarray = str.split(", ");
					nyReseptFraArray(leserarray);

					break;

					default:
					break;
				}

				str = breader.readLine();
			}
			}

		}


	}

	static public void nyPasientFraArray(String[] personarray){
		Pasient nypasient = new Pasient(personarray[1], personarray[2],
		personarray[3], personarray[4]);
		pasienttabell.settInnPaaIndeks(nypasient, nypasient.getPasientNummer());

	}

	static public void nyttLegeMiddelFraArray(String[] legemiddelarray){
		String navn = legemiddelarray[1];
		int pris = Integer.parseInt(legemiddelarray[4]);
		double virkestofftotalt = Double.parseDouble(legemiddelarray[6]);
		int narkostyrke = 0;


		if(legemiddelarray[3].equals("a")){

			narkostyrke = Integer.parseInt(legemiddelarray[7]);

			if(legemiddelarray[2].equals("mikstur")){
				double cm3iflaske = Double.parseDouble(legemiddelarray[5]);
				double virkestofficm3 = (virkestofftotalt/cm3iflaske);

				LegemiddelAFlytende nyttlegemiddel = new LegemiddelAFlytende(navn,
				pris, virkestofftotalt, cm3iflaske, virkestofficm3, narkostyrke);

				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
			}

			if(legemiddelarray[2].equals("pille")){
				int pillerieske = Integer.parseInt(legemiddelarray[5]);
				double virkestofficm3 = (virkestofftotalt/pillerieske);

				LegemiddelAPiller nyttlegemiddel = new LegemiddelAPiller(navn,
				pris, virkestofftotalt, virkestofficm3, pillerieske, narkostyrke);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());

			}


		}

		if(legemiddelarray[3].equals("b")){

			if(legemiddelarray[2].equals("mikstur")){
				double cm3iflaske = Double.parseDouble(legemiddelarray[5]);
				double virkestofficm3 = (virkestofftotalt/cm3iflaske);

				LegemiddelBFlytende nyttlegemiddel = new LegemiddelBFlytende(navn,
				pris, virkestofftotalt, cm3iflaske, virkestofficm3, narkostyrke);

				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
			}

			if(legemiddelarray[2].equals("pille")){
				int pillerieske = Integer.parseInt(legemiddelarray[5]);
				double virkestofficm3 = (virkestofftotalt/pillerieske);

				LegemiddelBPiller nyttlegemiddel = new LegemiddelBPiller(navn,
				pris, virkestofftotalt, virkestofficm3, pillerieske, narkostyrke);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());

			}
		}

		if(legemiddelarray[3].equals("c")){

			if(legemiddelarray[2].equals("mikstur")){
				double cm3iflaske = Double.parseDouble(legemiddelarray[5]);
				double virkestofficm3 = (virkestofftotalt/cm3iflaske);

				LegemiddelCFlytende nyttlegemiddel = new LegemiddelCFlytende(navn,
				pris, virkestofftotalt, cm3iflaske, virkestofficm3);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());
			}

			if(legemiddelarray[2].equals("pille")){
				int pillerieske = Integer.parseInt(legemiddelarray[5]);
				double virkestofficm3 = (virkestofftotalt/pillerieske);

				LegemiddelCPiller nyttlegemiddel = new LegemiddelCPiller(navn,
				pris, virkestofftotalt, virkestofficm3, pillerieske);
				legemiddeltabell.settInnPaaIndeks(nyttlegemiddel, nyttlegemiddel.getNummer());

			}
		}
		/*
		String navn = legemiddelarray[1];
		int pris = Integer.parseInt(legemiddelarray[4]);
		double virkestofftotalt = Double.parseDouble(legemiddelarray[6]);
		double cm3iflaske = Double.parseDouble(legemiddelarray[5]);
		double virkestofficm3 = (virkestofftotalt/cm3iflaske);
		int narkostyrke = Integer.parseInt(legemiddelarray[7]);
		*/
	}

	static public void nyLegeFraArray(String[] legearray){
		Lege nylege = new Lege(legearray[0]);

		if(legearray[1].equals("1")){
			nylege.opprettAvtale();
		}
		legeliste.settInnSortert(nylege);
	}

	static public void nyReseptFraArray(String[] reseptarray){
		Legemiddel reseptpaa = legemiddeltabell.finnFraIndeks((Integer.parseInt(reseptarray[4])));
		Lege utstedtav = legeliste.finnElementFraString(reseptarray[3]);
		Pasient utstedttil = pasienttabell.finnFraIndeks((Integer.parseInt(reseptarray[2])));
		int reit = Integer.parseInt(reseptarray[5]);
		int pris = reseptpaa.getPris();

		if(reseptarray[1].equals("blaa")){
			pris = 0;
		}

		Resept nyresept = new Resept(reseptpaa, utstedtav, utstedttil, reit, pris);
		reseptliste.settInn(nyresept);
		System.out.println(utstedttil.toString());
	}

	static public void nyLegeFraMeny(){

		String[] innlegearray;
		System.out.println("Skriv inn lege paa formatet Navn(mellomrom)1 (hvisavtale)0(hvis ikke)");
		String menylege = in.nextLine();
		innlegearray = menylege.split(" ");
		nyLegeFraArray(innlegearray);
	}

	static public void nyttLegeMiddelFraMeny(){
		Scanner in = new Scanner(System.in);
	}
}
