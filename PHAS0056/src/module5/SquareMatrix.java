package module5;

import java.lang.reflect.Array;
import java.util.Arrays;

class NotSquareMatrixException extends Exception{
	/* Constructor of custom exception class
	 * Throws exception to a string for a non-square matrix
	 * That string along with a message is displayed
	 */
	String str1;

	NotSquareMatrixException(String str2) {
		str1=str2;
	}
	public String toString() {
		return("NotSquareMatrixException Occured: "+str1);
	}
}

public class SquareMatrix {

	private double[][] sMatrix;

	public SquareMatrix(double[][] elements) throws NotSquareMatrixException {
		/* Square Matrix constructor
		 * Constructs a matrix of doubles that has and equal number of rows or columns
		 * If not a square matrix then NotSquareMatrixException is thrown
		 */
		try {
			if (elements.length == Array.getLength(elements[0])) {
				this.sMatrix = elements;
			}
			else {
				throw new NotSquareMatrixException("Dimensions of input is not a square matrix"); 
			}			
		}
		catch(NotSquareMatrixException e) {
			System.out.println(e);
		}
	}
	
	public String toString() {
		return Arrays.deepToString(sMatrix);
	}
	
	public static SquareMatrix unitMatrix(int size) throws NotSquareMatrixException {
		/* Creates a unit matrix of given size
		 * INPUT: int size
		 * OUTPUT: SquareMatrix with number of columns and rows equal to size and 1.0 on diagonal
		 */
		double[][] uMatrix = new double[size][size];
		for (int i=0;i<size;i++) {
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
	
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) {
		
	}
}
