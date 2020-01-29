package exam2test1;

import java.io.IOException;
import java.util.ArrayList;

public class ExamPart3 {

	public static void main(String[] args) throws IOException {
		
		// PART 1 ////////
		
		// Creating ArrayList fron urls
		ArrayList<Location> locations;

		locations = Analysis.dataFromLocation("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt");
		ArrayList<Ident> volunteerIdents = Analysis.dataFromIdent("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/classification.txt");
		ArrayList<Ident> expertIdents = Analysis.dataFromIdent("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/expert.txt");

		// Putting all information in one ArrayList 
		ArrayList<TenObserved> dataSet= new ArrayList<TenObserved>();
		for (int i = 0; i < locations.size(); i++) {
			Location location = locations.get(i);
			Ident expert = expertIdents.get(i);

			int id = location.getId();
			double[] loc = {location.getLat(), location.getLon()};
			String exp = expert.getAnimal();
			ArrayList<String> vol = new ArrayList<String>();
			for (int k = 0; k < volunteerIdents.size(); k++) {
				Ident volunteer = volunteerIdents.get(k);
				if (volunteer.getId() == id) {
					vol.add(volunteer.getAnimal());
					volunteerIdents.remove(k);
				}
			}
			TenObserved n = new TenObserved(id, loc, exp, vol);
			dataSet.add(n);
		}
		//////////////
		
		//PART 2 ///////////
		
		// expert
		System.out.println("The following have been identified by the expert as lion images:");
		SpeciesSelect example = new SpeciesSelect(dataSet, "lion");
		ArrayList<TenObserved> select1 = example.select(example.getDataSet(), example.getSpecies());
//		for (TenObserved i : select1) {
//			System.out.println(i.toString());
//		}

		// volunteers
		System.out.println("The following have been identified by volunteers as candidates for lion images:");
		LikelySpeciesSelector example1 = new LikelySpeciesSelector(dataSet, "lion");
		ArrayList<TenObserved> select2 = example1.select(example.getDataSet(), example.getSpecies());
//		for (TenObserved k : select2) {
//			System.out.println(k.toString());
//		}
		
		//////////////
		
		
		// Part 3 //////////
		
		double mcc = Tests.mccTest(volunteerIdents, select1, select2);
		System.out.println(mcc);
	}
}
