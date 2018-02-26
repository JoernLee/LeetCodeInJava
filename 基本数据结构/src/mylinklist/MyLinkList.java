package mylinklist;

/**
 * 链表节点定义，data代表数值，next代表指向下一个节点。
 * @author Joern
 *
 */
class Node implements Cloneable {
	
	//存放数据的变量,object型
	public Object data;
	////存放结点的变量,默认为null
	public Node next;
	////构造方法，在构造时就能够给data赋值
	public Node(Object data){
		this.data = data;
	}
	@Override
	public String toString() {
		
		return String.valueOf(data);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		 Node node = null;  
          try{  
             node = (Node)super.clone();   //浅复制  
          }catch(CloneNotSupportedException e) {  
              e.printStackTrace();  
          }  
          return node;  
	}
	
	
	
}

/**
 * 
 * @author Joern
 * 自己定义的一个单链表，方法包括：
 * 判空，表头添加节点，插入节点，删除节点，查找节点
 * 计算链表长度，打印节点，反转链表
 */

public class MyLinkList {
	
	//定义头节点
	private Node head;
	
	public MyLinkList(){
		head = new Node(null);
	}
	
	/**
	 * 是否为空链表
	 */
	public boolean isEmpty(){
		return (head.next == null);
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
	public boolean findNode(Object key){
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
    
    public void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+",");
            temp = temp.next;
        }
        System.out.println();
    }
    
    /**
     * 反转链表
     * 把0-1-2-3改成3-2-1-0
     * 反转链表的一般思路是使用三个指针。
     * 其中，一个指针为当前节点，一个指针指向当前节点的下一个节点，另外一个节点则指向新链表表头从而保存结果。
     * @throws CloneNotSupportedException 
     */
    public Node revLinkList() throws CloneNotSupportedException{
    	Node temp = (Node) head.clone();
    	
    	if(temp.next == null){
    		return temp;
    	}
    	//使用三个节点指针
    	Node currentNode = temp.next; //当前节点
    	Node newHead = null; //作为反转链表的头部
    	Node nextNode = null; //当前节点下一个节点
    
    	
    	
    	while(currentNode!=null){
    		//先将当前节点的下个节点保存-如果不理解建议单步调试进行分析
    		nextNode = currentNode.next;

            currentNode.next = newHead; //将原来的链表断链,将current的下一个结点指向新链表的头结点
            newHead = currentNode; //将current设为新表头

            currentNode = nextNode; //将之前保存的next设为下一个节点
    	}
    	
    	return newHead;
    }
}
