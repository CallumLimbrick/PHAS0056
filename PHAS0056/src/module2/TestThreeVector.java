package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		
		ThreeVector v1 = new ThreeVector(4,5,3);
		ThreeVector v2 = new ThreeVector(1,4,2);
		ThreeVector v3 = new ThreeVector(0,0,0);
		
		// Non-static method results
		System.out.println("The results of the NON-STATIC methods are:");
		
		double scal1 = v1.scalarProduct(v2);
		System.out.println("The scalar product of v1 and v2 is " +scal1);
		
		double scal2 = v1.scalarProduct(v3);
		System.out.println("The scalar product of v1 and v3 is " +scal2);
		
		ThreeVector vec1 = v1.vectorProduct(v2);
		System.out.println("The vector product of v1 and v2 is ("+vec1.getX()+", "+vec1.getY()+", "+vec1.getZ()+")");
		
		ThreeVector vec2 = v1.vectorProduct(v3);
		System.out.println("The vector product of v1 and v2 is ("+vec2.getX()+", "+vec2.getY()+", "+vec2.getZ()+")");
		
		double ang1 = v1.angle(v2);
		System.out.println("The angle between v1 and v2 is "+ang1);
		
		double ang2 = v1.angle(v3);
		System.out.println("The angle between v1 and v3 is "+ang2);
		
		// Non-static method results
		System.out.println("The results of the STATIC methods are:");
				
		double scal3 = ThreeVector.scalarProduct(v1, v2);
		System.out.println("The scalar product of v1 and v2 is " +scal3);
				
		double scal4 = ThreeVector.scalarProduct(v1, v3);
		System.out.println("The scalar product of v1 and v3 is " +scal4);
				
		ThreeVector vec3 = ThreeVector.vectorProduct(v1, v2);
		System.out.println("The vector product of v1 and v2 is ("+vec3.getX()+", "+vec3.getY()+", "+vec3.getZ()+")");
				
		ThreeVector vec4 = ThreeVector.vectorProduct(v1, v3);
		System.out.println("The vector product of v1 and v2 is ("+vec4.getX()+", "+vec4.getY()+", "+vec4.getZ()+")");
				
		double ang3 = ThreeVector.angle(v1, v2);
		System.out.println("The angle between v1 and v2 is "+ang3);
				
		double ang4 = ThreeVector.angle(v1, v3);
		System.out.println("The angle between v1 and v3 is "+ang4);
		
		
		System.out.println(v1);
		System.out.println("If there is no 'toString()' method then executing the command returns the name of the object as there is no method to convert it autimatically to a string.");
		
	}

}
