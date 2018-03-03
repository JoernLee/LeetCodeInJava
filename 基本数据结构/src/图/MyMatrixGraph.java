package ͼ;

import java.util.ArrayList;

import myqueue.MyQueue;

/**
 * �ڽӾ���ʵ��
 * @author Joern
 *
 */

public class MyMatrixGraph {
	private int numEdges; //����
	
	private ArrayList<Integer> vexs; //�����
	private int[][] edges; //�ڽӾ��� ���Կ��ɱ߱�
	
	private Boolean[] visited; //�����Է��ʱ�־
	
	/**
	 * 
	 * @param n:�ڽӾ����������
	 */
	public MyMatrixGraph(int n){
		vexs = new ArrayList<>(n);
		edges = new int[n][n];
		visited = new Boolean[n];
		numEdges = 0;		
	}
	
	//�õ��ڵ�ĸ���
	public int getNumOfVertexes(){
		return vexs.size();
	}
	
	//�õ��ߵ���Ŀ
	public int getNumOfEdges(){
		return numEdges;
	}
	
	//���ؽڵ�i������
	public Integer getValueByIndex(int index){
		if(index <= vexs.size()){
			return vexs.get(index);
		}else{
			System.out.println("��������ڵĽڵ�");
			return -1;
		}
	}
	
	//����v1��v2��Ȩֵ
	public int getEdgeWeight(int v1,int v2){
		if(v1<=edges.length && v2<=edges.length){
			return edges[v1][v2];	
		}else{
			System.out.println("��������ڵĽڵ�");
			return -1;
		}
		
	}
	
	//����ڵ�
	public void insertVertex(Integer vertex){
		if(vexs.size() < edges.length){
			vexs.add(vertex);
		}else{
			System.out.println("�Ѿ�������ʼ���ڵ�����");
		}
		
	}
	
	//�����
	public void insertEdge(int startVertex,int endVertex,int weight){
		if(edges[startVertex][endVertex] == 0){
			edges[startVertex][endVertex] = weight;
			//��Ϊ������ͼ���ڽӾ����ǶԳƵġ�����ͼ����Ҫ
			edges[endVertex][startVertex] = weight;
			numEdges++;
		}else{
			System.out.println("�ñ��Ѿ�����");
		}
	}
	
	//�޸ı�
	public void changeEdge(int startVertex,int endVertex,int weight){
		edges[startVertex][endVertex] = weight;
		//���������ͼ����Ҫ������һ��
		edges[endVertex][startVertex] = weight;
	}
	
	//ɾ����
	public void deleteEdge(int startVertex,int endVertex){
		edges[startVertex][endVertex] = 0;
		//����ͼ����Ҫ
		edges[endVertex][startVertex] = 0;
		numEdges--;
	}
	
	//�õ���һ���ڽӽڵ���±�
	public int getFirstNeighbour(int index){
		for(int i = 0;i < vexs.size();i++){
			if(edges[index][i] > 0){
				return i;
			}
		}
		return -1;
	}
	
	 //����ǰһ���ڽӽ����±���ȡ����һ���ڽӽ��
    public int getNextNeighbor(int index,int v1) {
        for (int j=v1+1;j<vexs.size();j++) {
            if (edges[index][j]>0) {
                return j;
            }
        }
        return -1;
    }
	
	//��ȱ���DFS
    public void DFSTraverse(){
    	int i;
    	//��ʼ��δ����
    	for(i = 0; i < vexs.size();i++){
    		visited[i] = false;
    	}
    	for(i = 0; i < vexs.size();i++){
    		if(!visited[i]){
    			//����δ���ʵĽڵ������ȱ�����һ�����ֻ��ִ��һ�Σ������Ƿ���ͨͼ
    			DFS(i);
    		}
    	}
    	
    }
    
    private void DFS(int currentVertex){
    	int j;
    	visited[currentVertex] = true;
    	System.out.println(getValueByIndex(currentVertex));
    	for(j = 0; j < vexs.size();j++){
    		if(edges[currentVertex][j]== 1 && !visited[j]){
    			DFS(j);
    		}
    	}
    	
    }
	
	/**
	 * ������ȱ���BFS
	 * 1.������ջ�����ݽṹ-�������ҵ�Ҳ������ϵͳ��Queue
	 * 2.����һ�����У��ѷ��ʵĽڵ����У����ų��ж���ͷ�ڵ㣬ͬʱ�ѳ��нڵ����ܷ��ʵ������нڵ㣨��û�з��ʹ������η��ʲ�����
	 * 3.�ظ�2����ֱ������Ϊ��
	 * 
	 */
    public void BFSTraverse(){
    	int i,j;
    	MyQueue<Integer> queue;
    	//��ʼ��δ����
    	for(i = 0; i < vexs.size();i++){
    		visited[i] = false;
    	}
    	queue = new MyQueue<>();
    	for(i = 0; i < vexs.size();i++){
    		if(!visited[i]){
    			visited[i] = true;
    			System.out.println(getValueByIndex(i));
    			queue.enQueue(i);
    			while(!queue.isEmpty()){
    				i = queue.deQueue();
    				for(j = 0; j < vexs.size();j++){
    					if(edges[i][j] == 1 && !visited[j]){
    						visited[j] = true;
    						System.out.println(getValueByIndex(j));
    						queue.enQueue(j);
    					}
    				}
    			}
    		}
    	}
    }
	
	
}
