package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Player {
    private Vector2 position;
    public final int DIRECTION_UP = 1;
    public final int DIRECTION_RIGHT = 2;
    public final int DIRECTION_DOWN = 3;
    public final int DIRECTION_LEFT = 4;
    public final int DIRECTION_STILL = 0;
    private int currentDirection;
    private int nextDirection;
    private World world;
    private char currentItem;
    
    private static final int [][] DIR_OFFSETS = new int [][] {
        {0,0},
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };
    public static final int SPEED = 5;
    
    public Player(int x, int y, World world) {
        position = new Vector2(x,y);
        this.world = world;
        currentDirection = DIRECTION_STILL;
        nextDirection = DIRECTION_STILL;
        currentItem = '0';
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public void move(int dir) { 
        position.x += SPEED * DIR_OFFSETS[dir][0];
        position.y += SPEED * DIR_OFFSETS[dir][1];
    }
    
    public void setNextDirection(int dir) {
        nextDirection = dir;
    }
    
    public void update() {
        if(isAtCenter()) {
            if(canMoveInDirection(nextDirection)) {
                currentDirection = nextDirection;    
            } else {
                currentDirection = DIRECTION_STILL;    
            }
        }
        move(currentDirection);
    }
    
    public boolean isAtCenter() {
        int blockSize = WorldRenderer.BLOCK_SIZE;
 
        return ((((int)position.x - blockSize/2) % blockSize) == 0) &&
                ((((int)position.y - blockSize/2) % blockSize) == 0);
    }
    
    private boolean canMoveInDirection(int dir) {
    	Board board = world.getBoard();
    	
    	int newRow = getRow() + DIR_OFFSETS[dir][1]; 
        int newCol = getColumn()  + DIR_OFFSETS[dir][0];
        if(!board.hasWallAt(newRow, newCol)) {
        	return true;
        }	
        return false;
    }
    
    public int getRow() {
        return ((int)position.y) / WorldRenderer.BLOCK_SIZE; 
    }
 
    public int getColumn() {
        return ((int)position.x) / WorldRenderer.BLOCK_SIZE; 
    }
    
    public char getCurrentItem() {
    	return currentItem;
    }
    
    public void randomItem() {
    	Random rand = new Random();
    	int random = rand.nextInt(38);
    	if (random < 1) {
    		currentItem = Integer.toString(3).charAt(0);
    	}
    	else if (random < 3) {
    		currentItem = Integer.toString(2).charAt(0);
    	}

    	else if (random < 6) {
    		currentItem = Integer.toString(1).charAt(0);
    	}

    	else if (random < 30) {
    		currentItem = Integer.toString(0).charAt(0);
    	}
    	else if (random < 38) {
    		currentItem = Integer.toString(4).charAt(0);
    	}
    	
    }
    
}
