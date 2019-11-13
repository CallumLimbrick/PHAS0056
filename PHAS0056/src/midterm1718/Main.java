package midterm1718;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//
		ArrayList<Entry> test = Analysis.dataFromFile("N:\\Eclipse\\N_extent_v3.0.csv");
		int entryCount = Analysis.countEntryInResource(test);
		System.out.println("The number of entries in the file is " + entryCount + ".");
		
		//
		HashMap<String, String> hemisphere = new HashMap<String, String>();
		String[] hemiKeys = {"N", "S"};
		String[] hemiVals = {"Northern", "Southern"};
		hemisphere.put(hemiKeys[0], hemiVals[0]);
		hemisphere.put(hemiKeys[1], hemiVals[1]);
		
		//
		HashMap<String, String> months = new HashMap<String, String>();
		String[] monthKeys = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		String[] monthVals = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		for(int i =0; i<monthKeys.length;i++) {
			months.put(monthKeys[i], monthVals[i]);
		}
		
		//
		String[] lowestIceLevel = Analysis.lowestIce(test);
		System.out.println("The lowest level of ice extent occured in " + months.get(lowestIceLevel[0]) + " " + lowestIceLevel[1] + " with  value of " + lowestIceLevel[2]+".");
		System.out.println("The lowest level of ice area occured in " +months.get(lowestIceLevel[3]) + " " + lowestIceLevel[4] + " with a value of " + lowestIceLevel[5]+".");
		
		//
		System.out.println("The lowest level of ice extent in March occured in " + Analysis.minMonth(3, test) + ".");
		
		//
		System.out.println(Analysis.annualDiff(3, 2012, test));
		
		//
		System.out.println(Analysis.fiveBiggestDrop(3, test));
	}
}
