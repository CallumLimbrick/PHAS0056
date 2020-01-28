package exam2test1;

/*
 * 
 */
public class Location {
	
	// Initialising variables
	private int id;
	private double lat;
	private double lon;
	
	// Constructor
	public Location(int id, double lat, double lon) {
		this.id = id;
		this.lat = lat;
		this.lon = lon;
	}
	
	// getter functions
	int getId() {return id;}
	double getLat() {return lat;}
	double getLon() {return lon;}
}
