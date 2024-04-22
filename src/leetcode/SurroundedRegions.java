package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        char[][] visited = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                visited[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    List<List<Integer>> modify = new ArrayList<>();
                    dfs(board, i, j, modify, visited);
                    List<List<Integer>> check = modify.stream().filter((list) -> {
                        if (list.get(0) == 0 || list.get(0) == board.length -1 || list.get(1) == 0 || list.get(1) == board[list.get(0)].length -1) {
                            return false;
                        } else {
                            return true;
                        }
                    }).toList();
                    System.out.println("check-------");
                    check.forEach((list) ->{
                        System.out.println(list.get(0));
                        System.out.println(list.get(1));
                        });
                    System.out.println(check.size());
                    System.out.println("check-------");
                    if (check.size() == 0) {
                        modify.forEach((list) ->{
                            System.out.println("-------");
                            System.out.println(list.get(0));
                            System.out.println(list.get(1));
                            board[list.get(0)][list.get(1)] = 'X';
                            System.out.println("-------");});
                    }



                }

            }
        }


    }
    public void dfs(char[][] board, int i, int j, List<List<Integer>> modify, char[][] visited) {
        if (i <0 || j<0 || i>= board.length || j >= board[i].length || visited[i][j] == 'X') {
            return;
        }

        modify.add(List.of(i,j));
        visited[i][j] = 'X';

        dfs(board, i+ 1, j, modify, visited);
        dfs(board, i- 1, j, modify, visited);
        dfs(board, i, j+1, modify, visited);
        dfs(board, i, j -1, modify, visited);
    }
}
