/**
 * @author Gustav Alm Rosenblad (910624-3570) & Lukas Kurtyan (910429-5614)
 */
public class Uppg1aTests {

	public static void main(String[] args) {
		
		Uppg1a theList = new Uppg1a();
		
		
		//TEST ADDFIRST
		theList.addFirst("0");
		System.out.println("*" + theList +  " # bör vara 0 i först");
		
		//TEST PROPER RESIZING
		theList = new Uppg1a(1);
		for (int i = 0; i < 10; i++) {
			theList.addFirst("" + i);
		}
		
		//TEST GETFIRST
		System.out.println("*" + theList.getFirst() +  " # bör vara 9");
		
		//TEST REMOVEFIRST
		theList.removeFirst();
		System.out.println("*" + theList  +  " # bör vara [ 8, 7, 6, 5, 4, 3, 2, 1, 0 ]");
		
		//TEST ISEMPTY
		while(!theList.empty()){
			theList.removeFirst();
		}
		System.out.println("*" + theList +  " # bör vara tom");
		
		//TEST EXISTP
		for (int i = 1; i < 10; i++) {
			theList.addFirst("" + i);
		}
		if(!theList.existP("5")){
			System.out.println("Error: existP can't find strings!");
		} else if(theList.existP("19")){
			System.out.println("Error: existP returns true for strings that aren't there!");
		} else {
			System.out.println("existP works properly");
		}
		
		System.out.println("All tests completed.");
	}
}
