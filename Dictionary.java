
public class Dictionary implements DictionaryInterface {
	int numitems;
	Node head, last;

	// Node Class
	private class Node {
		String key, item;
		Node next;

		public Node(String numba, String item) {
			this.item = item;
			key = numba;

		}
	}

	public Dictionary() {
		numitems = 0;
		head = null;

	}

	public void insert(String string, String string2) throws DuplicateKeyException {// inserts new (key,value)
		Node N = new Node(string, string2);
		for (int i = 0; i < numitems; i++) {
			if (string.compareTo(head.key) == 0) {
				throw new DuplicateKeyException(string);
			}
		}

		if (head == null) {
			head = N;
			last = head;
		} else {
			last.next = N;
			last = N;
		}
		numitems++;

	}

	public boolean isEmpty() { // returns true if this Dictionary is empty, false otherwise
		return numitems == 0;
	}

	public int size() { // returns the number of entries in this Dictionary
		return numitems;
	}

	public String lookup(String numba) { // returns value associated key, or null reference if no such key exists
		Node N = findKey(head, numba);
		if (N != null) {
			return N.item;
		}
		return null;
	}

	public void delete(String key) throws KeyNotFoundException { // deletes pair with the given key lookup(key)!=null
		Node N, temp = head;
		N = findKey(head, key);
		if (N == null) {
			throw new KeyNotFoundException(key);
		}
		// case 1 (delete head node)
		if (N == head) {
			head = head.next;
			numitems--;
			return;
		}
		// case 2 (delete other node)
		while (temp.next != N) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		numitems--;
	}

	public void makeEmpty() { // set numitems to 0
		numitems = 0;
		head = null;

	}

	private Node findKey(Node R, String k) {
		if (R == null || k.compareTo(R.key) == 0)
			return R;
		if (k.compareTo(R.key) != 0) {
			return findKey(R.next, k);
		} else {
			return null;
		}
	}

	public String toString() { // prints "number key" each term on its own line
		String temp = null;
		if (isEmpty()) {
			return "";
		}
		for (Node N = head; N != null; N = N.next) {
			temp += N.key + " " + N.item + "\n";
		}
		return temp.substring(4);

	}

}
