package day61;

/*有一个具有 n 个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，
其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
请你确定是否存在从顶点 source 开始，到顶点 destination 结束的 有效路径 。
给你数组 edges 和整数 n、source 和 destination，如果从 source 到 destination 存在 有效路径 ，则返回 true，否则返回 false 。*/

public class Ex1971 {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int destination = 2;
        Ex1971 ex1971 = new Ex1971();
        boolean res = ex1971.validPath(n, edges, source, destination);
        System.out.println(res);
    }

    //定义并查集，用于判断两个节点是否在同一个集合中，
// 如果在同一个集合中，说明存在有效路径。
    int[] father;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        father = new int[n];
        init();
        for (int i = 0; i < edges.length; i++) {
            join(edges[i][0], edges[i][1]);
        }
        return isSame(source, destination);
    }

    public void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    public int find(int u) {
        if (u == father[u]) return u;
        else {
            father[u] = find(father[u]);
            return father[u];
        }
    }

    public boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    public void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[v] = u;
    }
}
