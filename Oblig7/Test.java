import java.util.*;

class Test {
	static Scanner in = new Scanner(System.in);
	static private int lopenrresept = 0;
	static private int lopenrpasient = 0;
	static private int lopenravtale = 0;


	static private HashMap <Integer, Resept> resepter = new HashMap <Integer, Resept>();
	static private HashMap <Integer, Pasient> pasienter = new HashMap <Integer, Pasient>();
	static private HashMap <Integer, Legemiddel> legemidler = new HashMap <Integer, Legemiddel>();
	static private HashMap <String, Lege> leger = new HashMap <String, Lege>();

	public static void main(String[] args){

	}

public static Resept nyResept(){
	Pasient reseptpasient = null;
	Legemiddel reseptlegemiddel;
	Lege reseptlege;
	int reseptreitinnint;
	int reseptprisinnint;
	int reseptnummer = lopenrresept;

	System.out.println("Hvilket middel er resepten paa?");
	String legemiddelinn = in.nextLine();
	int legemiddelinnint = Integer.parseInt(legemiddelinn);
		if(legemidler.containsKey(legemiddelinnint)){
			reseptlegemiddel = legemidler.get(legemiddelinnint);
		}
		else{
			System.out.println("Legemiddel ikke funnet!");
			return null;
		}

	System.out.println("Hvem skal utstede resepten?");
	String legeinn = in.nextLine();
		if(leger.containsKey(legeinn)){
			reseptlege = leger.get(legeinn);
		}
		else{
			System.out.println("Lege ikke funnet!");
			return null;
		}

	System.out.println("Hvem skal resepten utstedes til?");
	String pasientinn = in.nextLine();
		for(Pasient p : pasienter.values()){
//			if(p.samme(pasientinn)){
//				reseptpasient = p;
//			}
//			else{
//			}
		}

	System.out.println("Hvor stor reit?");
	String reitinn = in.nextLine();
	reseptreitinnint = Integer.parseInt(reitinn);

	System.out.println("Hvor mye koster den?");
	String prisinn = in.nextLine();
	reseptprisinnint = Integer.parseInt(prisinn);

	Resept nyresept = new Resept(reseptlegemiddel, reseptlege, reseptpasient,
	reseptreitinnint, reseptprisinnint);

	lopenrresept++;
	return nyresept;
	}
}
