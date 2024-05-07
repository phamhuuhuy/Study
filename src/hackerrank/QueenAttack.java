package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueenAttack {
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        int result = 0;
        int[] direction = new int[8];
        direction[0] = n - r_q;
        direction[2] = n - c_q;
        direction[4] = r_q - 1;
        direction[6] = c_q - 1;

        direction[1] = Math.min(direction[0], direction[2]);
        direction[3] = Math.min(direction[2], direction[4]);
        direction[5] = Math.min(direction[4], direction[6]);
        direction[7] = Math.min(direction[6], direction[0]);
        int distance = 0;

        for (List<Integer> obstacle : obstacles) {
            int row = obstacle.get(0);
            int col = obstacle.get(1);

            if (row == r_q) {
                distance = Math.abs(col - c_q) - 1;
                if (col > c_q && distance < direction[2]) {
                    direction[2] = distance;
                }else if (col < c_q && distance < direction[6]) {
                    direction[6] = distance;
                }
            } else if(col == c_q) {
                distance = Math.abs(row - r_q) - 1;
                if (row > r_q && distance < direction[0]) {
                    direction[0] = distance;
                }else if (row < r_q && distance < direction[4]) {
                    direction[4] = distance;
                }
            } else if (Math.abs(row - r_q) == Math.abs(col - c_q)) {
                distance = Math.abs(row - r_q) - 1;
                if(col < c_q){
                    if(row < r_q && distance < direction[3])
                        direction[3] = distance;
                    else if(row > r_q && distance < direction[7])
                        direction[7] = distance;
                }
                else{
                    if(row < r_q && distance < direction[5])
                        direction[5] = distance;
                    else if(row > r_q && distance < direction[1])
                        direction[1] = distance;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            result += direction[i];
        }



        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> ob = new ArrayList<>();
        List<Integer> integers1 = new ArrayList<>(Arrays.asList(4,2));
        List<Integer> integers2 = new ArrayList<>(Arrays.asList(2,3));
        ob.add(integers1);
        ob.add(integers2);
        System.out.println(queensAttack(5,4, 4,3, ob));
    }
}
