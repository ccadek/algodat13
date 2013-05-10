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
		
		return quicksort(in, 1, numOfElements, in.first, in.first.prev);
	}
	
	private DoublyLinkedList quicksort(DoublyLinkedList in,int l, int r, ListElement left, ListElement right){
		
		ListElement p;	//Pivot-Stelle
		
		if(l < r){			
			ListElement x = in.first.prev;
			
			p = partition(in, l, r, x);
			
			quicksort(in,l, getNode(in, p)-1, left, p.prev);
			
			quicksort(in, getNode(in, p)+1, l, p.next, right);
			
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
	private ListElement partition(DoublyLinkedList in, int l, int r, ListElement x){
		int i = l-1;
		int j = r;
		ListElement left = getNode(in.first, i);
		ListElement right = getNode(in.first, j);
		ListElement end = right;
		do{
			do{
				i+=1;
				left = left.next;
			}while(left.getKey() < x.getKey()); //oder >=
			do{
				j-=1;
				right = right.prev;
			}while(j > i || right.getKey() > x.getKey()); //oder <=
			if(i < j){
				//Tausche left und right
				if(left == in.first) right = in.first;
				
				ListElement rn = right.next;
				ListElement rp = right.prev;
				ListElement lp = left.prev;
				ListElement ln = left.next;
				left.next = rn;
				left.prev = rp;
				rn.prev = left;
				rp.next = left;
				right.next = ln;
				right.prev = lp;
				ln.prev = right;
				lp.next = right;
				 
			}
		} while(i >= j);
		//A[i] mit A[r] tauschen
		if(left == in.first) right = in.first;
		ListElement rn = end.next;
		ListElement rp = end.prev;
		ListElement lp = left.prev;
		ListElement ln = left.next;
		left.next = rn;
		left.prev = rp;
		rn.prev = left;
		rp.next = left;
		end.next = ln;
		end.prev = lp;
		ln.prev = end;
		lp.next = end;
				
		return end;	// Pivot-Element
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
	private int getNode(DoublyLinkedList in, ListElement eing){
		ListElement tmp = in.first;
		boolean bool = false;
		int i = 1;
		while(!bool){
			if(tmp == eing) bool = true;
			else{ 
				tmp = tmp.next;
				i++;
			}
		}
		return i;
	}
}
