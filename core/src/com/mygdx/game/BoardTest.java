package com.mygdx.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	private Board board;

    @Before
    public void setUp() {
		board = new Board();
    }
    
    @Test
    public void shouldUpdateCorrectPosition() {
    	assertEquals(false, board.hasLotus1At(1, 1));
    	board.update(1, 1, '1');
    	assertEquals(true, board.hasLotus1At(1, 1));
    }
    
    @Test
    public void shouldUpdateOnlyEmptyPosition() {
    	board.update(1, 1, '1');
    	board.update(1, 1, '2');
    	assertEquals(true, board.hasLotus1At(1, 1));
    	
    	board.update(0, 0, '1');
    	assertEquals(false, board.hasLotus1At(0, 0));
    }
    
    @Test
    public void shouldHasSameItem() {
    	board.update(1, 1, '1');
    	assertEquals(true, board.isSameItem(1, 1, '1'));
    }
    
    @Test
    public void shouldRemoveStickItem() {
    	board.update(1, 1, '1');
    	board.update(1, 2, '1');
    	board.update(2, 2, '1');
    	assertEquals(true, board.isEmptyArea(1, 1));
    	assertEquals(true, board.isEmptyArea(1, 2));
    	assertEquals(false, board.isEmptyArea(2, 2));
    	
    	board.update(3, 1, '4');
    	board.update(3, 2, '4');
    	board.update(3, 3, '4');
    	assertEquals(false, board.isEmptyArea(3, 1));
    	assertEquals(false, board.isEmptyArea(3, 2));
    	assertEquals(false, board.isEmptyArea(3, 3));
    	
    }
}
