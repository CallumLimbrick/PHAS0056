package module5;

public class TestSquareMatrix {

	public static void main(String[] args) throws Exception {
		
		double[][] a = {{2,1,0},{0,1,0},{-1,0,2}};
		double[][] b = {{1,3,1},{0,2,0},{1,0,-1}};
		double[][] c = {{2,3},{3,4}};
		double[][] d = {{-4,3},{3,-2}};
		
		try {
			SquareMatrix A = new SquareMatrix(a);
			SquareMatrix B = new SquareMatrix(b);
			SquareMatrix C = new SquareMatrix(c);
			SquareMatrix D = new SquareMatrix(d);
			SquareMatrix I = SquareMatrix.unitMatrix(2);
			
			SquareMatrix aPlusB = A.add(B);
			SquareMatrix aMinusB = A.subtract(B);
			SquareMatrix AB = A.multiply(B);
			SquareMatrix BA = B.multiply(A);
			SquareMatrix ABCommute = AB.subtract(BA);
			SquareMatrix CD = C.multiply(D);
			
			System.out.println("A+B = " + aPlusB);
			System.out.println("A-B = " + aMinusB);
			System.out.println("AB = " + AB);
			System.out.println("BA = " + BA);
			System.out.println("[A,B] = "+ ABCommute);
			System.out.println("CD = " + CD);
			System.out.println("CD is equal to a 2x2 unit matrix: " + CD.equals(I));			
		}
		catch (Exception e) {
			System.out.println("Uh oh, something has gone wrong!");
			System.out.println(e);
		}
	}
}


