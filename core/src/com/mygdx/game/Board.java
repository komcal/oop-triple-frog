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
    private int countStickItem;
 
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
    
    public boolean hasLotus0At(int r, int c) {
    	return MAP[r].charAt(c) == '0';
    }
    
    public boolean hasLotus1At(int r, int c) {
    	return MAP[r].charAt(c) == '1';
    }
    
    public boolean hasLotus2At(int r, int c) {
    	return MAP[r].charAt(c) == '2';
    }
    
    public boolean hasLotus3At(int r, int c) {
    	return MAP[r].charAt(c) == '3';
    }
    
    public boolean isSameItem(int r, int c, char item) {
    	return MAP[r].charAt(c) == item;
    }
    
    public void update(int r, int c, char item) {
    	if (isEmptyArea(r, c)) {
    		updateNextToItem(r, c, item);
    		if(countStickItem >= 3) {
    			item = tranformItem(item);
    		}
    		MAP[r] = MAP[r].substring(0, c) + item + MAP[r].substring(c + 1);
    	}
    	else if (item == '.') {
    		MAP[r] = MAP[r].substring(0, c) + item + MAP[r].substring(c + 1);
    	}
    }
    
    private char tranformItem(char item) {
    	if(item == '3') {
    		item = '.';
    	}
    	else {
    		item++;
    	}
    	return item;
    }
    
    public void updateNextToItem(int r, int c, char item) {
    	int[] queueX = new int[100000];
    	int[] queueY = new int[100000];
    	int q = 0;
    	countStickItem = 1;
    	queueX[q] = c;
		queueY[q] = r;
		q++;
		while(q > 0) {
			q--;
			c = queueX[q];
			r = queueY[q];
			if(countStickItem >= 3) {
				update(r, c, '.');
			}
    		if (isSameItem(r-1, c, item)) {
				queueX[q] = c;
				queueY[q] = r-1;
				q++;
				countStickItem++;
			}
			if (isSameItem(r+1, c, item)) {
				queueX[q] = c;
				queueY[q] = r+1;
				q++;
				countStickItem++;
			}
			if (isSameItem(r, c-1, item)) {
				queueX[q] = c-1;
				queueY[q] = r;
				q++;
				countStickItem++;
			}
			if (isSameItem(r, c+1, item)) {
				queueX[q] = c+1;
				queueY[q] = r;
				q++;
				countStickItem++;
			}
			
		}
    	
    	
    }

}
