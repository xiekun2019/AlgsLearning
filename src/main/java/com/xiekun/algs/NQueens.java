package com.xiekun.algs;
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        backTrack(board, 0);
        return res;
    }

    void backTrack(String[][] board, int row){
        if(row == board.length){
            res.add(twoDArrayToList(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if(!isValid(board, row, col))
                continue;
            board[row][col] = "Q";
            backTrack(board, row + 1);
            board[row][col] = ".";
        }
    }

    private boolean isValid(String[][] board, int row, int col) {
        int n = board.length;
        // 检查列有没有冲突
        for (int i = 0; i < n; i++) {
            if(board[i][col] == "Q"){
                return false;
            }
        }
        // 检查右上角是否有冲突
        for (int i = row-1, j = col + 1; i >=0 && j<=n-1 ; i--, j++) {
            if(board[i][j] == "Q"){
                return false;
            }
        }

        // 检查左上角是否有冲突
        for (int i = row-1, j = col - 1; i >=0 && j >= 0 ; i--, j--) {
            if(board[i][j] == "Q"){
                return false;
            }
        }
        return true;
    }

    public List<String> twoDArrayToList(String[][] twoDArray) {
        ArrayList<String> list = new ArrayList<>();
        for (String[] ts : twoDArray) {
            String str = join(ts);
            list.add(str);
        }
        return list;
    }

    public String join(String[] strings){
        String res = "";
        for (String string : strings) {
            res += string;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
//        String[][] test = {{"Q", ".", "."}, {".","Q","."}, {".","Q","."}};
//        System.out.println(new NQueens().twoDArrayToList(test));
    }
}
