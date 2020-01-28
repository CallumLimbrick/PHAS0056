package exam2test1;

/*
 * 
 */
public class Ident {
	
	// initialising variables
	private int id;
	private int vol;
	private String animal;
	
	// constructor 
	public Ident(int id, int vol, String animal) {
		this.id = id;
		this.vol = vol;
		this.animal = animal;
	}
	
	// getter functions
	int getId() {return id;}
	int getVol() {return vol;}
	String getAnimal() {return animal;}
}
