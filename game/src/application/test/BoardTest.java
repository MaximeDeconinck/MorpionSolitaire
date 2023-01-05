package application.test;

import static org.junit.Assert.*;

import application.Board;

import org.junit.Test;

public class BoardTest {

	@Test
    public void testCopy() {
        Board board = new Board(16, "test board");
        board.initBoard();
        
        Board copy = board.copy();
        
        // Verify that the copy has the same size and name as the original
        assertEquals(board.size, copy.size);
        assertEquals(board.name, copy.name);
        
        // Verify that the grid in the copy is a deep copy of the original
        assertNotSame(board.grid, copy.grid);
        assertArrayEquals(board.grid.toArray(), copy.grid.toArray());
    }
	
	@Test
    public void testAddPoint() {
        Board board = new Board(16, "test board");
        
        // Add a point to the board
        board.addPoint(5, 5);
        
        // Verify that the point was added correctly
        assertTrue(board.grid.get(5).get(5));
        
        // Try adding a point outside the bounds of the board
        try {
            board.addPoint(-1, 5);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
        	System.out.println(e.getMessage());
            assertEquals("Index -1 out of bounds for length 16", e.getMessage());
        }
        
        try {
            board.addPoint(5, 16);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index 16 out of bounds for length 16", e.getMessage());
        }
    }
}
