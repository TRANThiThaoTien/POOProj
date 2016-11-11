import java.util.Arrays;

public class ChienDeGarde extends Alliee {

	public ChienDeGarde(int[] points) {
		super(points);
	}
	
	@Override
	public String toString() {
		return "ChienDeGarde [Points=" + Arrays.toString(Points) + "]";
	}
	public int puissanceChienGarde(String tour){
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
	public void protegerGraines(Ingredient Ing, String tour, Joueur cible, Joueur voleur){
		if (puissanceFarfadet(Ing, tour) >= puissanceChienGarde(tour))
			{
				if(cible.getGrainesACote() >= (puissanceFarfadet(Ing, tour) - puissanceChienGarde(tour)))
				{
					cible.setGrainesACote(cible.getGrainesACote() - (puissanceFarfadet(Ing, tour) - puissanceChienGarde(tour))); 
					voleur.setGrainesACote(voleur.getGrainesACote() + (puissanceFarfadet(Ing, tour) - puissanceChienGarde(tour)));
					System.out.println("Vous avez volé " + (puissanceFarfadet(Ing, tour) - puissanceChienGarde(tour)) + " Graine(s)");
				}
				else
				{
					cible.setGrainesACote(0);
					voleur.setGrainesACote(voleur.getGrainesACote() + cible.getGrainesACote());
					System.out.println("Vous avez volé " + cible.getGrainesACote() + " Graine(s)");
				}
				System.out.println("Vous avez maintenant " + voleur.getGrainesACote() + " Graine(s)");
			}
	}
	
	
}
