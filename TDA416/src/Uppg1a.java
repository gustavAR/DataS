/**
 * @author Gustav Alm Rosenblad (910624-3570) & Lukas Kurtyan (910429-5614)
 */
public class Uppg1a {

	
	private static final int DEFAULT_INITIAL_CAPACITY = 10;

	private String[] sequence;
	private int size;

	/**
	 * Creates a sequence with an initial capacity of 10
	 */
	public Uppg1a() {
		this(DEFAULT_INITIAL_CAPACITY);		
	}

	/**
	 * Creates a sequence with a specified initialcapacity
	 * @param initialCapacity
	 */
	public Uppg1a(int initialCapacity) {
		if(initialCapacity <= 0){
			throw new IllegalArgumentException("InitialCapacity must be greater than zero.");
		}
		this.sequence = new String[initialCapacity];		
		this.size = 0;
	}

	/**
	 * Adds the parameter element to the beginning of the sequence
	 * @param element
	 */
	public void addFirst(String element)
	{
		if(this.size == this.sequence.length){
			this.realloc();
		}
		
		
		for (int i = this.size; i > 0; i--) {
			this.sequence[i] = this.sequence[i - 1];
		}

		this.sequence[0] = element;
		this.size++;
	}

	/**
	 * @return True if the sequence is empty
	 */
	public boolean empty() {
		return this.size == 0;
	}

	/**
	 * @return The first element of the sequence
	 */
	public String getFirst() {
		return this.sequence[0];		
	}

	/**
	 * Removes the first element of the sequence
	 */
	public void removeFirst() {
		if(this.size == 0)
			return;
		
		for (int i = 1; i < this.size; i++) {
			this.sequence[i - 1] = this.sequence[i];
		}

		this.size--;
	}

	/**
	 * Searches the sequence for the parameter elem
	 * @param elem String to search for
	 * @return true if elem was present
	 */
	public boolean existP(String elem) {
		for (int i = 0; i < this.size; i++) {
			if(checkElementEquals(this.sequence[i], elem))
				return true;
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
		for (int i = 0; i < this.size - 1; i++) {
			builder.append(this.sequence[i]);
			builder.append(", ");
		}

		if(this.size != 0) {
			builder.append(this.sequence[this.size - 1]);
		}

		builder.append(" ]");
		return builder.toString();
	}


	private boolean checkElementEquals(String elem0, String elem1) {
		if(elem0 == null)
			return elem0 == elem1;
		else 
			return elem0.equals(elem1);		
	}

	private void realloc() {
		String[] resized = new String[sequence.length * 2];
		for (int i = 0; i < this.sequence.length; i++) {
			resized[i] = this.sequence[i];
		}

		this.sequence = resized;
	}


}