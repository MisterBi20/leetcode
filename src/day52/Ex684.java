package day52;

/*树可以看成是一个连通且 无环 的 无向 图。
给定一个图，该图从一棵 n 个节点 (节点值 1～n) 的树中添加一条边后获得。添加的边的两个不同顶点编号在 1 到 n 中间，
且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的那个。*/

public class Ex684 {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        Ex684 ex684 = new Ex684();
        int[] ints = ex684.findRedundantConnection(edges);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

//    并查集，判断是否有环，有环则返回true，否则返回false，
//    并查集的基本操作有：初始化、查找、合并，
//    初始化时，每个节点的父节点都是自己，
//    查找时，递归查找节点的父节点，直到找到根节点，
//    合并时，将一个节点的根节点的父节点设置为另一个节点的根节点，
//    判断是否有环时，遍历所有边，
//    如果边的两个节点的根节点相同，说明有环，
//    否则，合并这两个节点的根节点。
    private int n;
    private int[] father;

    public Ex684() {
        n = 1005;
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    private int find(int u) {
        if (u == father[u]) return u;
        father[u] = find(father[u]);
        return father[u];
    }

    private void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[v] = u;
    }

    private Boolean same(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            if (same(edges[i][0], edges[i][1])) return edges[i];
            else join(edges[i][0], edges[i][1]);
        }
        return null;
    }
}
