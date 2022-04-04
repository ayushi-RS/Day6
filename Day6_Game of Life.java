class Solution {
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
      
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //count of aliver neighbours
                int cnt = 0;
               
                if(i>0){
                    if(board[i-1][j]%2 != 0){
                        cnt++;
                    }
                    if(j>0 && board[i-1][j-1]%2 != 0){
                        cnt++;
                    }
                    if(j+1<n && board[i-1][j+1]%2 != 0){
                        cnt++;
                    }
                }
                if(i+1 < m){
                    if(board[i+1][j]%2 != 0){
                        cnt++;
                    }
                    if(j>0 && board[i+1][j-1]%2 != 0){
                        cnt++;
                    }
                    if(j+1<n && board[i+1][j+1]%2 != 0){
                        cnt++;
                    }
                }
                if(j>0 && board[i][j-1]%2 != 0){
                    cnt++;
                }
                if(j+1 < n && board[i][j+1]%2 != 0){
                    cnt++;
                }
                //under or over population
                if(cnt < 2 || cnt > 3){
                    if(board[i][j] == 1){
                        board[i][j] = 3;
                    }
                }
                //perfect neigbours
                else if(cnt == 3){
                    if(board[i][j] == 0){
                        board[i][j] = 2;
                    }
                }
            }
        }
		//resetting back dead & alive cells to original values
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
    }
}