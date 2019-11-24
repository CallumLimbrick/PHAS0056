package module6;

import java.util.Collection;

/*
 * Interface to calculate the goodness of fit of a given Theory theory given a Collection of DataPoint objects
 */
public interface GoodnessOfFitCalculator {

	double goodnessOfFit(Collection<DataPoint> data, Theory theory);

}
