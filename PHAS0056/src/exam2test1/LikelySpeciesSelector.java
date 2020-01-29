package exam2test1;

import java.util.ArrayList;

public class LikelySpeciesSelector implements ImageSelector {
	
	private ArrayList<TenObserved> dataSet;
	private String species;
	
	// constructor
	public LikelySpeciesSelector(ArrayList<TenObserved> dataSet, String species) {
		this.dataSet = dataSet;
		this.species = species;
	}
	
	// getter functions
	ArrayList<TenObserved> getDataSet() {return dataSet;}
	String getSpecies() {return species;}

	@Override
	/*
	 * (non-Javadoc)
	 * @see exam2test1.ImageSelector#select(java.util.ArrayList, java.lang.String)
	 */
	public ArrayList<TenObserved> select(ArrayList<TenObserved> dataSet, String species) {
		ArrayList<TenObserved> selected = new ArrayList<TenObserved>();
		for (TenObserved i : dataSet) {
			ArrayList<String> matched = new ArrayList<String>();
			for (String j : i.getVol()) {
				if (j.equals(species)) {
					matched.add(j);
				}
			}
			if (i.getVol().size() != 0) {				
				double percent = (double)matched.size()/(double)i.getVol().size();
				if (percent > 0.5) {
					selected.add(i);
				}
			}
		}
		return selected;
	}
}
