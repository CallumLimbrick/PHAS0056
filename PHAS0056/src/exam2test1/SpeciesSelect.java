package exam2test1;

import java.util.ArrayList;

public class SpeciesSelect implements ImageSelector {
	
	private ArrayList<TenObserved> dataSet;
	private String species;
	
	// constructor
	public SpeciesSelect(ArrayList<TenObserved> dataSet, String species) {
		this.dataSet = dataSet;
		this.species = species;
	}
	
	// getter functions
	ArrayList<TenObserved> getDataSet() {return dataSet;}
	String getSpecies() {return species;}
	
	@Override
	/*
	 * 
	 */
	public ArrayList<TenObserved> select(ArrayList<TenObserved> dataSet, String species) {
		ArrayList<TenObserved> selected = new ArrayList<TenObserved>();
		for (TenObserved i : dataSet) {
			if (species.equals(i.getExp())) {
				selected.add(i);
			}
		}
		return selected;
	}
}
