package module3;
import java.util.Random;
import java.lang.Character;
import java.lang.StringBuilder;
import java.lang.Integer;

public class Alphabet {
	// Creating random Character 
	public static char randomCharacter() {
		Random rand = new Random();
		int n = rand.nextInt(127);
		return (char) n;
	}	
	
	public static void main(String[] args) {
		// initialising sums
		int total = 0;
		int except = 0;
		
		StringBuilder builder = new StringBuilder(400);
		
		for (int i = 0; i <= 399; i++) {
			
			char a = randomCharacter();
			if (Character.isDigit(a) == true || Character.isLetter(a) == true) {
				
				builder.append(a); //appending string
								try {
					total += Integer.parseInt(String.valueOf(a)); //adding to digit total
				}
				catch (Exception e) {
					except += 1; //counting letters
				}
			}
		}
		
		System.out.println(builder);
		System.out.println("The length of the above string is: " + builder.length());
		System.out.println("The sum of all the integers in the string is: " + total);
		System.out.println("The total number of all letters in the string is: " + except);
	}

}
