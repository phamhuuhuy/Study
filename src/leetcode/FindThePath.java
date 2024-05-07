package leetcode;

public class FindThePath {
    public boolean findThePath(int[][] grid, int n) {
        if (grid == null || grid.length == 0) {
            return true;
        }
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return dfsCheckIsland(grid, i, j, visited);
                }
            }
        }
        return false;
    }

    public boolean dfsCheckIsland(int[][] grid,int i, int j, boolean[][] visited) {

        if (i <0 || j<0 || i>= grid.length || j >= grid[i].length || grid[i][j] == 0 || visited[i][j]) {
            return false;
        }
        if (grid[i][j] == 2)
            return true;
        visited[i][j] = true;
        boolean down = dfsCheckIsland(grid, i + 1, j, visited);
        boolean up = dfsCheckIsland(grid, i - 1, j, visited);
        boolean right = dfsCheckIsland(grid, i, j + 1, visited);
        boolean left = dfsCheckIsland(grid, i, j - 1, visited);

        return down || up || right || left;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 3, 0, 1 },
                { 3, 0, 3, 3 },
                { 2, 3, 3, 3 },
                { 0, 3, 3, 3 } };

        // calling isPath method
        FindThePath findThePath = new FindThePath();
        System.out.println(findThePath.findThePath(matrix, 4));
    }
}

