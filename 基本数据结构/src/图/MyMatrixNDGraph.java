package 图;

import java.util.ArrayList;

import myqueue.MyQueue;

/**
 * 无向图邻接矩阵实现
 * @author Joern
 *
 */

public class MyMatrixNDGraph {
	private int numEdges; //边数
	
	private ArrayList<Integer> vexs; //顶点表
	private int[][] edges; //邻接矩阵 可以看成边表
	
	private Boolean[] visited; //深度遍历以访问标志
	
	/**
	 * 
	 * @param n:邻接矩阵最大容量
	 */
	public MyMatrixNDGraph(int n){
		vexs = new ArrayList<>(n);
		edges = new int[n][n];
		visited = new Boolean[n];
		numEdges = 0;		
	}
	
	//得到节点的个数
	public int getNumOfVertexes(){
		return vexs.size();
	}
	
	//得到边的数目
	public int getNumOfEdges(){
		return numEdges;
	}
	
	//返回节点i的数据
	public Integer getValueByIndex(int index){
		if(index <= vexs.size()){
			return vexs.get(index);
		}else{
			System.out.println("请输入存在的节点");
			return -1;
		}
	}
	
	//返回v1，v2的权值
	public int getEdgeWeight(int v1,int v2){
		if(v1<=edges.length && v2<=edges.length){
			return edges[v1][v2];	
		}else{
			System.out.println("请输入存在的节点");
			return -1;
		}
		
	}
	
	//插入节点
	public void insertVertex(Integer vertex){
		if(vexs.size() < edges.length){
			vexs.add(vertex);
		}else{
			System.out.println("已经超过初始化节点上限");
		}
		
	}
	
	//插入边
	public void insertEdge(int v1,int v2,int weight){
		if(edges[v1][v2] == 0){
			edges[v1][v2] = weight;
			//因为是无向图，邻接矩阵对称
			edges[v2][v1] = weight;
			numEdges++;
		}else{
			System.out.println("该边已经存在");
		}
	}
	
	//修改边
	public void changeEdge(int v1,int v2,int weight){
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
	}
	
	//删除边
	public void deleteEdge(int v1,int v2){
		edges[v1][v2] = 0;
		numEdges--;
	}
	
	//得到第一个邻接节点的下标
	public int getFirstNeighbour(int index){
		for(int i = 0;i < vexs.size();i++){
			if(edges[index][i] > 0){
				return i;
			}
		}
		return -1;
	}
	
	 //根据前一个邻接结点的下标来取得下一个邻接结点
    public int getNextNeighbor(int index,int v1) {
        for (int j=v1+1;j<vexs.size();j++) {
            if (edges[index][j]>0) {
                return j;
            }
        }
        return -1;
    }
	
	//深度遍历DFS
    public void DFSTraverse(){
    	int i;
    	//初始化未访问
    	for(i = 0; i < vexs.size();i++){
    		visited[i] = false;
    	}
    	for(i = 0; i < vexs.size();i++){
    		if(!visited[i]){
    			//对于未访问的节点进行深度遍历，一般这个只会执行一次，除非是非连通图
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
	 * 广度优先遍历BFS
	 * 利用了栈的数据结构-可以用我的也可以用系统的Queue
	 */
    public void BFSTraverse(){
    	int i,j;
    	MyQueue<Integer> queue;
    	//初始化未访问
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
