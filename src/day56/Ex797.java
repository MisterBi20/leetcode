package day56;

/*给你一个有 n 个节点的 有向无环图（DAG），请你找出从节点 0 到节点 n-1 的所有路径并输出（不要求按特定顺序）
graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。*/

import java.util.ArrayList;
import java.util.List;

public class Ex797 {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        Ex797 ex797 = new Ex797();
        List<List<Integer>> paths = ex797.allPathsSourceTarget(graph);
        System.out.println(paths);
    }

    //    深度优先搜索，从节点0开始，遍历所有路径，当遍历到节点n-1时，将路径加入ans中，否则遍历所有邻接节点，
//    并将邻接节点加入路径中，递归遍历，遍历完成后，将邻接节点从路径中移除。
    List<List<Integer>> ans;
    List<Integer> cnt;

    public void dfs(int[][] graph, int node) {
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(cnt));
            return;
        }
        for (int index = 0; index < graph[node].length; index++) {
            int nextNode = graph[node][index];
            cnt.add(nextNode);
            dfs(graph, nextNode);
            cnt.remove(cnt.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        cnt = new ArrayList<>();
        cnt.add(0);
        dfs(graph, 0);
        return ans;
    }
}
