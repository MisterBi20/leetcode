package day35;

import java.util.HashSet;
import java.util.Set;

public class Ex202 {
    public static void main(String[] args) {
        Ex202 ex202 = new Ex202();
        System.out.println(ex202.isHappy(19));
    }

    //    使用set来记录已经出现过的数字，
//    如果出现了重复的数字，说明进入了循环，不是快乐数。
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNumber(n);
        }
        return n == 1;
    }

    private int getNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }
}
