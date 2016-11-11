public class Engrais {
	

	public Engrais() {
		super();
	}
	public int puissanceEngrais(Ingredient ing, String tour){
		int[] tab = ing.getPoints();
		if(tour == "Printemps")
		{
			return tab[4];
		}
		else if(tour == "Été")
		{
			return tab[5];
		}
		else if(tour == "Automne")
		{
			return tab[6];
		}
		else if(tour == "Hiver")
		{
			return tab[7];
		}
		else 
		{
			return -1;
		}
	}
	public void pousserGraines(Joueur j1, Ingredient ing, String tour) {
		if(j1.getGrainesACote() >= puissanceEngrais(ing, tour))
		{
			j1.setPointsMenhirs(j1.getPointsMenhirs() + puissanceEngrais(ing, tour));
			j1.setGrainesACote(j1.getGrainesACote() - puissanceEngrais(ing, tour));
			System.out.println("Vous avez fait poussé " + puissanceEngrais(ing, tour) + " Graine(s)");
		}
		else
		{
			j1.setPointsMenhirs(j1.getPointsMenhirs() + j1.getGrainesACote());
			j1.setGrainesACote(0);
			System.out.println("Vous avez poussé " + j1.getGrainesACote() + " Graine(s)");
		}
		System.out.println("Vous avez maintenant " + j1.getPointsMenhirs() + " Menhir(s) et " + j1.getGrainesACote() + " Graine(s)");
		
		
	}

}
