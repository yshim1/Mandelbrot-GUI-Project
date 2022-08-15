/*A general class called ComplexNuber that can be used in a variety of projects
 * This class contains arithmetic methods and boolean methods regarding ComplexNumbers
 * 
 */

public class ComplexNumber {

	/* STUDENTS:  You may NOT add any further instance or static variables! */
	private final MyDouble real;   // To be initialized in constructors
	private final MyDouble imag;   // To be initialized in constructors


	/* STUDENTS: Put your methods here, as described in the project description.
	 * 	 * IMPORTANT:  You may NOT call the toString method for the MyDouble class except
	 * while you are writing the toString method for the Complex class.  You may NOT
	 * call the toString method of the Complex class ANYWHERE.  If you don't adhere
	 * to this rule, you will fail some (or possibly all) release tests. */

	/*Constructor that takes two MyDouble parameters representing 
	 * real and imaginary components of ComplexNumber being constructed
	 *  and initializes it to real and imag data members.*/
	public ComplexNumber(MyDouble realIn , MyDouble imagIn) {
		real = realIn;
		imag = imagIn;
	}
	/*Constructor that takes one MyDouble representing the real component of ComplexNumber 
	 * to be constructed and initializes it with real data member.
	 * Imaginary component initialized with 0.0 value*/
	public ComplexNumber(MyDouble realIn) {
		this(realIn, new MyDouble(0.0));
	}
	/*Copy constructor that takes initializes real and imag data 
	 *members with another object of the ComplexNumber class */
	public ComplexNumber(ComplexNumber other) {
		real = other.real;
		imag = other.imag;
	}
	//A getter that obtains value for real data member
	public MyDouble getReal() {
		return real;
	}
	//A getter that obtains value for imaginary data member
	public MyDouble getImag() {
		return imag;
	}
	/* A method that takes in a ComplexNumber, (n), and adds it to the current object
	 * The method returns a ComplexNumber that represents the sum of the two ComplexNumbers
	 */
	public ComplexNumber add(ComplexNumber n) {
		MyDouble sReal = this.real.add(n.real);	//Variable that represents the real component of ComplexNumber s
		MyDouble sImag = this.imag.add(n.imag);	//Variable that represents the imaginary component of ComplexNumber s
		ComplexNumber s = new ComplexNumber(sReal, sImag);
		return s;
	}
	/*A method that takes in a ComplexNumber ,(n), and subtracts it from the current object
	 * This method returns a ComplexNumber that represents the result from the subtraction
	 */
	public ComplexNumber subtract(ComplexNumber n) {
		MyDouble sReal = this.real.subtract(n.real);
		MyDouble sImag = this.imag.subtract(n.imag);
		ComplexNumber s = new ComplexNumber(sReal , sImag);
		return s;
	}
	/* A method that takes a ComplexNumber, (n), and multiplies it with the current object
	 * This method returns a ComplexNumber that represents the product of the two ComplexNumbers
	 */
	public ComplexNumber multiply(ComplexNumber n) {
		MyDouble ac = this.real.multiply(n.real); //Variable that represents product of real components
		MyDouble ad = this.real.multiply(n.imag); //represents product of current object's real component and imaginary component of n
		MyDouble bic = this.imag.multiply(n.real); //represents product of current object's imaginary component and real component of n
		MyDouble bidi = this.imag.multiply(n.imag); //Variable that represents product of imaginary components
		MyDouble sReal = ac.subtract(bidi);
		MyDouble sImag = ad.add(bic);
		ComplexNumber s = new ComplexNumber (sReal , sImag);
		return s;
	}
	/* A method that takes a ComplexNumber, (n), divides it with the current object.
	 * The return will be a ComplexNumber that represents the quotient of the two.
	 */
	public ComplexNumber divide(ComplexNumber n) {
		MyDouble realTerm1 = this.real.multiply(n.real);//product of real components
		MyDouble realTerm2 = this.imag.multiply(n.imag);//products of imaginary components
		MyDouble imagTerm1 = this.imag.multiply(n.real);//product of current object's imag component and real component of n
		MyDouble imagTerm2 = this.real.multiply(n.imag);//product of current object's real component and imag component of n
		MyDouble realNSquared= n.real.multiply(n.real);//the real component of n squared
		MyDouble imagNSquared = n.imag.multiply(n.imag);// the imaginary component of n squared
		MyDouble realTermsSum = realTerm1.add(realTerm2);
		MyDouble imagTermsSum = imagTerm1.subtract(imagTerm2);
		MyDouble denominatorTerm = realNSquared.add(imagNSquared);
		MyDouble realTerm = realTermsSum.divide(denominatorTerm);
		MyDouble imagTerm = imagTermsSum.divide(denominatorTerm);
		ComplexNumber s = new ComplexNumber(realTerm, imagTerm);
		return s;
	}
	/*This method takes a ComplexNumber, n, and compares its real and imaginary components with
	 * the real and imaginary components of the current object. It returns true if both components
	 * are equal to each other and false if they are not equal to each other
	 */
	public boolean equals(ComplexNumber n) {
		if(this.real.equals(n.real) && this.imag.equals(n.imag)) {
			return true;
		}
		return false;
	}
	/* This method takes a ComplexNumber, n, and compares the norm of n and the norm of the current object
	 * It will return an integer. The integer will be 1 if the norm of the current object is greater, 
	 * -1 if the norm of the current object is less than the norm of n, and 0 if the two norms are equal
	 */
	public int compareTo(ComplexNumber n) {
		MyDouble nNorm = norm(n);
		MyDouble normCurrent = norm(this);
		if(normCurrent.compareTo(nNorm) < 0) {
			return -1;
		}
		else if(normCurrent.compareTo(nNorm) > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	/* This method takes a ComplexNumber, n, and calculates the norm of it.
	 * It will return a MyDouble representing the value of the norm
	 */
	public static MyDouble norm(ComplexNumber n) {
		MyDouble realSquared = n.real.multiply(n.real);
		MyDouble imagSquared = n.imag.multiply(n.imag).abs();
		MyDouble sum = realSquared.add(imagSquared).sqrt();
		return sum;
	}	
	/* This method takes a String and changes it to a ComplexNumber
	 * The return will be a ComplexNumber representing the string
	 */
	public static ComplexNumber parseComplexNumber(String n) {
		String newN = n.replaceAll("\\s",""); //new string of n without the whitespace
		int realBeginning = newN.indexOf('-');
		if(realBeginning == -1) {
			realBeginning = 0;
		}
		int realEnd = newN.indexOf('+');
		if (realEnd == -1) {
			realEnd = newN.lastIndexOf('-');
		}
		int imagEnd = newN.indexOf('i');
		String r = newN.substring(0, realEnd);
		String i = newN.substring(realEnd , imagEnd);
		Double realDouble = Double.parseDouble(r);
		Double imagDouble = Double.parseDouble(i);
		MyDouble real = new MyDouble (realDouble);
		MyDouble imag = new MyDouble (imagDouble);
		ComplexNumber s = new ComplexNumber(real, imag);
		return s;
	}
	/* A method that takes no parameters. This method returns a string that looks like a ComplexNumber
	 * This method uses the real and imaginary components of the current object
	 */
	public String toString() {
		MyDouble zero = new MyDouble(0.0); 
		int realCompareToValue = this.real.compareTo(zero);	//Return value of the compareTo method between real of current object and zero
		int imagCompareToValue = this.imag.compareTo(zero); //Return value of the compareTo method between imag of current object and zero
		String r = this.real.toString();
		String i = this.imag.toString();
		if(realCompareToValue < 0 && imagCompareToValue < 0) {
			String cn = r + i + 'i';
			return cn;
		}
		else if(realCompareToValue < 0 && imagCompareToValue > 0) {
			String cn = r + '+' + i + 'i';
			return cn;
		}
		else if(realCompareToValue > 0 && imagCompareToValue < 0) {
			String cn = r + i + 'i';
			return cn;
		}else {
			String cn = r + '+' + i + 'i';
			return cn;
		}
	}
}
////Boolean return type that checks if a number repeats in an integer array
//public static boolean hasRepeat(int [] arr) {
//	for(int i = 0; i < arr.length; i++) {
//		for(int j = i + 1; j < arr.length; j++) {
//			if(arr[i] == arr[j] && i!=j) {
//				return true;
//			}
//		}
//	}
//	return false;
//}
////boolean return type that checks if an array has an Ace
//public static boolean hasAce(int [] arr) {
//	for(int i = 0; i < arr.length; i++) {
//		if(arr[i] == 1) {
//			return true;
//		}
//	}
//	return false;
//}
////integer return type that returns the minimum value in an integer array
//public static int findMin(int [] arr) {
//	int min = 13;
//	for(int i = 0; i < arr.length; i++) {
//		if(arr[i] < 13) {
//			min = arr[i];
//		}
//	}
//	return min;
//}
////integer return type that returns the max value in an integer array
//public static int findMax(int [] arr) {
//	int max = 0;
//	for(int i = 0; i < arr.length; i++) {
//		if(arr[i] > 0) {
//			max = arr[i];
//		}
//	}
//	return max;
//}
//int [] arr = new int [cards.length];
//for(int i = 0; i < arr.length; i++) {
//	arr[i] = cards[i].getValue();
//}
//int min = findMin(arr);
//int max = findMax(arr);
//int difference = max - min;
//boolean hasAce = hasAce(arr);
//boolean repeat = hasRepeat(arr);
//if(hasAce == true && difference == 12 && repeat == false) {
//	for(int i = 0; i < arr.length; i++) {
//		if(arr[i] == 1) {
//			arr[i] = 14;
//			return true;
//		}
//	}
//}
//else if(repeat == false && difference == 4) {
//	return true;
//}
//return false;
//}