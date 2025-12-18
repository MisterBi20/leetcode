package day41;

/*给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
        所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
        例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
        假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。*/

import java.util.*;

public class Ex332 {
    public static void main(String[] args) {
        List<List<String>> tickets = new LinkedList<>();
        tickets.add(List.of("MUC", "LHR"));
        tickets.add(List.of("JFK", "MUC"));
        tickets.add(List.of("SFO", "SJC"));
        tickets.add(List.of("LHR", "SFO"));
        tickets.add(List.of("JFK", "LHR"));
        Ex332 ex332 = new Ex332();
        System.out.println(ex332.findItinerary(tickets));
    }

    //    Hierholzer算法,从JFK开始,每次选择字典序最小的机场,直到所有的机票都被使用,
//    或者当前机场没有下一个机场可以到达,则回溯到上一个机场,继续遍历下一个机场,使用优先队列存储下一个机场，
//    直到所有的机场都被遍历过一次,则回溯到JFK,将所有的机场添加到行程中,行程即为字典序最小的行程组合。
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> itinerary = new LinkedList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String curr) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        itinerary.add(curr);
    }
}
