package org.kranonit.tdd.gameOfLife;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

public class GameTest {

    @Test
    public void cellWithZeroNeighboursShouldDie() {
        // Given
        World world = new World();
        Cell cell = new Cell(2, 2);
        world.makeAlive(cell);
        // When
        World newWorld = Game.nextGeneration(world);
        //Then
        assertFalse(newWorld.isAlive(cell));
    }

    @Test
    public void cellWithOneNeighbourShouldDie() {
        // Given
        World world = new World();
        Cell cell = new Cell(2, 2);
        Cell neighbour = new Cell(2, 3);
        world.makeAlive(cell);
        world.makeAlive(neighbour);
        // When
        World newWorld = Game.nextGeneration(world);
        //Then
        assertFalse(newWorld.isAlive(cell));
    }

    @Test
    public void shouldReturnZeroWhenNoNeighbours() {
        //Given
        World world = new World();
        //When
        int count = world.countNeighbours(new Cell(1, 1));
        //Then
        assertEquals(0, count);
    }

    @Test
    public void shouldReturnEightWhenHasAllNeighbours() {
        //Given
        World world = new World();
        world.makeAlive(new Cell(0, 0));
        world.makeAlive(new Cell(0, 1));
        world.makeAlive(new Cell(0, 2));
        world.makeAlive(new Cell(1, 0));
        world.makeAlive(new Cell(1, 2));
        world.makeAlive(new Cell(2, 0));
        world.makeAlive(new Cell(2, 1));
        world.makeAlive(new Cell(2, 2));
        //When
        int count = world.countNeighbours(new Cell(1, 1));
        //Then
        assertEquals(8, count);
    }
}
