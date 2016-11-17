package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BoardRenderer {
	private Board board;
    private SpriteBatch batch;
    private Texture wallImage;
    private Texture lotus0Image;
    private Texture lotus1Image;
    private Texture lotus2Image;
    private Texture lotus3Image;
    private Texture lotus4Image;
    private Texture waterImage;
    private Texture frogImage;
    
    public BoardRenderer(SpriteBatch batch, Board board) {
        this.board = board;
        this.batch = batch;
    }
 
    public void render() {
    	wallImage = new Texture("wall.png");
    	lotus0Image = new Texture("lotus0.png");
    	lotus1Image = new Texture("lotus1.png");
    	lotus2Image = new Texture("lotus2.png");
    	lotus3Image = new Texture("lotus3.png");
    	waterImage = new Texture("water.png");
    	frogImage = new Texture("frog.png");
    	lotus4Image = new Texture("lotus4.png");
        batch.begin();
        for (int r = 0; r < board.getHeight(); r++) {
            for (int c = 0; c < board.getWidth(); c++) {
            	int x = c * WorldRenderer.BLOCK_SIZE;
            	int y = TripleFrog.HEIGHT - 
                        (r * WorldRenderer.BLOCK_SIZE) - WorldRenderer.BLOCK_SIZE;
            	
            	
                if(!board.hasWallAt(r, c)) {
                	batch.draw(waterImage, x, y);
                }
                if (board.hasLotus0At(r, c)) {
                	batch.draw(lotus0Image, x, y);
                } else if (board.hasLotus1At(r, c)) {
                	batch.draw(lotus1Image, x, y);
                } else if (board.hasLotus2At(r, c)) {
                	batch.draw(lotus2Image, x, y);
                } else if (board.hasLotus3At(r, c)) {
                	batch.draw(lotus3Image, x, y);
                } else if (board.hasFrogAt(r, c)) {
                	batch.draw(frogImage, x, y);
                } else if (board.hasLotus4At(r, c)) {
                	batch.draw(lotus4Image, x, y);
                }
            }
        }
        batch.end();
    }
}
