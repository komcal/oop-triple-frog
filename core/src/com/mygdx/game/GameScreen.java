package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private TripleFrog tripleFrog;
	private Texture playerImg;
    private int x;
    private int y;
    
	public GameScreen(TripleFrog tripleFrog) {
        this.tripleFrog = tripleFrog;
        playerImg = new Texture("player.png");
        x = 100;
        y = 100;
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	update(delta);
        SpriteBatch batch = tripleFrog.batch;
        batch.begin();
        batch.draw(playerImg, x, y);
        batch.end();
    }
    private void update(float delta) {
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            x -= 10;
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            x += 10;
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            y -= 10;
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            y += 10;
        }
    }

}
