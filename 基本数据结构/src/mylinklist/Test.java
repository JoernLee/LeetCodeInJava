package mylinklist;

import mylinklist.MyLinkList.Node;

public class Test {

	public static void main(String[] args) {
		//≤‚ ‘À„∑®∑Ω∑®
		MyLinkList linkList = new MyLinkList();
		Node node1 = linkList.new Node(1);
		Node node2 = linkList.new Node(2);
		Node node3 = linkList.new Node(3);
		linkList.addNote(node1);
		linkList.addNote(node2);
		linkList.insertNode(node3, 1);
		
		int length = linkList.linkLength();
		System.out.println(length);
		
		linkList.print();
		
		linkList.deleteNode(1);
		
		linkList.print();
		
		boolean find = linkList.findNote(3);
		System.out.println(find);
		
	}

}
