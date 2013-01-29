
public class Uppg1a {
	
	public static void main(String[] args){
		
		Uppg1a theList = new Uppg1a();
		
		
		//TEST ADDFIRST
		theList.addFirst("0");
		System.out.println("*" + theList +  " # bör vara 0 i först");
		
		//TEST PROPER RESIZING
		for (int i = 1; i < 10; i++) {
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
	
	public static final int DEFAULT_SIZE = 10;
	private String[] strings;
	private int size;
	
	/**
	 * Constructs a sequence starting with size size.
	 * @param size Starting size.
	 */
	public Uppg1a(int size){
		this.strings = new String[size];
		this.size = 0;
	}
	
	/**
	 * Constructs a sequence with the default size.
	 */
	public Uppg1a(){
		this(DEFAULT_SIZE);
	}
	
	/**
	 * Adds an element to the beginning of the sequence.
	 * @param element
	 */
	public void addFirst(String element){
		if (this.isFull()){
			doubleSize();
		}
		for (int i = this.strings.length - 1; i > 0; i--) {
			this.strings[i] = this.strings[i - 1];
		}
		this.strings[0] = element;
		this.size++;
	}
	
	private boolean isFull(){
		return this.size >= this.strings.length;
	}
	
	private void doubleSize(){
		String[] newArray = new String[this.strings.length * 2];
		for (int i = 0; i < this.strings.length; i++) {
			newArray[i] = this.strings[i];
		}
		this.strings = newArray;
	}
	
	/**
	 * Returns true if the sequence is empty.
	 * @return True if the sequence is empty.
	 */
	public boolean empty(){
		return this.size == 0;
	}
	
	/**
	 * Gets the first element of the sequence.
	 * @return The first element of the sequence.
	 */
	public String getFirst(){
		return this.strings[0];
	}
	
	/**
	 * Removes the first element of the sequence.
	 * @return false if the sequence was empty.
	 */
	public boolean removeFirst(){
		if (this.size == 0){
			return false;
		}
		for (int i = 0; i < this.strings.length - 1; i++) {
			this.strings[i] = this.strings[i + 1];
		}
		this.strings[this.strings.length - 1] = null;
		this.size--;
		return true;
	}
	
	/**
	 * Searches the sequence for element elem.
	 * @param elem String to search for
	 * @return True if elem exists in sequence
	 */
	public boolean existP(String elem){
		for (int i = 0; i < this.size; i++) {
			if(this.strings[i].equals(elem)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("[ ");
		if(!this.empty()) {
			for (int i = 0; i < this.size - 1; i++) {
				builder.append(this.strings[i]);
				builder.append(", ");
			}
			builder.append(this.strings[this.size - 1]);
		}
		builder.append(" ]");
		return builder.toString();
	}
}
