package com.mygdx.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PlayerTest {
	
	private Player player;
	private static final double DELTA = 1e-15;

    @Before
    public void setUp() {
		player = new Player(60, 60, null);
    }

	
	@Test
	public void testPlayerShouldMoveCorrectly() {
		player.move(player.DIRECTION_RIGHT);
		assertEquals(60, player.getPosition().y, DELTA);
		assertEquals(60 + player.SPEED, player.getPosition().x, DELTA);
		
		player.move(player.DIRECTION_RIGHT);
		player.move(player.DIRECTION_DOWN);
		assertEquals(60 + player.SPEED, player.getPosition().y, DELTA);
		assertEquals(65 + player.SPEED, player.getPosition().x, DELTA);
		
	}

}
