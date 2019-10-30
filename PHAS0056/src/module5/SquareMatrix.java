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
}
