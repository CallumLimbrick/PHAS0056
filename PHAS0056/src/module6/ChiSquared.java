package module6;

import java.util.Collection;

/*
 * Class that details methods to calculate the ChiSquared value of for a given Theory theory with a Collection
 * of DataPoint objects.
 */
public class ChiSquared implements GoodnessOfFitCalculator{

	/*
	 * (non-Javadoc)
	 * @see module6.GoodnessOfFitCalculator#goodnessOfFit(java.util.Collection, module6.Theory)
	 * 
	 * INPUTS: Collection of DataPoint objects, method that uses Theory interface
	 * OUTPUTS: double chi squared value
	 */
	@Override
	public double goodnessOfFit(Collection<DataPoint> data, Theory theory) {
		double chiSquared = 0;
		for(DataPoint point : data) {
			double x = point.x;
			double y = point.y;
			double ey = point.ey;
			double yTheory = theory.y(x);
			chiSquared += Math.pow(y-yTheory, 2) / Math.pow(ey, 2); // Chi-Squared calculation
		}
		return chiSquared;
	}
}
