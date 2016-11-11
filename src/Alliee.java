import java.util.Arrays;

public class Alliee extends Carte{
		protected int[] Points;

		public int[] getPoints() {
			return Points;
		}

		public void setPoints(int[] points) {
			Points = points;
		}

		@Override
		public String toString() {
			return "Alliee [Points=" + Arrays.toString(Points) + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(Points);
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
			Alliee other = (Alliee) obj;
			if (!Arrays.equals(Points, other.Points))
				return false;
			return true;
		}

		public Alliee(int[] points) {
			super();
			Points = points;
		}

}