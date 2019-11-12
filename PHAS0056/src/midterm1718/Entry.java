package midterm1718;

public class Entry {
	
	private int year;
	private int month;
	private String dType;
	private String region;
	private double extent;
	private double area;
	
	public Entry(int year, int month, String dType, String region, double extent, double area) {
		/*
		 * 
		 */
		this.year = year;
		this.month = month;
		this.dType = dType;
		this.region = region;
		this.extent = extent;
		this.area = area;
	}
	
	//
	public String toString() {
		String ret = "Year: " + this.getYear() + ", Month: " + this.getMonth() + ", Data Type: " + this.getDType() + ", Region: " + this.getRegion() + ", Extent: " +this.getExtent() + ", Area: " + this.getArea();
		return ret;
	}
	
	// getter functions
	
	int getYear() {return year;}
	int getMonth() {return month;}
	String getDType() {return dType;}
	String getRegion() {return region;}
	double getExtent() {return extent;}
	double getArea() {return area;}
}
