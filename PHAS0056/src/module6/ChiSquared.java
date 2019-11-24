package module6;

import java.util.ArrayList;

/*
 * 
 */
public class ChiSquared {
	
	
	public static double goodnessOfFit(Theory n, ArrayList<DataPoint> data) {
		/* Runs calculation of CHI^2 by summing over all data and comparing to theoretical values
		 * INPUT: Theory object to set n value, ArrayList of DataPoint Objects
		 * OUTPUT: double CHI^2 value for dataset
		 */
		double chiSquared = 0;
		for(int i=0; i<data.size();i++) {
			DataPoint point = (DataPoint) data.get(i);
			double x = point.x;
			double y = point.y;
			double ey = point.ey;
			double yTheory = n.y(x);
			chiSquared += Math.pow(y-yTheory, 2) / Math.pow(ey, 2);
		}
		return chiSquared;
	}
}
