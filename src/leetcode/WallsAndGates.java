package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    private int maxValue = 2147483647;

    public static void wallAndGate(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        Queue<Pair> queue = new LinkedList<>();

        for(int i= 0; i< rooms.length; i++){
            for(int j =0; j< rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new Pair(i,j));
                }
            }
        }

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            for(int[] d : dir){
                int x = p.x + d[0];
                int y = p.y + d[1];
                if(x <0 || x >= rooms.length || y <0 || y>= rooms[0].length
                        || rooms[x][y] <= rooms[p.x][p.y] + 1)
                    continue;
                rooms[x][y] = rooms[p.x][p.y] + 1;
                queue.offer(new Pair(x,y));
            }
        }
    }
}
class Pair{
    int x;
    int y;
    Pair(int _x, int _y){
        x = _x;
        y = _y;
    }
};
