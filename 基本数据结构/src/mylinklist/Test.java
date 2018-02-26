package mylinklist;



public class Test {

	public static void main(String[] args) {
		//测试算法方法
		MyLinkList linkList = new MyLinkList();
		System.out.println(linkList.isEmpty());
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		linkList.addNote(node1);
		linkList.addNote(node2);
		linkList.insertNode(node3, 1);
		
		int length = linkList.linkLength();
		System.out.println(length);
		
		linkList.print();
		
		System.out.println("\n");
		
		
		
		boolean find = linkList.findNode(2);
		System.out.println(find);
		
		System.out.println("\n");
		
		Node reverseHead = null;
		try {
			reverseHead = linkList.revLinkList();
		} catch (CloneNotSupportedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		System.out.println(reverseHead);
		
		linkList.print(reverseHead);
		
		System.out.println("\n");
		
		
		
		
	}

}
