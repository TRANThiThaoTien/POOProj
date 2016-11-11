import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TaupeGeante extends Alliee {

	public TaupeGeante(int[] points) {
		super(points);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TaupeGeante [Points=" + Arrays.toString(Points) + "]";
	}
	public int puissanceTaupeGeante(String tour){
		int[] tab = this.getPoints();
		if(tour == "Printemps")
		{
			return tab[0];
		}
		else if(tour == "Été")
		{
			return tab[1];
		}
		else if(tour == "Automne")
		{
			return tab[2];
		}
		else if(tour == "Hiver")
		{
			return tab[3];
		}
		else 
		{
			return -1;
		}
		
	}
	public Joueur choisirAdversaire(Joueur [] joueurs, int Nbjoueur) throws IOException
	{
		int choix = 0;
		for(int i = 0; i < Nbjoueur; i++)
		{
			System.out.println("Joueur : " + joueurs[i].getNom());
			System.out.println("Menhirs : " + joueurs[i].getPointsMenhirs());
			System.out.println("ID : " + joueurs[i].getId());
		}
		System.out.println("Veuillez choisir un joueur en désignant son ID");
		Scanner s = new Scanner(System.in);
		choix = s.nextInt();
		for(int k = 0; k < joueurs.length; k++)
		{
			if(choix == joueurs[k].id)
			{
				return joueurs[k];
			}
		}
		return joueurs[0];
		
	}
	/*public int choixAdversaire() throws Exception
	{
		int choix = 0;
		System.out.println("Quel adversaire souhaitez vous choisir");
		choix = (int)System.in.read();
		// on test nombre de joueurs 4/8
		return choix;
	}*/
	/*public void remettreGraine(int graines)
	{
		// total = getGrainesPotCommun();
		// setGrainesPotCommun(total+ graines);
	}*/
	public void detruireMenhirs(Joueur cible, String tour)
	{
		if(puissanceTaupeGeante(tour) <= cible.getPointsMenhirs())
		{
			cible.setPointsMenhirs(cible.getPointsMenhirs() - puissanceTaupeGeante(tour) );
			System.out.println("Vous avez détruit " + (cible.getPointsMenhirs() - puissanceTaupeGeante(tour)) + " Menhir(s)");
		}
		else	
		{
			cible.setPointsMenhirs(0);
			System.out.println("Vous avez détruit " + cible.getPointsMenhirs() + " Menhir(s)");
		}
	}
}
