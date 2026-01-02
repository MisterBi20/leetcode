package day57;

/*在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
注意，一开始你手头没有任何零钱。
给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。*/

public class Ex860 {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        Ex860 ex860 = new Ex860();
        System.out.println(ex860.lemonadeChange(bills));
    }

    //    遍历数组，模拟顾客购买柠檬水的过程，根据顾客付的账，判断是否能正确找零。
//    如果顾客付的账是5美元，直接收下。
//    如果顾客付的账是10美元，找零5美元。
//    如果顾客付的账是20美元，找零10美元和5美元，或者3个5美元。
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {
                five--;
                ten++;
            } else if (bill == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else five -= 3;
            }
            if (five < 0 || ten < 0) return false;
        }
        return true;
    }
}
