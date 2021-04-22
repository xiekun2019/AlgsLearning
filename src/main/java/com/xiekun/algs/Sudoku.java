package com.xiekun.algs;

public class Sudoku {
    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }

    public boolean backTrack(char[][] board, int row, int column){
        if(column == 9) {
            // 穷举到最后一列的话就换到下一行重新开始。
            return backTrack(board, row + 1, 0);
        }
        if(row == 9) {
            // 找到一个可行解，触发 base case
            return true;
        }
        for (int i = row; i < 9; i++) {
            for (int j = column; j < 9; j++) {

                if (board[i][j] != '.') {
                    // 如果有预设数字，不用我们穷举
                    return backTrack(board, i, j + 1);
                }

                for (char k='1'; k<='9'; k++) {
                    if(isValid(board, row, column, k)) {
                        board[i][j] = k;
                        if(backTrack(board, row, column + 1)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 穷举完 1~9，依然没有找到可行解，此路不通
                return false;
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int column, char k) {
        for (int i = 0; i < 9; i++) {
            // 检查列是否存在重复
            if(board[i][column] == k) return false;
            // 检查行是否存在重复
            if(board[row][i] == k) return false;
        }
        // 判断 3 x 3 方框是否存在重复
        // 确定 粗实线分隔 方框的起始位置
        int _row = (row / 3) * 3;
        int _column = (column / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[_row+i][_column+j] == k) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
