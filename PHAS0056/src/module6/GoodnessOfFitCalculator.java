package module6;

import java.util.Collection;

/*
 * Interface to calculate the goodness of fit of a given Theory theory given a Collection of DataPoint objects
 * Defines single method that the value for the "goodness of a fit" is dependent on the data and the theory that is used
 */
public interface GoodnessOfFitCalculator {

	double goodnessOfFit(Collection<DataPoint> data, Theory theory);

}
