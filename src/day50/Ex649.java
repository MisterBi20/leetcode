package day50;

/*Dota2 的世界里有两个阵营：Radiant（天辉）和 Dire（夜魇）
Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。
他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的 一 项：
剥夺一名参议员的权利：一名参议员可以使另一名参议员在本轮及所有后续轮次中失去所有权利。
宣布胜利：如果参议员发现有权利投票的参议员都是 同一个阵营的 ，他可以宣布胜利并决定在游戏中的有关变化。
给你一个字符串 senate 代表每个参议员的阵营。字母 'R' 和 'D'分别代表了 Radiant（天辉）和 Dire（夜魇）。
然后，如果有 n 个参议员，给定字符串的大小将是 n。
以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。
所有失去权利的参议员将在过程中被跳过。
假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。
输出应该是 "Radiant" 或 "Dire" 。*/

public class Ex649 {
    public static void main(String[] args) {
        String senate = "RD";
        Ex649 ex649 = new Ex649();
        String s = ex649.predictPartyVictory(senate);
        System.out.println(s);
    }

    //    循环遍历字符串senate，用flag记录当前轮次的投票结果，
//    如果flag<0，说明当前轮次 Radiant 阵营的参议员多，
//    所以当前轮次 Radiant 阵营的参议员可以剥夺 Dire 阵营的参议员的权利，
//    所以将 Dire 阵营的参议员的投票结果设置为0，
//    否则 Dire 阵营的参议员可以剥夺 Radiant 阵营的参议员的权利，
//    所以将 Radiant 阵营的参议员的投票结果设置为0，
//    最后判断flag是否大于0，大于0说明 Radiant 阵营的参议员多，
//    所以 Radiant 阵营的参议员可以宣布胜利，
//    否则 Dire 阵营的参议员可以宣布胜利。
    public String predictPartyVictory(String senate) {
        Boolean R = true, D = true;
        int flag = 0;
        byte[] bytes = senate.getBytes();
        while (R && D) {
            R = false;
            D = false;
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] == 'R') {
                    if (flag < 0) bytes[i] = 0;
                    else R = true;
                    flag++;
                }
                if (bytes[i] == 'D') {
                    if (flag > 0) bytes[i] = 0;
                    else D = true;
                    flag--;
                }
            }
        }
        return R ? "Radiant" : "Dire";
    }
}
