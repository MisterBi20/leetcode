package day56;

/*有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。
你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
当你进入一个房间，你可能会在里面找到一套 不同的钥匙，每把钥匙上都有对应的房间号，
即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。
如果能进入 所有 房间返回 true，否则返回 false。*/

import java.util.ArrayList;
import java.util.List;

public class Ex841 {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>() {
            {
                add(List.of(1));
                add(List.of(2));
                add(List.of(3));
                add(List.of());
            }
        };
        Ex841 ex841 = new Ex841();
        System.out.println(ex841.canVisitAllRooms(rooms));
    }

    //    深度优先搜索，从0号房间开始，遍历所有房间，
//    如果房间没有被访问过，就标记为已访问，
//    并遍历房间中的所有钥匙，递归访问对应的房间。
    private void dfs(int key, List<List<Integer>> room, List<Boolean> visited) {
        if (visited.get(key)) return;
        visited.set(key, true);
        for (Integer k : room.get(key)) {
            dfs(k, room, visited);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Boolean> visited = new ArrayList<>() {
            {
                for (int i = 0; i < rooms.size(); i++) {
                    add(false);
                }
            }
        };
        dfs(0, rooms, visited);
        for (Boolean flag : visited) {
            if (!flag) return false;
        }
        return true;
    }
}
