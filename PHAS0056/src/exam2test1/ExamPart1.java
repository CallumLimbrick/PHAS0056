package exam2test1;

import java.io.IOException;
import java.util.ArrayList;

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
		
		
	}
}

