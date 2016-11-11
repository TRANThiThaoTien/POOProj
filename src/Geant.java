public class Geant {

	public Geant() {
		super();
	}
	public int puissanceGeant(Ingredient ing, String tour){
		int[] tab = ing.getPoints();
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
	public void retirerGrainesPC(Joueur j1,Ingredient ing, String tour) {
		int tmp = j1.getGrainesACote();
		int puissance = puissanceGeant(ing, tour);
		j1.setGrainesACote(tmp + puissance);
		System.out.println("Vous avez gagné " + puissance + " Graine(s)");
		System.out.println("Vous avez maintenant " + j1.getGrainesACote() + " Graine(s)");
	}
	

}
