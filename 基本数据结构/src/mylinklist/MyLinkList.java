package mylinklist;

/**
 * 
 * @author Joern
 * �Լ������һ����������ɳ�ʼ������ȡ�����룬ɾ���Ȳ���.
 */

public class MyLinkList {
	
	//����ͷ�ڵ�
	Node head = new Node(null);
	
	/**
	 * ����ڵ㶨�壬data������ֵ��next����ָ����һ���ڵ㡣
	 * @author Joern
	 *
	 */
	public class Node {
		
		//������ݵı���,object��
		public Object data;
		////��Ž��ı���,Ĭ��Ϊnull
		public Node next = null;
		////���췽�����ڹ���ʱ���ܹ���data��ֵ
		public Node(Object data){
			this.data = data;
		}
		@Override
		public String toString() {
			
			return String.valueOf(data);
		}
		
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
	
}
