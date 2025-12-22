package day45;

/*
假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是满足尽可能多的孩子，并输出这个最大数值。
*/

import java.util.Arrays;

public class Ex455 {
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        Ex455 ex455 = new Ex455();
        int contentChildren = ex455.findContentChildren(g, s);
        System.out.println(contentChildren);
    }

    //    先排序，然后用双指针，一个指向胃口值，一个指向饼干尺寸，
    //    如果饼干尺寸大于等于胃口值，那么就满足了这个孩子，
    //    然后指针都向后移动，否则只移动饼干尺寸指针，
    //    最后返回满足的孩子数量。
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0, count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }
        return count;
    }
}
