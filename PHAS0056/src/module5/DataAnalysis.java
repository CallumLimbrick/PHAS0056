package module5;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class DataAnalysis {
	
	public static ArrayList<DataPoint> datafromURL(String url) throws IOException {
		/*
		 * 
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
			DataPoint p = new DataPoint(x, y, ey);
			mypoints.add(p);
			s.close();
		}
		return mypoints;
	}
	
	public static double goodnessOfFit(Theory n, ArrayList<DataPoint> data) {
		/*
		 * 
		 */
		double chiSquared = 0;
		for(int i=0; i<data.size();i++) {
			DataPoint point = (DataPoint) data.get(i);
			double x = point.getX();
			double y = point.getY();
			double ey = point.getEy();
			double yTheory = n.y(x);
			chiSquared += Math.pow(y-yTheory, 2) / Math.pow(ey, 2);
		}
		return chiSquared;
	}
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<DataPoint> a = datafromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
		
		double chiSquared2 = goodnessOfFit(new Theory(2), a);
		double chiSquared4 = goodnessOfFit(new Theory(4), a);
		
		System.out.println("The chi squared value for the prediction y=x^2 is: " + chiSquared2);
		System.out.println("The chi squared value for the prediction y=x^4 is: " + chiSquared4);
		
		if(chiSquared2<chiSquared4) {
			System.out.println("y=x^2 is the better theoretical model to describe this data as it has a chi squared value of " + chiSquared2);
		}
		else if(chiSquared2==chiSquared4) {
			System.out.println("Both y=x^2 and y=x^4 describe the model equally well as they both have a chi squared value of "+ chiSquared2);
		}
		else {
			System.out.println("y=x^4 is the better theoretical model to describe this data as it has a chi squared value of " + chiSquared4);
		}
		
		
	}
}

