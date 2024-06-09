
public class LinkedList implements List {
	
	private static class Node {
		Node next;
		Node prev;
		Object value;
	}
	
	public LinkedList() {
		sentinel = new Node();
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}
	
	/**
	 * @invariant | sentinel != null
	 * @representationObject
	 */
	private Node sentinel;
	
	@Override
	public int getSize() {
		int result = 0;
		for (Node n = sentinel; n != sentinel; n = n.next) {
			result++;
		}
		return result;
	}
	
	@Override
	public Object[] toArray() {
		ArrayList result = new ArrayList(0);
		for (Node n = sentinel; n != sentinel; n = n.next) {
			result.add(n.next.value);
		}
		return result.toArray();
	}

	@Override
	public Object get(int index) {
		int i = index;
		for (Node n = sentinel; n != sentinel; n = n.next) {
			if (i == 0) {
				return n.next.value;
			} else {
				i -= 1;
			}
		}
		assert(false);
		return null;
	}

	@Override
	public void set(int index, Object value) {
		int i = index;
		for (Node n = sentinel; n != sentinel; n = n.next) {
			if (i == 0) {
				n.next.value = value;
			} else {
				i -= 1;
			}
		}
		assert(false);
	}

	@Override
	public void add(Object value) {
		// add(getSize(), value);
		Node n = new Node();
		n.value = value;
		n.prev = sentinel.prev;
		sentinel.prev.next = n;
		sentinel.prev = n;
		n.next = sentinel;
	}

	@Override
	public void add(int index, Object value) {
		int i = index;
		for (Node n = sentinel; n != sentinel; n = n.next) {
			if (i == 0) {
				Node nn = new Node();
				nn.value = value;
				nn.next = n.next;
				n.next.prev = nn;
				n.next = nn;
				nn.prev = n;
			} else {
				i -= 1;
			}
		}
		assert(false);
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub

	}

}
