package module6;

import java.util.Collection;

/*
 * 
 */
public class DataAnalysis {
	
	@SuppressWarnings("unused")
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
		
		//dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt")
		
		//Theory th = bestTheory()
		

	}
}
