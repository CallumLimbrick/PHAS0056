package exam1;

import java.io.IOException;
import java.util.ArrayList;

public class MidTermExam {

	public static void main(String[] args) throws IOException {

		// Creating ArrayLists from data files
		ArrayList<Candidate> candidates = Analysis.dataFromCandidate("N:\\Eclipse\\results.csv");
		ArrayList<Constituency> constituencies = Analysis.dataFromConstituency("N:\\Eclipse\\constituencies.csv");
		
		// Counting the number of candidates
		System.out.println("There were " + candidates.size() + " candidates in the 2017 UK general election.");
		
		// Calculating turnout
		System.out.println("The turnout was " + Analysis.totalTurnout(candidates, constituencies) + "%.");
		
		// Calculating number of lost deposits
		System.out.println("The number of lost deposits was " + Analysis.lostDepositCount(candidates, constituencies) + ".");
		
		// Calculating which candidate got the most votes
		System.out.println("The candidate with the most votes was " + Analysis.mostVotes(candidates) + ".");
		
		// Calculating who won with the least votes
		System.out.println(Analysis.minimumWin(candidates, constituencies));
		// The above runs very slowly so if takes too long you should comment out please
		
		// Calculating lowest turnout
		double lowestTurnout = Double.MAX_VALUE;
		for(int i=0; i<constituencies.size();i++) {
			Constituency point = (Constituency) constituencies.get(i);
			double turnout = Analysis.turnout(point.getOns(), candidates, constituencies);
			if(turnout<lowestTurnout) {
				lowestTurnout = turnout;
			}
		}
		System.out.println("The percentage of voters who didn't vote in the constituency with the lowest turnout was " + (100-lowestTurnout) + "%.");
		
		// Calculating highest turnout
		double highestTurnout = Double.MIN_VALUE;
		for(int i=0; i<constituencies.size();i++) {
			Constituency point = (Constituency) constituencies.get(i);
			double turnout = Analysis.turnout(point.getOns(), candidates, constituencies);
			if(turnout>highestTurnout) {
				highestTurnout = turnout;
			}
		}
		System.out.println("The percentage of voters who didn't vote in the constituency with the highest turnout was " + (100-highestTurnout) + "%.");
	}

}
