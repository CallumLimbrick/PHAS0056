package module5;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Minerals {

	public static HashMap<Integer, String> dataFromURL(String url) throws Exception {
		/* Retrieves data from url and returns it in HashMap
		 * INPUT: url of data
		 * OUTPUT: HashMap of keys (Integers) and values (Strings)
		 * Throws exception if too many columns in dataset
		 */
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		HashMap<Integer, String> data = new HashMap<Integer, String>();
		String line = "";
		
		while((line = b.readLine()) != null) {
			Scanner s = new Scanner(line);
			int key;
			String value;
			// Checking if the key is the first or second number in the dataset
			if(s.hasNextInt()) {
				key = Integer.parseInt(s.next());
				value = s.next();
			}
			else {
				value = s.next();
				key = Integer.parseInt(s.next());
			}
			if(s.hasNext()) {
				s.close();
				throw new Exception("Data not in correct form (too many columns)");
			}
			data.put(key, value);
			s.close();
		}
		return data;
	}

	public static void main(String[] args) throws IOException {

		try {
			// Creating HashMaps for mass and location
			HashMap<Integer, String> masses = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");
			HashMap<Integer, String> locations = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");

			// initialising max and min masses
			double minMassVal = Double.MAX_VALUE;
			double maxMassVal = 0;
			int minMassKey = 0;
			int maxMassKey = 0;

			// Looping through HashMap to find maximum and minimum masses
			for(int i : masses.keySet()) {
				if(Double.parseDouble(masses.get(i))<minMassVal) {
					minMassVal = Double.parseDouble(masses.get(i));
				}
				if(Double.parseDouble(masses.get(i))>maxMassVal) {
					maxMassVal = Double.parseDouble(masses.get(i));
				}
			}
			
			//Retrieving keys for min amd max masses
			for(int i : masses.keySet()) {
				if(Double.parseDouble(masses.get(i)) == minMassVal) {
					minMassKey = i;
				}
				if(Double.parseDouble(masses.get(i)) == maxMassVal) {
					maxMassKey = i;
				}	
			}
			
			// throws exception if keys of min and max mass have not been updated
			if(minMassKey == 0 || maxMassKey == 0) {
				throw new Exception("Could not find corresponding locations for Min/Max masses");
			}
			
			// Retrieving locations of min and max masses
			String minMassLoc = locations.get(minMassKey);
			String maxMassLoc = locations.get(maxMassKey);
			
			System.out.println(minMassKey + " has the minimum mass of " + minMassVal + ", it was found at " + minMassLoc);
			System.out.println(maxMassKey + " has the maximimum mass of " + maxMassVal + ", it was found at " + maxMassLoc);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
