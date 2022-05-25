
public class main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node n1 = new Node("Hello");
		Node n2 = new Node("My");
		Node n3 = new Node("Name");
		Node n4 = new Node("Is");
		Node n5 = new Node("James");
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4, 3);
		list.add(n5, 1);
		list.remove("My");
		System.out.print(list.get(0));
		System.out.print(list.get(1));
		System.out.print(list.get(2));
		System.out.print(list.get(3));
	}

}
