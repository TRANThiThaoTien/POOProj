import java.io.IOException;

public class JoueurVirtuel extends Joueur{

	private Strategie strategie;
	public JoueurVirtuel(String nom, int age, int id, Strategie strategie) {
		super(nom, age, id);
		this.strategie = strategie;
		// TODO Auto-generated constructor stub
	}
	public void poserCarteIngredient(String tour, CarteMain main, Joueur [] joueurs, int nbJoueur, CarteMain [] mainCible, Joueur JV) throws IOException
	{
		this.strategie.poserCarteIngredient(tour, main, joueurs, nbJoueur, mainCible, JV);
	}
	public void piocherAllieeOu2Graines(Blocdecarte bloc, CarteMain main, int choix, Joueur JV)
	{
		this.strategie.piocherAllieeOu2Graines(bloc, main, choix , JV);
	}
	public void poserTaupe(Alliee alliee, Joueur[] joueurs, int nbJoueurs, String tour, CarteMain main, Joueur moi)
	{
		this.strategie.poserTaupe(alliee, joueurs, nbJoueurs, tour, main, moi);
	}
}
