

public class Blocdecarte {

	protected Ingredient[] listIngredient;
	protected Alliee [] listAlliee;
	private static int tailleAlliee = 5;
	private static int tailleIngredient = 23;
	
	
	public Blocdecarte(Ingredient[] listIngredient, Alliee[] listAlliee) {
		super();
		this.listIngredient = listIngredient;
		this.listAlliee = listAlliee;
	}
	public Ingredient[] getListIngredient() {
		return listIngredient;
	}
	public void setListIngredient(Ingredient[] listIngredient) {
		this.listIngredient = listIngredient;
	}
	public Alliee[] getListAlliee() {
		return listAlliee;
	}
	public void setListAlliee(Alliee[] listAlliee) {
		this.listAlliee = listAlliee;
	}
	public Alliee getAllieeRandom() {
		int rand = (int)(Math.random() * (Blocdecarte.tailleAlliee + 1));
		Alliee tmp = new Alliee(listAlliee[rand].getPoints());
		for (int i = rand; i <= Blocdecarte.tailleAlliee - 1; i++)
		{
			this.listAlliee[i] = this.listAlliee[i + 1];
		}
		Blocdecarte.tailleAlliee--;
		return tmp;
	}
	public Ingredient getIngredientRandom() {
		int rand = (int)(Math.random() * (Blocdecarte.tailleIngredient+1));
		Ingredient tmp = new Ingredient(listIngredient[rand].getPoints());
		for (int i = rand; i <= Blocdecarte.tailleIngredient - 1; i++)
		{
			this.listIngredient[i] = this.listIngredient[i + 1];
		}
		listIngredient[listIngredient.length - 1] = null;
		Blocdecarte.tailleIngredient--;
		return tmp;
	}
	
	public void distribuerCartesIngredient(CarteMain main)
	{
			/*for(int k = 1; k <= 4; k++)
			{
				main.addCarteMain(getIngredientRandom()); 
			}*/
		Ingredient Ing = getIngredientRandom();
		Ingredient Ing2 = getIngredientRandom();
		Ingredient Ing3 = getIngredientRandom();
		Ingredient Ing4 = getIngredientRandom();
		Carte [] listeMain = {Ing, Ing2,Ing3,Ing4};
		main.setListeCarte(listeMain);
		//Ingredient In1 = new Ingredient(getIngredientRandom().getPoints());
		//Ingredient In2 = new Ingredient(getIngredientRandom().getPoints());
		//Ingredient In3 = new Ingredient(getIngredientRandom().getPoints());
		//Ingredient In4 = new Ingredient(getIngredientRandom().getPoints());
		//Ingredient [] tab = new Ingredient();
		//main.setListeCarte(listeCarte);
	}
	public static void main(String[] args) {
		/*int[] tmp = {1,1,1,1,2,0,1,1,2,0,2,0};
		Ingredient Ing1 = new Ingredient (tmp);
		int[] tmp2 = {2,0,1,1,1,3,0,0,0,1,2,1};
		Ingredient Ing2 = new Ingredient (tmp2);
		int[] tmp3 = {0,0,4,0,0,2,2,0,0,0,1,3};
		Ingredient Ing3 = new Ingredient (tmp3);
		int[] tmp4 = {1,3,1,0,1,2,1,1,0,1,4,0};
		Ingredient Ing4 = new Ingredient (tmp4);
		Ingredient [] TMP = {Ing1,Ing2,Ing3,Ing4};
		int[] tmp5 = {1,1,1,1,2,0,1,1,2,0,2,0};
		Alliee al1 = new Alliee (tmp5);
		int[] tmp6 = {2,0,1,1,1,3,0,0,0,1,2,1};
		Alliee al2 = new Alliee (tmp6);
		Alliee [] TMP2 = {al1,al2};
		Blocdecarte bloc = new Blocdecarte(TMP,TMP2);
		//int[] go = {0,0,0,0,0,0,0,0,0,0,0,0};
		//Ingredient res = new Ingredient(go);
		//res = bloc.getIngredientRandom();
		CarteMain main = new CarteMain(TMP);
		bloc.distribuerCartesIngredient(main);*/
		
		
	}
}
