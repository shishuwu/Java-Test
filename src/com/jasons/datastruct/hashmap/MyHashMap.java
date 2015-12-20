package com.jasons.datastruct.hashmap;

public class MyHashMap {
	// This is to decide the table array max length
	// And the hashCode method is to make sure the new index scope cannot exceed
	// it.
	public static final int CAPACITY = 16;

	private Entry[] table = new Entry[CAPACITY];

	/**
	 * Put key value into map.
	 * 
	 * <pre>
	 * 	1. Get hashcode according to key.
	 *  2. Get the entry of table array by the hashcode.
	 *  	2.1 If entry is null, new entry and add it here
	 *  	2.2 If entry is not null
	 *  		2.2.1 Check if the key equals to input key,
	 *  				then update this entry to new entry (including the next link)
	 *  		2.2.2 Loop the linked entry, get its next entry:
	 *  		      refer 2.2.1
	 *  			  If cannot find same key, add it to the last null element
	 * 
	 * 
	 * </pre>
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Object key, Object value) {
		// hash code to determine which slot index it belongs
		int hash_index = hashCode(key);
		Entry tempEntry = table[hash_index];

		Entry newEntry = new Entry(key, value);

		if (tempEntry == null) {
			table[hash_index] = newEntry;
		} else {
			// HERE NEED TO CHECK WHETHER KEY IS THE SAME!!!
			Object tmpK = tempEntry.getKey();
			if (tmpK.equals(key)) {
				table[hash_index] = newEntry;
				newEntry.setNext(tempEntry.next());
				return;
			}
			while (tempEntry.hasNext()) {
				tempEntry = tempEntry.next();

				// HERE NEED TO CHECK WHETHER KEY IS THE SAME!!!
				tmpK = tempEntry.getKey();
				if (tmpK.equals(key)) {
					table[hash_index] = newEntry;
					newEntry.setNext(tempEntry.next());
					return;
				}
			}
			tempEntry.setNext(newEntry);
		}
	}

	/**
	 * Get value by key.
	 * <pre>
	 * 	1. Get hashcode of key.
	 *  2. Get entry from table by this hashcode
	 *  3. Check entry's key value equals to input key or not.
	 *  	If yes, return value
	 *  	If no, get next entry, and loop 3
	 *  4. return null if not found
	 * </pre>
	 * 
	 * @param key
	 * @return
	 */
	public Object get(Object key) {
		if (key == null) {
			return null;
		}

		int hashcode = hashCode(key);

		Entry entry = table[hashcode];
		if (entry.getKey().equals(key)) {
			return entry.getValue();
		} else {
			while (entry.hasNext()) {
				entry = entry.next();
				if (entry.getKey().equals(key)) {
					return entry.getValue();
				}
			}
		}
		return null;
	}

	int hashCode(Object key) {
		return key.hashCode() % CAPACITY;
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
		
		System.out.println(map.get(3));

		System.out.println(map);
	}
}
