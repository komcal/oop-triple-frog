package com.mygdx.game;

public class Board {
	private String[] MAP = new String [] {
            "###########",
            "#.........#",
            "#.........#",
            "#.........#",
            "#.........#",
            "#.........#",
            "#.........#",
            "#.........#",
            "#.........#",
            "#.........#",
            "###########"    
    };
    private int height;
    private int width;
 
    public Board() {
        height = MAP.length;
        width = MAP[0].length();
    }
 
    public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
    
    public boolean hasWallAt(int r, int c) {
        return MAP[r].charAt(c) == '#';
    }
 
    public boolean isEmptyArea(int r, int c) {
        return MAP[r].charAt(c) == '.';
    }
    
    public boolean hasLotus1At(int r, int c) {
    	return MAP[r].charAt(c) == '1';
    }
    
    public void update(int r, int c, char item) {
    	if (isEmptyArea(r, c)) {
    		MAP[r] = MAP[r].substring(0, c) + item + MAP[r].substring(c + 1);
    	}
    }

}
