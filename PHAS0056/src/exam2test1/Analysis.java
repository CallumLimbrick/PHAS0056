package exam2test1;

import java.io.*;
import java.net.URL;
import java.util.*;

/*
 * 
 */
public class Analysis {

	/*
	 * 
	 */
	public static ArrayList<Location> dataFromLocation(String webAddress) throws IOException{
		URL u = new URL(webAddress);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<Location> dataPoints = new ArrayList<Location>();
		String line = "";
		while((line = br.readLine())!=null) {
			Scanner s = new Scanner(line).useDelimiter(" ");

			int id = s.nextInt();
			double lat = s.nextDouble();
			double lon = s.nextDouble();

			Location n = new Location(id, lat, lon);
			dataPoints.add(n);
			s.close();
		}
		br.close();
		return dataPoints;
	}

	/*
	 * 
	 */
	public static ArrayList<Ident> dataFromIdent(String webAddress) throws IOException{
		URL u = new URL(webAddress);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<Ident> dataPoints = new ArrayList<Ident>();
		String line = "";
		while((line = br.readLine())!=null) {
			Scanner s = new Scanner(line).useDelimiter(" ");

			int id = s.nextInt();
			int vol = s.nextInt();
			String animal = s.next();

			Ident n = new Ident(id, vol, animal);
			dataPoints.add(n);
			s.close();
		}
		br.close();
		return dataPoints;
	}

	/*
	 * 
	 */
	public static List<Integer> volCheck(ArrayList<Ident> volunteers) {
		List<Integer> ids = new ArrayList<Integer>();
		for (Ident dataPoint : volunteers) {
			boolean found = false;
			for (int n : ids) {
				if (n == dataPoint.getId()) {
					found = true;
					break;
				}
			}
			if(found);
			else {
				ids.add(dataPoint.getId());
			}
		}
		return ids;
	}
	
	/*
	 * 
	 */
//	public int vol10Check(ArrayList<Ident> volunteers) {
//		HashMap<Integer, Integer> images = new HashMap<Integer, Integer>();
//		for (int n : volCheck(volunteers)) {
//			images.put(n, 0);
//		}
//		for (Ident dataPoint : volunteers) {
//			int m = images.get(dataPoint.getId());
//			images.replace(dataPoint.getId(), m+1);
//		}
//		for (int i : images.keySet()) {
//			if (images.get(i) >= 10) {
//				
//			}
//		}
//	}
}
