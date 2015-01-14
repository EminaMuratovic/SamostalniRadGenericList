import java.util.Iterator;
import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		/*LinkedList<String> test = new LinkedList<String>();
		test.add("Emina");
		test.add("Gorjan");
		test.add("Vedad");
		System.out.println("Linked list: " + test.toString());
		System.out.println("Size: " + test.getSize());
		System.out.println("Get at index 2: " + test.getAt(2));
*/
		System.out.println();

		LinkedListB<Integer> test1 = new LinkedListB<Integer>();
		test1.add(1);
		test1.add(2);
		test1.add(3);
		//System.out.println("Linked list: " + test1.toString());
		/*System.out.println("Size: " + test1.getSize());
		System.out.println("Get at index 2: " + test1.getAt(2));
	*/
		Iterator<Integer> benjo = test1.iterator();
		while(benjo.hasNext())
			System.out.println(benjo.next());
		LinkedList<Integer> test2 = new LinkedList<Integer>();
		test2.add(1);
		test2.add(2);
		test2.add(3);
		Iterator<Integer> benjo2 = test2.iterator();
		while(benjo2.hasNext())
			System.out.println(benjo2.next());
	}

}
