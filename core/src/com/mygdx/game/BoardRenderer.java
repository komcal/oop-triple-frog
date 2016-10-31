package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BoardRenderer {
	private Board board;
    private SpriteBatch batch;
    private Texture wallImage;
    private Texture leafImage;
    private Texture lotus1Image;
    private Texture waterImage;
    
    public BoardRenderer(SpriteBatch batch, Board board) {
        this.board = board;
        this.batch = batch;
    }
 
    public void render() {
    	wallImage = new Texture("wall.png");
    	leafImage = new Texture("leaf.png");
    	lotus1Image = new Texture("lotus1.png");
    	waterImage = new Texture("water.png");
        batch.begin();
        for(int r = 0; r < board.getHeight(); r++) {
            for(int c = 0; c < board.getWidth(); c++) {
            	int x = c * WorldRenderer.BLOCK_SIZE;
            	int y = TripleFrog.HEIGHT - 
                        (r * WorldRenderer.BLOCK_SIZE) - WorldRenderer.BLOCK_SIZE;
 
                if(board.hasWallAt(r, c)) {
                }
                else if(board.isEmptyArea(r, c)) {
                	batch.draw(waterImage, x, y);
                }
                else if(board.hasLotus1At(r, c)) {
                	batch.draw(lotus1Image, x, y);
                }
            }
        }
        batch.end();
    }
}
