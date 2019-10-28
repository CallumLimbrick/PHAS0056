package module4;

import java.io.*;
import java.util.Scanner;

public class NumericalReader {

	public static String getStringFromKeyboard() throws Exception {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(r);
		System.out.println("Please type the directory to be used!");
		String s = b.readLine();
		System.out.println("You typed: "+s);
		return s;
	}

	public BufferedReader brFromURL(String urlName) throws IOException {
		return WordCounter.brFromURL(urlName);
	}


	private PrintWriter pw;
	private double minValue;
	private double maxValue;
	private double nValues;
	private double sumOfValues;


	void analysisStart(String dataFile) throws Exception {
		FileWriter fw = new FileWriter(dataFile);
		BufferedWriter b = new BufferedWriter(fw);
		pw = new PrintWriter(b);
		minValue = 1000000000;
		this.maxValue = -1000000000;
		this.nValues = 0;
		this.sumOfValues = 0;
	}

	void analyseData(String line) throws IOException {
		
		if (line.isEmpty() || Character.isAlphabetic(line.charAt(0))) {} // Do nothing as line is empty or a comment 
		else {
			Scanner s = new Scanner(line);
			while (s.hasNext()) {
				if(s.hasNextDouble()) {
					double n = s.nextDouble();
					pw.println(String.valueOf(n));
					System.out.println(String.valueOf(n));
					if (n < minValue) {
						minValue = n;
					}
					else if (n > maxValue) {
						maxValue = n;
					}
					nValues += 1;
					sumOfValues += n;
				}
				else {
					s.next();
				}
			}
		}
	}		

	void analysisEnd() {
		pw.close();
		System.out.println("Minimum value: " + minValue);
		System.out.println("Maximum value: " + maxValue);
		System.out.println("Number of numbers: " + nValues);
		System.out.println("Average of numbers: " + sumOfValues/nValues);
	}

	public static void main(String[] args) throws Exception {
		String saveDir;
		try {
			saveDir = NumericalReader.getStringFromKeyboard();
		}
		catch (IOException e) {
			saveDir = System.getProperty("user.home");
		}

		String saveFile_1 = (saveDir + File.separator + "numbers_1.txt");
		NumericalReader nr_1 = new NumericalReader();

		try {
			BufferedReader reader = nr_1.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
			String line = "";
			nr_1.analysisStart(saveFile_1); // initialize minValue etc.
			while ((line = reader.readLine()) != null) {
				nr_1.analyseData(line); // analyze lines, check for comments etc.

			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			nr_1.analysisEnd(); // print min, max, etc.
		}

		String saveFile_2 = (saveDir + File.separator + "numbers_2.txt");
		NumericalReader nr_2 = new NumericalReader();

		try {
			BufferedReader reader = nr_2.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
			String line = "";
			nr_2.analysisStart(saveFile_2); // initialize minValue etc.
			while ((line = reader.readLine()) != null) {
				nr_2.analyseData(line); // analyze lines, check for comments etc.

			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			nr_2.analysisEnd(); // print min, max, etc.
		}


	}
}

