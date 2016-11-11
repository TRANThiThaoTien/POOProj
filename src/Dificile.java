import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Dificile implements Strategie {


		public Dificile() {
			// TODO Auto-generated constructor stub
		}
		public void piocherAllieeOu2Graines(Blocdecarte bloc, CarteMain main, int choix, Joueur JV)  
		{
			if (choix >= 3)
			{
				Carte [] liste = main.getListeCarte();
				Ingredient Ing = (Ingredient) liste[0];
				Ingredient Ing2 = (Ingredient) liste[1];
				Ingredient Ing3 = (Ingredient) liste[2];
				Ingredient Ing4 = (Ingredient) liste[3];
				Alliee all1 = bloc.getAllieeRandom();
				Carte [] listeMain = {Ing, Ing2,Ing3,Ing4, all1};
				main.setListeCarte(listeMain);
				JV.setGagne(true); 
			}
			else
			{
				JV.setGrainesACote(2); 
			}
		}
		public void poserTaupe(Alliee alliee, Joueur[] joueurs, int nbJoueurs, String tour, CarteMain main, Joueur moi)
		{
			TaupeGeante TG1 = new TaupeGeante(alliee.getPoints());
			Joueur cible = joueurs[0];
			for(int w = 0; w < nbJoueurs - 1; w++)
			{
				if(joueurs[w].pointsMenhirs < joueurs[w + 1].pointsMenhirs)
				{
					if(joueurs[w+1] != moi )
					{
						cible = joueurs[w + 1];
					}
				}
			}
			TG1.detruireMenhirs(cible,tour);
			main.deleteCarteMain(alliee);
		}
		public void poserCarteIngredient(String tour, CarteMain main, Joueur [] joueurs, int nbJoueur, CarteMain [] mainCible, Joueur JV) throws IOException
		{
			int rand1 = 0;
			int choix = 0;
			Carte [] cartes = main.getListeCarte();	
			Ingredient ing = (Ingredient) cartes[0];
			/*Ingredient ing0 = (Ingredient) cartes[0];
			Ingredient ing1 = (Ingredient) cartes[1];
			Ingredient ing2 = (Ingredient) cartes[2];
			Ingredient ing3 = (Ingredient) cartes[3];
			int [] test0 = ing0.getPoints();
			int [] test1 = ing1.getPoints(); // A REVOIR POUR LA SOUTENANCE !!
			int [] test2 = ing2.getPoints();
			int [] test3 = ing3.getPoints();
			int [] printemps = {test0[0], test1[0], test2[0], test3[0]};
			int max = printemps[0];
			int position = 0;*/
			switch (tour)
			{
			  case "Printemps" :
				/*for(int i = 0; i <= 3; i++)
				{
					if(max < printemps[i])
					{
						max = printemps[i]; 
						position = i; // 1
					}
				}*/
			    if(JV.getGrainesACote() > 0)
			    {
			   		rand1 = 1;
			   	} 
			    else
			    {
			    	rand1 = 0;
			    }
			    break;      
			  case "Été" :
			  case "Automne" :
			  case "Hiver" :
				    if(JV.getGrainesACote() > 0)
				    {
				   		rand1 = 1;
				   	}
				    else
				    {
				    	rand1 = 2;
				    }
				    break;            
			}
			if (rand1 == 0)
			{
				Geant geant = new Geant();
				geant.retirerGrainesPC(JV, ing, tour);
				main.deleteCarteMain(ing);
			}
			else if (rand1 == 1)
			{
				Engrais engrais = new Engrais();
				engrais.pousserGraines(JV, ing, tour);
				main.deleteCarteMain(ing);
			}
			else if (rand1 == 2)
			{
				Farfadet farfadet = new Farfadet();
				Joueur cible;
				do
				{
					cible = joueurs[(int) ((nbJoueur + 1) * Math.random())];
				}while(cible == JV);
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
						System.out.println("Voulez vous utiliser votre carte chien de garde ? ?");
						System.out.println("1.Oui");
						System.out.println("2.Non");
						System.out.println("Votre choix ?");
						Scanner s = new Scanner(System.in);
						choix = s.nextInt();
					}
					else
					{
						choix = (int) (2 * Math.random());
					}
					if(choix == 1)
					{
						ChienDeGarde chien = new ChienDeGarde(alliee.getPoints());
						chien.protegerGraines(ing, tour, cible, JV);
						mainCible[numMain].deleteAllieeMain(chien);
						main.deleteCarteMain(ing);
					}
				}
				}
				else
				{
					farfadet.VolerGraines(JV, cible, ing, tour);
					main.deleteCarteMain(ing);
				}
			}
		}
		
	}
