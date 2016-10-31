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

}
