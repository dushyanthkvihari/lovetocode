package com.vihari.ds.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *The idea behind solving this is for each row place find a safe position for the queen
 * Safe position implies chosen queen is not in same column or row or diagonal as other queens
 *
 * Step1
 * Choose a position for queen based on its safe or not
 * Next increment to next row and repeat the steps .
 * If no suitable position is found for next queen just back track and choose new position to current queen
 *
 */
public class NQueens {
//    class Positions
//    {
//        int row;int column;
//        public Positions(int r,int c)
//        {
//            row = r;
//            column=c;
//        }
//    }
//  public List allPossiblePositions()
//  {
//
//  }
class Position {
    int row, col;
    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

    public Position[] solveNQueenOneSolution(int n) {
        Position[] positions = new Position[n];
        boolean hasSolution = solveNQueenOneSolutionUtil(n, 0, positions);
        if (hasSolution) {
            return positions;
        } else {
            return new Position[0];
        }
    }

    private boolean solveNQueenOneSolutionUtil(int n, int row, Position[] positions) {
        if (n == row) {
            return true;
        }
        int col;
        for (col = 0; col < n; col++) {
            boolean foundSafe = true;

            //check if this row and col is not under attack from any previous queen.
            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
                        positions[queen].row + positions[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                positions[row] = new Position(row, col);
                if (solveNQueenOneSolutionUtil(n, row + 1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     *Solution for https://leetcode.com/problems/n-queens/
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Position[] positions = new Position[n];
        solve(0, positions, result, n);
        return result;
    }

    public void solve(int current, Position[] positions, List<List<String>> result, int n) {
        if (n == current) {
            StringBuffer buff = new StringBuffer();
            List<String> oneResult = new ArrayList<>();
            for (Position p : positions) {
                for (int i = 0; i < n; i++) {
                    if (p.col == i) {
                        buff.append("Q");
                    } else {
                        buff.append(".");
                    }
                }
                oneResult.add(buff.toString());
                buff = new StringBuffer();

            }
            result.add(oneResult);
            Arrays.stream(positions).forEach(position ->System.out.println(position.row + " " +position.col));
            System.out.println("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean foundSafe = true;
            for (int j = 0; j < current; j++) {
                if (positions[j].col == i || positions[j].col - positions[j].row == i - current || positions[j].row + positions[j].col == i + current) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                positions[current] = new Position(current, i);
                solve(current + 1, positions, result, n);
            }
        }
    }

    public static void main(String args[]) {
        NQueens s = new NQueens();
        Position[] positions = s.solveNQueenOneSolution(4);
        //Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.col));
        s.solveNQueens(4);
    }

}
