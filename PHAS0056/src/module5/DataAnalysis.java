package module5;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class DataAnalysis {
	
	public static ArrayList<DataPoint> datafromURL(String url) throws IOException {
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
			System.out.println(x + ", " + y + ", " + ey);
			mypoints.add(p);
		}
		return mypoints;
	}
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<DataPoint> a = datafromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
		System.out.println(a.get(1));
	}
}

