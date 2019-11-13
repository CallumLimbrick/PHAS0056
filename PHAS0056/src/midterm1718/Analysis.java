package midterm1718;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 
 */
public class Analysis {

	public static ArrayList<Entry> dataFromFile(String fileName) throws IOException {
		/*
		 * 
		 */
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<Entry> dataPoints = new ArrayList<Entry>();
		String line = "";
		br.readLine();
		while((line = br.readLine())!=null) {
			Scanner s = new Scanner(line).useDelimiter(",\\s*");

			int year = s.nextInt();
			int month = s.nextInt();
			String dType = s.next();
			String region = s.next();
			double extent = s.nextDouble();
			double area = s.nextDouble();

			Entry n = new Entry(year, month, dType, region, extent, area);
			dataPoints.add(n);
			s.close();
		}
		br.close();
		return dataPoints;
	}

	public static int countEntryInResource(ArrayList<Entry> resource) throws IOException {
		/*
		 * 
		 */
		int count = 0;
		for(int i=0; i<resource.size();i++) {
			Entry point = (Entry) resource.get(i);
			if(point.getDType() != "-9999" || point.getExtent() != -9999 || point.getArea() != -9999) {
				count += 1;
			}
		}
		return count;
	}

	public static String[] lowestIce(ArrayList<Entry> resource) {
		/*
		 * 
		 */
		double extentMin = Double.MAX_VALUE;
		double areaMin = Double.MAX_VALUE;
		String[] minimumResults = {null, null, null, null, null, null};
		for(int i=0; i<resource.size(); i++) {
			Entry data = (Entry) resource.get(i);
			if(data.getExtent()<extentMin && data.getExtent() != -9999) {
				minimumResults[0] = String.valueOf(data.getMonth());
				minimumResults[1] = String.valueOf(data.getYear());
				extentMin = data.getExtent();
				minimumResults[2] = String.valueOf(data.getExtent());
			}
			if(data.getArea()<areaMin && data.getArea() != -9999) {
				minimumResults[3] = String.valueOf(data.getMonth());
				minimumResults[4] = String.valueOf(data.getYear());
				areaMin = data.getArea();
				minimumResults[5] = String.valueOf(data.getArea());
			}
		}
		return minimumResults;
	}

	public static int minMonth(int month, ArrayList<Entry> resource) {
		/*
		 * 
		 */
		double extentMin = Double.MAX_VALUE;
		int year = 0;
		for(int i=0; i<resource.size(); i++) {
			Entry data = (Entry) resource.get(i);
			if(month == data.getMonth()) {
				if(data.getExtent()<extentMin) {
					year = data.getYear();
				}
			}
		}
		return year;
	}

	public static double annualDiff(int month, int year, ArrayList<Entry> resource) throws Exception {
		/*
		 * 
		 */
		double area1 = 0;
		double area2 = 0;
		for(int i=0; i<resource.size(); i++) {
			Entry data = (Entry) resource.get(i);
			if(month == data.getMonth() && year-1 == data.getYear()) {
				area2 = data.getArea();
			}
			if(month == data.getMonth() && year == data.getYear()) {
				area1 = data.getArea();
				break;
			}
		}
		if(area1 == 0) {
			throw new Exception("Invalid input date");
		}
		if(area1 == -9999) {
			throw new Exception("No data for input date");
		}
		if(area2 == 0 || area2 == -9999) {
			throw new Exception("No data for year prior to input date");
		}
		return area1 - area2;
	}

//	public static int[] fiveBiggestDrop(int month, ArrayList<Entry> resource) throws Exception {
//		/*
//		 * 
//		 */
//		HashMap<Integer, Double> monthData = new HashMap<Integer, Double>();
//		for(int i=0; i<resource.size(); i++) {
//			Entry data = (Entry) resource.get(i);
//			if(month == data.getMonth() && data.getArea() != -9999) {
//				monthData.put(data.getYear(), data.getArea());
//			}
//		int k = 0;
//		int prevKey;
//		
//		for(int j : monthData.keySet()) {
//			if(k == 0) {
//				k ++;
//				prevKey = j;
//			}
//			else {
//				
//			}
//		}
//		}
//		return years;
//	}
}

