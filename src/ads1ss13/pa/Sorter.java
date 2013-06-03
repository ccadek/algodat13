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
	 * @param in
	 *            Unsortierte Eingabefolge
	 * @param numOfElements
	 *            Gr&ouml;&szlig;e der Eingabefolge
	 * @return Sortiterte Eingabefolge
	 */
	public DoublyLinkedList quicksort(DoublyLinkedList in, int numOfElements) {
		return null;
	}
	
	/**
	 * Andere Lösung zum Sorter_lsg (der bei der Abgabe abgegeben wurde)
	 * Hier gehe ich die Liste nur von links durch und gebe alle Elemente größer als das 
	 * Pivot hinter das Pivot. 
	 * Dann teile ich die Liste am Pivot und sortierte links und rechts nach dem gleichen Schema.
	 * 
	 * 
	 * @param in
	 * @param left
	 * @param pivot
	 * @return
	 */
	public DoublyLinkedList quicksort(DoublyLinkedList in, ListElement left, ListElement pivot){
		
		while(left != pivot){
			
		}

		return null;
	}
	
	/**
	 * Gibt alle Elemente vor dem Pivot die größer als selbiges sind nach hinten
	 * und gibt anschließend das neue Pivot retour
	 * 
	 * @param in
	 * @param left
	 * @param pivot
	 * @return
	 */
	public ListElement partition(DoublyLinkedList in, ListElement left, ListElement pivot){
		
		while(left != pivot && left.getKey() < pivot.getKey()){
			left = left.next;
		}
		//left-element hinter pivot schieben und referenz auf left reparieren
		
		return pivot;
	}

}
