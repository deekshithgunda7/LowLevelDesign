import java.util.*;

class Solution {

       List<String> result = new ArrayList<>();

       private void path(int[][] m , String dir , int x ,int y ,int n){
             
             if(x == n-1 && y == n-1){
                result.add(dir);
                return;
             }

             if(m[x][y] == 0) return;
             
             // make that particaular co-ordinate as visisted
             m[x][y]=0;

             if(x>0) path(m,dir+'U',x-1,y,n);
             if(y>0) path(m,dir+'L',x,y-1,n);
             if(x<n-1) path(m,dir+'D',x+1,y,n);
             if(y<n-1) path(m,dir+'R',x,y+1,n);

             m[x][y]=1;

       }
       public List<String> findPath(int[][] grid) {

          int n = grid.length;

          result.clear();
          
          if(grid[0][0] == 0|| grid[n-1][n-1] == 0) return result;

          path(grid,"",0,0,n);
          Collections.sort(result);
          return result;
       

      }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {
            {1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {0, 1, 0, 0, 1},
            {0, 1, 1, 1, 1},
            {0, 0, 0, 0, 1}
        };

        List<String> paths = sol.findPath(grid);

        for (String path : paths) {
            System.out.println(path);
        }
    }
}
