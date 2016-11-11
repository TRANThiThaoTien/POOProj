import java.util.Arrays;

public class CarteMain {
	private Carte [] listeCarte;
	//private Joueur j1;
	private int taille;

@Override
	public String toString() {
		return "CarteMain [listeCarte=" + Arrays.toString(listeCarte) + "]";
	}
	

	public Carte[] getListeCarte() {
		return listeCarte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(listeCarte);
		result = prime * result + taille;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarteMain other = (CarteMain) obj;
		if (!Arrays.equals(listeCarte, other.listeCarte))
			return false;
		if (taille != other.taille)
			return false;
		return true;
	}


	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public CarteMain(Carte[] listeCarte) {
		super();
		this.listeCarte = listeCarte;
		//this.j1 = j1;
		this.taille = 0;
	}

	public void setListeCarte(Carte[] listeCarte) {
		this.listeCarte = listeCarte;
	}
	public void addCarteMain(Carte carte)
	{
		this.listeCarte[taille] = carte;
		this.taille++;
	}
	public void deleteCarteMain(Carte carte)
	{
		
		for(int i = 0; i <= listeCarte.length; i++)
		{
			if(carte == this.listeCarte[i])
			{
				for (int k = i; k < this.listeCarte.length - 1; k++)
				{
					this.listeCarte[k] = this.listeCarte[k + 1];
				}
				this.listeCarte[listeCarte.length-1] = null;
				this.taille--;
				break;
			}
		}
	}
		public void deleteAllieeMain(Alliee carte)
		{
			int i = 0;
			while(listeCarte[i] != null && i != listeCarte.length -1)
			{
				i++;
			}
			if(i == listeCarte.length -1  && listeCarte[i] != null)
			{
				listeCarte[4] = null;
			}
			else
			{
				listeCarte[i-1] = null;
			}
	}
	public static void main(String[] args) {
		
		Ingredient [] TMP = {null,null,null,null};
		CarteMain main = new CarteMain(TMP);
		CarteMain main2 = new CarteMain(TMP);
		CarteMain main3 = new CarteMain(TMP);
		int[] tmp10 = {1,3,1,2,2,1,2,2,0,0,3,4};
		Ingredient Ing10 = new Ingredient (tmp10);
		int[] tmp11 = {2,2,0,3,1,1,4,1,1,2,1,3};
		Ingredient Ing11 = new Ingredient (tmp11);
		int[] tmp12 = {2,2,3,1,2,3,0,3,1,1,3,3};
		Ingredient Ing12 = new Ingredient (tmp12);
		Carte[] Test = {Ing10,Ing11,Ing12};
		//CarteMain [] mains = {main,main2,main3};
		main.setListeCarte(Test);
		main2.setListeCarte(Test);
		//main.addCarteMain(Ing10);
		//main2.addCarteMain(Ing11);
	//	main3.addCarteMain(Ing12);
		
		//mains[1].deleteCarteMain(Ing11);
		
		main.toString();
	}
}
