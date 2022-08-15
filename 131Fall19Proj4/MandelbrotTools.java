import java.awt.Color;
/*A general class that is used for creating Mandelbrot Set images
 * The class codes for color and other aspects of the mandelbrot set
 */
public class MandelbrotTools {

	/*  STUDENTS:  Put your "isBig" and "divergence" methods here. */
	/*A method that takes a ComplexNumber, n, and adds the squares of its real and imaginary components
	 * The method compares this value to a int called Controller.DIVERGENCE_BOUNDARY and returns true
	 * if the calculated sum is greater than the divergence boundary. Return type is boolean
	 */
	public static boolean isBig(ComplexNumber n) {
		MyDouble real = n.getReal();
		MyDouble imag = n.getImag();
		MyDouble realSquared = real.multiply(real);
		MyDouble imagSquared = imag.multiply(imag);
		MyDouble sum = realSquared.add(imagSquared);
		if(sum.compareTo(Controller.DIVERGENCE_BOUNDARY) == 1) {
			return true;
		}else {
			return false;
		}
	}
	/* A method that takes a ComplexNumber, n, and calculates a sequence of ComplexNumbers. After each
	 * ComplexNumber is computed, it will use the isBig method to compare it with the divergence boundary. 
	 * The method will continue until the isBig method returns true or until it reaches the Controller.LIMIT
	 * It will return an integer that represents the number of iterations until the loop is broken.
	 * 
	 */
	public static int divergence(ComplexNumber n) {
		int i;
		ComplexNumber squared = n.multiply(n);	//variable representing the n squared
		for(i = 0; i < Controller.LIMIT; i++) {
			ComplexNumber firstNumber = squared.add(n);
			if(isBig(firstNumber) == true) {
				return i;
			}else {
				squared = firstNumber.multiply(firstNumber);
				continue;
			}
		}
		return -1;
	}
	/* This method selects a non-black color for a point which DIVERGED when 
	 * tested with the Mandelbrot recurrence, based on how many terms in the 
	 * sequence were computed before the terms got "too big".
	 * 
	 * The parameter represents the index of the term in the sequence which was 
	 * first to be "too big".  This value could be anything from 0 to 
	 * Controller.LIMIT.  The return value is the Color to be used 
	 * to color in the point.
	 * 
	 * STUDENTS:  IF you want to have some fun, write code for the else-if 
	 * clause below which says "modify this block to create your own color 
	 * scheme".  When someone runs the program and selects "Student Color 
	 * Scheme", the code you have written below will determine the colors.
	 */
	public static Color getColor(int divergence) {
		Color returnValue;

		if (Controller.colorScheme == Controller.RED_AND_WHITE_BANDS) {
			returnValue = (divergence  % 2 == 0)? Color.WHITE : Color.RED;
		}

		else if (Controller.colorScheme == Controller.CRAZY_COLORS) {
			int value = divergence * 2;
			int redAmount = (value % 5) * (255/5);
			int greenAmount = (value % 7) * (255/7);
			int blueAmount = (value % 9) * (255/9);
			returnValue = new Color(redAmount, greenAmount, blueAmount); 
		}

		else if (Controller.colorScheme == Controller.STUDENT_DEFINED){
			int value = divergence * 3;
			int redAmount = (value % 12) * (255/12);
			int blueAmount = (value % 10) * (255/10);
			int greenAmount = (value % 7) * (255/7);

			returnValue = new Color(redAmount, greenAmount, blueAmount);  // take out and return something useful 


		}
		else
			throw new RuntimeException("Unknown color scheme selected!");
		return returnValue;
	}

}
