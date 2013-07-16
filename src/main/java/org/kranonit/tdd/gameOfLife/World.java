package org.kranonit.tdd.gameOfLife;

public class World {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    private boolean[][] cells = new boolean[WIDTH][HEIGHT];

    public void makeAlive(Cell cell) {
        cells[cell.x][cell.y] = true;
    }


    public boolean isAlive(Cell cell) {
        return cells[cell.x][cell.y];
    }

    public int countNeighbours(Cell cell) {
        int count = 0;
        if (cells[cell.x - 1][cell.y - 1]) {
            count++;
        }
        if (cells[cell.x][cell.y - 1]) {
            count++;
        }
        if (cells[cell.x + 1][cell.y - 1]) {
            count++;
        }
        if (cells[cell.x - 1][cell.y]) {
            count++;
        }
        if (cells[cell.x + 1][cell.y]) {
            count++;
        }
        if (cells[cell.x - 1][cell.y + 1]) {
            count++;
        }
        if (cells[cell.x][cell.y + 1]) {
            count++;
        }
        if (cells[cell.x + 1][cell.y + 1]) {
            count++;
        }
        return count;
    }

    public void kill(Cell cell) {
        new Kill(cells, cell).invoke();
    }

}
