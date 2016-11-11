import java.util.Scanner;
import java.util.Arrays;

public class Joueur {
	protected String nom;
	protected int age;
	protected int id;
	protected boolean tour;
	protected boolean gagne;
	protected int points;
	//protected CarteMain main;
	protected int pointsMenhirs;
	protected int grainesACote;
	
	public Joueur(String nom, int age, int id) {
		super();
		this.nom = nom;
		this.age = age;
		this.id = id;
		this.gagne = false;
		this.points = 0;
		this.tour = false;
		this.pointsMenhirs = 0;
		this.grainesACote = 0;
	}

	@Override
	public String toString() {
		
		/*
		StringBuffer sb = new StringBuffer();
		sb.append("Joueur [nom :");
		sb.append(nom);
		
		return sb.toString();
		*/
		
		return "Joueur [nom=" + nom + ", age=" + age + ", id=" + id + ", tour=" + tour + ", gagne=" + gagne +
		", points=" + points + ", pointsMenhirs=" + pointsMenhirs + ", grainesACote=" + grainesACote + "]";
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isTour() {
		return tour;
	}
	public void setTour(boolean tour) {
		this.tour = tour;
	}

	public boolean isGagne() {
		return gagne;
	}

	public void setGagne(boolean gagne) {
		this.gagne = gagne;
	}
	public boolean getGagne(){
		return gagne;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getPointsMenhirs() {
		return pointsMenhirs;
	}
	public void setPointsMenhirs(int pointsMenhirs) {
		this.pointsMenhirs = pointsMenhirs;
	}
	public int getGrainesACote() {
		return grainesACote;
	}
	public void setGrainesACote(int grainesACote) {
		this.grainesACote = grainesACote;
	}

	//public void login()
	
	public void piocherAllieeOu2Graines(Blocdecarte bloc, CarteMain main) throws Exception {
		int choix = 0;
		do
		{
		System.out.println("Voulez vous piocher une carte Alliée ou 2 graines ?");
		System.out.println("1.Piocher Carte Alliée");
		System.out.println("2.Piocher 2 Graines");
		System.out.println("Votre choix ?");
		Scanner s = new Scanner(System.in);
		choix = s.nextInt();
		}while(choix != 1 && choix != 2);
		if (choix == 1)
		{
			Carte [] liste = main.getListeCarte();
			Ingredient Ing = (Ingredient) liste[0];
			Ingredient Ing2 = (Ingredient) liste[1];
			Ingredient Ing3 = (Ingredient) liste[2];
			Ingredient Ing4 = (Ingredient) liste[3];
			Alliee all1 = bloc.getAllieeRandom();
			Carte [] listeMain = {Ing, Ing2,Ing3,Ing4, all1};
			main.setListeCarte(listeMain);
			this.setGagne(true); 
		}
		else if (choix == 2)
		{
			this.grainesACote += 2;
		}
		else
			System.out.println("Merci de choisir un choix valide !");
	}
	
	
	public void poserCarteIngredient(String tour, CarteMain main, Joueur [] joueurs, int nbJoueur, CarteMain [] mainCible, Joueur moi) throws Exception
	{
		int choix = 0;
		int choix2 =0;
		System.out.println("Quel carte voulez vous choisir ?");
		System.out.println(main.toString());
		Scanner s = new Scanner(System.in);
		choix2 = s.nextInt();
		Carte [] cartes = main.getListeCarte();
		Ingredient ing = (Ingredient) cartes[choix2];
		do
		{
		System.out.println("Veuillez choisir votre type de carte ?");
		System.out.println("1.Poser Géant");
		System.out.println("2.Poser Engrais");
		System.out.println("3.Poser Farfadet");
		System.out.println("Votre choix ?");
		choix = s.nextInt();
		}while(choix != 1 && choix != 2 && choix != 3);
		if (choix == 1)
		{
			Geant geant = new Geant();
			geant.retirerGrainesPC(this, ing, tour);
			main.deleteCarteMain(ing);
		}
		else if (choix == 2)
		{
			Engrais engrais = new Engrais();
			engrais.pousserGraines(this, ing, tour);
			main.deleteCarteMain(ing);
		}
		else if (choix == 3)
		{
			Farfadet farfadet = new Farfadet();
			Joueur cible;
			do
			{
				 cible = farfadet.choisirAdversaire(joueurs, nbJoueur);
			}while(cible == moi);
			if(cible.getGagne())
			{
			int numMain = cible.getId() - 1;
			Carte [] tmp = mainCible[numMain].getListeCarte();
			Carte TMP = tmp[0];
			int c = 0;
			while(tmp[c] != null && c != tmp.length -1)
			{
				TMP = tmp[c];
				c++;
			}
			if(c == tmp.length -1 && tmp[c] != null)
			{
				TMP = tmp[4];
			}
			Alliee alliee = (Alliee) TMP;
			int Tab [] = {2,0,2,0};
			int Tab2 [] = {1,2,0,1};
			int Tab3 [] = {0,1,3,0};
			if(Arrays.equals(alliee.getPoints(), Tab) || Arrays.equals(alliee.getPoints(), Tab2) || Arrays.equals(alliee.getPoints(), Tab3))
			{
				if (cible instanceof JoueurPhysique)
				{
					do
					{
					System.out.println("Voulez vous utiliser votre carte chien de garde ? ?");
					System.out.println("1.Oui");
					System.out.println("2.Non");
					System.out.println("Votre choix ?");
					choix = s.nextInt();
					}while(choix != 1 && choix != 2);
				}
				else
				{
					choix = (int) (2 * Math.random());
				}
				if(choix == 1)
				{
					ChienDeGarde chien = new ChienDeGarde(alliee.getPoints());
					chien.protegerGraines(ing, tour, cible, this);
					mainCible[numMain].deleteAllieeMain(chien);
				}
			}
			}
			else
			{
				farfadet.VolerGraines(this, cible, ing, tour);
			}
			main.deleteCarteMain(ing);
		}
		else
			System.out.println("Merci de choisir un choix valide !");
	}
	public void poserCarteAlliee(Alliee alliee, CarteMain main, Joueur [] joueurs, int NbJoueur, String tour) throws Exception
	{
		int Tab [] = {1,1,1,1};
		int Tab2 [] = {0,2,2,0};
		int Tab3 [] = {0,1,2,1};
		if (Arrays.equals(alliee.getPoints(), Tab) || Arrays.equals(alliee.getPoints(), Tab2) || Arrays.equals(alliee.getPoints(), Tab3)) // TaupeGéante
		{
			TaupeGeante TG1 = new TaupeGeante(alliee.getPoints());
			Joueur cible = TG1.choisirAdversaire(joueurs, NbJoueur);
			TG1.detruireMenhirs(cible,tour);
			main.deleteCarteMain(alliee);
		}
		else
		{
			System.out.println("Ca ne sert a rien de le poser maintenant !");
			this.setGagne(true);
		} 
	}
	public void choisirPartie(Joueur [] joueurs, CarteMain [] mains, Blocdecarte [] BLOC, Partie P) throws Exception
	{
		int choix = 0;
		do
		{
		System.out.println("Veuillez choisir un mode de jeu ?");
		System.out.println("1.Partie Rapide");
		System.out.println("2.Partie Avancée");
		System.out.println("Votre choix ?");
		Scanner s = new Scanner(System.in);
		choix = s.nextInt();
		}while(choix != 1 && choix != 2);
		if (choix == 1)
		{
				P.lancerPartieRapide(joueurs, mains, BLOC[0]);
		}
		else if (choix == 2)
		{
				P.lancerPartieAvancee(joueurs, mains, BLOC);
		}
		else
			System.out.println("Merci de choisir un choix valide !");
		
	}
}
