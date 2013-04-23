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
		//quicksort(in, 1, numOfElements);
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
		ListElement right = getNode(in.first, r);
		do{
			do{
				i+=1;
			}while(left.getKey() >= x);
			do{
				j-=1;
			}while(j <= i || right.getKey() <= x);
			if(i < j){
				//Tausche left und right
			}
		} while(i >= j);
		//A[i] mit A[r] tauschen
		//return i; == Pivot-element
		return -1;
	}
	
	/**
	 * Ausgehend vom first-Element wird das Element an der index-ten Stelle geholt
	 * @param le
	 * @param index
	 * @return
	 */
	private ListElement getNode(ListElement le, int index){
		if(index > 1){
			getNode(le.next, index-1);
		}
		return le;
	}

}
