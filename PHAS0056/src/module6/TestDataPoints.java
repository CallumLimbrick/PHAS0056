package module6;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TestDataPoints {
	
	public static ArrayList<LabelledDataPoint> dataFromURL(String url) throws Exception {
		/* Retrieves data from URL and returns ArrayList of data
		 * INPUT: url of data
		 * OUTPUT: ArrayList of LabelledDataPoint objects
		 * Throws exception if there are too many columns of data in any of the lines in the url
		 */
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		ArrayList<LabelledDataPoint> mypoints = new ArrayList<LabelledDataPoint>();
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
				LabelledDataPoint p = new LabelledDataPoint(x, y, ey, null);
				mypoints.add(p);
			}
			s.close();
		}
		return mypoints;
	}

	public static void main(String[] args) {
		

	}

}
