package com.practice.ss;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Krishna Chaitanya M on 16/01/17.
 *
 * {0, 1, 0, 0, 0},
 * {0, 0, 0, 0, 0},
 * {0, 2, 0, 9, 0},
 * {0, 0, 0, 0, 0},
 * {0, 9, 3, 0, 4}
 *
 * Source 1's destination is 3, Source 2's destination is 4.
 * 1 and 3 should reach their destinations at the same time.
 * 9 is the obstacle.
 *
 * If any source starts traversal in any direction, it moves until
 * it finds and obstacle or its another corresponding source.
 *
 * We can traverse in any of the 4 directions.
 */
public class DualTraversal {
    private enum Direction {
        LEFT(1), RIGHT(2), UP(3), DOWN(4);

        int value;
        Direction(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }
    }

    private enum Points {
        SRC1(0), SRC2(1), DEST1(2), DEST2(3);
        int value;
        Points(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }
    }

    private class Point {
        private int row;
        private int col;
        private int element;

        Point(int row, int col, int element) {
            setRow(row);
            setCol(col);
            setElement(element);
        }

        public int getRow() { return row; }
        public void setRow(int row) { this.row = row; }

        public int getCol() { return col; }
        public void setCol(int col) { this.col = col; }

        public void setElement(int element) {
            this.element = element;
        }

        public int getElement() {
            return element;
        }


        public boolean isEquals(Point point) {
            if (this.getRow() == point.getRow() && this.getCol() == point.getCol()) {
                return true;
            }
            return false;
        }
    }

    private void traverseUp(Point p1, Point p2, int[][] matrix) {
        int row1 = p1.getRow();
        int row2 = p2.getRow();

        while (row1 >= 0) {
            if (row1 - 1 >= 0 && matrix[row1 - 1][p1.getCol()] != 9) {
                matrix[row1][p1.getCol()] = 0;
                row1 -= 1;
                matrix[row1][p1.getCol()] = p1.getElement();
            } else {
                break;
            }
        }

        while (row2 >= 0) {
            if (row2 - 1 >= 0 && matrix[row2 - 1][p2.getCol()] != 9 && matrix[row2 - 1][p2.getCol()] != p1.getElement()) {
                matrix[row2][p2.getCol()] = 0;
                row2 -= 1;
                matrix[row2][p2.getCol()] = p2.getElement();
            } else {
                break;
            }
        }

        p1.setRow(row1 < 0 ? row1 + 1 : row1);
        p2.setRow(row2 < 0 ? row2 + 1 : row2);
    }

    private void traverseDown(Point p1, Point p2, int[][] matrix) {
        int row1 = p1.getRow();
        int row2 = p2.getRow();

        int N = matrix.length;

        while (row1 < N) {
            if (row1 + 1 < N && matrix[row1 + 1][p1.getCol()] != 9) {
                matrix[row1][p1.getCol()] = 0;
                row1 += 1;
                matrix[row1][p1.getCol()] = p1.getElement();
            } else {
                break;
            }
        }

        while(row2 < N) {
            if (row2 + 1 < N && matrix[row2 + 1][p2.getCol()] != 9 && matrix[row2 + 1][p2.getCol()] != p1.getElement()) {
                matrix[row2][p2.getCol()] = 0;
                row2 += 1;
                matrix[row2][p2.getCol()] = p2.getElement();
            } else {
                break;
            }
        }

        p1.setRow(row1 == N ? row1 - 1 : row1);
        p2.setRow(row2 == N ? row2 - 1 : row2);
    }

    private void traverseLeft(Point p1, Point p2, int[][] matrix) {
        int col1 = p1.getCol();
        int col2 = p2.getCol();

        while (col1 >= 0) {
            if (col1 - 1 >= 0 && matrix[p1.getRow()][col1 - 1] != 9) {
                matrix[p1.getRow()][col1] = 0;
                col1 -= 1;
                matrix[p1.getRow()][col1] = p1.getElement();
            } else {
                break;
            }
        }

        while (col2 >= 0) {
            if (col2 - 1 >= 0 && matrix[p2.getRow()][col2 - 1] != 9 && matrix[p2.getRow()][col2 - 1] != p1.getElement()) {
                matrix[p2.getRow()][col2] = 0;
                col2 -= 1;
                matrix[p2.getRow()][col2] = p2.getElement();
            } else {
                break;
            }
        }

        p1.setCol(col1 < 0 ? col1 + 1 : col1);
        p2.setCol(col2 < 0 ? col2 + 1 : col2);
    }

