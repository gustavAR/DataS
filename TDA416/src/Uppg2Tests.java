/**
 * @author Gustav Alm Rosenblad (910624-3570) & Lukas Kurtyan (910429-5614)
 */
public class Uppg2Tests {

	public static void main(String[] args) {

		for (int i = 1; i <= 1000; i++) {
			System.out.print("Custom: " + Uppg2.binarySqrt(i, 10e-6));			
			System.out.print(" Math: " + Math.sqrt(i));	
			System.out.println("Difference: " + (Math.abs(Math.sqrt(i) - Uppg2.binarySqrt(i, 10e-6))));
		}
	}
}
