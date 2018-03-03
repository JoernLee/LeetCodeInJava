package ͼ;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import myqueue.MyQueue;

/**
 * �ڽӱ�ʵ�֣�����������ͼ������ͼ��ʹ��ʮ������
 * @author Joern
 *
 */
public class MyALGraph {
	
	//ָ�򶥵������
	private VertexNode[] head; 
	
	//�������
	private int vertexNum;
	
	//�߸���
	private int edgeNum;
	
	//�����ѷ��ʱ�־
	private Boolean[] visited; 
	
	//�߱�Ľڵ�
	private class EdgeNode{
		int adjvex;  //�ڽӵ���-�洢�ö����Ӧ�±�
		int weight; //Ȩֵ
		EdgeNode next; //ָ����һ���ڽӵ�
		
		public EdgeNode(int adj,int weight,EdgeNode node){
			this.adjvex = adj;
			this.weight = weight;
			this.next = node;
		}
	}
	
	//�����Ľڵ�
	private class VertexNode{
		int verName;
		EdgeNode firstEdge;
		
	}
	
	//�ڽӱ�ͼ�ĳ�ʼ��
	public MyALGraph(){
		int from,to,weight;
		Scanner sc = new Scanner(System.in);
		//�û�ȷ���������
		System.out.println("�����붥�������");
		vertexNum = sc.nextInt();
		head = new VertexNode[vertexNum];
		//���������ʼ��
		for(int i = 0;i < vertexNum;i++){
			head[i] = new VertexNode();
			head[i].verName = i;
			head[i].firstEdge = null;
		}
		
		//�û�ȷ�ϱߵĸ���
		System.out.println("������߸�����");
		edgeNum = sc.nextInt();
		System.out.println("��������ߵ���㣬�յ㣬Ȩֵ");
		for(int i = 0;i < edgeNum;i++){
			//ȷ������ı���Ϣ
			from = sc.nextInt();
			to = sc.nextInt();
			weight = sc.nextInt();
			//�����յ�߱�ڵ�---����ͷ�巨
			//һ���߶�Ӧ�����ڵ�-��������
			EdgeNode p = new EdgeNode(to,weight,null);
			p.next = head[from].firstEdge;
			head[from].firstEdge = p;
			
			EdgeNode q = new EdgeNode(from, weight, null);
			q.next = head[to].firstEdge;
			head[to].firstEdge = q;
		}
		visited = new Boolean[vertexNum];
	}
	
	/** 
     * ���ָ���ߵ�Ȩֵ 
     * @param v1 ����v1 
     * @param v2 ����v2 
     * @return Ȩֵ 
     */  
    public int getWeight(int v1,int v2){  
        if(v1==-1||v2==-1)return -1;  
        EdgeNode p=head[v1].firstEdge;  
        while(p!=null){  
            if(p.adjvex==v2){
            	return p.weight;  
            }
            p=p.next;  
        }  
        return -1;  
    }  
    /** 
     * ���v�ĵ�һ���ڽӶ��� 
     * @param v ����v 
     * @return ��һ���ڽӶ������� 
     */  
    public int getFirstNeighbor(int v){  
        if(v==-1)return -1;  
        EdgeNode p=head[v].firstEdge;  
        if(p!=null)return p.adjvex;  
        else return -1;  
    }  
    /** 
     * ���v1�����v2�ĵ�һ������ 
     * @param v1 ����v1 
     * @param v2 ����v2 
     * @return �������� 
     */  
    public int getNextNeighbor(int v1,int v2){  
        if(v1==-1||v2==-1){
        	return -1;  
        }
        EdgeNode p=head[v1].firstEdge;  
        //һֱ��������ĩβ���߱�����v2
        while(p.adjvex!=v2&&p!=null){  
            p=p.next;  
        }  
        //������ĩβ
        if(p==null){
        	return -1;  
        }
        //���v2��Ӧ���Ѿ��Ǳ߱����һ����
        p=p.next;
        if(p==null){
        	return -1;  
        }
        
        return p.adjvex;  
    }  
    
    //��ȱ���DFS
    public void DFSTraverse(){
    	int i;
    	//��ʼ��δ����
    	for(i = 0; i < vertexNum;i++){
    		visited[i] = false;
    	}
    	DFS(0);
    }
    /** 
     * �Ӷ���v����������ȱ����ĵݹ��㷨 
     * @param v ����v 
     */  
    private void DFS(int currentVertex){
    	int j;
    	visited[currentVertex] = true;
    	System.out.println(head[currentVertex].verName);
    	int next = getFirstNeighbor(currentVertex);
    	while(next != -1){
    		if(visited[next] == false){
    			DFS(next);
    		}
    		next = getNextNeighbor(currentVertex, next);
    	}
    }
    
    /** 
     * ������ȱ����ĵ����㷨 ---����ջȥά�����
     * @param v ��ʼ����v 
     */  
    public void DFSTraverse2(int v){  
        int[] visited=new int[this.vertexNum];  
        for(int i=0;i<this.vertexNum;i++){  
            visited[i]=0;  
        }  
        Stack<Integer> s=new Stack<>();  
        s.push(v);  
        int w;  
        while(!s.isEmpty()){  
            w=s.pop();  
            visited[w]=1;  
            System.out.print(w+" ");  
            int k=getFirstNeighbor(w);  
            while(k!=-1){  
                if(visited[k]==0){
                	if(!s.contains(k)){
                		s.push(k);//û�����ʹ���ջ�в����ڣ�ѹջ  
                	}
                }
                k=getNextNeighbor(w, k);  
            }  
        }  
    }  
    
    /** 
     * ������ȱ����ĵ����㷨--ʹ�ö���ά��������˼·ͬ�ڽӾ����BFS���� 
     * @param v ��ʼ����v 
     */  
    public void BFS(int v){  
        int[] visited=new int[this.vertexNum];  
        for(int i=0;i<this.vertexNum;i++){  
            visited[i]=0;  
        }  
        System.out.print(v+" ");  
        visited[v]=1;  
        MyQueue<Integer> a=new MyQueue<Integer>();  
        a.enQueue(v);  
        while(!a.isEmpty()){  
            int q=a.deQueue();  
            int p=getFirstNeighbor(q);  
            while(p!=-1){  
                if(visited[p]==0){  
                    System.out.print(p+" ");  
                    visited[p]=1;  
                    a.enQueue(p);  
                }  
                p=getNextNeighbor(q, p);  
            }  
        }  
    }  
	
	

}
