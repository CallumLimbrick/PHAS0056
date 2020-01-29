package exam2test1;

import java.util.ArrayList;

public class Tests {

	public static double mccTest(ArrayList<Ident> totalDataSet, ArrayList<TenObserved> expDataSet, ArrayList<TenObserved> volDataSet) {
		double tp = 0;
		double tn = Analysis.volCheck(totalDataSet).size() - expDataSet.size();
		double fp = 0;
		double fn = expDataSet.size() - volDataSet.size();

		for (TenObserved i : volDataSet) {
			if (i.getExp().equals("lion")) {
				tp += 1;
			}
			else {
				fp += 1;
			}
		}
		System.out.println("tp = " + tp + ", tn = " +tn+ ", fp = " + fp + "and fn = " + fn);
		double numerator = tp*tn - fp*fn;
		double denominator = Math.sqrt((tp+fp)*(tp+fn)*(tn+fp)*(tn+fn));
		System.out.println("num = " + numerator + ", den = " + denominator);
		return numerator/denominator;
	}
}