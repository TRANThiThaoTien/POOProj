import java.io.IOException;

public interface Strategie {
	
	public void piocherAllieeOu2Graines(Blocdecarte bloc, CarteMain main, int choix, Joueur JV);
	public void poserCarteIngredient(String tour, CarteMain main, Joueur [] joueurs, int nbJoueur, CarteMain [] mainCible, Joueur JV) throws IOException;
	public void poserTaupe(Alliee alliee, Joueur[] joueurs, int nbJoueurs, String tour, CarteMain main, Joueur moi);
}
