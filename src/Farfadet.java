import java.io.IOException;
import java.util.Scanner;

public class Farfadet  {
	
	
	public Farfadet() {
		super();
	}
	public int puissanceFarfadet(Ingredient ing, String tour){
		int[] tab = ing.getPoints();
		if(tour == "Printemps")
		{
			return tab[8];
		}
		else if(tour == "Été")
		{
			return tab[9];
		}
		else if(tour == "Automne")
		{
			return tab[10];
		}
		else if(tour == "Hiver")
		{
			return tab[11];
		}
		else 
		{
			return -1;
		}
	}
	public void VolerGraines(Joueur voleur, Joueur cible, Ingredient ing, String tour) {
		if(cible.getGrainesACote() >= puissanceFarfadet(ing,tour))
		{
			voleur.setGrainesACote(voleur.getGrainesACote() + puissanceFarfadet(ing,tour));
			cible.setGrainesACote(cible.getGrainesACote() - puissanceFarfadet(ing,tour));
			System.out.println("Vous avez volé " + puissanceFarfadet(ing,tour) + " Graine(s)");
		}
		else
		{
			voleur.setGrainesACote(voleur.getGrainesACote() + cible.getGrainesACote());;
			cible.setGrainesACote(0);
			System.out.println("Vous avez volé " + cible.getGrainesACote() + " Graine(s)");
		}
		System.out.println("Vous avez maintenant " + voleur.getGrainesACote() + " Graine(s)");
	}
	public Joueur choisirAdversaire(Joueur [] joueurs, int Nbjoueur) throws IOException
	{
		int choix = 0;
		for(int i = 0; i < Nbjoueur; i++)
		{
			System.out.println("Joueur :" + joueurs[i].nom);
			System.out.println("Graines :" + joueurs[i].grainesACote);
			System.out.println("Id : " + joueurs[i].id);
		}
		System.out.println("Veuillez choisir un joueur en désignant son ID");
		Scanner s = new Scanner(System.in);
		choix = s.nextInt();
		for(int k = 0; k < Nbjoueur; k++)
		{
			if(choix == joueurs[k].id)
			{
				return joueurs[k];
			}
		}
		return joueurs[0];
		
	}
}