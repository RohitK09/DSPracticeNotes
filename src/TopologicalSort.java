import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TopologicalSort {

    public List<Integer> findOrder(int nodes, int[][] edges) {
        //indegreeNodes each node hase how many incoming nodes. 
        int[] inDegreeNodes = new int[nodes];
        List<Integer> results = new ArrayList<>();
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        //create Adj List
        for (int[] edge: edges) {
            int dest = edge[0];
            int src = edge[1];
            Set<Integer> connection = adjList.getOrDefault(src,new HashSet<>());
            connection.add(dest);
            adjList.put(src, connection);
            inDegreeNodes[dest]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i =0; i< inDegreeNodes.length; i++ ) {
            System.out.println(i +"-"+inDegreeNodes[i]);
            if(inDegreeNodes[i] == 0 ) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
         int curr = q.poll();
         results.add(curr);
         Set<Integer> neighbours = adjList.get(curr);
         if(neighbours!=null) {
            for (int neighbour: neighbours) {
                inDegreeNodes[neighbour] =  inDegreeNodes[neighbour] -1;
                if(inDegreeNodes[neighbour]==0) {
                    q.offer(neighbour);
                }
            }
         }
       
    }
        return results;
    }
    public static void main(String[] args) {
       int[][] edges = new int[][] {{1,0},{2,0},{3,1},{3,2}};
       TopologicalSort tp = new TopologicalSort();
       
       System.out.println(tp.findOrder(4, edges).toString());
    }
}
