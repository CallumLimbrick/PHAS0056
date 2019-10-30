package module5;

import java.util.Arrays;

public class TestSquareMatrix {

	public static void main(String[] args) throws Exception {
		SquareMatrix test1 = SquareMatrix.unitMatrix(4);
		System.out.println(test1);

		double[][] a = {{1,2},{3,4}};
		SquareMatrix test2 = new SquareMatrix(a);
		System.out.println(test2);
		
		System.out.println(test1.equals(test1));
	}
}


