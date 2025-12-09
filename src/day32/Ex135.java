package day32;

/*n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
        你需要按照以下要求，给这些孩子分发糖果：
        每个孩子至少分配到 1 个糖果。
        相邻两个孩子中，评分更高的那个会获得更多的糖果。
        请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。*/

public class Ex135 {
    public static void main(String[] args) {
        int[] ratings = {1, 2, 2};
        Ex135 ex135 = new Ex135();
        System.out.println(ex135.candy(ratings));
    }

    //    两次遍历，一次从左到右，一次从右到左，
//    从左到右遍历，保证右边评分高的孩子获得更多的糖果，
//    从右到左遍历，保证左边评分高的孩子获得更多的糖果，
//    最后取两次遍历的最大值。
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candyVec = new int[len];
        candyVec[0] = 1;
        for (int i = 1; i < len; i++) {
            candyVec[i] = (ratings[i] > ratings[i - 1] ? candyVec[i - 1] + 1 : 1);
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }
        int res = 0;
        for (int num : candyVec) {
            res += num;
        }
        return res;
    }
}
