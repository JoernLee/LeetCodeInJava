package mylinklist;

/**
 * ����ڵ㶨�壬data������ֵ��next����ָ����һ���ڵ㡣
 * @author Joern
 *
 */
class Node implements Cloneable {
	
	//������ݵı���,object��
	public Object data;
	////��Ž��ı���,Ĭ��Ϊnull
	public Node next;
	////���췽�����ڹ���ʱ���ܹ���data��ֵ
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
             node = (Node)super.clone();   //ǳ����  
          }catch(CloneNotSupportedException e) {  
              e.printStackTrace();  
          }  
          return node;  
	}
	
	
	
}

/**
 * 
 * @author Joern
 * �Լ������һ������������������
 * �пգ���ͷ��ӽڵ㣬����ڵ㣬ɾ���ڵ㣬���ҽڵ�
 * ���������ȣ���ӡ�ڵ㣬��ת����
 */

public class MyLinkList {
	
	//����ͷ�ڵ�
	private Node head;
	
	public MyLinkList(){
		head = new Node(null);
	}
	
	/**
	 * �Ƿ�Ϊ������
	 */
	public boolean isEmpty(){
		return (head.next == null);
	}
	
	
	/**
	 * ���ӽڵ����
	 * @param node:��ӵĽڵ㣨��ͷ��
	 * 
	 */
	public void addNote(Node node){
		//���������һ���ڵ㣬Ȼ����ӽڵ�
		//�����ж������Ƿ�Ϊ��
		
		Node temp = head;  //��ͷ�ڵ㿴��һ��ָ��ͷ�ڵ��ָ��
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = node;
	}
	
	/**
	 * ����ڵ����
	 * @param node:��Ҫ����Ľڵ�
	 * @param index:��ӵ�λ��
	 */
	public void insertNode(Node node,int index){
		//�жϲ���λ���Ƿ�Ϸ�
		if(index <= 1 && index > linkLength()  ){
			System.out.println("����λ�ò��Ϸ�");
			return;
		}
		int now = 1;
		Node temp = head; //�ɱ�����ָ��
		while(temp.next!= null){
			if(index == now++){
				//��ʱ��tempΪ����ڵ�ǰһ��λ�ã��˴�����next��ָ�룬��node����
				node.next = temp.next;
				temp.next = node;
				return;
			}
			temp = temp.next;
		}
	}
	
	/**
	 * ɾ������
	 * @param index:ɾ����λ��
	 */
	public void deleteNode(int index){
		//�ж�ɾ��λ���Ƿ�Ϸ�
		if(index <= 1 && index > linkLength()  ){
			System.out.println("ɾ��λ�ò��Ϸ�");
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
	 * ��ȡ����
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
	 * ����������
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
     * ������������ӡ����data
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
     * ��ת����
     * ��0-1-2-3�ĳ�3-2-1-0
     * ��ת�����һ��˼·��ʹ������ָ�롣
     * ���У�һ��ָ��Ϊ��ǰ�ڵ㣬һ��ָ��ָ��ǰ�ڵ����һ���ڵ㣬����һ���ڵ���ָ���������ͷ�Ӷ���������
     * @throws CloneNotSupportedException 
     */
    public Node revLinkList() throws CloneNotSupportedException{
    	Node temp = (Node) head.clone();
    	
    	if(temp.next == null){
    		return temp;
    	}
    	//ʹ�������ڵ�ָ��
    	Node currentNode = temp.next; //��ǰ�ڵ�
    	Node newHead = null; //��Ϊ��ת�����ͷ��
    	Node nextNode = null; //��ǰ�ڵ���һ���ڵ�
    
    	
    	
    	while(currentNode!=null){
    		//�Ƚ���ǰ�ڵ���¸��ڵ㱣��-�������⽨�鵥�����Խ��з���
    		nextNode = currentNode.next;

            currentNode.next = newHead; //��ԭ�����������,��current����һ�����ָ���������ͷ���
            newHead = currentNode; //��current��Ϊ�±�ͷ

            currentNode = nextNode; //��֮ǰ�����next��Ϊ��һ���ڵ�
    	}
    	
    	return newHead;
    }
}
