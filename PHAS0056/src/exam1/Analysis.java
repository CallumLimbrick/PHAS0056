package exam1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/* Analysis class containing methods to analyse the data from the 2017 UK General Election
 * (I forgot that you can't do == to compare strings and had to use the .equals method. I spent literally like an hour trying to figure it out :( )
 */
public class Analysis {

	/* Reading in Candidate information and putting in array list of Candidate objects
	 * INPUT: file
	 * OUTPUT: Array List of Candidate objects
	 */
	public static ArrayList<Candidate> dataFromCandidate(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<Candidate> dataPoints = new ArrayList<Candidate>();
		String line = "";
		br.readLine();
		while((line = br.readLine())!=null) {
			Scanner s = new Scanner(line).useDelimiter(",\\s*");

			String ons = s.next();
			int pano = s.nextInt();
			String conName = s.next();
			String surname = s.next();
			String forname = s.next();
			String party = s.next();
			String partyId = s.next();
			int votes = s.nextInt();

			Candidate n = new Candidate(ons, pano, conName, surname, forname, party, partyId, votes);
			dataPoints.add(n);
			s.close();
		}
		br.close();
		return dataPoints;
	}

	/* Reading in Constituency information and putting in array list of Constituency objects
	 * INPUT: file
	 * OUTPUT: Array List of Constituency objects
	 */
	public static ArrayList<Constituency> dataFromConstituency(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<Constituency> dataPoints = new ArrayList<Constituency>();
		String line = "";
		br.readLine();
		while((line = br.readLine())!=null) {
			Scanner s = new Scanner(line).useDelimiter(",\\s*");

			String ons = s.next();
			String conName = s.next();
			String region = s.next();
			int voters = s.nextInt();

			Constituency n = new Constituency(ons, conName, region, voters);
			dataPoints.add(n);
			s.close();
		}
		br.close();
		return dataPoints;
	}

	/* Mehod calculating the total turnout for the election
	 * INPUT: Array lists of candidates and constituencies
	 * OUTPUT: double value that is percentage turnout
	 */
	public static double totalTurnout(ArrayList<Candidate> candidates, ArrayList<Constituency> constituencies) throws IOException {
		int registered = 0;
		int validVotes = 0;
		for(int i=0; i<candidates.size();i++) {
			Candidate cand = (Candidate) candidates.get(i);
			validVotes += cand.getVotes();
		}
		for(int j=0;j<constituencies.size();j++) {
			Constituency con = (Constituency) constituencies.get(j);
			registered += con.getVoters();
		}
		double registered1 = (double) registered;
		double validVotes1 = (double) validVotes;
		return (validVotes1/registered1)*100;
	}

	/* Method to calculate how many candidates lost their deposit by scoring less than 5% of votes cast
	 * INPUT: Array Lists of candidates and constituencies
	 * OUTPUT: Integer count value
	 */
	public static int lostDepositCount(ArrayList<Candidate> candidates, ArrayList<Constituency> constituencies) {
		int count = 0;
		for(int i=0;i<constituencies.size();i++) {
			Constituency con = (Constituency) constituencies.get(i);
			int validVotes = 0;
			for(int k=0; k<candidates.size();k++) {
				Candidate can = (Candidate) candidates.get(k);
				if(con.getOns().equals(can.getOns())) { 
					validVotes += can.getVotes();
				}
			}
			for(int j=0; j<candidates.size();j++) {
				Candidate can2 = (Candidate) candidates.get(j);
				double voteTot = (double) validVotes;
				double candVote = (double) can2.getVotes();
				if((candVote/voteTot)<0.05) {
					count+=1;
				}
			}
		}
		return count;
	}

	/* Method calculating who had the most votes is the UK general election
	 * INPUT: Array List candidates
	 * OUTPUT: String of forname and surname
	 */
	public static String mostVotes(ArrayList<Candidate> candidates) {
		int maxVotes = Integer.MIN_VALUE;
		String maxForname = null;
		String maxSurname = null;
		for(int i=0; i<candidates.size();i++) {
			Candidate point = (Candidate) candidates.get(i);
			if(point.getVotes()>maxVotes) {
				maxVotes = point.getVotes();
				maxForname = point.getForname();
				maxSurname = point.getSurname();
			}
		}
		return maxForname + " " + maxSurname;
	}
 
	/* Method calculating who won a seat with the minimum number of votes
	 * INPUT: Array Lists of candidates and constituencies
	 * OUTPUT: String of forname and surname
	 */
	public static String minimumWin(ArrayList<Candidate> candidates, ArrayList<Constituency> constituencies) {
		int minWin = Integer.MAX_VALUE;
		String minWinName = null;
		HashMap<String, Integer> wins = new HashMap<String, Integer>();
		for(int i=0; i<constituencies.size();i++) {
			Constituency con = (Constituency) constituencies.get(i);
			int conWin = Integer.MIN_VALUE;
			String winForname = null;
			String winSurname = null;
			for(int j=0; j<candidates.size();i++) {
				Candidate can = (Candidate) candidates.get(j);
				if(con.getOns().equals(can.getOns()) && can.getVotes()>conWin) {
					conWin = can.getVotes();
					winForname = can.getForname();
					winSurname = can.getSurname();
				}
			}
			String winName = winForname + " " + winSurname;
			wins.put(winName, conWin);	
		}
		for(String k : wins.keySet()) {
			if(minWin<wins.get(k)) {
				minWinName = k;
				minWin = wins.get(k);
			}
		}
		return minWinName;
	}

	/* Method to calculate the turnout of a specific constituency
	 * INPUT: ONS code for said constituency, array list of both candidates and constituecies
	 * OUTPUT: double value of percentage of turnout
	 */
	public static double turnout(String ons, ArrayList<Candidate> candidates, ArrayList<Constituency> constituencies) {
		int votes = 0;
		int validVoters = 0;
		for(int i=0; i<candidates.size();i++) {
			Candidate can = (Candidate) candidates.get(i);
			if(ons.equals(can.getOns())) {
				votes += can.getVotes();
			}
			for(int j=0;j<constituencies.size();j++) {
				Constituency con = (Constituency) constituencies.get(j);
				if(ons.equals(con.getOns())) {
					validVoters = con.getVoters();
				}
			}
		}
		double votes1 = (double) votes;
		double validVoters1 = (double) validVoters;
		return (votes1/validVoters1)*100;
	}
}
