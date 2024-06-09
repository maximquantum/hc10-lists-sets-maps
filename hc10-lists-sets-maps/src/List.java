import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @invariant | arr != null
 * @representationObject
 */
public interface List {
	
	public int getSize(); //impliciet allemaal abstract (dankzij interface)
	
	/**
	 * @post | result != null
	 * @creates | result
	 */
	public Object[]	toArray();

	/**
	 * @pre | 0 <= index
	 * @pre | index < getSize()
	 * @post | result == toArray() [index]
	 */
	public Object get(int index);
	
	public void set (int index, Object value);
	
	/**
	 * @post | IntStream.range(0, old(getSize())).allMatch(i -> toArray()[i] == old(toArray())[i])
	 * @post | toArray()[old(getSize())] == value
	 * @post | getSize() == old(getSize()) + 1
	 */
	public void add(Object value);
	
	/**
	 * @pre | 0 <= index
	 * @pre | index <= getSize()
	 * @post | IntStream.range(0, index).allMatch(i -> toArray()[i] == old(toArray())[i])
	 * @post | toArray()[index] == value
	 * @post | IntStream.range(index, getSize()-1).allMatch(i -> toArray()[i+1] == old(toArray())[i])
	 * @post | getSize() == old(getSize()) + 1
	 */
	public void add(int index, Object value);
		
	/**
	 * 
	 */
	public void remove(int index);
	
//		public void remove(Object val) {
//			
//		}
}
