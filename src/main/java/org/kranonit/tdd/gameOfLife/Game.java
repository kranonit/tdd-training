package org.kranonit.tdd.gameOfLife;

public class Game {
    public static World nextGeneration(World world) {
        World newWorld = new World();
        for (int x = 1; x < World.WIDTH - 1; x++) {
            for (int y = 1; y < World.HEIGHT - 1; y++) {
                Cell cell = new Cell(x, y);
                int neighbours = world.countNeighbours(cell);
                if (neighbours < 2) {
                    newWorld.kill(cell);
                } else {
                    newWorld.makeAlive(cell);
                }
            }
        }
        return newWorld;
    }
}
