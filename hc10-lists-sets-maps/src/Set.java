import java.util.Arrays;

public interface Set {
	
	public Object[] toArray();
	
	/**
	 * @post | result == toArray().length
	 */
	public int getSize();
	
	/**
	 * @pre | value != null
	 * @mutates | this
	 * @post The given value is in the set.
	         | Arrays.stream(toArray()).anyMatch(e -> e.equals(value))
	 * @post No elements have disappeared from the set.
	 *       | Arrays.stream(old(toArray())).allMatch(eo ->
	         |     Arrays.stream(toArray()).anyMatch(e -> e.equals(eo)))
     * @post No elements, other than the given value, have been added.
			 | Arrays.stream(toArray()).allMatch(e -> e.equals(value) ||
			 |     Arrays.stream(old(toArray())).anyMatch(eo -> e.equals(eo)))
	 */
	public void add(Object value);
	
	/**
	 * @pre | value != null
	 * @mutates | this
	 * @post The given value is no longer in the set.
	         | Arrays.stream(toArray()).noneMatch(e -> e.equals(value))
	 * @post No elements, other than the given value, have disappeared
	 *       from the set.
	 *       | Arrays.stream(old(toArray())).allMatch(eo -> eo.equals(value) ||
	 *       |     Arrays.stream(toArray()).anyMatch(e -> e.equals(eo)))
	 * @post No elements have been added to the set.
	 *       | Arrays.stream(toArray()).allMatch(e ->
	 *       |     Arrays.stream(old(toArray())).anyMatch(eo -> e.equals(eo)))
	 */
	public void remove(Object value);
	
	/**
	 * @post | Arrays.stream(toArray()).anyMatch(v -> v.equals(value))
	 */
	public boolean contains(Object value);
}
