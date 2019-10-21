package module4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WordCounter {
	
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
	}

	
	public static BufferedReader brFromFile(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}
	
	public static int countWordsInResource(BufferedReader dataAsBR) {
		int wordCount = 0;
		Scanner s = new Scanner(dataAsBR);
		while (s.hasNext()) {
			String word = s.next();
			wordCount +=1;
		}
		return wordCount;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		try {
			System.out.println(countWordsInResource(brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt")));	
		} catch (Exception e) {}
	}
}
