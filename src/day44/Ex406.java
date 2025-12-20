package day44;

/*假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。*/

import java.util.Arrays;
import java.util.LinkedList;

public class Ex406 {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Ex406 ex406 = new Ex406();
        int[][] reconstructQueue = ex406.reconstructQueue(people);
        for (int[] p : reconstructQueue) {
            System.out.println(Arrays.toString(p));
        }
    }

    //    先按身高排序，身高相同按k值排序，身高降序，k升序，
//    然后按k值插入队列，因为身高降序，所以插入时，前面的人都比当前人高，
//    所以插入时，只需要插入到k值对应的位置即可。
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            que.add(p[1], p);
        }
        return que.toArray(new int[people.length][]);
    }
}