    private void traverseRight(Point p1, Point p2, int[][] matrix) {
        int col1 = p1.getCol();
        int col2 = p2.getCol();

        int N = matrix.length;

        while (col1 < N) {
            if (col1 + 1 < N && matrix[p1.getRow()][col1 + 1] != 9) {
                matrix[p1.getRow()][col1] = 0;
                col1 += 1;
                matrix[p1.getRow()][col1] = p1.getElement();
            } else {
                break;
            }
        }

        while (col2 < N) {
            if (col2 + 1 < N && matrix[p2.getRow()][col2 + 1] != 9 && matrix[p2.getRow()][col2 + 1] != p1.getElement()) {
                matrix[p2.getRow()][col2] = 0;
                col2 += 1;
                matrix[p2.getRow()][col2] = p2.getElement();
            } else {
                break;
            }
        }

        p1.setCol(col1 == N ? col1 - 1 : col1);
        p2.setCol(col2 == N ? col2 - 1 : col2);
    }

    private int [][] cacheMatrix(int [][] matrix) {
        int N = matrix.length;
        int[][] cacheMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cacheMatrix[i][j] = matrix[i][j];
            }
        }
        return cacheMatrix;
    }

    private Point cachePoint(Point point) {
        Point pt = new Point(point.getRow(), point.getCol(), point.getElement());
        return pt;
    }

    private void traverse(Point src1, Point src2, Point dest1, Point dest2, int count, int [][] matrix, Set<Integer> directions) {
        if (src1.isEquals(dest1) && src2.isEquals(dest2)) {
            directions.add(count);
        }

        if (count >= 8) {
            return;
        }

        for (Direction direction : Direction.values()) {
            int temp[][] = cacheMatrix(matrix);
            Point srcPoint1 = cachePoint(src1);
            Point srcPoint2 = cachePoint(src2);

            if (direction.getValue() == Direction.DOWN.getValue()) {
                if (src1.getCol() == src2.getCol() && src1.getRow() < src2.getRow()) {
                    traverseDown(src2, src1, matrix);
                } else {
                    traverseDown(src1, src2, matrix);
                }
            } else if (direction.getValue() == Direction.UP.getValue()) {
                if (src1.getCol() == src2.getCol() && src1.getRow() < src2.getRow()) {
                    traverseUp(src1, src2, matrix);
                } else {
                    traverseUp(src2, src1, matrix);
                }

            } else if (direction.getValue() == Direction.LEFT.getValue()) {
                if (src1.getRow() == src2.getRow() && src1.getCol() < src2.getCol()) {
                    traverseLeft(src1, src2, matrix);
                } else {
                    traverseLeft(src2, src1, matrix);
                }

            } else {
                if (src1.getRow() == src2.getRow() && src1.getCol() < src2.getCol()) {
                    traverseRight(src2, src1, matrix);
                } else {
                    traverseRight(src1, src2, matrix);
                }
            }

            traverse(src1, src2, dest1, dest2, count + 1, matrix, directions);

            matrix = temp;
            src1 = srcPoint1;
            src2 = srcPoint2;
        }
    }

    private void initPoints(int[][] matrix, Point[] points) {
        int N = matrix.length;
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < N; j++) {
                switch (matrix[i][j]) {
                    case 1:
                        points[Points.SRC1.getValue()] = new Point(i, j, 1);
                        break;
                    case 2:
                        points[Points.SRC2.getValue()] = new Point(i, j, 2);
                        break;
                    case 3:
                        points[Points.DEST1.getValue()] = new Point(i, j, 3);
                        break;
                    case 4:
                        points[Points.DEST2.getValue()] = new Point(i, j, 4);
                        break;
                }
            }
        }
    }

    private int getMinimumTraversal(int[][] matrix) {
        Point points[] = new Point[4];
        initPoints(matrix, points);

        Set<Integer> set = new TreeSet<>();
        traverse(points[Points.SRC1.getValue()],
                 points[Points.SRC2.getValue()],
                 points[Points.DEST1.getValue()],
                 points[Points.DEST2.getValue()],
                 0, matrix, set);
        return set.isEmpty()? -1 : set.iterator().next();
    }

    public static void main(String args[]) {
        DualTraversal dualTraversal = new DualTraversal();
        /* int [][] matrix = {
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 2, 0, 9, 0},
                {0, 0, 0, 0, 0},
                {0, 9, 3, 0, 4}
        }; */

        int [][] matrix = {
                {3, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {4, 0, 0, 9, 0},
                {2, 0, 0, 0, 0},
                {0, 9, 0, 0, 0}
        };


        System.out.println(dualTraversal.getMinimumTraversal(matrix));
    }
}
