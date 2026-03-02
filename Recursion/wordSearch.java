class Solution {
    public boolean dfs(char[][] board,int i ,int j , int index , String word){

        if(word.length() == index) return true;
        
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j]='#';

        boolean  found =  dfs(board,i+1,j,index+1,word) || dfs(board,i,j+1,index+1,word) || dfs(board,i-1,j,index+1,word) || dfs(board,i,j-1,index+1,word);

        board[i][j]= temp;

        return found;
    }
    public boolean exist(char[][] board, String word) {
        //your code goes here
         
         for(int  i =0 ; i <  board.length ; i++){
            for(int j=0 ; j < board[0].length ;j++){
            if(board[i][j] == word.charAt(0)){
                if(dfs(board,i,j,0,word)) return true;
              }        
            }
         }
         return false;
    }
     public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";

        if (solution.exist(board, word)) {
            System.out.println("Word found!");
        } else {
            System.out.println("Word not found!");
        }
    }
}