import static org.junit.Assert.*;

import org.junit.Test;


public class PublicTests {

	@Test
	public void testBasicConstructorsAndGetters() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble d = new MyDouble(555.729);

		ComplexNumber x = new ComplexNumber(a, b);
		assertTrue(x.getReal().compareTo(a) == 0 && x.getImag().compareTo(b) == 0);

		ComplexNumber z = new ComplexNumber(d);
		assertTrue(z.getReal().compareTo(d) == 0 && z.getImag().compareTo(new MyDouble(0)) == 0);
	}

	@Test
	public void testCopyConstructor() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(x);
		assertTrue(x != y);     // Check to be sure they are not aliased!
		assertTrue(y.getReal().compareTo(a) == 0 && y.getImag().compareTo(b) == 0);
	}
	@Test
	public void testAdd() {
		MyDouble a = new MyDouble(5.7), b = new MyDouble (-3.7), c = new MyDouble(2.3), d = new MyDouble(4.7);
		ComplexNumber z = new ComplexNumber(a,b);
		ComplexNumber y = new ComplexNumber(c,d);
		ComplexNumber x = z.add(y);
		ComplexNumber w = new ComplexNumber(new MyDouble (8.0), new MyDouble(1.0));
		assertTrue(x.equals(w));
		
		MyDouble l = new MyDouble(-3.2), m = new MyDouble(12.9), n = new MyDouble(6.6), o = new MyDouble(5.4);
		ComplexNumber zz = new ComplexNumber (l,m);
		ComplexNumber yy = new ComplexNumber (n,o);
		ComplexNumber xx = zz.add(yy);
		ComplexNumber ww = new ComplexNumber (new MyDouble(3.4), new MyDouble(18.3));
		assertTrue(xx.equals(ww));
	}
	@Test
	public void testSubtract() {
		MyDouble a = new MyDouble(5.7), b = new MyDouble (-3.7), c = new MyDouble(2.7), d = new MyDouble(4.0);
		ComplexNumber z = new ComplexNumber(a,b);
		ComplexNumber y = new ComplexNumber(c,d);
		ComplexNumber x = z.subtract(y);
		ComplexNumber w = new ComplexNumber(new MyDouble(3.0), new MyDouble(-7.7));
		assertTrue(x.equals(w));
		
		MyDouble l = new MyDouble(-3.2), m = new MyDouble(12.9), n = new MyDouble(6.6), o = new MyDouble(5.4);
		ComplexNumber zz = new ComplexNumber (l,m);
		ComplexNumber yy = new ComplexNumber (n,o);
		ComplexNumber xx = zz.subtract(yy);
		ComplexNumber ww = new ComplexNumber (new MyDouble(-9.8), new MyDouble(7.5));
		assertTrue(xx.equals(ww));
		
	}
	@Test 
	public void testMultiply() {
		MyDouble a = new MyDouble(5.7), b = new MyDouble (-3.7), c = new MyDouble(2.0), d = new MyDouble(4.0);
		ComplexNumber z = new ComplexNumber(a,b);
		ComplexNumber y = new ComplexNumber(c,d);
		ComplexNumber x = z.multiply(y);
		ComplexNumber w = new ComplexNumber (new MyDouble (26.2), new MyDouble (15.4));
		assertTrue(x.equals(w));
		
		MyDouble l = new MyDouble(-3.2), m = new MyDouble(12.9), n = new MyDouble(6.6), o = new MyDouble(5.4);
		ComplexNumber zz = new ComplexNumber (l,m);
		ComplexNumber yy = new ComplexNumber (n,o);
		ComplexNumber xx = zz.multiply(yy);
		ComplexNumber ww = new ComplexNumber(new MyDouble(-90.78), new MyDouble(67.86));
		assertTrue(xx.equals(ww));
	}
	@Test 
	public void testDivide() {
		MyDouble a = new MyDouble(16), b = new MyDouble (-2), c = new MyDouble(3), d = new MyDouble(-2);
		ComplexNumber z = new ComplexNumber(a,b);
		ComplexNumber y = new ComplexNumber(c,d);
		ComplexNumber x = z.divide(y);
		ComplexNumber w = new ComplexNumber (new MyDouble(4), new MyDouble(2));
		assertTrue(x.equals(w));
		
		MyDouble l = new MyDouble(-3.1), m = new MyDouble(12.2), n = new MyDouble(6.1), o = new MyDouble(5.2);
		ComplexNumber zz = new ComplexNumber (l,m);
		ComplexNumber yy = new ComplexNumber (n,o);
		ComplexNumber xx = zz.divide(yy);
		ComplexNumber ww = new ComplexNumber( new MyDouble(.69307), new MyDouble(1.40918));
		assertTrue(xx.equals(ww));
	}
	@Test 
	public void testEqComp() {
		ComplexNumber z = new ComplexNumber(new MyDouble (16), new MyDouble (-2));
		ComplexNumber y = new ComplexNumber(new MyDouble (16), new MyDouble (-2));
		ComplexNumber x = new ComplexNumber(new MyDouble (32), new MyDouble (6));
		assertTrue(x.compareTo(y) == 1);
		assertTrue(y.equals(z));
		
		ComplexNumber zz = new ComplexNumber(new MyDouble (-4.2), new MyDouble (9.5));
		ComplexNumber yy = new ComplexNumber(new MyDouble (6.5), new MyDouble (3.3));
		ComplexNumber xx = new ComplexNumber(new MyDouble (2.1), new MyDouble(1.9));
		assertTrue(xx.compareTo(yy) == -1);
		assertFalse(zz.equals(yy));
	}
	@Test 
	public void testNorm() {
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		ComplexNumber z = new ComplexNumber (a,b);
		MyDouble x = ComplexNumber.norm(z);
		MyDouble y = new MyDouble(Math.sqrt(46.18));
		assertTrue(x.equals(y));
		
		MyDouble l = new MyDouble(-3.2), m = new MyDouble(12.9);
		ComplexNumber zz = new ComplexNumber (l,m);
		MyDouble xx = ComplexNumber.norm(zz);
		MyDouble yy = new MyDouble(Math.sqrt(176.65));
		assertTrue(xx.equals(yy));
		
	}
	@Test
	public void testParseComplexNumber() {
		String nn = new String (" 5.7  -  3.7 i");
		ComplexNumber zz = ComplexNumber.parseComplexNumber(nn);
		ComplexNumber yy = new ComplexNumber (new MyDouble (5.7), new MyDouble(-3.7));
		assertTrue(yy.equals(zz));
		
		String n = new String("- 3.0 - 2.9  i");
		ComplexNumber z = ComplexNumber.parseComplexNumber(n);
		ComplexNumber y = new ComplexNumber (new MyDouble(-3.0), new MyDouble(-2.9));
		assertTrue(y.equals(z));
	}
	@Test
	public void testToString() {
		ComplexNumber z = new ComplexNumber(new MyDouble(3.2), new MyDouble(-4.2));
		String x = z.toString();
		String s = "3.2-4.2i";
		assertTrue(x.contentEquals(s));
		
	}
}

