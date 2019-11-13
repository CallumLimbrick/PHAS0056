package exam1;

// Candidate class for information on all of the candidates in UK 2017 general election
public class Candidate {
	
	// Initialising variables
	private String ons;
	private int pano;
	private String conName;
	private String surname;
	private String forname;
	private String party;
	private String partyId;
	private int votes;
	
	// constructor
	public Candidate(String ons, int pano, String conName, String surname, String forname, String party, String partyId, int votes) {
		this.ons = ons;
		this.pano = pano;
		this.conName = conName;
		this.surname = surname;
		this.forname = forname;
		this.party = party;
		this.partyId = partyId;
		this.votes = votes;
	}
	
	// getter functions
	String getOns() {return ons;}
	int getPano() {return pano;}
	String getConName() {return conName;}
	String getSurname() {return surname;}
	String getForname() {return forname;}
	String getParty() {return party;}
	String getPartyId() {return partyId;}
	int getVotes() {return votes;}
}
