package module5;

public class Theory {

		private double n;
		
		public Theory(double n) {
			/*
			 * Theory constructor that sets the n value
			 */
			this.n = n;
		}
		
		public double y(double x) {return Math.pow(x, n);}
}
