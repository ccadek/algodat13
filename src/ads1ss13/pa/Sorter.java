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

public class Sorter {

	/**
	 * Quicksort Implementierung
	 * 
	 * @param in Unsortierte Eingabefolge
	 * @param numOfElements Gr&ouml;&szlig;e der Eingabefolge 
	 * @return Sortiterte Eingabefolge
	 */
	public DoublyLinkedList quicksort(DoublyLinkedList in, int numOfElements) {
		quicksort(in, 1, numOfElements);
		return null;
	}
	private DoublyLinkedList quicksort(DoublyLinkedList in, int l, int r){
		int x;	//Pivot-Element
		int p;	//Pivot-Stelle
		
		if(l < r){
			
			int i = l;
			ListElement tmp = in.first;
			while(i <= r){	// Auf das Pivot-Element gehen
				tmp = tmp.next;
			}
			
			x = tmp.getKey();
			p = partition(in, l, r, x);
			
			quicksort(in, l, p-1);
			
			quicksort(in, p+1, r);
			
		}
		return null; //Auf in setzen !!!!
	}
	/**
	 * 
	 * @param in
	 * @param l = Linke Grenze
	 * @param r = Rechte Grenze
	 * @param x = Pivot-Wert
	 * @return
	 */
	private  int partition(DoublyLinkedList in, int l, int r, int x){
		int i = l-1;
		int j = r;
		ListElement left = getNode(in.first, i);
		ListElement right = getNode(in.first, j);
		ListElement end = right;
		do{
			do{
				i+=1;
				left = left.next;
			}while(left.getKey() >= x);
			do{
				j-=1;
				right = right.prev;
			}while(j <= i || right.getKey() <= x);
			if(i < j){
				//Tausche left und right
				/*
				 * ListElement rn = right.next;
				 * ListElement rp = right.prev;
				 * ListElement lp = left.prev;
				 * ListElement ln = left.next;
				 * left.next = rn;
				 * left.prev = rp;
				 * right.next = ln;
				 * right.prev = lp;
				 */
			}
		} while(i >= j);
		//A[i] mit A[r] tauschen
		/*
		 * ListElement rn = end.next;
		 * ListElement rp = end.prev;
		 * ListElement lp = left.prev;
		 * ListElement ln = left.next;
		 * left.next = rn;
		 * left.prev = rp;
		 * end.next = ln;
		 * end.prev = lp;
		 */		
		return i;	// Pivot-Element
	}
	
	
	/**
	 * Ausgehend vom first-Element wird das Element geholt
	 * @param le = Element, von dem ausgegangen wird
	 * @param index 
	 * @return Element
	 */
	private ListElement getNode(ListElement le, int index){
		if(index > 1){
			getNode(le.next, index-1);
		}
		return le;
	}
}
