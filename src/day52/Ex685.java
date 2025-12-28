package day52;

/*在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。
该树除了根节点之外的每一个节点都有且只有一个父节点，而根节点没有父节点。
输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。
附加的边包含在 1 到 n 中的两个不同顶点间，这条附加的边不属于树中已存在的边。
结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 vi 的一个父节点。
返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。*/

import java.util.ArrayList;

public class Ex685 {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        Ex685 ex685 = new Ex685();
        int[] removeEdge = ex685.findRedundantDirectedConnection(edges);
        System.out.println(removeEdge[0] + " " + removeEdge[1]);
    }
//    并查集，判断是否有环，有环则返回构成环的边，否则返回null，
//    并查集里寻根的过程
    private static final int N = 1010;  // 如题：二维数组大小的在3到1000范围内
    private int[] father;
    public Ex685() {
        father = new int[N];

        // 并查集初始化
        for (int i = 0; i < N; ++i) {
            father[i] = i;
        }
    }

    private int find(int u) {
        if(u == father[u]) {
            return u;
        }
        father[u] = find(father[u]);
        return father[u];
    }

    private void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return ;
        father[v] = u;
    }
    private Boolean same(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    private void initFather() {
        // 并查集初始化
        for (int i = 0; i < N; ++i) {
            father[i] = i;
        }
    }

    private int[] getRemoveEdge(int[][] edges) {
        initFather();
        for(int i = 0; i < edges.length; i++) {
            if(same(edges[i][0], edges[i][1])) { // 构成有向环了，就是要删除的边
                return edges[i];
            }
            join(edges[i][0], edges[i][1]);
        }
        return null;
    }

    private Boolean isTreeAfterRemoveEdge(int[][] edges, int deleteEdge)
    {
        initFather();
        for(int i = 0; i < edges.length; i++)
        {
            if(i == deleteEdge) continue;
            if(same(edges[i][0], edges[i][1])) { // 构成有向环了，一定不是树
                return false;
            }
            join(edges[i][0], edges[i][1]);
        }
        return true;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] inDegree = new int[N];
        for(int i = 0; i < edges.length; i++)
        {
            // 入度
            inDegree[ edges[i][1] ] += 1;
        }

        // 找入度为2的节点所对应的边，注意要倒序，因为优先返回最后出现在二维数组中的答案
        ArrayList<Integer> twoDegree = new ArrayList<Integer>();
        for(int i = edges.length - 1; i >= 0; i--)
        {
            if(inDegree[edges[i][1]] == 2) {
                twoDegree.add(i);
            }
        }

        // 处理图中情况1 和 情况2
        // 如果有入度为2的节点，那么一定是两条边里删一个，看删哪个可以构成树
        if(!twoDegree.isEmpty())
        {
            if(isTreeAfterRemoveEdge(edges, twoDegree.get(0))) {
                return edges[ twoDegree.get(0)];
            }
            return edges[ twoDegree.get(1)];
        }

        // 明确没有入度为2的情况，那么一定有有向环，找到构成环的边返回就可以了
        return getRemoveEdge(edges);
    }
}
