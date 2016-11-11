import java.util.Arrays;
import java.util.Scanner;

public class Partie {
	private int manche;
	private String tour;
	public int getManche() {
		return manche;
	}
	public void setManche(int manche) {
		this.manche = manche;
	}
	public String getTour() {
		return tour;
	}
	public void setTour(String tour) {
		this.tour = tour;
	}
	@Override
	public String toString() {
		return "Partie [manche=" + manche + ", tour=" + tour + "]";
	}
	public Partie(int manche, String tour) {
		super();
		this.manche = manche;
		this.tour = tour;
	}
	public void lancerPartieRapide(Joueur[] joueurs, CarteMain [] mains, Blocdecarte bloc) throws Exception{
		int nbJoueur = 0;
		Joueur winner = joueurs[0];
		tour = "Printemps";
		System.out.println("Cb de joueurs ?");
		do
		{
		Scanner s = new Scanner(System.in);
		nbJoueur = s.nextInt();
		}while(nbJoueur <= 1 && nbJoueur > 6);
		for(int k = 0; k < nbJoueur; k++)
		{
			joueurs[k].setGrainesACote(2);
			bloc.distribuerCartesIngredient(mains[k]);
		}
		int tourDeJeu = 4;
		while (tourDeJeu != 0)
		{
			if(tourDeJeu == 3)
			{
				tour = "Été";
			}
			else if(tourDeJeu == 2)
			{
				tour = "Automne";
			}
			else if(tourDeJeu == 1)
			{
				tour = "Hiver";
			}
			for(int t = 0; t < nbJoueur; t++)
			{
				if(joueurs[t] instanceof JoueurPhysique)
				{
					joueurs[t].poserCarteIngredient(tour,mains[t],joueurs, nbJoueur, mains, joueurs[t]);
				}
				else
				{
					JoueurVirtuel J = (JoueurVirtuel)joueurs[t];
					J.poserCarteIngredient(tour, mains[t], joueurs, nbJoueur, mains, J);
				}
			}
			tourDeJeu--;
		}
		for(int w = 0; w < nbJoueur - 1; w++)
		{
			if(joueurs[w].pointsMenhirs < joueurs[w + 1].pointsMenhirs)
			{
				winner = joueurs[w + 1];
			}
		}
		System.out.println(winner.toString());
	}
	
	public void lancerPartieAvancee(Joueur [] joueurs, CarteMain [] mains, Blocdecarte [] BLOC) throws Exception{
		int nbJoueur = 0;
		int choice = 0;
		int manche = 1;
		Joueur winner = joueurs[0];
		tour = "Printemps";
		do
		{
		System.out.println("Cb de joueurs ?");
		Scanner s = new Scanner(System.in);
		nbJoueur = s.nextInt();
		}while(nbJoueur <= 1 && nbJoueur > 6);
		for(manche = 1; manche <= nbJoueur; manche++)
		{
			for(int k = 0; k < nbJoueur; k++)
			{
				BLOC[manche].distribuerCartesIngredient(mains[k]);
				if(joueurs[k] instanceof JoueurPhysique)
				{
					joueurs[k].piocherAllieeOu2Graines(BLOC[manche], mains[k]);
				}
				else
				{
					JoueurVirtuel J = (JoueurVirtuel)joueurs[k];
					J.piocherAllieeOu2Graines(BLOC[manche], mains[k], (int)(10 * Math.random()), J);
				}
			}
			int tourDeJeu = 4;
			while (tourDeJeu != 0)
			{
				if(tourDeJeu == 3)
				{
					tour = "Été";
				}
				else if(tourDeJeu == 2)
				{
					tour = "Automne";
				}
				else if(tourDeJeu == 1)
				{
					tour = "Hiver";
				}
				for(int t = 0; t < nbJoueur; t++)
				{
					if(joueurs[t] instanceof JoueurPhysique)
					{
						joueurs[t].poserCarteIngredient(tour,mains[t],joueurs, nbJoueur, mains, joueurs[t]);
						do
						{
						System.out.println("Voulez vous poser une carte Alliée ?");
						System.out.println("1.Oui");
						System.out.println("2.Non");
						Scanner s = new Scanner(System.in);
						choice = s.nextInt();
						}while(choice != 1 && choice != 2);
					}
					else
					{
						JoueurVirtuel J = (JoueurVirtuel)joueurs[t];
						J.poserCarteIngredient(tour, mains[t], joueurs, nbJoueur, mains, J);
						choice = (int) (2 * Math.random());
					}
					if(choice == 1 && joueurs[t].gagne) // Gagné ça veut dire qu'il a une carte alliée x)
					{
						Carte [] tmp = mains[t].getListeCarte();
						Carte TMP = tmp[0];
						int c = 0;
						while(tmp[c] != null && c != tmp.length - 1)
						{
							TMP = tmp[c];
							c++;
						}
						if(c == tmp.length -1  && tmp[c] != null)
						{
							TMP = tmp[4];
						}
						joueurs[t].setGagne(false);
						Alliee al = (Alliee) TMP;
						if(joueurs[t] instanceof JoueurPhysique)
						{
							joueurs[t].poserCarteAlliee(al, mains[t], joueurs, nbJoueur, tour);
						}
						else
						{
							JoueurVirtuel J = (JoueurVirtuel)joueurs[t];
							int Tab [] = {1,1,1,1};
							int Tab2 [] = {0,2,2,0};
							int Tab3 [] = {0,1,2,1};
							if (Arrays.equals(al.getPoints(), Tab) || Arrays.equals(al.getPoints(), Tab2) || Arrays.equals(al.getPoints(), Tab3)) // TaupeGéante
							{
								J.poserTaupe(al, joueurs, nbJoueur, tour, mains[t], J);
							}
							else
							{
								J.setGagne(true); // On dit qu'il en a tourjours une !
							}
						}
					}
				}
				tourDeJeu--;
			}
			
		}
		for(int w = 0; w < nbJoueur - 1; w++)
		{
			if(joueurs[w].pointsMenhirs < joueurs[w + 1].pointsMenhirs)
			{
				winner = joueurs[w + 1];
			}
		}
		System.out.println(winner.toString());
	}
	
