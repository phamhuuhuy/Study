package leetcode;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nums = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                nums++;
                dfsCheckIsland(grid, i,j);
            }
        }
        return nums;
    }

    public void dfsCheckIsland(char[][] grid,int i, int j) {
        if (i <0 || j<0 || i>= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfsCheckIsland(grid, i+ 1, j);
        dfsCheckIsland(grid, i- 1, j);
        dfsCheckIsland(grid, i, j+1);
        dfsCheckIsland(grid, i, j -1);
    }
}
