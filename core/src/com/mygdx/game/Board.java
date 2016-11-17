package com.mygdx.game;

import java.util.Random;

public class Board {
	private String[] MAP = new String [] {
            "##########",
            "#........#",
            "#........#",
            "#........#",
            "#........#",
            "#........#",
            "#........#",
            "#........#",
            "#........#",
            "##########"    
    };
    private int height;
    private int width;
    private int countStickItem;
    public final char WALL = '#';
    public final char EMPTY_AREA = '.';
    public final char LOTUS0 = '0';
    public final char LOTUS1 = '1';
    public final char LOTUS2 = '2';
    public final char LOTUS3 = '3';
    public final char LOTUS4 = '5';
    public final char FROG = '4';
    public int[] frogsColumn = new int[200];
    public int[] frogsRow = new int[200];
    public int frogArrayIndex = 0;
    Score score;
    private int[] queueX = new int[100];
	private int[] queueY = new int[100];
 
    public Board(Score score) {
        height = MAP.length;
        width = MAP[0].length();
        this.score = score;
    }
 
    public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
    
    public boolean hasWallAt(int r, int c) {
        return MAP[r].charAt(c) == WALL;
    }
 
    public boolean isEmptyArea(int r, int c) {
        return MAP[r].charAt(c) == EMPTY_AREA;
    }
    
    public boolean hasLotus0At(int r, int c) {
    	return MAP[r].charAt(c) == LOTUS0;
    }
    
    public boolean hasLotus1At(int r, int c) {
    	return MAP[r].charAt(c) == LOTUS1;
    }
    
    public boolean hasLotus2At(int r, int c) {
    	return MAP[r].charAt(c) == LOTUS2;
    }
    
    public boolean hasLotus3At(int r, int c) {
    	return MAP[r].charAt(c) == LOTUS3;
    }
    
    public boolean hasFrogAt(int r, int c) {
    	return MAP[r].charAt(c) == FROG;
    }
    
    public boolean hasLotus4At(int r, int c) {
    	return MAP[r].charAt(c) == LOTUS4;
    }
    
    public boolean isSameItem(int r, int c, char item) {
    	return (MAP[r].charAt(c) == item && item != FROG && item != LOTUS4);
    }
    
    public void update(int r, int c, char item) {
    	if (isEmptyArea(r, c)) {
    		updateNextToItem(r, c, item);
    		if (countStickItem >= 3 && item != EMPTY_AREA && item != LOTUS4) {
    			item = tranformItem(item);
    			if (item != EMPTY_AREA && item != LOTUS4) {
    				update(r, c, item);
    			}
    		} else {
    			if (item == FROG) {
    				frogsRow[frogArrayIndex] = r;
    				frogsColumn[frogArrayIndex] = c;
    				frogArrayIndex++;
    			}
    			updateMap(r, c, item);
    			changeFrogsPocition();
    		}
    	} else if (item == EMPTY_AREA) {
    		updateMap(r, c, item);
    	}
    }
    private void updateMap(int r, int c, char item) {
    	MAP[r] = MAP[r].substring(0, c) + item + MAP[r].substring(c + 1);
    }
    
    private void changeFrogsPocition() {
    	for (int i = 0 ; i < frogArrayIndex ; i++) {
    		int r = frogsRow[i];
        	int c = frogsColumn[i];
    		updateMap(r, c, '.');
    		
    		randomNewFrogPosition(i);
    		r = frogsRow[i];
        	c = frogsColumn[i];
    		updateMap(r, c, '4');
    	}
    }
    
    private void randomNewFrogPosition(int index) {
    	int r = frogsRow[index];
    	int c = frogsColumn[index];
    	
		Random rand = new Random();
    	r = rand.nextInt(10);
    	c = rand.nextInt(10);
    	
    	if (isEmptyArea(r, c)) {
        	frogsRow[index] = r;
        	frogsColumn[index] = c;	
    	}
    }
    
    private char tranformItem(char item) {
    	if(item == '3') {
    		this.score.increaseThreePoint();
    		item = LOTUS4;
    	} else {
    		this.score.increaseTwoPoint();
    		item++;
    	}
    	return item;
    }
    
    public void updateNextToItem(int r, int c, char item) {
    	int q = 0;
    	countStickItem = 1;
    	queueX[q] = c;
		queueY[q] = r;
		q++;
		while (q > 0) {
			q--;
			c = queueX[q];
			r = queueY[q];
			if (countStickItem >= 3) {
				update(r, c, EMPTY_AREA);
			}
    		if (isSameItem(r - 1, c, item)) {
				q = enqueue(c, r - 1, q);
			}
			if (isSameItem(r + 1, c, item)) {
				
				q = enqueue(c, r + 1, q);
			}
			if (isSameItem(r, c - 1, item)) {
				q = enqueue(c - 1, r, q);
			}
			if (isSameItem(r, c + 1, item)) {
				q = enqueue(c + 1, r, q);
			}
			
		}	
    }
    
    private int enqueue(int c, int r, int q) {
    	queueX[q] = c;
		queueY[q] = r;
		q++;
		countStickItem++;
    	return q;
    }
}
