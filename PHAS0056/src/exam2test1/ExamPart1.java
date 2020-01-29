package exam2test1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ExamPart1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Creating ArrayList fron urls
		ArrayList<Location> locations = Analysis.dataFromLocation("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt");
		ArrayList<Ident> volunteerIdents = Analysis.dataFromIdent("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/classification.txt");
		ArrayList<Ident> expertIdents = Analysis.dataFromIdent("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/expert.txt");
		
		// Counting the number of images
		System.out.println("In total there were " + locations.size() + " images that needed to be classified.");
		
		// Counting number of images classified by at least one volunteer
		System.out.println("The total number of images classified by at least one volunteer is " + Analysis.volCheck(volunteerIdents).size() + ".");
		
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
		// This last bit is the occurs more than 10 times bit ;)
		for (TenObserved point : dataSet) {
			if (point.getVol().size() >= 10) {
				System.out.println(point.getId() + ", " + Arrays.toString(point.getLoc()) + ", " + point.getExp() + ", " + point.getVol());
			}
		}
	}
}

