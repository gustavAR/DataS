/**
 * @author Gustav Alm Rosenblad (910624-3570) & Lukas Kurtyan (910429-5614)
 */
public class Uppg2 {
	public static double binarySqrt(double sqr, double eps) {
		if(sqr < 1) {
			throw new IllegalArgumentException("sqr has to be larger then on equals to 1.");
		} else if(eps < 0) {
			throw new IllegalArgumentException("eps has to be a posetive number");
		}

		return help(sqr, eps, 1, sqr);			
	}

	private static double help(double sqr, double eps, double low, double high) {
		double middle = (high + low) / 2.0d;

		if(Math.abs((middle * middle) - sqr) < eps) {
			return middle;			
		} else if(middle * middle > sqr) {
			return help(sqr, eps, low, middle);
		} else  {
			return help(sqr, eps, middle, high);
		}
	}
}
