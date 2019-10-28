package module5;

import java.util.Arrays;

public class TestSquareMatrix {

	public static void main(String[] args) {
		//Creating Matrices
		int[][] A = { {2,1,0}, {0,1,0}, {-1,0,2} };
		int[][] B = { {1,3,1}, {0,2,0}, {1,0,-1} };
		int[][] C = { {2,3}, {3,4} };
		int[][] D = { {-4,3}, {3,-2} };

		//Carrying out and printing calculations
		int[][] aPlusB = new int[3][3]; 
		for (int k=0;k==2;k++) {
			for (int j=0;j==2;j++) {
				aPlusB[k][j] = A[k][j] + B[k][j];
			}
		}
		System.out.println(Arrays.deepToString(aPlusB));
	}

}

