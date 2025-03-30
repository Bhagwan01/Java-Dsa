package recursion;

public class N_Queens {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board =new boolean[n][n];
        System.out.println(queen(board,0));
    }

    static int queen(boolean[][] board, int r) {
        if (r == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for(int c=0;c<board.length;c++){
            if(isSafe(board,r,c)){
                board[r][c]=true;
                count+=queen(board,r+1);
                board[r][c]=false;
            }
        }
        return count;

    }
    static boolean isSafe(boolean[][] board,int r,int c){
        // for vertical columns
        for(int i=0;i<r;i++){
            if(board[i][c]){
                return false;
            }
        }
        // for left diagonal
        int maxleft=Math.min(r,c);
        for (int i=1;i<=maxleft;i++){
            if(board[r-i][c-i]){
                return false;
            }
        }
        // for right diagonal
        int maxright=Math.min(r,board.length-c-1);
        for(int i=1;i<=maxright;i++){
            if(board[r-i][c+i]){
                return false;
            }
        }
        return true;


    }
    static void display(boolean[][] board){
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if (board[i][j]) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    }


