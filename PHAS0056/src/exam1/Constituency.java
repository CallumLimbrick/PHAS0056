package exam1;
// Constituency class for information on constituencies in the 2017 UK general election
public class Constituency {
	
	// initialising variables
	private String ons;
	private String conName;
	private String region;
	private int voters;
	
	// constructor
	public Constituency(String ons, String conName, String region, int voters) {
		this.ons = ons;
		this.conName = conName;
		this.region = region;
		this.voters = voters;
	}
	
	// getter functions
	String getOns() {return ons;}
	String getconName() {return conName;}
	String getRegion() {return region;}
	int getVoters() {return voters;}
}
