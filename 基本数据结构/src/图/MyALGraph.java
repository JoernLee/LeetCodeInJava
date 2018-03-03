package 图;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import myqueue.MyQueue;

/**
 * 邻接表实现（适用于无向图，有向图请使用十字链表）
 * @author Joern
 *
 */
public class MyALGraph {
	
	//指向顶点表引用
	private VertexNode[] head; 
	
	//顶点个数
	private int vertexNum;
	
	//边个数
	private int edgeNum;
	
	//遍历已访问标志
	private Boolean[] visited; 
	
	//边表的节点
	private class EdgeNode{
		int adjvex;  //邻接点域-存储该顶点对应下标
		int weight; //权值
		EdgeNode next; //指向下一个邻接点
		
		public EdgeNode(int adj,int weight,EdgeNode node){
			this.adjvex = adj;
			this.weight = weight;
			this.next = node;
		}
	}
	
	//顶点表的节点
	private class VertexNode{
		int verName;
		EdgeNode firstEdge;
		
	}
	
	//邻接表图的初始化
	public MyALGraph(){
		int from,to,weight;
		Scanner sc = new Scanner(System.in);
		//用户确定顶点个数
		System.out.println("请输入顶点个数：");
		vertexNum = sc.nextInt();
		head = new VertexNode[vertexNum];
		//顶点个数初始化
		for(int i = 0;i < vertexNum;i++){
			head[i] = new VertexNode();
			head[i].verName = i;
			head[i].firstEdge = null;
		}
		
		//用户确认边的个数
		System.out.println("请输入边个数：");
		edgeNum = sc.nextInt();
		System.out.println("请输入各边的起点，终点，权值");
		for(int i = 0;i < edgeNum;i++){
			//确定输入的边信息
			from = sc.nextInt();
			to = sc.nextInt();
			weight = sc.nextInt();
			//根据终点边表节点---链表头插法
			//一条边对应两个节点-插入两次
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
     * 获得指定边的权值 
     * @param v1 顶点v1 
     * @param v2 顶点v2 
     * @return 权值 
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
     * 获得v的第一个邻接顶点 
     * @param v 顶点v 
     * @return 第一个邻接顶点的序号 
     */  
    public int getFirstNeighbor(int v){  
        if(v==-1)return -1;  
        EdgeNode p=head[v].firstEdge;  
        if(p!=null)return p.adjvex;  
        else return -1;  
    }  
    /** 
     * 获得v1相对于v2的第一个顶点 
     * @param v1 顶点v1 
     * @param v2 顶点v2 
     * @return 顶点的序号 
     */  
    public int getNextNeighbor(int v1,int v2){  
        if(v1==-1||v2==-1){
        	return -1;  
        }
        EdgeNode p=head[v1].firstEdge;  
        //一直到遍历到末尾或者遍历到v2
        while(p.adjvex!=v2&&p!=null){  
            p=p.next;  
        }  
        //遍历到末尾
        if(p==null){
        	return -1;  
        }
        //如果v2对应的已经是边表最后一个了
        p=p.next;
        if(p==null){
        	return -1;  
        }
        
        return p.adjvex;  
    }  
    
    //深度遍历DFS
    public void DFSTraverse(){
    	int i;
    	//初始化未访问
    	for(i = 0; i < vertexNum;i++){
    		visited[i] = false;
    	}
    	DFS(0);
    }
    /** 
     * 从顶点v出发深度优先遍历的递归算法 
     * @param v 顶点v 
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
     * 深度优先遍历的迭代算法 ---利用栈去维护深度
     * @param v 起始顶点v 
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
                		s.push(k);//没被访问过且栈中不存在，压栈  
                	}
                }
                k=getNextNeighbor(w, k);  
            }  
        }  
    }  
    
    /** 
     * 广度优先遍历的迭代算法--使用队列维护，具体思路同邻接矩阵的BFS类似 
     * @param v 起始顶点v 
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
