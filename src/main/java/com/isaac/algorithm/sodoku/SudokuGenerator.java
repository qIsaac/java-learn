package com.isaac.algorithm.sodoku;

import java.util.Random;
import java.util.Scanner;

public class SudokuGenerator {

    public static void main(String[] args) {
        // 输入剩余数字数
        Scanner input = new Scanner(System.in);
        System.out.print("输入需要填写多少个单元格(1 - 30): ");
        int level = input.nextInt();
        while (level < 1 || level > 30) {
            System.out.print("Enter the level(1 - 30): ");
            level = input.nextInt();
        }
        int holes = 81 - level;
        int[][] sudokuBoard = generateSudoku(holes); // 生成一个有30个空单元格的数独谜题
        printSudoku(sudokuBoard);
        solveSudoku(sudokuBoard, new Random());
        System.out.println("Sudoku Solution:");
        printSudoku(sudokuBoard);
    }

    public static int[][] generateSudoku(int holes) {
        int[][] board = new int[9][9];
        fillSudoku(board); // 填充一个完整的数独棋盘
        generateSudokuPuzzle(board, holes); // 挖洞生成数独谜题
        return board;
    }

    public static void fillSudoku(int[][] board) {
        Random random = new Random();
        solveSudoku(board, random);
    }

    public static void generateSudokuPuzzle(int[][] board, int holes) {
        Random random = new Random();
        int holesToDig = 81 - holes;

        while (holesToDig > 0) {
            int row, col;
            do {
                row = random.nextInt(9);
                col = random.nextInt(9);
            } while (board[row][col] == 0); // 确保没有重复挖洞

            int temp = board[row][col];
            board[row][col] = 0;

            // 检查挖洞后的谜题是否有唯一解，如果不是，恢复原数字
            int[][] tempBoard = new int[9][9];
            for (int i = 0; i < 9; i++) {
                System.arraycopy(board[i], 0, tempBoard[i], 0, 9);
            }
            if (!solveSudoku(tempBoard, random)) {
                board[row][col] = temp;
                holesToDig++;
            }

            holesToDig--;
        }
    }

    public static void printSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solveSudoku(int[][] board, Random random) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                    shuffleArray(numbers, random);

                    for (int num : numbers) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;

                            if (solveSudoku(board, random)) {
                                return true;
                            }

                            board[row][col] = 0;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        return !usedInRow(board, row, num) && !usedInColumn(board, col, num) && !usedInBox(board, row - row % 3, col - col % 3, num);
    }

    public static boolean usedInRow(int[][] board, int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean usedInColumn(int[][] board, int col, int num) {
        for (int row = 0; row < 9; row++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean usedInBox(int[][] board, int boxStartRow, int boxStartCol, int num) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row + boxStartRow][col + boxStartCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void shuffleArray(int[] arr, Random random) {
        for (int i = arr.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
