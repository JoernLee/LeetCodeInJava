package myduallinklist;

/**
 * ����ڵ㶨�壬data������ֵ��next����ָ����һ���ڵ�,prior��ʾǰһ���ڵ�
 * @author Joern
 *
 */
class Node {
	
	//������ݵı���,object��
	public Object data;
	//�����һ�����ı���,Ĭ��Ϊnull
	public Node next;
	//�����һ���ڵ�ı�����Ĭ��Ϊnull
	public Node prior;
	//���췽�����ڹ���ʱ���ܹ���data��ֵ
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
	//����ͷ�ڵ�-һ��ָ���һ���ڵ㣬��һ��ָ�����һ���ڵ㣨����˫������
	private Node first;
	private Node last;
	//������
	private int length;
	
	//��ʼ��
	public MyDualLinkList(){
		first = null;
		last = null;
		length = 0;
	}
	
	//�ж������Ƿ�Ϊ��
	public boolean isEmpty(){
        return (first==null);
    }
	
	//ͷ������һ���ڵ�
	public void insertFirst(Object data){
		Node newNode = new Node(data);
		if(isEmpty()){
			//�������ĵ�һ���ڵ㵱Ȼ�������һ���ڵ�
			last = newNode;
		}else{
			//���Ǹ�����Ľڵ��Ϊͷ��������ԭ����first�ڵ��໥����
			first.prior = newNode;
			newNode.next = first;
		}
		first = newNode;
		length++;
		
	}
	
	//β������һ���ڵ�
	public void insertLast(Object data){
		Node newNode = new Node(data);
		if(isEmpty()){
			first = newNode;
		}else{
			//β������Ľڵ��Ϊβ������ԭ����last�ڵ��໥����
			last.next = newNode;
			newNode.prior = last;
		}
		last = newNode;
		length++;
	}
	
	//ָ��λ�ò���ڵ�
	public boolean insert(Object data,int index){
		Node newNode = new Node(data);
		Node current = first;
		int j = 0;
		//ȷ��index�Ƿ����
		if(index > length && index < 0){
			return false;
		}
		//�ҵ�index��Ӧ�Ľڵ�
		while( j < index - 1){
			current = current.next;
			j++;
		}
		//�������-��������
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
	//ɾ��ͷ���ڵ�
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
	
	//ɾ��β���ڵ�
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
	//ɾ��ָ��λ�ýڵ�
	public boolean delete(int index){
		Node current = first;
		int j = 0;
		if(index > length && index < 0){
			System.out.println("ɾ��λ�ô���");
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
	
	//��ǰ������
	public void displayDoubleLinkForward(){
        System.out.println("display DoubleLink :");
        Node current = first;
        while(current!=null){
            System.out.println(current);
            current = current.next;
        }
        System.out.println(" ....end ");
    }
	
	//�Ӻ���ǰ����
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
