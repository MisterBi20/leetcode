package day55;

/*有 n 个网络节点，标记为 1到 n。
        给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i]=(ui,vi,wi)，
        其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
        现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。*/

import java.util.*;

public class Ex743 {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        Ex743 ex743 = new Ex743();
        int res = ex743.networkDelayTime(times, n, k);
        System.out.println(res);
    }

    //    dijkstra算法,有向边，单源最短路，定义边类，节点状态类，
//    定义图类，图类中存储的是每个节点的出边，每个出边是一个边类，边类中存储的是目标节点和权重。
    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class NodeState {
        int node;
        int distance;

        NodeState(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new Edge(v, w));
        }
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<NodeState> pq = new PriorityQueue<>(Comparator.comparing(a -> a.distance));
        dist[k] = 0;
        pq.offer(new NodeState(k, 0));
        while (!pq.isEmpty()) {
            NodeState cur = pq.poll();
            int u = cur.node;
            if (visited[u]) continue;
            visited[u] = true;
            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int w = edge.weight;
                if (!visited[v] && dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new NodeState(v, dist[v]));
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
