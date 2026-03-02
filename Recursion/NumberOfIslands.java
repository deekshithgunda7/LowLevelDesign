class Solution {
    public void isIsland(char[][] grid,int i ,int j){

        // DFS

        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length) return;

        if(grid[i][j] != '1') return;

        
            grid[i][j]=0;

            isIsland(grid,i+1,j) ;
            isIsland(grid,i-1,j);  
            isIsland(grid,i,j+1); 
            isIsland(grid,i,j-1); 
            isIsland(grid,i+1,j+1);
            isIsland(grid,i-1,j-1); 
            isIsland(grid,i+1,j-1);
            isIsland(grid,i-1,j+1);
     
        
    }
    public int numIslands(char[][] grid) {
       int count = 0;

       for(int i=0;i<grid.length;i++){
        for(int j=0 ;j<grid[0].length;j++){
            if(grid[i][j] == '1'){
                count++;
                isIsland(grid,i,j);
            }
        }
       }
       return count;
    }
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '1', '0', '1'},
            {'1', '0', '0', '0', '0'},
            {'1', '1', '1', '0', '1'},
            {'0', '0', '0', '1', '1'}
        };
        
        // Creating an instance of Solution class
        Solution sol = new Solution();
        
        /* Function call to find the
        number of islands in given grid */
        int ans = sol.numIslands(grid);
        
        System.out.println("The total islands in given grids are: " + ans);
    }
}

