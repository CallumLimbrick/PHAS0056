package module6;


import java.util.ArrayList;
import java.util.Collection;

/*
 * Class with method that calculates the best theory to use given a set of data and a method of calculating "goodness of fit"
 * along with a main method that calculates said method for the given dataset, theories and Chi-Squared test
 */
public class DataAnalysis {
	
	/*
	 * Method that runs Chi-Squared test for each theory in Collection on the dataset data and returns the theory that is the best fit
	 * INPUTS: Collection of DataPoint objects, Collection of Theory objects and GoodnessOfFitCalculator object
	 * OUTPUTS: Theory object of theory that is the best fit
	 */
	private static Theory bestTheory(Collection<DataPoint> data,
            Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
        boolean first = true;
        double bestGoodnessOfFit = 0.0;
        Theory bestTheory = null;
        for (Theory theory : theories) {
            double gof = gofCalculator.goodnessOfFit(data, theory);
            if (first) {
                bestTheory = theory;
                bestGoodnessOfFit = gof;
                first = false;
            } else if (gof < bestGoodnessOfFit) {
                bestTheory = theory;
                bestGoodnessOfFit = gof;
            }
        }
        return bestTheory;
    }
	
	
	public static void main(String[] args) {
		
		try {
			// Initialising and populating array list of Theory objects with script specified parameters
			Collection<Theory> theories = new ArrayList<Theory>();
			Theory theory1 = new PowerLawTheory(2);
			Theory theory2 = new PowerLawTheory(2.05);
			Theory theory3 = new QuadraticTheory(1,10,0);
			theories.add(theory1);
			theories.add(theory2);
			theories.add(theory3);
			
			// Initialising dataset Collection from given url
			Collection<DataPoint> dataset = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			
			GoodnessOfFitCalculator chi2 = new ChiSquared();
			Theory th = bestTheory(dataset, theories, chi2);

			System.out.println("The function that best matches the datafile is " + th.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		

	}
}