	public static void main(String[] args) throws Exception  {
		int age;
		
		// Initialisation des cartes ingredients
		
		int[] tmp = {1,1,1,1,2,0,1,1,2,0,2,0};
		Ingredient RL1 = new Ingredient (tmp);
		int[] tmp2 = {2,0,1,1,1,3,0,0,0,1,2,1};
		Ingredient RL2 = new Ingredient (tmp2);
		int[] tmp3 = {0,0,4,0,0,2,2,0,0,0,1,3};
		Ingredient RL3 = new Ingredient (tmp3);
		int[] tmp4 = {1,3,1,0,1,2,1,1,0,1,4,0};
		Ingredient CS1 = new Ingredient (tmp4);
		int[] tmp5 = {2,1,1,1,1,0,2,2,3,0,0,2};
		Ingredient CS2 = new Ingredient (tmp5);
		int[] tmp6 = {1,2,2,0,1,1,2,1,2,0,1,2};
		Ingredient CS3 = new Ingredient (tmp6);
		int[] tmp7 = {2,1,1,2,1,1,1,3,2,0,2,2};
		Ingredient LD1 = new Ingredient (tmp7);
		int[] tmp8 = {0,3,0,3,2,1,3,0,1,1,3,1};
		Ingredient LD2 = new Ingredient (tmp8);
		int[] tmp9 = {1,2,1,2,1,0,1,4,2,4,0,0};
		Ingredient LD3 = new Ingredient (tmp9);
		int[] tmp10 = {1,3,1,2,2,1,2,2,0,0,3,4};
		Ingredient FE1 = new Ingredient (tmp10);
		int[] tmp11 = {2,2,0,3,1,1,4,1,1,2,1,3};
		Ingredient FE2 = new Ingredient (tmp11);
		int[] tmp12 = {2,2,3,1,2,3,0,3,1,1,3,3};
		Ingredient FE3 = new Ingredient (tmp12);
		int[] tmp13 = {2,2,2,2,0,4,4,0,1,3,2,2};
		Ingredient PO1 = new Ingredient (tmp13);
		int[] tmp14 = {3,1,3,1,1,4,2,1,2,4,1,1};
		Ingredient PO2 = new Ingredient (tmp14);
		int[] tmp15 = {4,1,1,1,1,2,1,3,1,2,2,2};
		Ingredient PO3 = new Ingredient (tmp15);
		int[] tmp16 = {2,3,2,0,0,4,3,0,2,1,1,3};
		Ingredient RA1 = new Ingredient (tmp16);
		int[] tmp17 = {2,2,3,0,1,1,1,4,2,0,3,2};
		Ingredient RA2 = new Ingredient (tmp17);
		int[] tmp18 = {3,1,4,1,2,1,3,3,2,3,2,2};
		Ingredient RA3 = new Ingredient (tmp18);
		int[] tmp19 = {2,4,1,2,2,2,2,3,1,4,3,1};
		Ingredient ED1 = new Ingredient (tmp19);
		int[] tmp20 = {3,3,3,0,1,3,3,2,2,3,1,3};
		Ingredient ED2 = new Ingredient (tmp20);
		int[] tmp21 = {1,2,2,1,1,2,3,0,0,2,2,2};
		Ingredient ED3 = new Ingredient (tmp21);
		int[] tmp22 = {4,0,1,1,1,1,3,1,0,0,3,3};
		Ingredient RF1 = new Ingredient (tmp22);
		int[] tmp23 = {2,0,1,3,0,3,0,3,1,2,2,1};
		Ingredient RF2 = new Ingredient (tmp23);
		int[] tmp24 = {2,2,3,1,2,3,0,3,1,1,3,3};
		Ingredient RF3 = new Ingredient (tmp24);
		
		Ingredient [] ingredients = {RL1,RL2,RL3,CS1,CS2,CS3,LD1,LD2,LD3,FE1,FE2,FE3,PO1,PO2,PO3,RA1,RA2,RA3,ED1,ED2,ED3,RF1,RF2,RF3};
		Ingredient [] init = {null,null,null,null};
		// Initialisation des cartes Alliées 
		
		int[] tmp25 = {1,1,1,1};
		TaupeGeante TG1 = new TaupeGeante(tmp25);
		int[] tmp26 = {0,2,2,0};
		TaupeGeante TG2 = new TaupeGeante(tmp26);
		int[] tmp27 = {0,1,2,1};
		TaupeGeante TG3 = new TaupeGeante(tmp27);
		int[] tmp28 = {2,0,2,0};
		ChienDeGarde CG1 = new ChienDeGarde(tmp28);
		int[] tmp29 = {1,2,0,1};
		ChienDeGarde CG2 = new ChienDeGarde(tmp29);
		int[] tmp30 = {0,1,3,0};
		ChienDeGarde CG3 = new ChienDeGarde(tmp30);
		
		Alliee [] alliees = {TG1,TG2,TG3,CG1,CG2,CG3};
		
		// Initialisation Bloc de cartes 
		
		Blocdecarte bloc = new Blocdecarte(ingredients,alliees);
		Blocdecarte bloc2 = new Blocdecarte(ingredients,alliees);
		Blocdecarte bloc3 = new Blocdecarte(ingredients,alliees);
		Blocdecarte bloc4 = new Blocdecarte(ingredients,alliees);
		Blocdecarte bloc5 = new Blocdecarte(ingredients,alliees);
		Blocdecarte bloc6 = new Blocdecarte(ingredients,alliees);
		Blocdecarte [] BLOC = {bloc,bloc2,bloc3,bloc4,bloc5,bloc6};
		// Initialisation Joueurs 
		
		//JoueurPhysique J1 = new JoueurPhysique("MOI",13,1);
		JoueurVirtuel J2 = new JoueurVirtuel("PC2",44,2, new Dificile());
		JoueurVirtuel J3 = new JoueurVirtuel("PC3",22,3, new Facile());
		JoueurVirtuel J4 = new JoueurVirtuel("PC4",14,4, new Facile());
		JoueurVirtuel J5 = new JoueurVirtuel("PC5",16,5, new Facile());
		JoueurVirtuel J6 = new JoueurVirtuel("PC6",12,5, new Facile());
		System.out.println("Bienvenue dans le jeu du Menhir");
		System.out.println("Quel est votre nom ?");
		Scanner s = new Scanner(System.in);
		String nom = s.nextLine();
		do
		{
		System.out.println("Quel est votre age ?");
		age = s.nextInt();
		}while(age < 12 && age >90);
		JoueurPhysique J1 = new JoueurPhysique(nom,age,1);
		Joueur [] joueurs = {J1,J2,J3,J4,J5,J6};
		
		// Initialisation main des joueurs 
		
		CarteMain main1 = new CarteMain(init);
		CarteMain main2 = new CarteMain(init);
		CarteMain main3 = new CarteMain(init);
		CarteMain main4 = new CarteMain(init);
		CarteMain main5 = new CarteMain(init);
		CarteMain main6 = new CarteMain(init);
		CarteMain [] mains = {main1,main2,main3,main4,main5,main6};
		
		// Initialisation Partie
		
		Partie partie = new Partie(1,"Printemps");
		J1.choisirPartie(joueurs, mains, BLOC, partie);
		//partie.lancerPartieAvancee(joueurs, mains, BLOC);
	}
}
