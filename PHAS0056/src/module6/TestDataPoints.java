package module6;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Includes method for importing data form URL into ArrayList that contains DataPoint objects
 * Main method to test importing is working and that the LabelledDataPoint subclass is working correctly
 */
public class TestDataPoints {

	public static ArrayList<DataPoint> dataFromURL(String url) throws Exception {
		/* Retrieves data from URL and returns ArrayList of data
		 * INPUT: url of data
		 * OUTPUT: ArrayList of LabelledDataPoint objects
		 * Throws exception if there are too many columns of data in any of the lines in the url
		 */
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		ArrayList<DataPoint> mypoints = new ArrayList<DataPoint>();
		String line = "";

		while((line = b.readLine()) != null) {
			Scanner s = new Scanner(line);

			double x = s.nextDouble();
			double y = s.nextDouble();
			double ey = s.nextDouble();

			if(s.hasNext()) {
				String label = s.next();
				LabelledDataPoint p = new LabelledDataPoint(x, y, ey, label);
				mypoints.add(p);
				if(s.hasNext()) {
					s.close();
					throw new Exception("Data not in correct form (too many columns)");
				}
			}
			else {
				DataPoint p = new DataPoint(x, y, ey);
				mypoints.add(p);
			}
			s.close();
		}
		return mypoints;
	}

	public static void main(String[] args) throws Exception {

		try {
			// Importing data from URL
			ArrayList<DataPoint> test = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");

			// Loop printing DataPoint objects from ArrayList 
			for(DataPoint point : test) {
				System.out.println(point.toString());
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}

