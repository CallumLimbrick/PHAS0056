package exam2test1;

import java.util.ArrayList;
import java.util.Arrays;

public class TenObserved {
	
	// Initialising variables
	private int id;
	private double[] loc;
	private String exp;
	private ArrayList<String> vol;
	
	// Constructor
	public TenObserved(int id, double[] loc, String exp, ArrayList<String> vol) {
		this.id = id;
		this.loc = loc;
		this.exp = exp;
		this.vol = vol;
	}
	
	// getter functions
	int getId() {return id;}
	double[] getLoc() {return loc;}
	String getExp() {return exp;}
	ArrayList<String> getVol() {return vol;}
	
	// setter functions
	void setId(int val) {val = id;}
	void setLoc(double[] val) {val = loc;}
	void setExp(String val) {val = exp;}
	void setVol(ArrayList<String> val) {val = vol;}
	
	// toString function
	public String toString() {
		return "Id: " + id + ", location: " + Arrays.toString(loc) + ", expert classification: " + exp + ", volunteer classification(s): " + vol + ".";
	}
}
