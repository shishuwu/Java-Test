package com.jasons.datastruct.hashmap;

public class MyHashMap {
	// This is to decide the table array max length
	// And the hashCode method is to make sure the new index scope cannot exceed
	// it.
	public static final int COLLISION_FACTOR = 16;
	
	private Entry[] table = new Entry[COLLISION_FACTOR];

	public void put(Object key, Object value) {
		// hash code to determine which slot index it belongs
		int hash_index = hashCode(key);
		Entry tempEntry = table[hash_index];

		Entry newEntry = new Entry(key, value);

		if (tempEntry == null) {
			table[hash_index] = newEntry;
		} else {
			// HERE NEED TO CHECK WHETHER KEY IS THE SAME!!!
			while (tempEntry.hasNext()) {
				tempEntry = tempEntry.next();
			}
			tempEntry.setNext(newEntry);
		}
	}

	int hashCode(Object key) {
		return key.hashCode() % COLLISION_FACTOR;
	}

	/**
	 * It is a basic entry which has
	 * 
	 * <pre>
	 *  - key & value, 
	 *  - and also has link function.
	 * </pre>
	 * 
	 * @author jasons
	 */
	class Entry {
		private Object key;
		private Object value;
		private Entry nextE;

		public Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		public Object getKey() {
			return key;
		}

		public Object getValue() {
			return value;
		}

		public void setNext(Entry nextE) {
			this.nextE = nextE;
		}

		public boolean hasNext() {
			if (nextE == null) {
				return false;
			}
			return true;
		}

		public Entry next() {
			return nextE;
		}
	}

	public static void main(String[] args) {
		MyHashMap map = new MyHashMap();
		map.put(1, 1111);
		map.put(1, 2222);
		
		map.put(2, 2222);
		map.put(3, 3333);

		map.put(17, 171717);

		System.out.println(map);
	}
}
