package module4;

import java.io.*;
import java.util.Scanner;

public class NumericalReader {

	public static String getStringFromKeyboard() throws Exception {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(r);
		System.out.println("Please type something!");
		String s = b.readLine();
		System.out.println("You typed: "+s);
		return s;
	}

	public BufferedReader brFromURL(String urlName) throws IOException {
		return WordCounter.brFromURL(urlName);
	}

	private File dataFile;
	private double minValue;
	private double maxValue;
	private double nValues;
	private double sumOfValues;

	void analysisStart(String dataFile) throws Exception {
		File f = new File(dataFile);
		this.minValue = 1000000000;
		this.maxValue = 0;
		this.nValues = 0;
		this.sumOfValues = 0;
	}

	void analyseData(String line) throws IOException {
		Scanner s = new Scanner(line);
		if (line.isEmpty() || line.startsWith("c")) {} // Can I get it to check if it contains ONLY spaces?
		else if (s.hasNextDouble()) {
			FileWriter f = new FileWriter(dataFile);
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter pw = new PrintWriter(b);
			while (s.hasNextDouble()) {
				double n = s.nextDouble();
				pw.write(String.valueOf(n));
				pw.print(n);
				if (n < minValue) {
					this.minValue = n;
				}
				else if (n > maxValue) {
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
	
	public static void main(String[] args) throws IOException {

		try {
			
//			analysisStart("N:" + File.separator + "mywork" + File.separator + getStringFromKeyboard());
		} catch (Exception e) {}
	}
}

