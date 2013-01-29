
public class BinomialCoefficients {
	
	public static void main(String[] args){
		System.out.println(binomial(-1, 0));
		System.out.println(binomial(3, 2));
		System.out.println(binomial(4, 3));
		System.out.println(binomial(4, 2));
		System.out.println(binomial(4, 0));
		System.out.println(binomial(4, 5));
	}
	
	public static int binomial(int n, int k){
		if(k<0 || n<k){
			return 0;
		} else if (k == 0 || n == k){
			return 1;
		} else {
			return binomial(n - 1, k - 1) + binomial(n - 1, k);
		}
	}
}
