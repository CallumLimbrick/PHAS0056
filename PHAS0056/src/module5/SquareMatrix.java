package module5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SquareMatrix {

	private double[][] sMatrix;

	public SquareMatrix(double[][] elements) throws Exception {
		/* Square Matrix constructor
		 * Constructs a matrix of doubles that has and equal number of rows or columns
		 * If not a square matrix then Exception is thrown
		 */
		if (elements.length == Array.getLength(elements[0])) {
			this.sMatrix = elements;
		}
		else {
			throw new Exception("Dimensions of input is not a square matrix"); 
		}
		for (int i=0;i<sMatrix.length;i++) {
			if (sMatrix[0].length == sMatrix[i].length) {}
			else {
				throw new Exception("All rows of input not same length, not a square matrix");
			}
		}
	}


	public int numberOfRows() {
		return sMatrix.length;
	}

	public int numberOfCols() {
		return sMatrix[0].length;
	}

	public String toString() {
		return Arrays.deepToString(sMatrix);
	}

	public static SquareMatrix unitMatrix(int size) throws Exception {
		/* Creates a unit matrix of given size
		 * INPUT: int size
		 * OUTPUT: SquareMatrix with number of columns and rows equal to size and 1.0 on diagonal
		 */
		double[][] uMatrix = new double[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if (i==j) {
					uMatrix[i][j] = 1;
				}
				else {
					uMatrix[i][j] = 0;
				}
			}
		}
		SquareMatrix uFMatrix = new SquareMatrix(uMatrix);
		return uFMatrix;
	}

	public int hashCode() {
		/*
		 * To be completely honest, I've no idea what this is
		 */
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(sMatrix);
		return result;
	}

	public boolean equals(Object obj) {
		/* Checks if two matrices have the same elements
		 * INPUT: Object to be compared to
		 * OUTPUT: Boolean 
		 */
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(sMatrix, other.sMatrix))
			return false;
		return true;
	}

	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception{
		/* Add two square matrices together by looping through their elements and adding them
		 * INPUT: Two square matrices
		 * OUTPUT: New Square matrix of same dimensions
		 * Throws exception if the matrices are not the correct dimensions
		 */
		if((sm1.numberOfCols()==sm2.numberOfCols() && sm1.numberOfRows()==sm2.numberOfRows())==false) {
			throw new Exception("Matrices don't have correct dimensions to add");
		}
		double [][] smAdd = new double[sm1.numberOfRows()][sm1.numberOfCols()];
		for(int i=0;i<sm1.numberOfRows();i++) {
			for(int j=0;j<sm1.numberOfCols();j++) {
				smAdd[i][j] = sm1.sMatrix[i][j] + sm2.sMatrix[i][j];
			}
		}	
		return new SquareMatrix(smAdd);
	}
	
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws Exception{
		/* Subtract one matrix from another by looping through their elements and subtracting them
		 * INPUT: Two square matrices
		 * OUTPUT: New Square matrix of same dimensions
		 * Throws exception if the matrices are not the correct dimensions
		 */
		if(sm1.numberOfCols()!=sm2.numberOfCols() || sm1.numberOfRows()!=sm2.numberOfRows()) {
			throw new Exception("Matrices don't have correct dimensions to subtract");
		}
		double [][] smSub = new double[sm1.numberOfRows()][sm1.numberOfCols()];
		for(int i=0;i<sm1.numberOfRows();i++) {
			for(int j=0;j<sm1.numberOfCols();j++) {
				smSub[i][j] = sm1.sMatrix[i][j] - sm2.sMatrix[i][j];
			}
		}	
		return new SquareMatrix(smSub);
	}
	
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception{
		/*
		 * 
		 */
		if(sm1.numberOfRows()!=sm2.numberOfCols() || sm1.numberOfCols()!=sm2.numberOfRows()) {
			throw new Exception("Matrices don't have correct dimesnions to multiply");
		}
		double[][] smMultiply = new double[sm1.numberOfRows()][sm2.numberOfCols()];
		for(int i=0;i<sm1.numberOfRows();i++) {
			for(int j=0;j<sm2.numberOfCols();j++) {
				smMultiply[i][j] = 
			}
		}
	}
}
