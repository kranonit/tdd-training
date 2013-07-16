package org.kranonit.tdd.gameOfLife;

class Kill {
    private Cell cell;
    private boolean[][] cells;

    public Kill(boolean[][] cells, Cell cell) {
        this.cell = cell;
        this.cells = cells;
    }

    public void invoke() {
        cells[cell.x][cell.y] = false;
    }
}
