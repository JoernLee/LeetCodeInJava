package myduallinklist;

/**
 * 链表节点定义，data代表数值，next代表指向下一个节点,prior表示前一个节点
 * @author Joern
 *
 */
class Node {
	
	//存放数据的变量,object型
	public Object data;
	//存放下一个结点的变量,默认为null
	public Node next;
	//存放上一个节点的变量，默认为null
	public Node prior;
	//构造方法，在构造时就能够给data赋值
	public Node(Object data){
		this.data = data;
		this.next = null;
		this.prior = null;
	}
	@Override
	public String toString() {
		
		return String.valueOf(data);
	}
}

public class MyDualLinkList {
	//定义头节点-一个指向第一个节点，另一个指向最后一个节点（这是双端链表）
	private Node first;
	private Node last;
	//链表长度
	private int length;
	
	//初始化
	public MyDualLinkList(){
		first = null;
		last = null;
		length = 0;
	}
	
	//判断链表是否为空
	public boolean isEmpty(){
        return (first==null);
    }
	
	//头部插入一个节点
	public void insertFirst(Object data){
		Node newNode = new Node(data);
		if(isEmpty()){
			//链表插入的第一个节点当然就是最后一个节点
			last = newNode;
		}else{
			//让那个插入的节点成为头部，并和原来的first节点相互关联
			first.prior = newNode;
			newNode.next = first;
		}
		first = newNode;
		length++;
		
	}
	
	//尾部插入一个节点
	public void insertLast(Object data){
		Node newNode = new Node(data);
		if(isEmpty()){
			first = newNode;
		}else{
			//尾部插入的节点成为尾部并和原来的last节点相互关联
			last.next = newNode;
			newNode.prior = last;
		}
		last = newNode;
		length++;
	}
	
	//指定位置插入节点
	public boolean insert(Object data,int index){
		Node newNode = new Node(data);
		Node current = first;
		int j = 0;
		//确定index是否存在
		if(index > length && index < 0){
			return false;
		}
		//找到index对应的节点
		while( j < index - 1){
			current = current.next;
			j++;
		}
		//特殊情况-在最后插入
		if(index == length){
			insertLast(data);
			return true;
		}else if(index==0){
			insertFirst(data);
			return true;
		}else{
			newNode.next = current.next;
			current.next.prior = newNode;
			newNode.prior = current;
			current.next = newNode;
			length++;
			return true;
		}
	}
	//删除头部节点
	public Node deleteFirst(){
		Node temp=first;
        if(isEmpty())
            return null;
        else{
            first=temp.next;
            temp.next.prior=null;
        }
        length--;
        return temp;
	}
	
	//删除尾部节点
	public Node deleteLast(){
		Node temp = last;
		if(isEmpty()){
			return null;
		}else{
			last = temp.prior;
			temp.prior.next = null;
		}
		length--;
		return temp;
			
	}
	//删除指定位置节点
	public boolean delete(int index){
		Node current = first;
		int j = 0;
		if(index > length && index < 0){
			System.out.println("删除位置错误");
			return false;
		}
		while(j < index){
			current = current.next;
			j++;
		}
		if(index == 0){
			deleteFirst();
			return true;
		}else if(index == length-1){
			deleteLast();
			return true;
		}else{
			current.next.prior = current.prior;
			current.prior.next = current.next;
			length--;
			return true;
		}
		
	}
	
	//从前向后遍历
	public void displayDoubleLinkForward(){
        System.out.println("display DoubleLink :");
        Node current = first;
        while(current!=null){
            System.out.println(current);
            current = current.next;
        }
        System.out.println(" ....end ");
    }
	
	//从后向前遍历
	public void displayDoubleLinkBackward(){
        System.out.println("display DoubleLink :");
        Node current = last;
        while(current!=null){
            System.out.println(current);
            current = current.prior;
        }
        System.out.println(" ....end ");
    }
	
	
}
