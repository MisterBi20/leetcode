package day61;

/*有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。*/

public class Ex1791 {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        Ex1791 ex1791 = new Ex1791();
        int center = ex1791.findCenter(edges);
        System.out.println(center);
    }

    //    统计每个节点的度，度为 n-1 的节点就是中心节点。
    public int findCenter(int[][] edges) {
        int[] du = new int[edges.length + 2];
        for (int i = 0; i < edges.length; i++) {
            du[edges[i][0]]++;
            du[edges[i][1]]++;
            if (du[edges[i][0]] > 1) return edges[i][0];
            if (du[edges[i][1]] > 1) return edges[i][1];
        }
        return -1;
    }
}
