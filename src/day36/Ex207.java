package day36;

/*你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。*/

import java.util.*;

public class Ex207 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        Ex207 ex207 = new Ex207();
        System.out.println(ex207.canFinish(numCourses, prerequisites));

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];//入度数组 + 邻接表
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
            List<Integer> nextCourses = graph.get(cur);
            if (nextCourses != null) {
                for (Integer next : nextCourses) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
