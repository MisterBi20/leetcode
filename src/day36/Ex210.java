package day36;

/*现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。*/

import java.util.*;

public class Ex210 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        Ex210 ex210 = new Ex210();
        System.out.println(Arrays.toString(ex210.findOrder(numCourses, prerequisites)));
    }

    //    拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];//入度数组 + 邻接表
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {//读 prerequisites，建图
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            inDegree[to]++;
            if (!graph.containsKey(from))
                graph.put(from, new ArrayList<>());
            graph.get(from).add(to);
        }
        Queue<Integer> queue = new LinkedList<>();//把入度为 0 的课放进队列
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        int count = 0;//开始拓扑排序
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            result.add(cur);
            if (graph.containsKey(cur)) {
                List<Integer> courses = graph.get(cur);
                for (Integer next : courses) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        if (count == numCourses) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i] = result.get(i);
            }
            return ans;
        } else {
            return new int[0];
        }
    }
}
