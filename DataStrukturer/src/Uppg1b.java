
public class Uppg1b {
	private static final int DEFAULT_INITIAL_CAPACITY = 10;
	
	private String[] sequence;
	private int size;
	private int position;
	
	public Uppg1b() {
		this(DEFAULT_INITIAL_CAPACITY);		
	}
	
	public Uppg1b(int initialCapacity) {
		this.sequence = new String[initialCapacity];	
		this.size = 0;
		this.position = 0;
	}
	
	public void addFirst(String element)
	{
		if(this.size == this.sequence.length){
			this.realloc();
		}
		
		for (int i = 0; i < this.size; i++) {
			this.sequence[i] = this.sequence[i + 1];
		}
		
		this.sequence[0] = element;
		this.size++;
	}
	
	public boolean empty() {
		return this.size == 0;
	}
	
	public String getFirst() {
		return this.sequence[0];		
	}
	
	public void removeFirst() {
		if(this.size == 0)
			return;
		
		
		for (int i = 1; i < this.size - 1; i++) {
			this.sequence[i - 1] = this.sequence[i];
		}
		
		this.size--;
	}
		
	public boolean existP(String elem) {
		for (int i = 0; i < this.size; i++) {
			if(checkElementEquals(this.sequence[i], elem))
				return true;
		}		
		return false;
	}
	
	public void setP(int p) throws IndexOutOfBoundsException {
		this.position = p;		
	}
	
	public void addAfterP(String element) {
		if(!hasNext()) {
			throw new IndexOutOfBoundsException("The position:" + this.position + " is set to a position that is outside of the sequence.");
		}
		if(this.size == this.sequence.length) {
			this.realloc();
		}
		
		for (int i = this.position; i < this.size; i++) {
			this.sequence[i] = this.sequence[i + 1];
		}
		
		this.sequence[this.position] = element;
		
		this.size++;		
	}
	
	public String get() {
		if(!hasNext()) {
			throw new IndexOutOfBoundsException("The position:" + this.position + " is set to a position that is outside of the sequence.");
		}
		
		return this.sequence[this.position];
	}
	
	public void moveP(int val) {
		this.position += val;		
	}
	
	public boolean hasNext() {
		return this.position < this.size;
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
