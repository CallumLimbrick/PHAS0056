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

	private static String dataFile = "numbers.txt";
	private double minValue;
	private double maxValue;
	private double nValues;
	private double sumOfValues;
	private String f;

	void analysisStart(String dataFile) throws Exception {
		File f = new File(dataFile);
		FileWriter fw = new FileWriter(f);
		this.minValue = 1000000000;
		this.maxValue = 0;
		this.nValues = 0;
		this.sumOfValues = 0;
	}

	void analyseData(String line) throws IOException {
		Scanner s = new Scanner(line);
		System.out.println(line);
		if (line.isEmpty() || line.startsWith("c")) {} 
		else if (s.hasNextDouble()) {
			System.out.println("file");
			FileWriter file = new FileWriter(this.f);
			System.out.println("br");
			BufferedWriter br = new BufferedWriter(file);
			System.out.println("pw");
			PrintWriter pw = new PrintWriter(br);
			while (s.hasNextDouble()) {
				System.out.println(s.nextDouble());
				double n = s.nextDouble();
				pw.write(String.valueOf(n));
				pw.print(n);
				if (n < this.minValue) {
					this.minValue = n;
				}
				else if (n > this.maxValue) {
					this.maxValue = n;
				}
				this.nValues += 1;
				this.sumOfValues += n;
			}
		}
	}

	void analysisEnd() {
		System.out.println("Minimum value: " + this.minValue);
		System.out.println("Maximum value: " + this.maxValue);
		System.out.println("Number of numbers: " + this.nValues);
		System.out.println("Average of numbers: " + this.sumOfValues/this.nValues);
	}

	public static void main(String[] args) throws Exception {	
		
		String saveDir = NumericalReader.getStringFromKeyboard();

		String saveFile = (saveDir + File.separator + dataFile);
		NumericalReader nr = new NumericalReader();

		BufferedReader reader = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
		String line = "";
		nr.analysisStart(saveFile); // initialize minValue etc.
		while ((line = reader.readLine()) != null) {
			nr.analyseData(line); // analyze lines, check for comments etc.
		}
		nr.analysisEnd(); // print min, max, etc.
	}
}

