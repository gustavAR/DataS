/**
 * @author Gustav Alm Rosenblad (910624-3570) & Lukas Kurtyan (910429-5614)
 */
public class Uppg1bTests {
	public static void main(String[] args) {
		
		Uppg1b theList = new Uppg1b();
		
		
		//TEST ADDFIRST
		theList.addFirst("0");
		System.out.println("*" + theList +  " # bör vara 0 i först");
		
		//TEST PROPER RESIZING
		theList = new Uppg1b(1);
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
		
		//TEST HASNEXT
		theList.setP(-1);
		System.out.println("hasNext() == " + theList.hasNext() + ". hasNext() should be false");
		theList.setP(124);
		System.out.println("hasNext() == " + theList.hasNext() + " hasNext() should be false");
		theList.setP(0);
		System.out.println("hasNext() == " + theList.hasNext() + " hasNext() should be true");
		theList.setP(8);
		System.out.println("hasNext() == " + theList.hasNext() + " hasNext() should be true");
		
		//TEST RETRIEVAL
		theList.setP(0);
		System.out.println(theList.get() + "#Should be 9");
		theList.setP(-1);
		try {
			theList.get();
			System.out.println("ERROR: Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception properly thrown");
		}
		theList.setP(10);
		try {
			theList.get();
			System.out.println("ERROR: Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception properly thrown");
		}
		
		//TEST ITERATION
		theList.setP(0);
		while(theList.hasNext()){
			System.out.println("Testing iteration." + theList.get());
			theList.moveP(1);
		}
		System.out.println("Should stop at 1");
		
		//TEST INSERTION
		theList.setP(5);
		theList.addAfterP("4.5");
		System.out.println(theList + "# bör vara [ 9, 8, 7, 6, 5, 4.5, 4, 3, 2, 1, 0 ]");
		theList.setP(-1);
		try {
			theList.addAfterP("Foo");
			System.out.println("ERROR: Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception properly thrown");
		}
		theList.setP(99);
		try {
			theList.addAfterP("Bar");
			System.out.println("ERROR: Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception properly thrown");
		}
	}
}
