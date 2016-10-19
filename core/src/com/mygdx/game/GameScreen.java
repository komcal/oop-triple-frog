package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private TripleFrog tripleFrog;
	private Texture playerImg;
    
	public GameScreen(TripleFrog tripleFrog) {
        this.tripleFrog = tripleFrog;
        playerImg = new Texture("player.png");
    }
    @Override
    public void render(float delta) {
        SpriteBatch batch = tripleFrog.batch;
        batch.begin();
        batch.draw(playerImg, 100, 100);
        batch.end();
    }

}
