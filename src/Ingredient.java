import java.util.Arrays;

public class Ingredient extends Carte {

	protected int[] points;
	
	public Ingredient() {
		super();
	}
	public Ingredient(int[] points) {
		super();
		this.points = points;
	}
	
	@Override
	public String toString() {
		return "Ingredient [points=" + Arrays.toString(points) + "]";
	}
	public int[] getPoints() {
		return points;
	}
	public void setPoints(int[] points) {
		this.points = points;
	}
	public static void main(String[] args) {
	/*	int[] tmp = {1,1,1,1,2,0,1,1,2,0,2,0};
		Ingredient Ing1 = new Ingredient (tmp);
		int[] tmp2 = {2,0,1,1,1,3,0,0,0,1,2,1};
		Ingredient Ing2 = new Ingredient (tmp2);
		int[] tmp3 = {0,0,4,0,0,2,2,0,0,0,1,3};
		Ingredient Ing3 = new Ingredient (tmp3);
		int[] tmp4 = {1,3,1,0,1,2,1,1,0,1,4,0};
		Ingredient Ing4 = new Ingredient (tmp4);
		int[] tmp5 = {2,1,1,1,1,0,2,2,3,0,0,2};
		Ingredient Ing5 = new Ingredient (tmp5);
		int[] tmp6 = {1,2,2,0,1,1,2,1,2,0,1,2};
		Ingredient Ing6 = new Ingredient (tmp6);
		int[] tmp7 = {2,1,1,2,1,1,1,3,2,0,2,2};
		Ingredient Ing7 = new Ingredient (tmp7);
		int[] tmp8 = {0,3,0,3,2,1,3,0,1,1,3,1};
		Ingredient Ing8 = new Ingredient (tmp8);
		int[] tmp9 = {1,2,1,2,1,0,1,4,2,4,0,0};
		Ingredient Ing9 = new Ingredient (tmp9);
		int[] tmp10 = {1,3,1,2,2,1,2,2,0,0,3,4};
		Ingredient Ing10 = new Ingredient (tmp10);
		int[] tmp11 = {2,2,0,3,1,1,4,1,1,2,1,3};
		Ingredient Ing11 = new Ingredient (tmp11);
		int[] tmp12 = {2,2,3,1,2,3,0,3,1,1,3,3};
		Ingredient Ing12 = new Ingredient (tmp12);
		int[] tmp13 = {2,2,2,2,0,4,4,0,1,3,2,2};
		Ingredient Ing13 = new Ingredient (tmp13);
		int[] tmp14 = {3,1,3,1,1,4,2,1,2,4,1,1};
		Ingredient Ing14 = new Ingredient (tmp14);
		int[] tmp15 = {4,1,1,1,1,2,1,3,1,2,2,2};
		Ingredient Ing15 = new Ingredient (tmp15);
		int[] tmp16 = {2,3,2,0,0,4,3,0,2,1,1,3};
		Ingredient Ing16 = new Ingredient (tmp16);
		int[] tmp17 = {2,2,3,0,1,1,1,4,2,0,3,2};
		Ingredient Ing17 = new Ingredient (tmp17);
		int[] tmp18 = {3,1,4,1,2,1,3,3,2,3,2,2};
		Ingredient Ing18 = new Ingredient (tmp18);
		int[] tmp19 = {2,4,1,2,2,2,2,3,1,4,3,1};
		Ingredient Ing19 = new Ingredient (tmp19);
		int[] tmp20 = {3,3,3,0,1,3,3,2,2,3,1,3};
		Ingredient Ing20 = new Ingredient (tmp20);
		int[] tmp21 = {1,2,2,1,1,2,3,0,0,2,2,2};
		Ingredient Ing21 = new Ingredient (tmp21);
		int[] tmp22 = {4,0,1,1,1,1,3,1,0,0,3,3};
		Ingredient Ing22 = new Ingredient (tmp22);
		int[] tmp23 = {2,0,1,3,0,3,0,3,1,2,2,1};
		Ingredient Ing23 = new Ingredient (tmp23);
		int[] tmp24 = {2,2,3,1,2,3,0,3,1,1,3,3};
		Ingredient Ing24 = new Ingredient (tmp24);*/
	}
}

