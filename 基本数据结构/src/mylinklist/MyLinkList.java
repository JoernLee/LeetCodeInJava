package mylinklist;

/**
 * 
 * @author Joern
 * 自己定义的一个单链表，完成初始化，读取，插入，删除等操作.
 */

public class MyLinkList {
	
	//定义头节点
	Node head = new Node(null);
	
	/**
	 * 链表节点定义，data代表数值，next代表指向下一个节点。
	 * @author Joern
	 *
	 */
	public class Node {
		
		//存放数据的变量,object型
		public Object data;
		////存放结点的变量,默认为null
		public Node next = null;
		////构造方法，在构造时就能够给data赋值
		public Node(Object data){
			this.data = data;
		}
		@Override
		public String toString() {
			
			return String.valueOf(data);
		}
		
	}
	
	
	
	/**
	 * 增加节点操作
	 * @param node:添加的节点（表头）
	 * 
	 */
	public void addNote(Node node){
		//遍历到最后一个节点，然后添加节点
		//首先判断链表是否为空
		
		Node temp = head;  //把头节点看成一个指向头节点的指针
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = node;
	}
	
	/**
	 * 插入节点操作
	 * @param node:需要插入的节点
	 * @param index:添加的位置
	 */
	public void insertNode(Node node,int index){
		//判断插入位置是否合法
		if(index <= 1 && index > linkLength()  ){
			System.out.println("插入位置不合法");
			return;
		}
		int now = 1;
		Node temp = head; //可遍历的指针
		while(temp.next!= null){
			if(index == now++){
				//此时的temp为插入节点前一个位置，此处更改next的指针，把node插入
				node.next = temp.next;
				temp.next = node;
				return;
			}
			temp = temp.next;
		}
	}
	
	/**
	 * 删除操作
	 * @param index:删除的位置
	 */
	public void deleteNode(int index){
		//判断删除位置是否合法
		if(index <= 1 && index > linkLength()  ){
			System.out.println("删除位置不合法");
			return;
		}
		Node temp = head;
		int now = 1;
		while(temp.next != null){
			if(index == now++){
				temp.next = temp.next.next;
				return;
			}
			temp = temp.next;
		}
	}
	
	/**
	 * 读取操作
	 * @
	 */
	public boolean findNote(Object key){
		Node temp = head;
		while(temp!= null){
			if(temp.data == key){
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	/**
	 * 计算链表长度
	 */
	public int linkLength(){
		int length = 0;
		Node temp = head;
		while(temp.next!=null){
			temp = temp.next;
			length++;
		}
		return length;
	}
	
	/**
     * 遍历单链表，打印所有data
     */
    public void print(){
        Node temp = head.next;
        while(temp != null){
            System.out.print(temp.data+",");
            temp = temp.next;
        }
        System.out.println();
    }
	
}
