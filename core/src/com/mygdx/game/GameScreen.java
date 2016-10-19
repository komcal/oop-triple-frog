package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	private TripleFrog tripleFrog;
	private Texture playerImg;
	private Player player;
	public World world;
    
	public GameScreen(TripleFrog tripleFrog) {
        this.tripleFrog = tripleFrog;
        playerImg = new Texture("player.png");
        world = new World(tripleFrog);
        player = world.getPlayer();
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	update(delta);
        SpriteBatch batch = tripleFrog.batch;
        batch.begin();
        Vector2 pos = player.getPosition();
        batch.draw(playerImg, pos.x, pos.y);
        batch.end();
    }
    private void update(float delta) {
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            player.move(player.DIRECTION_UP);
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            player.move(player.DIRECTION_DOWN);
        }
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            player.move(player.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            player.move(player.DIRECTION_RIGHT);
        }
    }

}
