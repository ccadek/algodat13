package ads1ss13.pa;

/**
 * Sorter Klasse in der die Methode {@link #quicksort(DoublyLinkedList, int)}
 * implementiert werden soll.
 * 
 * <p>
 * In dieser Klasse m&uuml;ssen Sie Ihren Code einf&uuml;gen und die Method
 * {@link #quicksort(DoublyLinkedList, int)} implementieren.
 * </p>
 * 
 * <p>
 * Sie k&ouml;nnen beliebige neue Variablen und Methoden in dieser Klasse
 * hinzuf&uuml;gen.
 * </p>
 */

public class Sorter_lsg {

	/**
	 * Quicksort Implementierung
	 * 
	 * @param in
	 *            Unsortierte Eingabefolge
	 * @param numOfElements
	 *            Gr&ouml;&szlig;e der Eingabefolge
	 * @return Sortiterte Eingabefolge
	 */
	public DoublyLinkedList quicksort(DoublyLinkedList in, int numOfElements) {
		return quicksort(in, in.first, in.first.prev);
	}

	private DoublyLinkedList quicksort(DoublyLinkedList in, ListElement left, ListElement right) {
		if (left == right) {
			return in;
		}
		ListElement pivot = right;
		ListElement[] grenzen = partition(in, left, right);

		if (pivot != grenzen[0]) {
			quicksort(in, grenzen[0], pivot.prev);
		}
		if (pivot != grenzen[1]) {
			quicksort(in, pivot.next, grenzen[1]);
		}
		return in;
	}

	private void swap(DoublyLinkedList list, ListElement[] grenzen, ListElement node1, ListElement node2) {

		if (grenzen[0] == node1) {
			grenzen[0] = node2;
			if (node1 == list.first) {
				list.first = node2;
			}
		}
		if (grenzen[1] == node2) {
			grenzen[1] = node1;
		}
		
		if (node1.prev == node2) { // node1 ist in.first, node2 ist pivot
			ListElement node2Prev = node2.prev;
			ListElement node1Next = node1.next;
			
			node1.next = node2;
			node2.prev = node1;
			node2Prev.next = node1;
			node2Prev.next.prev = node2Prev;
			node1Next.prev = node2;
			node1Next.prev.next = node1Next;
		} else {
	
			ListElement node1Prev = node1.prev;
			ListElement node1Next = node1.next;
			node1.next = node2.next;
			node1.prev = node2.prev != node1 ? node2.prev : node2;
	
			node2.next = node1Next != node2 ? node1Next : node1;
			node2.prev = node1Prev;

			// pointer reparieren
			node1.prev.next = node1;
			node1.next.prev = node1;
			node2.prev.next = node2;
			node2.next.prev = node2;
		}
	}

	private ListElement[] partition(DoublyLinkedList list, ListElement left, ListElement pivot) {
		ListElement[] grenzen = new ListElement[] { left, pivot };
		ListElement right = pivot.prev;
		do {
			while (left.getKey() <= pivot.getKey() && left != right) {
				left = left.next;
			}

			while (right.getKey() > pivot.getKey() && left != right) {
				right = right.prev;
			}

			if (left.getKey() > right.getKey()) { 	//Würde left != right nicht reichen?
				swap(list, grenzen, left, right);	//In den oberen Schleifen wird das abgefangen
				ListElement helper = left;			//Und left kann ja nur größer als right sein
				left = right;
				right = helper;
			}

		} while (left != right);

		// pivot element tauschen
		if (left.getKey() > pivot.getKey()) {
			swap(list, grenzen, left, pivot);
		}
		return grenzen;
	}
}
